package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("shipmentItemsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShipmentItemsModel extends AbstractModel {
    private String shipmentId;
    private String orderItemId;
    private String shipmentItemStatus;

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getShipmentItemStatus() {
        return shipmentItemStatus;
    }

    public void setOrderItemId(final String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setShipmentId(final String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public void setShipmentItemStatus(final String shipmentItemStatus) {
        this.shipmentItemStatus = shipmentItemStatus;
    }
}
