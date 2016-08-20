/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubOrderModel extends AbstractModel {

    private String usersId;
    private String timingsId;
    private String ordersId;
    private String sellerInvoiceId;
    private String sellerBranchId;
    private String subOrderDeliveryDate;
    private String subOrderDeliveryTime;
    private String subOrderStatus;
    private String createdDate;
    private String modifiedDate;
    private String subOrderCode;
    private String subOrderCount;
    private String subOrderTotalPrice;
    private String taxValue;
    private String discount;
    private String readStatus;
    private String deliveryType;
    private String refundPaidReferenceNo;
    private String refundPaidStatus;
    private String refundAmount;
    private String refundDeductedAmount;
    private String refundDescription;
    private String refundStatus;
    private String billedStatus;
    private String deliveryContactId;
    private String deliveryContactName;
    private String subOrderTotalCharges;
    private String refundPayableAmount;
    private List<OrderItemModel> orderItemModels = new ArrayList<OrderItemModel>(0);
    private List<SubOrderStatusCodeModel> subOrderStatusCodeModels = new ArrayList<SubOrderStatusCodeModel>(0);
    private List<SubOrderTaxesModel> subOrderTaxModels = new ArrayList<SubOrderTaxesModel>(0);

    /**
     * @return the billedStatus
     */
    public String getBilledStatus() {
        return billedStatus;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the deliveryContactId
     */
    public String getDeliveryContactId() {
        return deliveryContactId;
    }

    /**
     * @return the deliveryContactName
     */
    public String getDeliveryContactName() {
        return deliveryContactName;
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
     * @return the modifiedDate
     */
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @return the orderItemModels
     */
    public List<OrderItemModel> getOrderItemModels() {
        return orderItemModels;
    }

    /**
     * @return the ordersId
     */
    public String getOrdersId() {
        return ordersId;
    }

    /**
     * @return the readStatus
     */
    public String getReadStatus() {
        return readStatus;
    }

    /**
     * @return the refundAmount
     */
    public String getRefundAmount() {
        return refundAmount;
    }

    /**
     * @return the refundDeductedAmount
     */
    public String getRefundDeductedAmount() {
        return refundDeductedAmount;
    }

    /**
     * @return the refundDescription
     */
    public String getRefundDescription() {
        return refundDescription;
    }

    /**
     * @return the refundPaidReferenceNo
     */
    public String getRefundPaidReferenceNo() {
        return refundPaidReferenceNo;
    }

    /**
     * @return the refundPaidStatus
     */
    public String getRefundPaidStatus() {
        return refundPaidStatus;
    }

    /**
     * @return the refundPayableAmount
     */
    public String getRefundPayableAmount() {
        return refundPayableAmount;
    }

    /**
     * @return the refundStatus
     */
    public String getRefundStatus() {
        return refundStatus;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the sellerInvoiceId
     */
    public String getSellerInvoiceId() {
        return sellerInvoiceId;
    }

    /**
     * @return the subOrderCode
     */
    public String getSubOrderCode() {
        return subOrderCode;
    }

    /**
     * @return the subOrderCount
     */
    public String getSubOrderCount() {
        return subOrderCount;
    }

    /**
     * @return the subOrderDeliveryDate
     */
    public String getSubOrderDeliveryDate() {
        return subOrderDeliveryDate;
    }

    /**
     * @return the subOrderDeliveryTime
     */
    public String getSubOrderDeliveryTime() {
        return subOrderDeliveryTime;
    }

    /**
     * @return the subOrderStatus
     */
    public String getSubOrderStatus() {
        return subOrderStatus;
    }

    /**
     * @return the subOrderStatusCodeModels
     */
    public List<SubOrderStatusCodeModel> getSubOrderStatusCodeModels() {
        return subOrderStatusCodeModels;
    }

    /**
     * @return the subOrderTaxModels
     */
    public List<SubOrderTaxesModel> getSubOrderTaxModels() {
        return subOrderTaxModels;
    }

    /**
     * @return the subOrderDeliveryCharges
     */
    public String getSubOrderTotalCharges() {
        return subOrderTotalCharges;
    }

    /**
     * @return the subOrderTotalPrice
     */
    public String getSubOrderTotalPrice() {
        return subOrderTotalPrice;
    }

    /**
     * @return the taxValue
     */
    public String getTaxValue() {
        return taxValue;
    }

    /**
     * @return the timingsId
     */
    public String getTimingsId() {
        return timingsId;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    /**
     * @param billedStatus
     *            the billedStatus to set
     */
    public void setBilledStatus(final String billedStatus) {
        this.billedStatus = billedStatus;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param deliveryContactId
     *            the deliveryContactId to set
     */
    public void setDeliveryContactId(final String deliveryContactId) {
        this.deliveryContactId = deliveryContactId;
    }

    /**
     * @param deliveryContactName
     *            the deliveryContactName to set
     */
    public void setDeliveryContactName(final String deliveryContactName) {
        this.deliveryContactName = deliveryContactName;
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
     * @param modifiedDate
     *            the modifiedDate to set
     */
    public void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @param orderItemModels
     *            the orderItemModels to set
     */
    public void setOrderItemModels(final List<OrderItemModel> orderItemModels) {
        this.orderItemModels = orderItemModels;
    }

    /**
     * @param ordersId
     *            the ordersId to set
     */
    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * @param readStatus
     *            the readStatus to set
     */
    public void setReadStatus(final String readStatus) {
        this.readStatus = readStatus;
    }

    /**
     * @param refundAmount
     *            the refundAmount to set
     */
    public void setRefundAmount(final String refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * @param refundDeductedAmount
     *            the refundDeductedAmount to set
     */
    public void setRefundDeductedAmount(final String refundDeductedAmount) {
        this.refundDeductedAmount = refundDeductedAmount;
    }

    /**
     * @param refundDescription
     *            the refundDescription to set
     */
    public void setRefundDescription(final String refundDescription) {
        this.refundDescription = refundDescription;
    }

    /**
     * @param refundPaidReferenceNo
     *            the refundPaidReferenceNo to set
     */
    public void setRefundPaidReferenceNo(final String refundPaidReferenceNo) {
        this.refundPaidReferenceNo = refundPaidReferenceNo;
    }

    /**
     * @param refundPaidStatus
     *            the refundPaidStatus to set
     */
    public void setRefundPaidStatus(final String refundPaidStatus) {
        this.refundPaidStatus = refundPaidStatus;
    }

    /**
     * @param refundPayableAmount
     *            the refundPayableAmount to set
     */
    public void setRefundPayableAmount(final String refundPayableAmount) {
        this.refundPayableAmount = refundPayableAmount;
    }

    /**
     * @param refundStatus
     *            the refundStatus to set
     */
    public void setRefundStatus(final String refundStatus) {
        this.refundStatus = refundStatus;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param sellerInvoiceId
     *            the sellerInvoiceId to set
     */
    public void setSellerInvoiceId(final String sellerInvoiceId) {
        this.sellerInvoiceId = sellerInvoiceId;
    }

    /**
     * @param subOrderCode
     *            the subOrderCode to set
     */
    public void setSubOrderCode(final String subOrderCode) {
        this.subOrderCode = subOrderCode;
    }

    /**
     * @param subOrderCount
     *            the subOrderCount to set
     */
    public void setSubOrderCount(final String subOrderCount) {
        this.subOrderCount = subOrderCount;
    }

    /**
     * @param subOrderDeliveryDate
     *            the subOrderDeliveryDate to set
     */
    public void setSubOrderDeliveryDate(final String subOrderDeliveryDate) {
        this.subOrderDeliveryDate = subOrderDeliveryDate;
    }

    /**
     * @param subOrderDeliveryTime
     *            the subOrderDeliveryTime to set
     */
    public void setSubOrderDeliveryTime(final String subOrderDeliveryTime) {
        this.subOrderDeliveryTime = subOrderDeliveryTime;
    }

    /**
     * @param subOrderStatus
     *            the subOrderStatus to set
     */
    public void setSubOrderStatus(final String subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }

    /**
     * @param subOrderStatusCodeModels
     *            the subOrderStatusCodeModels to set
     */
    public void setSubOrderStatusCodeModels(final List<SubOrderStatusCodeModel> subOrderStatusCodeModels) {
        this.subOrderStatusCodeModels = subOrderStatusCodeModels;
    }

    /**
     * @param subOrderTaxModels
     *            the subOrderTaxModels to set
     */
    public void setSubOrderTaxModels(final List<SubOrderTaxesModel> subOrderTaxModels) {
        this.subOrderTaxModels = subOrderTaxModels;
    }

    /**
     * @param subOrderDeliveryCharges
     *            the subOrderDeliveryCharges to set
     */
    public void setSubOrderTotalCharges(final String subOrderTotalCharges) {
        this.subOrderTotalCharges = subOrderTotalCharges;
    }

    /**
     * @param subOrderTotalPrice
     *            the subOrderTotalPrice to set
     */
    public void setSubOrderTotalPrice(final String subOrderTotalPrice) {
        this.subOrderTotalPrice = subOrderTotalPrice;
    }

    /**
     * @param taxValue
     *            the taxValue to set
     */
    public void setTaxValue(final String taxValue) {
        this.taxValue = taxValue;
    }

    /**
     * @param timingsId
     *            the timingsId to set
     */
    public void setTimingsId(final String timingsId) {
        this.timingsId = timingsId;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
