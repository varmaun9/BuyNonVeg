/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ShipmentModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("shipmentRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "shipment", uri = "/shipments/{id}")
@Representation(ShipmentModel.class)
public class ShipmentRepresentation extends BaseResource {
    private String id;
    private String orderId;
    private String shipmentTrackingNumber;
    private String shipmentDetails;
    private String shipmentDate;
    private String invoiceId;
    private List<ShipmentItemsRepresentation> shipmentItemRep = new ArrayList<ShipmentItemsRepresentation>(0);

    public String getId() {
        return id;
    }

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

    public List<ShipmentItemsRepresentation> getShipmentItemRep() {
        return shipmentItemRep;
    }

    public String getShipmentTrackingNumber() {
        return shipmentTrackingNumber;
    }

    public void setId(final String id) {
        this.id = id;
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

    public void setShipmentItemRep(final List<ShipmentItemsRepresentation> shipmentItemRep) {
        this.shipmentItemRep = shipmentItemRep;
    }

    public void setShipmentTrackingNumber(final String shipmentTrackingNumber) {
        this.shipmentTrackingNumber = shipmentTrackingNumber;
    }

}
