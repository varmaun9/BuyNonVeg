package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OrdersModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ordersRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orders", uri = "/orderses/{id}")
@Representation(OrdersModel.class)
public class OrdersRepresentation extends BaseResource {

    private String id;
    private String usersId;
    private String name;
    private String status;
    private String rating;
    private String comments;
    private String transactionId;
    private String itemInfo;
    private String amount;
    private String discount;
    private String shippingCharges;
    private String orderCreatedTime;
    private String orderModifiedDate;
    private String orderModifiedTime;
    private String orderCode;
    private String orderCount;
    private String orderCreatedDate;
    private String orderDetails;
    private String addressId;
    @Siren4JSubEntity
    private List<OrderDeliveryOptionsRepresentation> orderDeliveryOptionsRep = new ArrayList<OrderDeliveryOptionsRepresentation>(0);

    @Siren4JSubEntity
    private List<OrderItemRepresentation> orderItemRep = new ArrayList<OrderItemRepresentation>(0);

    @Siren4JSubEntity
    private List<ShipmentRepresentation> shipmentRep = new ArrayList<ShipmentRepresentation>(0);
    @Siren4JSubEntity
    private List<OrderStatusCodesRepresentation> orderStatusCodesRep = new ArrayList<OrderStatusCodesRepresentation>(0);

    /**
     * @return the addressId
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the itemInfo
     */
    public String getItemInfo() {
        return itemInfo;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the orderCode
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * @return the orderCount
     */
    public String getOrderCount() {
        return orderCount;
    }

    /**
     * @return the orderCreatedDate
     */
    public String getOrderCreatedDate() {
        return orderCreatedDate;
    }

    /**
     * @return the orderCreatedTime
     */
    public String getOrderCreatedTime() {
        return orderCreatedTime;
    }

    /**
     * @return the orderDeliveryOptionsRep
     */
    public List<OrderDeliveryOptionsRepresentation> getOrderDeliveryOptionsRep() {
        return orderDeliveryOptionsRep;
    }

    /**
     * @return the orderDetails
     */
    public String getOrderDetails() {
        return orderDetails;
    }

    /**
     * @return the orderItemRep
     */
    public List<OrderItemRepresentation> getOrderItemRep() {
        return orderItemRep;
    }

    /**
     * @return the orderModifiedDate
     */
    public String getOrderModifiedDate() {
        return orderModifiedDate;
    }

    /**
     * @return the orderModifiedTime
     */
    public String getOrderModifiedTime() {
        return orderModifiedTime;
    }

    /**
     * @return the orderStatusCodesRep
     */
    public List<OrderStatusCodesRepresentation> getOrderStatusCodesRep() {
        return orderStatusCodesRep;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @return the shipmentRep
     */
    public List<ShipmentRepresentation> getShipmentRep() {
        return shipmentRep;
    }

    /**
     * @return the shippingCharges
     */
    public String getShippingCharges() {
        return shippingCharges;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    /**
     * @param addressId
     *            the addressId to set
     */
    public void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(final String comments) {
        this.comments = comments;
    }

    /**
     * @param discount
     *            the discount to set
     */
    public void setDiscount(final String discount) {
        this.discount = discount;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemInfo
     *            the itemInfo to set
     */
    public void setItemInfo(final String itemInfo) {
        this.itemInfo = itemInfo;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param orderCode
     *            the orderCode to set
     */
    public void setOrderCode(final String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * @param orderCount
     *            the orderCount to set
     */
    public void setOrderCount(final String orderCount) {
        this.orderCount = orderCount;
    }

    /**
     * @param orderCreatedDate
     *            the orderCreatedDate to set
     */
    public void setOrderCreatedDate(final String orderCreatedDate) {
        this.orderCreatedDate = orderCreatedDate;
    }

    /**
     * @param orderCreatedTime
     *            the orderCreatedTime to set
     */
    public void setOrderCreatedTime(final String orderCreatedTime) {
        this.orderCreatedTime = orderCreatedTime;
    }

    /**
     * @param orderDeliveryOptionsRep
     *            the orderDeliveryOptionsRep to set
     */
    public void setOrderDeliveryOptionsRep(final List<OrderDeliveryOptionsRepresentation> orderDeliveryOptionsRep) {
        this.orderDeliveryOptionsRep = orderDeliveryOptionsRep;
    }

    /**
     * @param orderDetails
     *            the orderDetails to set
     */
    public void setOrderDetails(final String orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @param orderItemRep
     *            the orderItemRep to set
     */
    public void setOrderItemRep(final List<OrderItemRepresentation> orderItemRep) {
        this.orderItemRep = orderItemRep;
    }

    /**
     * @param orderModifiedDate
     *            the orderModifiedDate to set
     */
    public void setOrderModifiedDate(final String orderModifiedDate) {
        this.orderModifiedDate = orderModifiedDate;
    }

    /**
     * @param orderModifiedTime
     *            the orderModifiedTime to set
     */
    public void setOrderModifiedTime(final String orderModifiedTime) {
        this.orderModifiedTime = orderModifiedTime;
    }

    /**
     * @param orderStatusCodesRep
     *            the orderStatusCodesRep to set
     */
    public void setOrderStatusCodesRep(final List<OrderStatusCodesRepresentation> orderStatusCodesRep) {
        this.orderStatusCodesRep = orderStatusCodesRep;
    }

    /**
     * @param rating
     *            the rating to set
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @param shipmentRep
     *            the shipmentRep to set
     */
    public void setShipmentRep(final List<ShipmentRepresentation> shipmentRep) {
        this.shipmentRep = shipmentRep;
    }

    /**
     * @param shippingCharges
     *            the shippingCharges to set
     */
    public void setShippingCharges(final String shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param transactionId
     *            the transactionId to set
     */
    public void setTransactionId(final String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}