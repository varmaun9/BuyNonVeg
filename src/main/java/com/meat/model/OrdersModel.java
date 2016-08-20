package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ordersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrdersModel extends AbstractModel {

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
    private List<OrderDeliveryOptionsModel> orderDeliveryOptionsesModels = new ArrayList<OrderDeliveryOptionsModel>(0);
    private List<OrderItemModel> orderItemsModels = new ArrayList<OrderItemModel>(0);
    private List<ShipmentModel> shipmentsModels = new ArrayList<ShipmentModel>(0);
    private List<OrderStatusCodesModel> orderStatusCodesesModels = new ArrayList<OrderStatusCodesModel>(0);

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
     * @return the orderDeliveryOptionsesModels
     */
    public List<OrderDeliveryOptionsModel> getOrderDeliveryOptionsesModels() {
        return orderDeliveryOptionsesModels;
    }

    /**
     * @return the orderDetails
     */
    public String getOrderDetails() {
        return orderDetails;
    }

    /**
     * @return the orderItemsModels
     */
    public List<OrderItemModel> getOrderItemsModels() {
        return orderItemsModels;
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
     * @return the orderStatusCodesesModels
     */
    public List<OrderStatusCodesModel> getOrderStatusCodesesModels() {
        return orderStatusCodesesModels;
    }

    /**
     * @return the rating
     */
    public String getRating() {
        return rating;
    }

    /**
     * @return the shipmentsModels
     */
    public List<ShipmentModel> getShipmentsModels() {
        return shipmentsModels;
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
     * @param orderDeliveryOptionsesModels
     *            the orderDeliveryOptionsesModels to set
     */
    public void setOrderDeliveryOptionsesModels(final List<OrderDeliveryOptionsModel> orderDeliveryOptionsesModels) {
        this.orderDeliveryOptionsesModels = orderDeliveryOptionsesModels;
    }

    /**
     * @param orderDetails
     *            the orderDetails to set
     */
    public void setOrderDetails(final String orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * @param orderItemsModels
     *            the orderItemsModels to set
     */
    public void setOrderItemsModels(final List<OrderItemModel> orderItemsModels) {
        this.orderItemsModels = orderItemsModels;
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
     * @param orderStatusCodesesModels
     *            the orderStatusCodesesModels to set
     */
    public void setOrderStatusCodesesModels(final List<OrderStatusCodesModel> orderStatusCodesesModels) {
        this.orderStatusCodesesModels = orderStatusCodesesModels;
    }

    /**
     * @param rating
     *            the rating to set
     */
    public void setRating(final String rating) {
        this.rating = rating;
    }

    /**
     * @param shipmentsModels
     *            the shipmentsModels to set
     */
    public void setShipmentsModels(final List<ShipmentModel> shipmentsModels) {
        this.shipmentsModels = shipmentsModels;
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
