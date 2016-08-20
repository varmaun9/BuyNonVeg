package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderDeliveryOptionsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orderDeliveryOptions", uri = "/orderDeliveryOptionses/{id}")
@Representation(OrderDeliveryOptionsModel.class)
public class OrderDeliveryOptionsRepresentation extends BaseResource {

    private String id;
    private String addressId;
    private String ordersId;
    private String shippingCost;

    public String getAddressId() {
        return addressId;
    }

    public String getId() {
        return id;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

    public void setShippingCost(final String shippingCost) {
        this.shippingCost = shippingCost;
    }

}