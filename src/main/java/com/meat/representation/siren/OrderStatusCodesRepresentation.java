package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OrderStatusCodesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderStatusCodesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orderStatusCodes", uri = "/orderStatusCodeses/{id}")
@Representation(OrderStatusCodesModel.class)
public class OrderStatusCodesRepresentation extends BaseResource {

    private String id;
    private String orderId;
    private String orderStatusCode;
    private String orderStatusDescription;
    private String orderStatusDate;

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderStatusCode() {
        return orderStatusCode;
    }

    public String getOrderStatusDate() {
        return orderStatusDate;
    }

    public String getOrderStatusDescription() {
        return orderStatusDescription;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setOrderStatusCode(final String orderStatusCode) {
        this.orderStatusCode = orderStatusCode;
    }

    public void setOrderStatusDate(final String orderStatusDate) {
        this.orderStatusDate = orderStatusDate;
    }

    public void setOrderStatusDescription(final String orderStatusDescription) {
        this.orderStatusDescription = orderStatusDescription;
    }

}