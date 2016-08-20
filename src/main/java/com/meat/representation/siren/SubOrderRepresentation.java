/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubOrderModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subOrder", uri = "/subOrders/{id}")
@Representation(SubOrderModel.class)
public class SubOrderRepresentation extends BaseResource {
    private String id;
    private String usersId;
    private String timingsId;
    private String ordersId;
    private String sellerInvoiceId;
    private String sellerBranchId;
    private String subOrderDeliveryDate;
    private String subOrderDeliveryTime;
    private String subOrderStatus;
    private String createdDate;
    private String subOrderCode;
    private String subOrderCount;
    private String subOrderTotalPrice;
    private String taxValue;
    private String discount;
    private String readStatus;
    private String deliveryType;
    private String refundPaidReferenceNo;

    private String deliveryContactName;
    private String refundPaidStatus;
    private String refundAmount;
    private String refundDeductedAmount;
    private String refundDescription;
    private String refundStatus;
    private String billedStatus;
    private String subOrderTotalCharges;
    private String deliveryContactId;
    private String refundPayableAmount;
    @Siren4JSubEntity
    private List<OrderItemRepresentation> orderItemRep = new ArrayList<OrderItemRepresentation>(0);
    @Siren4JSubEntity
    private List<SubOrderStatusCodeRepresentation> subOrderStatusCodeRep = new ArrayList<SubOrderStatusCodeRepresentation>(0);

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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the orderItemRep
     */
    public List<OrderItemRepresentation> getOrderItemRep() {
        return orderItemRep;
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
     * @return the subOrderStatusCodeRep
     */
    public List<SubOrderStatusCodeRepresentation> getSubOrderStatusCodeRep() {
        return subOrderStatusCodeRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param orderItemRep
     *            the orderItemRep to set
     */
    public void setOrderItemRep(final List<OrderItemRepresentation> orderItemRep) {
        this.orderItemRep = orderItemRep;
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
     * @param subOrderStatusCodeRep
     *            the subOrderStatusCodeRep to set
     */
    public void setSubOrderStatusCodeRep(final List<SubOrderStatusCodeRepresentation> subOrderStatusCodeRep) {
        this.subOrderStatusCodeRep = subOrderStatusCodeRep;
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
