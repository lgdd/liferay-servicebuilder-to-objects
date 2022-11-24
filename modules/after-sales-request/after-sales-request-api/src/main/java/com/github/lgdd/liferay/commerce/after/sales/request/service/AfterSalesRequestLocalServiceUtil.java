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

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AfterSalesRequest. This utility wraps
 * <code>com.github.lgdd.liferay.commerce.after.sales.request.service.impl.AfterSalesRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestLocalService
 * @generated
 */
public class AfterSalesRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.github.lgdd.liferay.commerce.after.sales.request.service.impl.AfterSalesRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AfterSalesRequest addAfterSalesRequest(
		AfterSalesRequest afterSalesRequest) {

		return getService().addAfterSalesRequest(afterSalesRequest);
	}

	public static AfterSalesRequest addAfterSalesRequest(
			String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAfterSalesRequest(
			title, description, serviceContext);
	}

	/**
	 * Creates a new after sales request with the primary key. Does not add the after sales request to the database.
	 *
	 * @param afterSalesRequestId the primary key for the new after sales request
	 * @return the new after sales request
	 */
	public static AfterSalesRequest createAfterSalesRequest(
		long afterSalesRequestId) {

		return getService().createAfterSalesRequest(afterSalesRequestId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static AfterSalesRequest deleteAfterSalesRequest(
		AfterSalesRequest afterSalesRequest) {

		return getService().deleteAfterSalesRequest(afterSalesRequest);
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
	public static AfterSalesRequest deleteAfterSalesRequest(
			long afterSalesRequestId)
		throws PortalException {

		return getService().deleteAfterSalesRequest(afterSalesRequestId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AfterSalesRequest fetchAfterSalesRequest(
		long afterSalesRequestId) {

		return getService().fetchAfterSalesRequest(afterSalesRequestId);
	}

	/**
	 * Returns the after sales request matching the UUID and group.
	 *
	 * @param uuid the after sales request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchAfterSalesRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAfterSalesRequestByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the after sales request with the primary key.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request
	 * @throws PortalException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest getAfterSalesRequest(
			long afterSalesRequestId)
		throws PortalException {

		return getService().getAfterSalesRequest(afterSalesRequestId);
	}

	/**
	 * Returns the after sales request matching the UUID and group.
	 *
	 * @param uuid the after sales request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching after sales request
	 * @throws PortalException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest getAfterSalesRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAfterSalesRequestByUuidAndGroupId(uuid, groupId);
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
	public static List<AfterSalesRequest> getAfterSalesRequests(
		int start, int end) {

		return getService().getAfterSalesRequests(start, end);
	}

	/**
	 * Returns all the after sales requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the after sales requests
	 * @param companyId the primary key of the company
	 * @return the matching after sales requests, or an empty list if no matches were found
	 */
	public static List<AfterSalesRequest>
		getAfterSalesRequestsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAfterSalesRequestsByUuidAndCompanyId(
			uuid, companyId);
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
	public static List<AfterSalesRequest>
		getAfterSalesRequestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getService().getAfterSalesRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of after sales requests.
	 *
	 * @return the number of after sales requests
	 */
	public static int getAfterSalesRequestsCount() {
		return getService().getAfterSalesRequestsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static AfterSalesRequest updateAfterSalesRequest(
		AfterSalesRequest afterSalesRequest) {

		return getService().updateAfterSalesRequest(afterSalesRequest);
	}

	public static AfterSalesRequest updateAfterSalesRequest(
			long afterSalesRequestId, String title, String description,
			java.util.Date dueDate,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateAfterSalesRequest(
			afterSalesRequestId, title, description, dueDate, serviceContext);
	}

	public static AfterSalesRequest updateStatus(
			long userId, long afterSalesRequestId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException, SystemException {

		return getService().updateStatus(
			userId, afterSalesRequestId, status, serviceContext);
	}

	public static AfterSalesRequestLocalService getService() {
		return _service;
	}

	private static volatile AfterSalesRequestLocalService _service;

}