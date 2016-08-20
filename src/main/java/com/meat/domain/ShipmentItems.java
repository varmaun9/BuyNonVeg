package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import javax.persistence.*;

/**
 * ShipmentItems generated by hbm2java
 */
@Entity
@Table(name = "shipment_items", catalog = "meat_app")
public class ShipmentItems extends AbstractDomain implements java.io.Serializable {

    private Shipment shipment;
    private OrderItem orderItem;
    private String shipmentItemStatus;

    public ShipmentItems() {
    }

    public ShipmentItems(final String id, final Shipment shipment, final OrderItem orderItem, final String shipmentItemStatus) {
        this.id = id;
        this.shipment = shipment;
        this.orderItem = orderItem;
        this.shipmentItemStatus = shipmentItemStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false)
    public OrderItem getOrderItem() {
        return orderItem;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    public Shipment getShipment() {
        return shipment;
    }

    @Column(name = "shipment_item_status", nullable = false, length = 45)
    public String getShipmentItemStatus() {
        return shipmentItemStatus;
    }

    public void setOrderItem(final OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setShipment(final Shipment shipment) {
        this.shipment = shipment;
    }

    public void setShipmentItemStatus(final String shipmentItemStatus) {
        this.shipmentItemStatus = shipmentItemStatus;
    }

}