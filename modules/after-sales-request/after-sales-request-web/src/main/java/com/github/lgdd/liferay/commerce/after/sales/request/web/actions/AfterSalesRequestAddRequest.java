package com.github.lgdd.liferay.commerce.after.sales.request.web.actions;

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.service.AfterSalesRequestLocalService;
import com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestMVCCommandNames;
import com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestWebKeys;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AfterSalesRequestWebKeys.PORTLET_NAME,
        "mvc.command.name=" + AfterSalesRequestMVCCommandNames.ADD_REQUEST
    },
    service = MVCActionCommand.class
)
public class AfterSalesRequestAddRequest
    extends BaseMVCActionCommand {

  @Override
  protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
      throws Exception {

    ServiceContext serviceContext = ServiceContextFactory.getInstance(
        AfterSalesRequest.class.getName(), actionRequest);

    String title = ParamUtil.getString(actionRequest, "title");
    String description = ParamUtil.getString(actionRequest, "description");
    long commerceOrderId = ParamUtil.getLong(actionRequest, "commerceOrderId");

    _afterSalesRequestLocalService
        .addAfterSalesRequest(title, description, commerceOrderId, serviceContext);
  }

  @Reference
  private AfterSalesRequestLocalService _afterSalesRequestLocalService;

}
