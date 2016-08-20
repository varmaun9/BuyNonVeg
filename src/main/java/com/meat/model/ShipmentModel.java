package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("shipmentModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShipmentModel extends AbstractModel {
    private String orderId;
    private String shipmentTrackingNumber;
    private String shipmentDetails;
    private String shipmentDate;
    private String invoiceId;
    private List<ShipmentItemsModel> shipmentItemModels = new ArrayList<ShipmentItemsModel>(0);

    public String getInvoiceId() {
        return invoiceId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public String getShipmentDetails() {
        return shipmentDetails;
    }

    public List<ShipmentItemsModel> getShipmentItemModels() {
        return shipmentItemModels;
    }

    public String getShipmentTrackingNumber() {
        return shipmentTrackingNumber;
    }

    public void setInvoiceId(final String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public void setShipmentDate(final String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public void setShipmentDetails(final String shipmentDetails) {
        this.shipmentDetails = shipmentDetails;
    }

    public void setShipmentItemModels(final List<ShipmentItemsModel> shipmentItemModels) {
        this.shipmentItemModels = shipmentItemModels;
    }

    public void setShipmentTrackingNumber(final String shipmentTrackingNumber) {
        this.shipmentTrackingNumber = shipmentTrackingNumber;
    }

}
