package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderItemStatusCodesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderItemStatusCodesModel extends AbstractModel {

    private String orderItemId;
    private String orderItemStatusCode;
    private String orderItemStatusDate;
    private String orderItemStatusDescription;

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getOrderItemStatusCode() {
        return orderItemStatusCode;
    }

    public String getOrderItemStatusDate() {
        return orderItemStatusDate;
    }

    public String getOrderItemStatusDescription() {
        return orderItemStatusDescription;
    }

    public void setOrderItemId(final String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setOrderItemStatusCode(final String orderItemStatusCode) {
        this.orderItemStatusCode = orderItemStatusCode;
    }

    public void setOrderItemStatusDate(final String orderItemStatusDate) {
        this.orderItemStatusDate = orderItemStatusDate;
    }

    public void setOrderItemStatusDescription(final String orderItemStatusDescription) {
        this.orderItemStatusDescription = orderItemStatusDescription;
    }

}
