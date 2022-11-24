package com.github.lgdd.liferay.commerce.after.sales.request.service.workflow;

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.service.AfterSalesRequestLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    service = WorkflowHandler.class
)
public class AfterSalesRequestWorkflowHandler
    extends BaseWorkflowHandler<AfterSalesRequest> {

  @Override
  public String getClassName() {

    return AfterSalesRequest.class.getName();
  }

  @Override
  public String getType(Locale locale) {

    return _resourceActions.getModelResource(locale, getClassName());
  }

  @Override
  public AfterSalesRequest updateStatus(int status, Map<String, Serializable> workflowContext) throws
                                                                                        PortalException {

    long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

    long resourcePrimKey = GetterUtil
        .getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

    ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

    return _afterSalesRequestLocalService.updateStatus(userId, resourcePrimKey, status, serviceContext);
  }

  @Reference
  private AfterSalesRequestLocalService _afterSalesRequestLocalService;

  @Reference
  private ResourceActions _resourceActions;
}
