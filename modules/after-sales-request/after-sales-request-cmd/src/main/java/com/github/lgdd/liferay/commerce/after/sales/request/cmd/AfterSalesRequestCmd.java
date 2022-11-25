package com.github.lgdd.liferay.commerce.after.sales.request.cmd;

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.service.AfterSalesRequestLocalService;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "osgi.command.scope=dev24",
        "osgi.command.function=transfer"
    },
    service = AfterSalesRequestCmd.class
)
public class AfterSalesRequestCmd {

  public void transfer(long objectDefinitionId, String relationshipName)
      throws PortalException {

    List<AfterSalesRequest> afterSalesRequests =
        _afterSalesRequestLocalService.getAfterSalesRequests(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

    for (AfterSalesRequest afterSalesRequest : afterSalesRequests) {
      Map<String, Serializable> values = new HashMap<>();
      values.put("title", afterSalesRequest.getTitle());
      values.put("description", afterSalesRequest.getDescription());
      values.put("r_" + relationshipName + "_commerceOrderId",
                 afterSalesRequest.getCommerceOrderId());

      ObjectEntry objectEntry = _objectEntryLocalService.addObjectEntry(
          afterSalesRequest.getUserId(),
          afterSalesRequest.getGroupId(), objectDefinitionId,
          values, new ServiceContext());

      objectEntry.setUserId(afterSalesRequest.getUserId());
      objectEntry.setCreateDate(afterSalesRequest.getCreateDate());
      objectEntry.setModifiedDate(afterSalesRequest.getModifiedDate());
      objectEntry.setCompanyId(afterSalesRequest.getCompanyId());
      objectEntry.setGroupId(afterSalesRequest.getGroupId());
      objectEntry.setExternalReferenceCode(String.valueOf(afterSalesRequest.getPrimaryKey()));

      _objectEntryLocalService.updateObjectEntry(objectEntry);
    }

  }

  @Reference
  private AfterSalesRequestLocalService _afterSalesRequestLocalService;

  @Reference
  private ObjectEntryLocalService _objectEntryLocalService;

}
