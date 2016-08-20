package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderDeliveryOptionsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderDeliveryOptionsModel extends AbstractModel {

    private String addressId;
    private String ordersId;
    private String shippingCost;

    public String getAddressId() {
        return addressId;
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

    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

    public void setShippingCost(final String shippingCost) {
        this.shippingCost = shippingCost;
    }

}
