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
 * Provides a wrapper for {@link AfterSalesRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see AfterSalesRequestService
 * @generated
 */
public class AfterSalesRequestServiceWrapper
	implements AfterSalesRequestService,
			   ServiceWrapper<AfterSalesRequestService> {

	public AfterSalesRequestServiceWrapper(
		AfterSalesRequestService afterSalesRequestService) {

		_afterSalesRequestService = afterSalesRequestService;
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest addAfterSalesRequest(
					String title, String description, long commerceOrderId,
					com.liferay.portal.kernel.service.ServiceContext
						serviceContext)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestService.addAfterSalesRequest(
			title, description, commerceOrderId, serviceContext);
	}

	@Override
	public
		com.github.lgdd.liferay.commerce.after.sales.request.model.
			AfterSalesRequest deleteAfterSalesRequest(long afterSalesRequestId)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _afterSalesRequestService.deleteAfterSalesRequest(
			afterSalesRequestId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _afterSalesRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public AfterSalesRequestService getWrappedService() {
		return _afterSalesRequestService;
	}

	@Override
	public void setWrappedService(
		AfterSalesRequestService afterSalesRequestService) {

		_afterSalesRequestService = afterSalesRequestService;
	}

	private AfterSalesRequestService _afterSalesRequestService;

}