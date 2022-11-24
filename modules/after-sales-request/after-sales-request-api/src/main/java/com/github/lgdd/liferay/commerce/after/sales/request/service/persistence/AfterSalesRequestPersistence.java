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

import com.github.lgdd.liferay.commerce.after.sales.request.exception.NoSuchAfterSalesRequestException;
import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the after sales request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestUtil
 * @generated
 */
@ProviderType
public interface AfterSalesRequestPersistence
	extends BasePersistence<AfterSalesRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AfterSalesRequestUtil} to access the after sales request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching after sales requests
	 */
	public java.util.List<AfterSalesRequest> findByUuid(String uuid);

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
	public java.util.List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest[] findByUuid_PrevAndNext(
			long afterSalesRequestId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Removes all the after sales requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching after sales requests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the after sales request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the after sales request that was removed
	 */
	public AfterSalesRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the number of after sales requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching after sales requests
	 */
	public java.util.List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public AfterSalesRequest[] findByUuid_C_PrevAndNext(
			long afterSalesRequestId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Removes all the after sales requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching after sales requests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	public java.util.List<AfterSalesRequest> findByGroupId(long groupId);

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
	public java.util.List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest[] findByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns all the after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	public java.util.List<AfterSalesRequest> filterFindByGroupId(long groupId);

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
	public java.util.List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set of after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest[] filterFindByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Removes all the after sales requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching after sales requests
	 */
	public java.util.List<AfterSalesRequest> findByStatus(int status);

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
	public java.util.List<AfterSalesRequest> findByStatus(
		int status, int start, int end);

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
	public java.util.List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the after sales requests before and after the current after sales request in the ordered set where status = &#63;.
	 *
	 * @param afterSalesRequestId the primary key of the current after sales request
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest[] findByStatus_PrevAndNext(
			long afterSalesRequestId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Removes all the after sales requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching after sales requests
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	public java.util.List<AfterSalesRequest> findByG_S(
		int status, long groupId);

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
	public java.util.List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end);

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
	public java.util.List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByG_S_First(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the first after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByG_S_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

	/**
	 * Returns the last after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	public AfterSalesRequest findByG_S_Last(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the last after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	public AfterSalesRequest fetchByG_S_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public AfterSalesRequest[] findByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns all the after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	public java.util.List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId);

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
	public java.util.List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end);

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
	public java.util.List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public AfterSalesRequest[] filterFindByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
				orderByComparator)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Removes all the after sales requests where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public void removeByG_S(int status, long groupId);

	/**
	 * Returns the number of after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	public int countByG_S(int status, long groupId);

	/**
	 * Returns the number of after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	public int filterCountByG_S(int status, long groupId);

	/**
	 * Caches the after sales request in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequest the after sales request
	 */
	public void cacheResult(AfterSalesRequest afterSalesRequest);

	/**
	 * Caches the after sales requests in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequests the after sales requests
	 */
	public void cacheResult(
		java.util.List<AfterSalesRequest> afterSalesRequests);

	/**
	 * Creates a new after sales request with the primary key. Does not add the after sales request to the database.
	 *
	 * @param afterSalesRequestId the primary key for the new after sales request
	 * @return the new after sales request
	 */
	public AfterSalesRequest create(long afterSalesRequestId);

	/**
	 * Removes the after sales request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request that was removed
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest remove(long afterSalesRequestId)
		throws NoSuchAfterSalesRequestException;

	public AfterSalesRequest updateImpl(AfterSalesRequest afterSalesRequest);

	/**
	 * Returns the after sales request with the primary key or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest findByPrimaryKey(long afterSalesRequestId)
		throws NoSuchAfterSalesRequestException;

	/**
	 * Returns the after sales request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request, or <code>null</code> if a after sales request with the primary key could not be found
	 */
	public AfterSalesRequest fetchByPrimaryKey(long afterSalesRequestId);

	/**
	 * Returns all the after sales requests.
	 *
	 * @return the after sales requests
	 */
	public java.util.List<AfterSalesRequest> findAll();

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
	public java.util.List<AfterSalesRequest> findAll(int start, int end);

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
	public java.util.List<AfterSalesRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator);

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
	public java.util.List<AfterSalesRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AfterSalesRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the after sales requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of after sales requests.
	 *
	 * @return the number of after sales requests
	 */
	public int countAll();

}