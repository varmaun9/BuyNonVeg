package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("couponModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CouponModel extends AbstractModel {
    private String amountTypeId;
    private String couponName;
    private String description;
    private String status;
    private String couponCode;
    private String placedByStatus;
    private String couponFromDate;
    private String couponToDate;
    private String quantity;
    private String invoiceAmount;
    private String billType;
    private String couponType;
    private String couponCount;
    private String createdDate;
    private String amountTypeValue;
    private List<CouponPercentDirectModel> couponPercentDirectsModels = new ArrayList<CouponPercentDirectModel>(0);
    private List<CouponBuyXGetYModel> couponBuyXGetYsModels = new ArrayList<CouponBuyXGetYModel>(0);

    /**
     * @return the amountTypeId
     */
    public String getAmountTypeId() {
        return amountTypeId;
    }

    /**
     * @return the amountType
     */

    public String getAmountTypeValue() {
        return amountTypeValue;
    }

    public String getBillType() {
        return billType;
    }

    public List<CouponBuyXGetYModel> getCouponBuyXGetYsModels() {
        return couponBuyXGetYsModels;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getCouponCount() {
        return couponCount;
    }

    public String getCouponFromDate() {
        return couponFromDate;
    }

    public String getCouponName() {
        return couponName;
    }

    public List<CouponPercentDirectModel> getCouponPercentDirectsModels() {
        return couponPercentDirectsModels;
    }

    public String getCouponToDate() {
        return couponToDate;
    }

    public String getCouponType() {
        return couponType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public String getPlacedByStatus() {
        return placedByStatus;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    /**
     * @param amountTypeId
     *            the amountTypeId to set
     */
    public void setAmountTypeId(final String amountTypeId) {
        this.amountTypeId = amountTypeId;
    }

    /**
     * @param amountType
     *            the amountType to set
     */

    public void setAmountTypeValue(final String amountTypeValue) {
        this.amountTypeValue = amountTypeValue;
    }

    public void setBillType(final String billType) {
        this.billType = billType;
    }

    public void setCouponBuyXGetYsModels(final List<CouponBuyXGetYModel> couponBuyXGetYsModels) {
        this.couponBuyXGetYsModels = couponBuyXGetYsModels;
    }

    public void setCouponCode(final String couponCode) {
        this.couponCode = couponCode;
    }

    public void setCouponCount(final String couponCount) {
        this.couponCount = couponCount;
    }

    public void setCouponFromDate(final String couponFromDate) {
        this.couponFromDate = couponFromDate;
    }

    public void setCouponName(final String couponName) {
        this.couponName = couponName;
    }

    public void setCouponPercentDirectsModels(final List<CouponPercentDirectModel> couponPercentDirectsModels) {
        this.couponPercentDirectsModels = couponPercentDirectsModels;
    }

    public void setCouponToDate(final String couponToDate) {
        this.couponToDate = couponToDate;
    }

    public void setCouponType(final String couponType) {
        this.couponType = couponType;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setInvoiceAmount(final String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public void setPlacedByStatus(final String placedByStatus) {
        this.placedByStatus = placedByStatus;
    }

    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
