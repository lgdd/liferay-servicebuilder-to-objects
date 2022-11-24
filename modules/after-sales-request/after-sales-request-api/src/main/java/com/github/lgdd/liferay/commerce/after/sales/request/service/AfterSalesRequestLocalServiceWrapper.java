/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.github.lgdd.liferay.commerce.after.sales.request.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AfterSalesRequestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestLocalService
 * @generated
 */
public class AfterSalesRequestLocalServiceWrapper
	implements AfterSalesRequestLocalService,
			   ServiceWrapper<AfterSalesRequestLocalService> {

	public AfterSalesRequestLocalServiceWrapper(
		AfterSalesRequestLocalService afterSalesRequestLocalService) {

		_afterSalesRequestLocalService = afterSalesRequestLocalService;
	}

	/**
	 * Adds the after sales request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AfterSalesRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param afterSalesRequest the after sales request
	 * @return the after sales request that was added
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest addAfterSalesRequest(
				com.github.lgdd.liferay.commerce.after.sales.request.model.
					AfterSalesRequest afterSalesRequest) {

		return _afterSalesRequestLocalService.addAfterSalesRequest(
			afterSalesRequest);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest addAfterSalesRequest(
					String title, String description, long commerceOrderId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.addAfterSalesRequest(
			title, description, commerceOrderId, serviceContext);
	}

	/**
	 * Creates a new after sales request with the primary key. Does not add the after sales request to the database.
	 *
	 * @param afterSalesRequestId the primary key for the new after sales request
	 * @return the new after sales request
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest createAfterSalesRequest(
				long afterSalesRequestId) {

		return _afterSalesRequestLocalService.createAfterSalesRequest(
			afterSalesRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the after sales request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AfterSalesRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param afterSalesRequest the after sales request
	 * @return the after sales request that was removed
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest deleteAfterSalesRequest(
				com.github.lgdd.liferay.commerce.after.sales.request.model.
					AfterSalesRequest afterSalesRequest) {

		return _afterSalesRequestLocalService.deleteAfterSalesRequest(
			afterSalesRequest);
	}

	/**
	 * Deletes the after sales request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AfterSalesRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request that was removed
	 * @throws PortalException if a after sales request with the primary key could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest deleteAfterSalesRequest(long afterSalesRequestId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.deleteAfterSalesRequest(
			afterSalesRequestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _afterSalesRequestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _afterSalesRequestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _afterSalesRequestLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _afterSalesRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _afterSalesRequestLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _afterSalesRequestLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _afterSalesRequestLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _afterSalesRequestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest fetchAfterSalesRequest(long afterSalesRequestId) {

		return _afterSalesRequestLocalService.fetchAfterSalesRequest(
			afterSalesRequestId);
	}

	/**
	 * Returns the after sales request matching the UUID and group.
	 *
	 * @param uuid the after sales request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest fetchAfterSalesRequestByUuidAndGroupId(
				String uuid, long groupId) {

		return _afterSalesRequestLocalService.
			fetchAfterSalesRequestByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _afterSalesRequestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the after sales request with the primary key.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request
	 * @throws PortalException if a after sales request with the primary key could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest getAfterSalesRequest(long afterSalesRequestId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.getAfterSalesRequest(
			afterSalesRequestId);
	}

	/**
	 * Returns the after sales request matching the UUID and group.
	 *
	 * @param uuid the after sales request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching after sales request
	 * @throws PortalException if a matching after sales request could not be found
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest getAfterSalesRequestByUuidAndGroupId(
					String uuid, long groupId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.
			getAfterSalesRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the after sales requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of after sales requests
	 */
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest> getAfterSalesRequests(int start, int end) {

		return _afterSalesRequestLocalService.getAfterSalesRequests(start, end);
	}

	/**
	 * Returns all the after sales requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the after sales requests
	 * @param companyId the primary key of the company
	 * @return the matching after sales requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest> getAfterSalesRequestsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _afterSalesRequestLocalService.
			getAfterSalesRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of after sales requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the after sales requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching after sales requests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest> getAfterSalesRequestsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.github.lgdd.liferay.commerce.after.sales.request.model.
						AfterSalesRequest> orderByComparator) {

		return _afterSalesRequestLocalService.
			getAfterSalesRequestsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of after sales requests.
	 *
	 * @return the number of after sales requests
	 */
	@Override
	public int getAfterSalesRequestsCount() {
		return _afterSalesRequestLocalService.getAfterSalesRequestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _afterSalesRequestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _afterSalesRequestLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _afterSalesRequestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the after sales request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AfterSalesRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param afterSalesRequest the after sales request
	 * @return the after sales request that was updated
	 */
	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest updateAfterSalesRequest(
				com.github.lgdd.liferay.commerce.after.sales.request.model.
					AfterSalesRequest afterSalesRequest) {

		return _afterSalesRequestLocalService.updateAfterSalesRequest(
			afterSalesRequest);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest updateAfterSalesRequest(
					long afterSalesRequestId, String title, String description,
					long commerceOrderId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestLocalService.updateAfterSalesRequest(
			afterSalesRequestId, title, description, commerceOrderId,
			serviceContext);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest updateStatus(
					long userId, long afterSalesRequestId, int status,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException,
					   com.liferay.portal.kernel.exception.SystemException {

		return _afterSalesRequestLocalService.updateStatus(
			userId, afterSalesRequestId, status, serviceContext);
	}

	@Override
	public AfterSalesRequestLocalService getWrappedService() {
		return _afterSalesRequestLocalService;
	}

	@Override
	public void setWrappedService(
		AfterSalesRequestLocalService afterSalesRequestLocalService) {

		_afterSalesRequestLocalService = afterSalesRequestLocalService;
	}

	private AfterSalesRequestLocalService _afterSalesRequestLocalService;

}