package com.github.lgdd.liferay.commerce.after.sales.request.web.actions;

import com.github.lgdd.liferay.commerce.after.sales.request.service.AfterSalesRequestLocalService;
import com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestMVCCommandNames;
import com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestWebKeys;
import com.liferay.commerce.account.constants.CommerceAccountConstants;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import java.util.List;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AfterSalesRequestWebKeys.PORTLET_NAME,
        "mvc.command.name=/",
        "mvc.command.name=" + AfterSalesRequestMVCCommandNames.VIEW_FORM
    },
    service = MVCRenderCommand.class
)
public class AfterSalesRequestViewForm
    implements MVCRenderCommand {

  @Override
  public String render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws PortletException {

    try {
      _addCommerceOrderListAttributes(renderRequest);
    } catch (PortalException e) {
      _logger.error(e.getMessage());
      throw new PortletException(e);
    }

    return "/view.jsp";
  }

  private void _addCommerceOrderListAttributes(RenderRequest renderRequest)
      throws PortalException {

    ThemeDisplay themeDisplay =
        (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

    List<CommerceAccount> accounts =
        _accountLocalService.getUserCommerceAccounts(themeDisplay.getUserId(),
                                                     CommerceAccountConstants.DEFAULT_PARENT_ACCOUNT_ID,
                                                     CommerceAccountConstants.SITE_TYPE_B2B,
                                                     "", QueryUtil.ALL_POS, QueryUtil.ALL_POS);

    String orderByCol =
        ParamUtil.getString(renderRequest, "orderByCol", "createDate");
    String orderByType =
        ParamUtil.getString(renderRequest, "orderByType", "asc");

    OrderByComparator<CommerceOrder> orderByComparator =
        OrderByComparatorFactoryUtil.create(
            "CommerceOrder", orderByCol, !("asc").equals(orderByType));

    List<CommerceOrder> commerceOrders = _commerceOrderLocalService
        .getCommerceOrdersByCommerceAccountId(accounts.get(0).getCommerceAccountId(),
                                              QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                                              orderByComparator);

    renderRequest.setAttribute("commerceOrders", commerceOrders);
  }

  @Reference
  private CommerceOrderLocalService _commerceOrderLocalService;

  @Reference
  private CommerceAccountLocalService _accountLocalService;

  private static final Logger _logger = LoggerFactory.getLogger(AfterSalesRequestViewForm.class);

}
