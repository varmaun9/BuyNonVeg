/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CouponModel;
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
@Component("couponRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "coupon", uri = "/coupons/{id}")
@Representation(CouponModel.class)
public class CouponRepresentation extends BaseResource {
    private String id;
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
    @Siren4JSubEntity
    private List<CouponPercentDirectRepresentation> couponPercentDirectsRep = new ArrayList<CouponPercentDirectRepresentation>(0);
    @Siren4JSubEntity
    private List<CouponBuyXGetYRepresentation> couponBuyXGetYsRep = new ArrayList<CouponBuyXGetYRepresentation>(0);

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

    public List<CouponBuyXGetYRepresentation> getCouponBuyXGetYsRep() {
        return couponBuyXGetYsRep;
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

    public List<CouponPercentDirectRepresentation> getCouponPercentDirectsRep() {
        return couponPercentDirectsRep;
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

    public String getId() {
        return id;
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

    public void setCouponBuyXGetYsRep(final List<CouponBuyXGetYRepresentation> couponBuyXGetYsRep) {
        this.couponBuyXGetYsRep = couponBuyXGetYsRep;
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

    public void setCouponPercentDirectsRep(final List<CouponPercentDirectRepresentation> couponPercentDirectsRep) {
        this.couponPercentDirectsRep = couponPercentDirectsRep;
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

    public void setId(final String id) {
        this.id = id;
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
