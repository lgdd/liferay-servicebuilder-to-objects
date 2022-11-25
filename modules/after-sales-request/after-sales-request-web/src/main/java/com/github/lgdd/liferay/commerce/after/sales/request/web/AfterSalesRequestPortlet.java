package com.github.lgdd.liferay.commerce.after.sales.request.web;

import com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestWebKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=After Sales Request",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + AfterSalesRequestWebKeys.PORTLET_NAME,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user",
        "javax.portlet.version=3.0"
    },
    service = Portlet.class
)
public class AfterSalesRequestPortlet
    extends MVCPortlet {

}