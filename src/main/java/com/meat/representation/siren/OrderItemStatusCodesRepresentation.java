package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OrderItemStatusCodesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderItemStatusCodesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orderItemStatusCodes", uri = "/orderItemStatusCodeses/{id}")
@Representation(OrderItemStatusCodesModel.class)
public class OrderItemStatusCodesRepresentation extends BaseResource {

    private String id;
    private String orderItemId;
    private String orderItemStatusCode;
    private String orderItemStatusDate;
    private String orderItemStatusDescription;

    public String getId() {
        return id;
    }

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

    public void setId(final String id) {
        this.id = id;
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