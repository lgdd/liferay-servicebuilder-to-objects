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

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.service.base.AfterSalesRequestLocalServiceBaseImpl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
    property = "model.class.name=com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest",
    service = AopService.class
)
public class AfterSalesRequestLocalServiceImpl
    extends AfterSalesRequestLocalServiceBaseImpl {

  @Indexable(
      type = IndexableType.REINDEX
  )
  public AfterSalesRequest addAfterSalesRequest(String title, String description,
      ServiceContext serviceContext)
      throws PortalException {

    long groupId = serviceContext.getScopeGroupId();
    Group group = groupLocalService.getGroup(groupId);
    long userId = serviceContext.getUserId();
    User user = userLocalService.getUser(userId);

    long afterSalesRequestId = counterLocalService.increment(AfterSalesRequest.class.getName());

    AfterSalesRequest afterSalesRequest = createAfterSalesRequest(afterSalesRequestId);

    afterSalesRequest.setCompanyId(groupId);
    afterSalesRequest.setGroupId(serviceContext.getScopeGroupId());
    afterSalesRequest.setUserId(userId);
    afterSalesRequest.setTitle(title);
    afterSalesRequest.setDescription(description);

    afterSalesRequest.setStatus(WorkflowConstants.STATUS_DRAFT);
    afterSalesRequest.setStatusByUserId(userId);
    afterSalesRequest.setStatusByUserName(user.getFullName());
    afterSalesRequest.setStatusDate(serviceContext.getModifiedDate(null));

    afterSalesRequest.setUserName(user.getScreenName());
    afterSalesRequest.setCreateDate(serviceContext.getCreateDate(new Date()));
    afterSalesRequest.setModifiedDate(serviceContext.getModifiedDate(new Date()));

    afterSalesRequest = super.addAfterSalesRequest(afterSalesRequest);

    boolean portletActions = false;
    boolean addGroupPermissions = true;
    boolean addGuestPermissions = true;

    resourceLocalService.addResources(group.getCompanyId(), groupId, userId,
                                      AfterSalesRequest.class.getName(),
                                      afterSalesRequest.getAfterSalesRequestId(), portletActions,
                                      addGroupPermissions, addGuestPermissions);

    updateAsset(afterSalesRequest, serviceContext);

    return startWorkflowInstance(userId, afterSalesRequest, serviceContext);
  }

  @Indexable(
      type = IndexableType.REINDEX
  )
  public AfterSalesRequest updateAfterSalesRequest(long afterSalesRequestId, String title,
      String description,
      Date dueDate, ServiceContext serviceContext)
      throws PortalException {

    AfterSalesRequest afterSalesRequest = getAfterSalesRequest(afterSalesRequestId);

    afterSalesRequest.setModifiedDate(new Date());
    afterSalesRequest.setTitle(title);
    afterSalesRequest.setDescription(description);

    afterSalesRequest = super.updateAfterSalesRequest(afterSalesRequest);

    updateAsset(afterSalesRequest, serviceContext);

    return afterSalesRequest;
  }


  @Indexable(
      type = IndexableType.DELETE
  )
  public AfterSalesRequest deleteAfterSalesRequest(long afterSalesRequestId)
      throws PortalException {

    AfterSalesRequest afterSalesRequest =
        afterSalesRequestLocalService.getAfterSalesRequest(afterSalesRequestId);

    resourceLocalService.deleteResource(
        afterSalesRequest, ResourceConstants.SCOPE_INDIVIDUAL);

    assetEntryLocalService.deleteEntry(AfterSalesRequest.class.getName(),
                                       afterSalesRequest.getAfterSalesRequestId());

    workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(afterSalesRequest.getCompanyId(),
                                                                 afterSalesRequest.getGroupId(),
                                                                 AfterSalesRequest.class.getName(),
                                                                 afterSalesRequest.getAfterSalesRequestId());

    return super.deleteAfterSalesRequest(afterSalesRequest);
  }

  public AfterSalesRequest updateStatus(long userId, long afterSalesRequestId, int status,
      ServiceContext serviceContext)
      throws PortalException, SystemException {

    User user = userLocalService.getUser(userId);
    AfterSalesRequest afterSalesRequest = getAfterSalesRequest(afterSalesRequestId);

    afterSalesRequest.setStatus(status);
    afterSalesRequest.setStatusByUserId(userId);
    afterSalesRequest.setStatusByUserName(user.getFullName());
    afterSalesRequest.setStatusDate(new Date());

    afterSalesRequestPersistence.update(afterSalesRequest);

    assetEntryLocalService
        .updateVisible(AfterSalesRequest.class.getName(), afterSalesRequestId,
                       status == WorkflowConstants.STATUS_APPROVED);

    return afterSalesRequest;
  }

  protected AfterSalesRequest startWorkflowInstance(long userId,
      AfterSalesRequest afterSalesRequest,
      ServiceContext serviceContext)
      throws PortalException {

    Map<String, Serializable> workflowContext = new HashMap<>();

    String userPortraitURL = StringPool.BLANK;
    String userURL = StringPool.BLANK;

    if (serviceContext.getThemeDisplay() != null) {
      User user = userLocalService.getUser(userId);

      userPortraitURL = user.getPortraitURL(serviceContext.getThemeDisplay());
      userURL = user.getDisplayURL(serviceContext.getThemeDisplay());
    }

    workflowContext.put(WorkflowConstants.CONTEXT_USER_PORTRAIT_URL, userPortraitURL);
    workflowContext.put(WorkflowConstants.CONTEXT_USER_URL, userURL);

    return WorkflowHandlerRegistryUtil.startWorkflowInstance(afterSalesRequest.getCompanyId(),
                                                             afterSalesRequest.getGroupId(),
                                                             userId,
                                                             AfterSalesRequest.class.getName(),
                                                             afterSalesRequest.getAfterSalesRequestId(),
                                                             afterSalesRequest, serviceContext,
                                                             workflowContext);
  }

  private void updateAsset(AfterSalesRequest afterSalesRequest, ServiceContext serviceContext)
      throws PortalException {

    assetEntryLocalService.updateEntry(serviceContext.getUserId(), serviceContext.getScopeGroupId(),
                                       afterSalesRequest.getCreateDate(),
                                       afterSalesRequest.getModifiedDate(),
                                       AfterSalesRequest.class.getName(),
                                       afterSalesRequest.getAfterSalesRequestId(),
                                       afterSalesRequest.getUuid(), 0,
                                       serviceContext.getAssetCategoryIds(),
                                       serviceContext.getAssetTagNames(), true, true,
                                       afterSalesRequest.getCreateDate(), null, null, null,
                                       ContentTypes.TEXT_HTML, afterSalesRequest.getTitle(),
                                       afterSalesRequest.getDescription(),
                                       null, null, null, 0, 0, serviceContext.getAssetPriority());
  }

}