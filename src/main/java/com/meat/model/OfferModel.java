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
 * @author arthvedi5
 *
 */
@Component("offersModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OfferModel extends AbstractModel {
    private String amountTypeId;
    private String description;
    private String offerName;
    private String offerNoOfDays;
    private String status;
    private String offerCouponStatus;
    private String offerFromDate;
    private String offerToDate;
    private String offerFromTime;
    private String offerToTime;
    private String offerCode;
    private String offerCount;
    private String placedByStatus;
    private String invoiceAmount;
    private String quantity;
    private String bankName;
    private String bankStatus;
    private String amountTypeValue;
    private String offerType;
    private String createdDate;
    private String offerModifiedDate;
    private String offerModifiedTime;
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);
    private List<BankOfferModel> bankOfferModels = new ArrayList<BankOfferModel>(0);
    private List<UsersOfferModel> usersOfferModels = new ArrayList<UsersOfferModel>(0);
    private List<PreOrderCartItemsModel> preOrderCartItemsModels = new ArrayList<PreOrderCartItemsModel>(0);

    /**
     * @return the amountTypeId
     */
    public String getAmountTypeId() {
        return amountTypeId;
    }

    /**
     * @return the amountTypeValue
     */
    public String getAmountTypeValue() {
        return amountTypeValue;
    }

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the bankOfferModels
     */
    public List<BankOfferModel> getBankOfferModels() {
        return bankOfferModels;
    }

    /**
     * @return the bankStatus
     */
    public String getBankStatus() {
        return bankStatus;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the invoiceAmount
     */
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * @return the offerConfigModels
     */
    public List<OfferConfigModel> getOfferConfigModels() {
        return offerConfigModels;
    }

    /**
     * @return the offerCouponStatus
     */
    public String getOfferCouponStatus() {
        return offerCouponStatus;
    }

    /**
     * @return the offerExcludeConfigModels
     */
    public List<OfferExcludeConfigModel> getOfferExcludeConfigModels() {
        return offerExcludeConfigModels;
    }

    /**
     * @return the offerFromDate
     */
    public String getOfferFromDate() {
        return offerFromDate;
    }

    /**
     * @return the offerFromTime
     */
    public String getOfferFromTime() {
        return offerFromTime;
    }

    /**
     * @return the offerModifiedDate
     */
    public String getOfferModifiedDate() {
        return offerModifiedDate;
    }

    /**
     * @return the offerModifiedTime
     */
    public String getOfferModifiedTime() {
        return offerModifiedTime;
    }

    /**
     * @return the offerName
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * @return the offerNoOfDays
     */
    public String getOfferNoOfDays() {
        return offerNoOfDays;
    }

    /**
     * @return the offerToDate
     */
    public String getOfferToDate() {
        return offerToDate;
    }

    /**
     * @return the offerToTime
     */
    public String getOfferToTime() {
        return offerToTime;
    }

    /**
     * @return the offerType
     */
    public String getOfferType() {
        return offerType;
    }

    /**
     * @return the placedByStatus
     */
    public String getPlacedByStatus() {
        return placedByStatus;
    }

    /**
     * @return the preOrderCartItemsModels
     */
    public List<PreOrderCartItemsModel> getPreOrderCartItemsModels() {
        return preOrderCartItemsModels;
    }

    /**
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the usersOfferModels
     */
    public List<UsersOfferModel> getUsersOfferModels() {
        return usersOfferModels;
    }

    /**
     * @param amountTypeId
     *            the amountTypeId to set
     */
    public void setAmountTypeId(final String amountTypeId) {
        this.amountTypeId = amountTypeId;
    }

    /**
     * @param amountTypeValue
     *            the amountTypeValue to set
     */
    public void setAmountTypeValue(final String amountTypeValue) {
        this.amountTypeValue = amountTypeValue;
    }

    /**
     * @param bankName
     *            the bankName to set
     */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /**
     * @param bankOfferModels
     *            the bankOfferModels to set
     */
    public void setBankOfferModels(final List<BankOfferModel> bankOfferModels) {
        this.bankOfferModels = bankOfferModels;
    }

    /**
     * @param bankStatus
     *            the bankStatus to set
     */
    public void setBankStatus(final String bankStatus) {
        this.bankStatus = bankStatus;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param invoiceAmount
     *            the invoiceAmount to set
     */
    public void setInvoiceAmount(final String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * @param offerConfigModels
     *            the offerConfigModels to set
     */
    public void setOfferConfigModels(final List<OfferConfigModel> offerConfigModels) {
        this.offerConfigModels = offerConfigModels;
    }

    /**
     * @param offerCouponStatus
     *            the offerCouponStatus to set
     */
    public void setOfferCouponStatus(final String offerCouponStatus) {
        this.offerCouponStatus = offerCouponStatus;
    }

    /**
     * @param offerExcludeConfigModels
     *            the offerExcludeConfigModels to set
     */
    public void setOfferExcludeConfigModels(final List<OfferExcludeConfigModel> offerExcludeConfigModels) {
        this.offerExcludeConfigModels = offerExcludeConfigModels;
    }

    /**
     * @param offerFromDate
     *            the offerFromDate to set
     */
    public void setOfferFromDate(final String offerFromDate) {
        this.offerFromDate = offerFromDate;
    }

    /**
     * @param offerFromTime
     *            the offerFromTime to set
     */
    public void setOfferFromTime(final String offerFromTime) {
        this.offerFromTime = offerFromTime;
    }

    /**
     * @param offerModifiedDate
     *            the offerModifiedDate to set
     */
    public void setOfferModifiedDate(final String offerModifiedDate) {
        this.offerModifiedDate = offerModifiedDate;
    }

    /**
     * @param offerModifiedTime
     *            the offerModifiedTime to set
     */
    public void setOfferModifiedTime(final String offerModifiedTime) {
        this.offerModifiedTime = offerModifiedTime;
    }

    /**
     * @param offerName
     *            the offerName to set
     */
    public void setOfferName(final String offerName) {
        this.offerName = offerName;
    }

    /**
     * @param offerNoOfDays
     *            the offerNoOfDays to set
     */
    public void setOfferNoOfDays(final String offerNoOfDays) {
        this.offerNoOfDays = offerNoOfDays;
    }

    /**
     * @param offerToDate
     *            the offerToDate to set
     */
    public void setOfferToDate(final String offerToDate) {
        this.offerToDate = offerToDate;
    }

    /**
     * @param offerToTime
     *            the offerToTime to set
     */
    public void setOfferToTime(final String offerToTime) {
        this.offerToTime = offerToTime;
    }

    /**
     * @param offerType
     *            the offerType to set
     */
    public void setOfferType(final String offerType) {
        this.offerType = offerType;
    }

    /**
     * @param placedByStatus
     *            the placedByStatus to set
     */
    public void setPlacedByStatus(final String placedByStatus) {
        this.placedByStatus = placedByStatus;
    }

    /**
     * @param preOrderCartItemsModels
     *            the preOrderCartItemsModels to set
     */
    public void setPreOrderCartItemsModels(final List<PreOrderCartItemsModel> preOrderCartItemsModels) {
        this.preOrderCartItemsModels = preOrderCartItemsModels;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(final String quantity) {
        this.quantity = quantity;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param usersOfferModels
     *            the usersOfferModels to set
     */
    public void setUsersOfferModels(final List<UsersOfferModel> usersOfferModels) {
        this.usersOfferModels = usersOfferModels;
    }

    /**
     * @return the offerCode
     */
    public String getOfferCode() {
        return offerCode;
    }

    /**
     * @param offerCode the offerCode to set
     */
    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    /**
     * @return the offerCount
     */
    public String getOfferCount() {
        return offerCount;
    }

    /**
     * @param offerCount the offerCount to set
     */
    public void setOfferCount(String offerCount) {
        this.offerCount = offerCount;
    }

}
