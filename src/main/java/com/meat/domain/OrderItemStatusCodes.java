package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.*;

/**
 * OrderItemStatusCodes generated by hbm2java
 */
@Entity
@Table(name = "order_item_status_codes", catalog = "meat_app")
public class OrderItemStatusCodes extends AbstractDomain implements java.io.Serializable {

    private OrderItem orderItem;
    private String orderItemStatusCode;
    private Date orderItemStatusDate;
    private String orderItemStatusDescription;

    public OrderItemStatusCodes() {
    }

    public OrderItemStatusCodes(final String id, final OrderItem orderItem, final String orderItemStatusCode,
            final Date orderItemStatusDate) {
        this.id = id;
        this.orderItem = orderItem;
        this.orderItemStatusCode = orderItemStatusCode;
        this.orderItemStatusDate = orderItemStatusDate;
    }

    public OrderItemStatusCodes(final String id, final OrderItem orderItem, final String orderItemStatusCode,
            final Date orderItemStatusDate, final String orderItemStatusDescription) {
        this.id = id;
        this.orderItem = orderItem;
        this.orderItemStatusCode = orderItemStatusCode;
        this.orderItemStatusDate = orderItemStatusDate;
        this.orderItemStatusDescription = orderItemStatusDescription;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id", nullable = false)
    public OrderItem getOrderItem() {
        return orderItem;
    }

    @Column(name = "order_item_status_code", nullable = false, length = 45)
    public String getOrderItemStatusCode() {
        return orderItemStatusCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_item_status_date", nullable = false, length = 19)
    public Date getOrderItemStatusDate() {
        return orderItemStatusDate;
    }

    @Column(name = "order_item_status_description", length = 100)
    public String getOrderItemStatusDescription() {
        return orderItemStatusDescription;
    }

    public void setOrderItem(final OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setOrderItemStatusCode(final String orderItemStatusCode) {
        this.orderItemStatusCode = orderItemStatusCode;
    }

    public void setOrderItemStatusDate(final Date orderItemStatusDate) {
        this.orderItemStatusDate = orderItemStatusDate;
    }

    public void setOrderItemStatusDescription(final String orderItemStatusDescription) {
        this.orderItemStatusDescription = orderItemStatusDescription;
    }

}