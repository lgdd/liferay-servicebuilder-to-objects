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

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for AfterSalesRequest. This utility wraps
 * <code>com.github.lgdd.liferay.commerce.after.sales.request.service.impl.AfterSalesRequestServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestService
 * @generated
 */
public class AfterSalesRequestServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.github.lgdd.liferay.commerce.after.sales.request.service.impl.AfterSalesRequestServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AfterSalesRequest addAfterSalesRequest(
			String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addAfterSalesRequest(
			title, description, serviceContext);
	}

	public static AfterSalesRequest deleteAfterSalesRequest(
			long afterSalesRequestId)
		throws PortalException {

		return getService().deleteAfterSalesRequest(afterSalesRequestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static AfterSalesRequestService getService() {
		return _service;
	}

	private static volatile AfterSalesRequestService _service;

}