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

package com.github.lgdd.liferay.commerce.after.sales.request.model.impl;

import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequest;
import com.github.lgdd.liferay.commerce.after.sales.request.model.AfterSalesRequestModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AfterSalesRequest service. Represents a row in the &quot;DEV24_AfterSalesRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AfterSalesRequestModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AfterSalesRequestImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestImpl
 * @generated
 */
public class AfterSalesRequestModelImpl
	extends BaseModelImpl<AfterSalesRequest> implements AfterSalesRequestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a after sales request model instance should use the <code>AfterSalesRequest</code> interface instead.
	 */
	public static final String TABLE_NAME = "DEV24_AfterSalesRequest";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"afterSalesRequestId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"title", Types.VARCHAR}, {"description", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("afterSalesRequestId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DEV24_AfterSalesRequest (uuid_ VARCHAR(75) null,afterSalesRequestId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,title VARCHAR(75) null,description VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table DEV24_AfterSalesRequest";

	public static final String ORDER_BY_JPQL =
		" ORDER BY afterSalesRequest.title ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DEV24_AfterSalesRequest.title ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long TITLE_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public AfterSalesRequestModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _afterSalesRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAfterSalesRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _afterSalesRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AfterSalesRequest.class;
	}

	@Override
	public String getModelClassName() {
		return AfterSalesRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AfterSalesRequest, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AfterSalesRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AfterSalesRequest, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AfterSalesRequest)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AfterSalesRequest, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AfterSalesRequest, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AfterSalesRequest)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AfterSalesRequest, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AfterSalesRequest, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AfterSalesRequest>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AfterSalesRequest.class.getClassLoader(), AfterSalesRequest.class,
			ModelWrapper.class);

		try {
			Constructor<AfterSalesRequest> constructor =
				(Constructor<AfterSalesRequest>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<AfterSalesRequest, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AfterSalesRequest, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AfterSalesRequest, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<AfterSalesRequest, Object>>();
		Map<String, BiConsumer<AfterSalesRequest, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<AfterSalesRequest, ?>>();

		attributeGetterFunctions.put("uuid", AfterSalesRequest::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<AfterSalesRequest, String>)AfterSalesRequest::setUuid);
		attributeGetterFunctions.put(
			"afterSalesRequestId", AfterSalesRequest::getAfterSalesRequestId);
		attributeSetterBiConsumers.put(
			"afterSalesRequestId",
			(BiConsumer<AfterSalesRequest, Long>)
				AfterSalesRequest::setAfterSalesRequestId);
		attributeGetterFunctions.put("groupId", AfterSalesRequest::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AfterSalesRequest, Long>)AfterSalesRequest::setGroupId);
		attributeGetterFunctions.put(
			"companyId", AfterSalesRequest::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AfterSalesRequest, Long>)
				AfterSalesRequest::setCompanyId);
		attributeGetterFunctions.put("userId", AfterSalesRequest::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<AfterSalesRequest, Long>)AfterSalesRequest::setUserId);
		attributeGetterFunctions.put(
			"userName", AfterSalesRequest::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AfterSalesRequest, String>)
				AfterSalesRequest::setUserName);
		attributeGetterFunctions.put(
			"createDate", AfterSalesRequest::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AfterSalesRequest, Date>)
				AfterSalesRequest::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AfterSalesRequest::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AfterSalesRequest, Date>)
				AfterSalesRequest::setModifiedDate);
		attributeGetterFunctions.put("status", AfterSalesRequest::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<AfterSalesRequest, Integer>)
				AfterSalesRequest::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", AfterSalesRequest::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<AfterSalesRequest, Long>)
				AfterSalesRequest::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", AfterSalesRequest::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<AfterSalesRequest, String>)
				AfterSalesRequest::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", AfterSalesRequest::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<AfterSalesRequest, Date>)
				AfterSalesRequest::setStatusDate);
		attributeGetterFunctions.put("title", AfterSalesRequest::getTitle);
		attributeSetterBiConsumers.put(
			"title",
			(BiConsumer<AfterSalesRequest, String>)AfterSalesRequest::setTitle);
		attributeGetterFunctions.put(
			"description", AfterSalesRequest::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<AfterSalesRequest, String>)
				AfterSalesRequest::setDescription);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getAfterSalesRequestId() {
		return _afterSalesRequestId;
	}

	@Override
	public void setAfterSalesRequestId(long afterSalesRequestId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_afterSalesRequestId = afterSalesRequestId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AfterSalesRequest.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AfterSalesRequest.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AfterSalesRequest toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AfterSalesRequest>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AfterSalesRequestImpl afterSalesRequestImpl =
			new AfterSalesRequestImpl();

		afterSalesRequestImpl.setUuid(getUuid());
		afterSalesRequestImpl.setAfterSalesRequestId(getAfterSalesRequestId());
		afterSalesRequestImpl.setGroupId(getGroupId());
		afterSalesRequestImpl.setCompanyId(getCompanyId());
		afterSalesRequestImpl.setUserId(getUserId());
		afterSalesRequestImpl.setUserName(getUserName());
		afterSalesRequestImpl.setCreateDate(getCreateDate());
		afterSalesRequestImpl.setModifiedDate(getModifiedDate());
		afterSalesRequestImpl.setStatus(getStatus());
		afterSalesRequestImpl.setStatusByUserId(getStatusByUserId());
		afterSalesRequestImpl.setStatusByUserName(getStatusByUserName());
		afterSalesRequestImpl.setStatusDate(getStatusDate());
		afterSalesRequestImpl.setTitle(getTitle());
		afterSalesRequestImpl.setDescription(getDescription());

		afterSalesRequestImpl.resetOriginalValues();

		return afterSalesRequestImpl;
	}

	@Override
	public AfterSalesRequest cloneWithOriginalValues() {
		AfterSalesRequestImpl afterSalesRequestImpl =
			new AfterSalesRequestImpl();

		afterSalesRequestImpl.setUuid(
			this.<String>getColumnOriginalValue("uuid_"));
		afterSalesRequestImpl.setAfterSalesRequestId(
			this.<Long>getColumnOriginalValue("afterSalesRequestId"));
		afterSalesRequestImpl.setGroupId(
			this.<Long>getColumnOriginalValue("groupId"));
		afterSalesRequestImpl.setCompanyId(
			this.<Long>getColumnOriginalValue("companyId"));
		afterSalesRequestImpl.setUserId(
			this.<Long>getColumnOriginalValue("userId"));
		afterSalesRequestImpl.setUserName(
			this.<String>getColumnOriginalValue("userName"));
		afterSalesRequestImpl.setCreateDate(
			this.<Date>getColumnOriginalValue("createDate"));
		afterSalesRequestImpl.setModifiedDate(
			this.<Date>getColumnOriginalValue("modifiedDate"));
		afterSalesRequestImpl.setStatus(
			this.<Integer>getColumnOriginalValue("status"));
		afterSalesRequestImpl.setStatusByUserId(
			this.<Long>getColumnOriginalValue("statusByUserId"));
		afterSalesRequestImpl.setStatusByUserName(
			this.<String>getColumnOriginalValue("statusByUserName"));
		afterSalesRequestImpl.setStatusDate(
			this.<Date>getColumnOriginalValue("statusDate"));
		afterSalesRequestImpl.setTitle(
			this.<String>getColumnOriginalValue("title"));
		afterSalesRequestImpl.setDescription(
			this.<String>getColumnOriginalValue("description"));

		return afterSalesRequestImpl;
	}

	@Override
	public int compareTo(AfterSalesRequest afterSalesRequest) {
		int value = 0;

		value = getTitle().compareTo(afterSalesRequest.getTitle());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AfterSalesRequest)) {
			return false;
		}

		AfterSalesRequest afterSalesRequest = (AfterSalesRequest)object;

		long primaryKey = afterSalesRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<AfterSalesRequest> toCacheModel() {
		AfterSalesRequestCacheModel afterSalesRequestCacheModel =
			new AfterSalesRequestCacheModel();

		afterSalesRequestCacheModel.uuid = getUuid();

		String uuid = afterSalesRequestCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			afterSalesRequestCacheModel.uuid = null;
		}

		afterSalesRequestCacheModel.afterSalesRequestId =
			getAfterSalesRequestId();

		afterSalesRequestCacheModel.groupId = getGroupId();

		afterSalesRequestCacheModel.companyId = getCompanyId();

		afterSalesRequestCacheModel.userId = getUserId();

		afterSalesRequestCacheModel.userName = getUserName();

		String userName = afterSalesRequestCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			afterSalesRequestCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			afterSalesRequestCacheModel.createDate = createDate.getTime();
		}
		else {
			afterSalesRequestCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			afterSalesRequestCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			afterSalesRequestCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		afterSalesRequestCacheModel.status = getStatus();

		afterSalesRequestCacheModel.statusByUserId = getStatusByUserId();

		afterSalesRequestCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = afterSalesRequestCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			afterSalesRequestCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			afterSalesRequestCacheModel.statusDate = statusDate.getTime();
		}
		else {
			afterSalesRequestCacheModel.statusDate = Long.MIN_VALUE;
		}

		afterSalesRequestCacheModel.title = getTitle();

		String title = afterSalesRequestCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			afterSalesRequestCacheModel.title = null;
		}

		afterSalesRequestCacheModel.description = getDescription();

		String description = afterSalesRequestCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			afterSalesRequestCacheModel.description = null;
		}

		return afterSalesRequestCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AfterSalesRequest, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AfterSalesRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AfterSalesRequest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply(
				(AfterSalesRequest)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		Map<String, Function<AfterSalesRequest, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AfterSalesRequest, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AfterSalesRequest, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AfterSalesRequest)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AfterSalesRequest>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _afterSalesRequestId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _description;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AfterSalesRequest, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AfterSalesRequest)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("afterSalesRequestId", _afterSalesRequestId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("afterSalesRequestId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("status", 256L);

		columnBitmasks.put("statusByUserId", 512L);

		columnBitmasks.put("statusByUserName", 1024L);

		columnBitmasks.put("statusDate", 2048L);

		columnBitmasks.put("title", 4096L);

		columnBitmasks.put("description", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AfterSalesRequest _escapedModel;

}