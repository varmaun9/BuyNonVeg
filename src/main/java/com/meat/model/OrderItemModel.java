package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderItemModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderItemModel extends AbstractModel {

    private String sellerItemId;
    private String ordersId;
    private String otherOffers;
    //  private String usersId;
    private String subOrderId;
    private String finalUnitPrice;
    private String quantity;
    private String marketPrice;
    private String sellerPrice;
    private String cartStatusFlag;
    private String units;
    private String sellerDiscounts;
    private String otherDiscounts;
    private String deliveryDate;

    private String timingName;

    private String timingsId;

    private String availableTime;

    private String deliveryTime;
    private String orderItemStatus;
    private String orderItemCode;
    private String orderItemCount;
    private String createdDate;
    private String deliveryType;
    private String discount;
    private String taxValue;
    private String sellerItemName;
    private String cutType;
    private String measurementUnit;
    private String orderItemTotalPrice;
    private String specialPieceName;
    private String specialPieceCount;
    private List<OrderItemStatusCodesModel> orderItemStatusCodesesModels = new ArrayList<OrderItemStatusCodesModel>(0);
    private List<ShipmentItemsModel> shipmentItemsesModels = new ArrayList<ShipmentItemsModel>(0);

    public String getAvailableTime() {
        return availableTime;
    }

    /**
     * @return the cartStatusFlag
     */
    public String getCartStatusFlag() {
        return cartStatusFlag;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the cutType
     */
    public String getCutType() {
        return cutType;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * @return the deliveryType
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @return the finalUnitPrice
     */
    public String getFinalUnitPrice() {
        return finalUnitPrice;
    }

    /**
     * @return the marketPrice
     */
    public String getMarketPrice() {
        return marketPrice;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    /**
     * @return the orderItemCode
     */
    public String getOrderItemCode() {
        return orderItemCode;
    }

    public String getOrderItemCount() {
        return orderItemCount;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public List<OrderItemStatusCodesModel> getOrderItemStatusCodesesModels() {
        return orderItemStatusCodesesModels;
    }

    /**
     * @return the orderItemTotalPrice
     */
    public String getOrderItemTotalPrice() {
        return orderItemTotalPrice;
    }

    public String getOrdersId() {
        return ordersId;
    }

    public String getOtherDiscounts() {
        return otherDiscounts;
    }

    /**
     * @return the otherOffers
     */
    public String getOtherOffers() {
        return otherOffers;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSellerDiscounts() {
        return sellerDiscounts;
    }

    public String getSellerItemId() {
        return sellerItemId;
    }

    /**
     * @return the sellerItemName
     */
    public String getSellerItemName() {
        return sellerItemName;
    }

    /**
     * @return the sellerPrice
     */
    public String getSellerPrice() {
        return sellerPrice;
    }

    public List<ShipmentItemsModel> getShipmentItemsesModels() {
        return shipmentItemsesModels;
    }

    public String getSpecialPieceCount() {
        return specialPieceCount;
    }

    public String getSpecialPieceName() {
        return specialPieceName;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    /**
     * @return the taxValue
     */
    public String getTaxValue() {
        return taxValue;
    }

    public String getTimingName() {
        return timingName;
    }

    public String getTimingsId() {
        return timingsId;
    }

    public String getUnits() {
        return units;
    }

    public void setAvailableTime(final String availableTime) {
        this.availableTime = availableTime;
    }

    /**
     * @param cartStatusFlag
     *            the cartStatusFlag to set
     */
    public void setCartStatusFlag(final String cartStatusFlag) {
        this.cartStatusFlag = cartStatusFlag;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param cutType
     *            the cutType to set
     */
    public void setCutType(final String cutType) {
        this.cutType = cutType;
    }

    public void setDeliveryDate(final String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setDeliveryTime(final String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * @param deliveryType
     *            the deliveryType to set
     */
    public void setDeliveryType(final String deliveryType) {
        this.deliveryType = deliveryType;
    }

    /**
     * @param discount
     *            the discount to set
     */
    public void setDiscount(final String discount) {
        this.discount = discount;
    }

    /**
     * @param finalUnitPrice
     *            the finalUnitPrice to set
     */
    public void setFinalUnitPrice(final String finalUnitPrice) {
        this.finalUnitPrice = finalUnitPrice;
    }

    /**
     * @param marketPrice
     *            the marketPrice to set
     */
    public void setMarketPrice(final String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public void setMeasurementUnit(final String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    /**
     * @param orderItemCode
     *            the orderItemCode to set
     */
    public void setOrderItemCode(final String orderItemCode) {
        this.orderItemCode = orderItemCode;
    }

    public void setOrderItemCount(final String orderItemCount) {
        this.orderItemCount = orderItemCount;
    }

    public void setOrderItemStatus(final String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public void setOrderItemStatusCodesesModels(final List<OrderItemStatusCodesModel> orderItemStatusCodesesModels) {
        this.orderItemStatusCodesesModels = orderItemStatusCodesesModels;
    }

    /**
     * @param orderItemTotalPrice
     *            the orderItemTotalPrice to set
     */
    public void setOrderItemTotalPrice(final String orderItemTotalPrice) {
        this.orderItemTotalPrice = orderItemTotalPrice;
    }

    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

    public void setOtherDiscounts(final String otherDiscounts) {
        this.otherDiscounts = otherDiscounts;
    }

    /**
     * @param otherOffers
     *            the otherOffers to set
     */
    public void setOtherOffers(final String otherOffers) {
        this.otherOffers = otherOffers;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public void setSellerDiscounts(final String sellerDiscounts) {
        this.sellerDiscounts = sellerDiscounts;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    /**
     * @param sellerItemName
     *            the sellerItemName to set
     */
    public void setSellerItemName(final String sellerItemName) {
        this.sellerItemName = sellerItemName;
    }

    /**
     * @param sellerPrice
     *            the sellerPrice to set
     */
    public void setSellerPrice(final String sellerPrice) {
        this.sellerPrice = sellerPrice;
    }

    public void setShipmentItemsesModels(final List<ShipmentItemsModel> shipmentItemsesModels) {
        this.shipmentItemsesModels = shipmentItemsesModels;
    }

    public void setSpecialPieceCount(final String specialPieceCount) {
        this.specialPieceCount = specialPieceCount;
    }

    public void setSpecialPieceName(final String specialPieceName) {
        this.specialPieceName = specialPieceName;
    }

    public void setSubOrderId(final String subOrderId) {
        this.subOrderId = subOrderId;
    }

    /**
     * @param taxValue
     *            the taxValue to set
     */
    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

    public void setTimingName(final String timingName) {
        this.timingName = timingName;
    }

    public void setTimingsId(final String timingsId) {
        this.timingsId = timingsId;
    }

    public void setUnits(final String units) {
        this.units = units;
    }

}
