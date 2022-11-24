/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

package com.github.lgdd.liferay.commerce.after.sales.request.service.impl;

import com.github.lgdd.liferay.commerce.after.sales.request.constants.AfterSalesRequestActionKeys;
import com.github.lgdd.liferay.commerce.after.sales.request.constants.AfterSalesRequestConstants;
import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.service.base.AfterSalesRequestServiceBaseImpl;

import com.liferay.depot.constants.DepotActionKeys;
import com.liferay.depot.constants.DepotConstants;
import com.liferay.depot.model.DepotEntry;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.permission.GroupPermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
    property = {
        "json.web.service.context.name=dev24",
        "json.web.service.context.path=AfterSalesRequest"
    },
    service = AopService.class
)
public class AfterSalesRequestServiceImpl
    extends AfterSalesRequestServiceBaseImpl {

  @Override
  public AfterSalesRequest addAfterSalesRequest(String title, String description,
      long commerceOrderId, ServiceContext serviceContext)
      throws PortalException {

    _portletResourcePermission.check(
        getPermissionChecker(), serviceContext.getScopeGroupId(),
        AfterSalesRequestActionKeys.ADD_AFTER_SALES_REQUEST);

    return afterSalesRequestLocalService
        .addAfterSalesRequest(title, description, commerceOrderId, serviceContext);
  }

  @Override
  public AfterSalesRequest deleteAfterSalesRequest(long afterSalesRequestId)
      throws PortalException {

    _afterSalesRequestModelResourcePermission.check(
        getPermissionChecker(), afterSalesRequestId, ActionKeys.DELETE);

    return afterSalesRequestLocalService.deleteAfterSalesRequest(afterSalesRequestId);
  }

  @Reference(
      policy = ReferencePolicy.DYNAMIC,
      policyOption = ReferencePolicyOption.GREEDY,
      target = "(model.class.name=com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest)"
  )
  private volatile ModelResourcePermission<AfterSalesRequest>
      _afterSalesRequestModelResourcePermission;

  @Reference(
      policy = ReferencePolicy.DYNAMIC,
      policyOption = ReferencePolicyOption.GREEDY,
      target = "(resource.name=" + AfterSalesRequestConstants.RESOURCE_NAME + ")"
  )
  private volatile PortletResourcePermission _portletResourcePermission;

}