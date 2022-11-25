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

package com.github.lgdd.liferay.commerce.after.sales.request.service.persistence.impl;

import com.github.lgdd.liferay.commerce.after.sales.request.exception.NoSuchAfterSalesRequestException;
import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequestTable;
import com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestImpl;
import com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestModelImpl;
import com.github.lgdd.liferay.commerce.after.sales.request.service.persistence.AfterSalesRequestPersistence;
import com.github.lgdd.liferay.commerce.after.sales.request.service.persistence.AfterSalesRequestUtil;
import com.github.lgdd.liferay.commerce.after.sales.request.service.persistence.impl.constants.DEV24PersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the after sales request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	service = {AfterSalesRequestPersistence.class, BasePersistence.class}
)
public class AfterSalesRequestPersistenceImpl
	extends BasePersistenceImpl<AfterSalesRequest>
	implements AfterSalesRequestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AfterSalesRequestUtil</code> to access the after sales request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AfterSalesRequestImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AfterSalesRequest afterSalesRequest : list) {
					if (!uuid.equals(afterSalesRequest.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByUuid_First(
			String uuid, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByUuid_First(
			uuid, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUuid_First(
		String uuid, OrderByComparator<AfterSalesRequest> orderByComparator) {

		List<AfterSalesRequest> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByUuid_Last(
			String uuid, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUuid_Last(
		String uuid, OrderByComparator<AfterSalesRequest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AfterSalesRequest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest[] findByUuid_PrevAndNext(
			long afterSalesRequestId, String uuid,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		uuid = Objects.toString(uuid, "");

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, afterSalesRequest, uuid, orderByComparator, true);

			array[1] = afterSalesRequest;

			array[2] = getByUuid_PrevAndNext(
				session, afterSalesRequest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest getByUuid_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, String uuid,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the after sales requests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AfterSalesRequest afterSalesRequest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"afterSalesRequest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(afterSalesRequest.uuid IS NULL OR afterSalesRequest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByUUID_G(String uuid, long groupId)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByUUID_G(uuid, groupId);

		if (afterSalesRequest == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAfterSalesRequestException(sb.toString());
		}

		return afterSalesRequest;
	}

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the after sales request where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof AfterSalesRequest) {
			AfterSalesRequest afterSalesRequest = (AfterSalesRequest)result;

			if (!Objects.equals(uuid, afterSalesRequest.getUuid()) ||
				(groupId != afterSalesRequest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<AfterSalesRequest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AfterSalesRequest afterSalesRequest = list.get(0);

					result = afterSalesRequest;

					cacheResult(afterSalesRequest);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AfterSalesRequest)result;
		}
	}

	/**
	 * Removes the after sales request where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the after sales request that was removed
	 */
	@Override
	public AfterSalesRequest removeByUUID_G(String uuid, long groupId)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = findByUUID_G(uuid, groupId);

		return remove(afterSalesRequest);
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"afterSalesRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(afterSalesRequest.uuid IS NULL OR afterSalesRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"afterSalesRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AfterSalesRequest afterSalesRequest : list) {
					if (!uuid.equals(afterSalesRequest.getUuid()) ||
						(companyId != afterSalesRequest.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AfterSalesRequest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the first after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		List<AfterSalesRequest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the last after sales request in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AfterSalesRequest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest[] findByUuid_C_PrevAndNext(
			long afterSalesRequestId, String uuid, long companyId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		uuid = Objects.toString(uuid, "");

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, afterSalesRequest, uuid, companyId, orderByComparator,
				true);

			array[1] = afterSalesRequest;

			array[2] = getByUuid_C_PrevAndNext(
				session, afterSalesRequest, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest getByUuid_C_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, String uuid,
		long companyId, OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the after sales requests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AfterSalesRequest afterSalesRequest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"afterSalesRequest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(afterSalesRequest.uuid IS NULL OR afterSalesRequest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"afterSalesRequest.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AfterSalesRequest afterSalesRequest : list) {
					if (groupId != afterSalesRequest.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByGroupId_First(
			long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByGroupId_First(
			groupId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the first after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByGroupId_First(
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator) {

		List<AfterSalesRequest> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByGroupId_Last(
			long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the last after sales request in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByGroupId_Last(
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<AfterSalesRequest> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest[] findByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, afterSalesRequest, groupId, orderByComparator, true);

			array[1] = afterSalesRequest;

			array[2] = getByGroupId_PrevAndNext(
				session, afterSalesRequest, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest getByGroupId_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	@Override
	public List<AfterSalesRequest> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
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
	@Override
	public List<AfterSalesRequest> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AFTERSALESREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, AfterSalesRequestImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, AfterSalesRequestImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<AfterSalesRequest>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public AfterSalesRequest[] filterFindByGroupId_PrevAndNext(
			long afterSalesRequestId, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				afterSalesRequestId, groupId, orderByComparator);
		}

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, afterSalesRequest, groupId, orderByComparator, true);

			array[1] = afterSalesRequest;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, afterSalesRequest, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest filterGetByGroupId_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AFTERSALESREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, AfterSalesRequestImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, AfterSalesRequestImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the after sales requests where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (AfterSalesRequest afterSalesRequest :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of after sales requests that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_AFTERSALESREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"afterSalesRequest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findByStatus(
		int status, int start, int end) {

		return findByStatus(status, start, end, null);
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
	@Override
	public List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findByStatus(
		int status, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AfterSalesRequest afterSalesRequest : list) {
					if (status != afterSalesRequest.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByStatus_First(
			int status, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByStatus_First(
			status, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByStatus_First(
		int status, OrderByComparator<AfterSalesRequest> orderByComparator) {

		List<AfterSalesRequest> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request
	 * @throws NoSuchAfterSalesRequestException if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest findByStatus_Last(
			int status, OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByStatus_Last(
			status, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByStatus_Last(
		int status, OrderByComparator<AfterSalesRequest> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<AfterSalesRequest> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest[] findByStatus_PrevAndNext(
			long afterSalesRequestId, int status,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, afterSalesRequest, status, orderByComparator, true);

			array[1] = afterSalesRequest;

			array[2] = getByStatus_PrevAndNext(
				session, afterSalesRequest, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest getByStatus_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, int status,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the after sales requests where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (AfterSalesRequest afterSalesRequest :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"afterSalesRequest.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findByG_S(int status, long groupId) {
		return findByG_S(
			status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end) {

		return findByG_S(status, groupId, start, end, null);
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
	@Override
	public List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findByG_S(status, groupId, start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {status, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				status, groupId, start, end, orderByComparator
			};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AfterSalesRequest afterSalesRequest : list) {
					if ((status != afterSalesRequest.getStatus()) ||
						(groupId != afterSalesRequest.getGroupId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(groupId);

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public AfterSalesRequest findByG_S_First(
			int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByG_S_First(
			status, groupId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the first after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByG_S_First(
		int status, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		List<AfterSalesRequest> list = findByG_S(
			status, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest findByG_S_Last(
			int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByG_S_Last(
			status, groupId, orderByComparator);

		if (afterSalesRequest != null) {
			return afterSalesRequest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAfterSalesRequestException(sb.toString());
	}

	/**
	 * Returns the last after sales request in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching after sales request, or <code>null</code> if a matching after sales request could not be found
	 */
	@Override
	public AfterSalesRequest fetchByG_S_Last(
		int status, long groupId,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		int count = countByG_S(status, groupId);

		if (count == 0) {
			return null;
		}

		List<AfterSalesRequest> list = findByG_S(
			status, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AfterSalesRequest[] findByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, afterSalesRequest, status, groupId, orderByComparator,
				true);

			array[1] = afterSalesRequest;

			array[2] = getByG_S_PrevAndNext(
				session, afterSalesRequest, status, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest getByG_S_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, int status,
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AFTERSALESREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching after sales requests that the user has permission to view
	 */
	@Override
	public List<AfterSalesRequest> filterFindByG_S(int status, long groupId) {
		return filterFindByG_S(
			status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end) {

		return filterFindByG_S(status, groupId, start, end, null);
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
	@Override
	public List<AfterSalesRequest> filterFindByG_S(
		int status, long groupId, int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(status, groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AFTERSALESREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, AfterSalesRequestImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, AfterSalesRequestImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(status);

			queryPos.add(groupId);

			return (List<AfterSalesRequest>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
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
	@Override
	public AfterSalesRequest[] filterFindByG_S_PrevAndNext(
			long afterSalesRequestId, int status, long groupId,
			OrderByComparator<AfterSalesRequest> orderByComparator)
		throws NoSuchAfterSalesRequestException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				afterSalesRequestId, status, groupId, orderByComparator);
		}

		AfterSalesRequest afterSalesRequest = findByPrimaryKey(
			afterSalesRequestId);

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest[] array = new AfterSalesRequestImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, afterSalesRequest, status, groupId, orderByComparator,
				true);

			array[1] = afterSalesRequest;

			array[2] = filterGetByG_S_PrevAndNext(
				session, afterSalesRequest, status, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AfterSalesRequest filterGetByG_S_PrevAndNext(
		Session session, AfterSalesRequest afterSalesRequest, int status,
		long groupId, OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_AFTERSALESREQUEST_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(AfterSalesRequestModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(
				_FILTER_ENTITY_ALIAS, AfterSalesRequestImpl.class);
		}
		else {
			sqlQuery.addEntity(
				_FILTER_ENTITY_TABLE, AfterSalesRequestImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(status);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						afterSalesRequest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AfterSalesRequest> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the after sales requests where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	@Override
	public void removeByG_S(int status, long groupId) {
		for (AfterSalesRequest afterSalesRequest :
				findByG_S(
					status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests
	 */
	@Override
	public int countByG_S(int status, long groupId) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {status, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AFTERSALESREQUEST_WHERE);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of after sales requests that the user has permission to view where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching after sales requests that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(int status, long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(status, groupId);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_AFTERSALESREQUEST_WHERE);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), AfterSalesRequest.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(status);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"afterSalesRequest.status = ? AND ";

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"afterSalesRequest.groupId = ?";

	public AfterSalesRequestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AfterSalesRequest.class);

		setModelImplClass(AfterSalesRequestImpl.class);
		setModelPKClass(long.class);

		setTable(AfterSalesRequestTable.INSTANCE);
	}

	/**
	 * Caches the after sales request in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequest the after sales request
	 */
	@Override
	public void cacheResult(AfterSalesRequest afterSalesRequest) {
		entityCache.putResult(
			AfterSalesRequestImpl.class, afterSalesRequest.getPrimaryKey(),
			afterSalesRequest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				afterSalesRequest.getUuid(), afterSalesRequest.getGroupId()
			},
			afterSalesRequest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the after sales requests in the entity cache if it is enabled.
	 *
	 * @param afterSalesRequests the after sales requests
	 */
	@Override
	public void cacheResult(List<AfterSalesRequest> afterSalesRequests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (afterSalesRequests.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AfterSalesRequest afterSalesRequest : afterSalesRequests) {
			if (entityCache.getResult(
					AfterSalesRequestImpl.class,
					afterSalesRequest.getPrimaryKey()) == null) {

				cacheResult(afterSalesRequest);
			}
		}
	}

	/**
	 * Clears the cache for all after sales requests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AfterSalesRequestImpl.class);

		finderCache.clearCache(AfterSalesRequestImpl.class);
	}

	/**
	 * Clears the cache for the after sales request.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AfterSalesRequest afterSalesRequest) {
		entityCache.removeResult(
			AfterSalesRequestImpl.class, afterSalesRequest);
	}

	@Override
	public void clearCache(List<AfterSalesRequest> afterSalesRequests) {
		for (AfterSalesRequest afterSalesRequest : afterSalesRequests) {
			entityCache.removeResult(
				AfterSalesRequestImpl.class, afterSalesRequest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AfterSalesRequestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AfterSalesRequestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AfterSalesRequestModelImpl afterSalesRequestModelImpl) {

		Object[] args = new Object[] {
			afterSalesRequestModelImpl.getUuid(),
			afterSalesRequestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, afterSalesRequestModelImpl);
	}

	/**
	 * Creates a new after sales request with the primary key. Does not add the after sales request to the database.
	 *
	 * @param afterSalesRequestId the primary key for the new after sales request
	 * @return the new after sales request
	 */
	@Override
	public AfterSalesRequest create(long afterSalesRequestId) {
		AfterSalesRequest afterSalesRequest = new AfterSalesRequestImpl();

		afterSalesRequest.setNew(true);
		afterSalesRequest.setPrimaryKey(afterSalesRequestId);

		String uuid = PortalUUIDUtil.generate();

		afterSalesRequest.setUuid(uuid);

		afterSalesRequest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return afterSalesRequest;
	}

	/**
	 * Removes the after sales request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request that was removed
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	@Override
	public AfterSalesRequest remove(long afterSalesRequestId)
		throws NoSuchAfterSalesRequestException {

		return remove((Serializable)afterSalesRequestId);
	}

	/**
	 * Removes the after sales request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the after sales request
	 * @return the after sales request that was removed
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	@Override
	public AfterSalesRequest remove(Serializable primaryKey)
		throws NoSuchAfterSalesRequestException {

		Session session = null;

		try {
			session = openSession();

			AfterSalesRequest afterSalesRequest =
				(AfterSalesRequest)session.get(
					AfterSalesRequestImpl.class, primaryKey);

			if (afterSalesRequest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAfterSalesRequestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(afterSalesRequest);
		}
		catch (NoSuchAfterSalesRequestException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AfterSalesRequest removeImpl(
		AfterSalesRequest afterSalesRequest) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(afterSalesRequest)) {
				afterSalesRequest = (AfterSalesRequest)session.get(
					AfterSalesRequestImpl.class,
					afterSalesRequest.getPrimaryKeyObj());
			}

			if (afterSalesRequest != null) {
				session.delete(afterSalesRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (afterSalesRequest != null) {
			clearCache(afterSalesRequest);
		}

		return afterSalesRequest;
	}

	@Override
	public AfterSalesRequest updateImpl(AfterSalesRequest afterSalesRequest) {
		boolean isNew = afterSalesRequest.isNew();

		if (!(afterSalesRequest instanceof AfterSalesRequestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(afterSalesRequest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					afterSalesRequest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in afterSalesRequest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AfterSalesRequest implementation " +
					afterSalesRequest.getClass());
		}

		AfterSalesRequestModelImpl afterSalesRequestModelImpl =
			(AfterSalesRequestModelImpl)afterSalesRequest;

		if (Validator.isNull(afterSalesRequest.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			afterSalesRequest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (afterSalesRequest.getCreateDate() == null)) {
			if (serviceContext == null) {
				afterSalesRequest.setCreateDate(date);
			}
			else {
				afterSalesRequest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!afterSalesRequestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				afterSalesRequest.setModifiedDate(date);
			}
			else {
				afterSalesRequest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(afterSalesRequest);
			}
			else {
				afterSalesRequest = (AfterSalesRequest)session.merge(
					afterSalesRequest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AfterSalesRequestImpl.class, afterSalesRequestModelImpl, false,
			true);

		cacheUniqueFindersCache(afterSalesRequestModelImpl);

		if (isNew) {
			afterSalesRequest.setNew(false);
		}

		afterSalesRequest.resetOriginalValues();

		return afterSalesRequest;
	}

	/**
	 * Returns the after sales request with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the after sales request
	 * @return the after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	@Override
	public AfterSalesRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAfterSalesRequestException {

		AfterSalesRequest afterSalesRequest = fetchByPrimaryKey(primaryKey);

		if (afterSalesRequest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAfterSalesRequestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return afterSalesRequest;
	}

	/**
	 * Returns the after sales request with the primary key or throws a <code>NoSuchAfterSalesRequestException</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request
	 * @throws NoSuchAfterSalesRequestException if a after sales request with the primary key could not be found
	 */
	@Override
	public AfterSalesRequest findByPrimaryKey(long afterSalesRequestId)
		throws NoSuchAfterSalesRequestException {

		return findByPrimaryKey((Serializable)afterSalesRequestId);
	}

	/**
	 * Returns the after sales request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param afterSalesRequestId the primary key of the after sales request
	 * @return the after sales request, or <code>null</code> if a after sales request with the primary key could not be found
	 */
	@Override
	public AfterSalesRequest fetchByPrimaryKey(long afterSalesRequestId) {
		return fetchByPrimaryKey((Serializable)afterSalesRequestId);
	}

	/**
	 * Returns all the after sales requests.
	 *
	 * @return the after sales requests
	 */
	@Override
	public List<AfterSalesRequest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AfterSalesRequest> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AfterSalesRequest> findAll(
		int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AfterSalesRequest> findAll(
		int start, int end,
		OrderByComparator<AfterSalesRequest> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AfterSalesRequest> list = null;

		if (useFinderCache) {
			list = (List<AfterSalesRequest>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AFTERSALESREQUEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AFTERSALESREQUEST;

				sql = sql.concat(AfterSalesRequestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AfterSalesRequest>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the after sales requests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AfterSalesRequest afterSalesRequest : findAll()) {
			remove(afterSalesRequest);
		}
	}

	/**
	 * Returns the number of after sales requests.
	 *
	 * @return the number of after sales requests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AFTERSALESREQUEST);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "afterSalesRequestId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AFTERSALESREQUEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AfterSalesRequestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the after sales request persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"status", "groupId"}, true);

		_finderPathWithoutPaginationFindByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, true);

		_finderPathCountByG_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, false);

		_setAfterSalesRequestUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAfterSalesRequestUtilPersistence(null);

		entityCache.removeCache(AfterSalesRequestImpl.class.getName());
	}

	private void _setAfterSalesRequestUtilPersistence(
		AfterSalesRequestPersistence afterSalesRequestPersistence) {

		try {
			Field field = AfterSalesRequestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, afterSalesRequestPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DEV24PersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DEV24PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DEV24PersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AFTERSALESREQUEST =
		"SELECT afterSalesRequest FROM AfterSalesRequest afterSalesRequest";

	private static final String _SQL_SELECT_AFTERSALESREQUEST_WHERE =
		"SELECT afterSalesRequest FROM AfterSalesRequest afterSalesRequest WHERE ";

	private static final String _SQL_COUNT_AFTERSALESREQUEST =
		"SELECT COUNT(afterSalesRequest) FROM AfterSalesRequest afterSalesRequest";

	private static final String _SQL_COUNT_AFTERSALESREQUEST_WHERE =
		"SELECT COUNT(afterSalesRequest) FROM AfterSalesRequest afterSalesRequest WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"afterSalesRequest.afterSalesRequestId";

	private static final String _FILTER_SQL_SELECT_AFTERSALESREQUEST_WHERE =
		"SELECT DISTINCT {afterSalesRequest.*} FROM DEV24_AfterSalesRequest afterSalesRequest WHERE ";

	private static final String
		_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {DEV24_AfterSalesRequest.*} FROM (SELECT DISTINCT afterSalesRequest.afterSalesRequestId FROM DEV24_AfterSalesRequest afterSalesRequest WHERE ";

	private static final String
		_FILTER_SQL_SELECT_AFTERSALESREQUEST_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN DEV24_AfterSalesRequest ON TEMP_TABLE.afterSalesRequestId = DEV24_AfterSalesRequest.afterSalesRequestId";

	private static final String _FILTER_SQL_COUNT_AFTERSALESREQUEST_WHERE =
		"SELECT COUNT(DISTINCT afterSalesRequest.afterSalesRequestId) AS COUNT_VALUE FROM DEV24_AfterSalesRequest afterSalesRequest WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "afterSalesRequest";

	private static final String _FILTER_ENTITY_TABLE =
		"DEV24_AfterSalesRequest";

	private static final String _ORDER_BY_ENTITY_ALIAS = "afterSalesRequest.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"DEV24_AfterSalesRequest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AfterSalesRequest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AfterSalesRequest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AfterSalesRequestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private AfterSalesRequestModelArgumentsResolver
		_afterSalesRequestModelArgumentsResolver;

}