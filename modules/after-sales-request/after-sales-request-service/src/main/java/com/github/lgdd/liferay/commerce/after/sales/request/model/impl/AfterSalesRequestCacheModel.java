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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AfterSalesRequest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AfterSalesRequestCacheModel
	implements CacheModel<AfterSalesRequest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AfterSalesRequestCacheModel)) {
			return false;
		}

		AfterSalesRequestCacheModel afterSalesRequestCacheModel =
			(AfterSalesRequestCacheModel)object;

		if (afterSalesRequestId ==
				afterSalesRequestCacheModel.afterSalesRequestId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, afterSalesRequestId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", afterSalesRequestId=");
		sb.append(afterSalesRequestId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", commerceOrderId=");
		sb.append(commerceOrderId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AfterSalesRequest toEntityModel() {
		AfterSalesRequestImpl afterSalesRequestImpl =
			new AfterSalesRequestImpl();

		if (uuid == null) {
			afterSalesRequestImpl.setUuid("");
		}
		else {
			afterSalesRequestImpl.setUuid(uuid);
		}

		afterSalesRequestImpl.setAfterSalesRequestId(afterSalesRequestId);
		afterSalesRequestImpl.setGroupId(groupId);
		afterSalesRequestImpl.setCompanyId(companyId);
		afterSalesRequestImpl.setUserId(userId);

		if (userName == null) {
			afterSalesRequestImpl.setUserName("");
		}
		else {
			afterSalesRequestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			afterSalesRequestImpl.setCreateDate(null);
		}
		else {
			afterSalesRequestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			afterSalesRequestImpl.setModifiedDate(null);
		}
		else {
			afterSalesRequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		afterSalesRequestImpl.setStatus(status);
		afterSalesRequestImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			afterSalesRequestImpl.setStatusByUserName("");
		}
		else {
			afterSalesRequestImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			afterSalesRequestImpl.setStatusDate(null);
		}
		else {
			afterSalesRequestImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			afterSalesRequestImpl.setTitle("");
		}
		else {
			afterSalesRequestImpl.setTitle(title);
		}

		if (description == null) {
			afterSalesRequestImpl.setDescription("");
		}
		else {
			afterSalesRequestImpl.setDescription(description);
		}

		afterSalesRequestImpl.setCommerceOrderId(commerceOrderId);

		afterSalesRequestImpl.resetOriginalValues();

		return afterSalesRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		afterSalesRequestId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		commerceOrderId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(afterSalesRequestId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(commerceOrderId);
	}

	public String uuid;
	public long afterSalesRequestId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String description;
	public long commerceOrderId;

}