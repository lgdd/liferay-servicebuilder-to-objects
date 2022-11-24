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

package com.github.lgdd.liferay.commerce.after.sales.request.service.persistence;

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the after sales request service. This utility wraps <code>com.github.lgdd.liferay.commerce.after.sales.request.service.persistence.impl.AfterSalesRequestPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestPersistence
 * @generated
 */
public class AfterSalesRequestUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AfterSalesRequest afterSalesRequest) {
		getPersistence().clearCache(afterSalesRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AfterSalesRequest> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AfterSalesRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AfterSalesRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AfterSalesRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AfterSalesRequest update(
		AfterSalesRequest afterSalesRequest) {

		return getPersistence().update(afterSalesRequest);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AfterSalesRequest update(
		AfterSalesRequest afterSalesRequest, ServiceContext serviceContext) {

		return getPersistence().update(afterSalesRequest, serviceContext);
	}

	/**
	 * Returns all the after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the after sales requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByUuid_First(
			String uuid, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUuid_First(
		String uuid, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByUuid_Last(
			String uuid, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUuid_Last(
		String uuid, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] findByUuid_PrevAndNext(
			long afterSalesRequestId, String uuid,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_PrevAndNext(
			afterSalesRequestId, uuid, orderByComparator);
	}

	/**
	 * Removes all the after sales requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching after sales requests
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByUUID_G(String uuid, long groupId)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the after sales request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the after sales request that was removed
	 */
	public static AfterSalesRequest removeByUUID_G(String uuid, long groupId)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] findByUuid_C_PrevAndNext(
			long afterSalesRequestId, String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByUuid_C_PrevAndNext(
			afterSalesRequestId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the after sales requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching after sales requests
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	public static List<AfterSalesRequest> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the after sales requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByGroupId_First(
			long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByGroupId_First(
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByGroupId_Last(
			long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByGroupId_Last(
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] findByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByGroupId_PrevAndNext(
			afterSalesRequestId, groupId, orderByComparator);
	}

	/**
	 * Returns all the after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set of after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] filterFindByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			afterSalesRequestId, groupId, orderByComparator);
	}

	/**
	 * Removes all the after sales requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching after sales requests
	 */
	public static List<AfterSalesRequest> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the after sales requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByStatus_First(
			int status, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByStatus_First(
		int status, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByStatus_Last(
			int status, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByStatus_Last(
		int status, OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where status = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] findByStatus_PrevAndNext(
			long afterSalesRequestId, int status,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByStatus_PrevAndNext(
			afterSalesRequestId, status, orderByComparator);
	}

	/**
	 * Removes all the after sales requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching after sales requests
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	public static List<AfterSalesRequest> findByG_S(int status, long groupId) {
		return getPersistence().findByG_S(status, groupId);
	}

	/**
	 * Returns a range of all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end) {

		return getPersistence().findByG_S(status, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findByG_S(
			status, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching after sales requests
	 */
	public static List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			status, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByG_S_First(
			int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByG_S_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByG_S_First(
		int status, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public static AfterSalesRequest findByG_S_Last(
			int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByG_S_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public static AfterSalesRequest fetchByG_S_Last(
		int status, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] findByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByG_S_PrevAndNext(
			afterSalesRequestId, status, groupId, orderByComparator);
	}

	/**
	 * Returns all the after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId) {

		return getPersistence().filterFindByG_S(status, groupId);
	}

	/**
	 * Returns a range of all the after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end) {

		return getPersistence().filterFindByG_S(status, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests that the user has permissions to view where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching after sales requests that the user has permission to view
	 */
	public static List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().filterFindByG_S(
			status, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set of after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest[] filterFindByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			afterSalesRequestId, status, groupId, orderByComparator);
	}

	/**
	 * Removes all the after sales requests where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public static void removeByG_S(int status, long groupId) {
		getPersistence().removeByG_S(status, groupId);
	}

	/**
	 * Returns the number of after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public static int countByG_S(int status, long groupId) {
		return getPersistence().countByG_S(status, groupId);
	}

	/**
	 * Returns the number of after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	public static int filterCountByG_S(int status, long groupId) {
		return getPersistence().filterCountByG_S(status, groupId);
	}

	/**
	 * Caches the after sales request in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequest the after sales request
	 */
	public static void cacheResult(AfterSalesRequest afterSalesRequest) {
		getPersistence().cacheResult(afterSalesRequest);
	}

	/**
	 * Caches the after sales requests in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequests the after sales requests
	 */
	public static void cacheResult(List<AfterSalesRequest> afterSalesRequests) {
		getPersistence().cacheResult(afterSalesRequests);
	}

	/**
	 * Creates a new after sales request with the primary key. Does not add the after sales request to the database.
	 *
	 * @param afterSalesRequestId the primary key for the new after sales request
	 * @return the new after sales request
	 */
	public static AfterSalesRequest create(long afterSalesRequestId) {
		return getPersistence().create(afterSalesRequestId);
	}

	/**
	 * Removes the after sales request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request that was removed
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest remove(long afterSalesRequestId)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().remove(afterSalesRequestId);
	}

	public static AfterSalesRequest updateImpl(
		AfterSalesRequest afterSalesRequest) {

		return getPersistence().updateImpl(afterSalesRequest);
	}

	/**
	 * Returns the after sales request with the primary key or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest findByPrimaryKey(long afterSalesRequestId)
		throws com.github.lgdd.liferay.commerce.after.sales.request.exception.
			NoSuchAfterSalesRequestException {

		return getPersistence().findByPrimaryKey(afterSalesRequestId);
	}

	/**
	 * Returns the after sales request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request, or <code>null</code> if a after sales request with the primary key could not be found
	 */
	public static AfterSalesRequest fetchByPrimaryKey(
		long afterSalesRequestId) {

		return getPersistence().fetchByPrimaryKey(afterSalesRequestId);
	}

	/**
	 * Returns all the after sales requests.
	 *
	 * @return the after sales requests
	 */
	public static List<AfterSalesRequest> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the after sales requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @return the range of after sales requests
	 */
	public static List<AfterSalesRequest> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the after sales requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of after sales requests
	 */
	public static List<AfterSalesRequest> findAll(
		int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the after sales requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AfterSalesRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of after sales requests
	 * @param end the upper bound of the range of after sales requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of after sales requests
	 */
	public static List<AfterSalesRequest> findAll(
		int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the after sales requests from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of after sales requests.
	 *
	 * @return the number of after sales requests
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AfterSalesRequestPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AfterSalesRequestPersistence _persistence;

}