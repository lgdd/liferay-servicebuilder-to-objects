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

package com.github.lgdd.liferay.commerce.after.sales.request.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AfterSalesRequest service. Represents a row in the &quot;DEV24_AfterSalesRequest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestModel
 * @generated
 */
@ImplementationClassName(
	"com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestImpl"
)
@ProviderType
public interface AfterSalesRequest
	extends AfterSalesRequestModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.github.lgdd.liferay.commerce.after.sales.request.model.impl.AfterSalesRequestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AfterSalesRequest, Long>
		AFTER_SALES_REQUEST_ID_ACCESSOR =
			new Accessor<AfterSalesRequest, Long>() {

				@Override
				public Long get(AfterSalesRequest afterSalesRequest) {
					return afterSalesRequest.getAfterSalesRequestId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AfterSalesRequest> getTypeClass() {
					return AfterSalesRequest.class;
				}

			};

}