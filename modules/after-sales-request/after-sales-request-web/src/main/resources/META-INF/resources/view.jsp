<%@ page
        import="com.github.lgdd.liferay.commerce.after.sales.request.web.constants.AfterSalesRequestMVCCommandNames" %>
<%@ page import="com.liferay.commerce.model.CommerceOrder" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>

<%
    List<CommerceOrder> commerceOrders =
            (List<CommerceOrder>) request.getAttribute("commerceOrders");
%>

<portlet:actionURL var="afterSalesRequestActionURL"
                   name="<%=AfterSalesRequestMVCCommandNames.ADD_REQUEST %>">
</portlet:actionURL>

<div class="container-fluid-1280">

    <h1>After Sales Request</h1>

    <aui:form action="${afterSalesRequestActionURL}" name="fm">

        <aui:input name="afterSalesRequestId" field="afterSalesRequestId" type="hidden"/>

        <aui:fieldset-group markupView="lexicon">

            <aui:fieldset>

                <aui:select name="commerceOrderId" label="Commerce Order">

                    <%
                        for (CommerceOrder order : commerceOrders) {
                    %>
                    <aui:option
                            label="<%= order.getCommerceOrderId() %>"
                            value="<%= order.getCommerceOrderId() %>"/>
                    <%
                        }
                    %>
                </aui:select>

                <aui:input name="title">
                    <aui:validator name="required"/>
                </aui:input>

                <aui:input name="description">
                    <aui:validator name="required"/>
                </aui:input>
            </aui:fieldset>
        </aui:fieldset-group>

        <%--Buttons. --%>

        <aui:button-row>
            <aui:button cssClass="btn btn-primary" type="submit"/>
            <aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel"/>
        </aui:button-row>
    </aui:form>

</div>