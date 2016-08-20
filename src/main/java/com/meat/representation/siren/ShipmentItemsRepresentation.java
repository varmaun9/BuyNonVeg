/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ShipmentItemsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("shipmentItemsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "shipmentItem", uri = "/shipmentItems/{id}")
@Representation(ShipmentItemsModel.class)
public class ShipmentItemsRepresentation extends BaseResource {
    private String id;
    private String shipmentId;
    private String orderItemId;
    private String shipmentItemStatus;

    public String getId() {
        return id;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public String getShipmentItemStatus() {
        return shipmentItemStatus;
    }

    public void setId(final String id) {
        this.id = id;
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
