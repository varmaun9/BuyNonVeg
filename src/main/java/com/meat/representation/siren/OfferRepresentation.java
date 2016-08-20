/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.OfferModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi5
 *
 */
@Component("offerRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "offer", uri = "/offers/{id}")
@Representation(OfferModel.class)
public class OfferRepresentation extends BaseResource {

    private String id;
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
    private String placedByStatus;
    private String invoiceAmount;
    private String quantity;
    private String bankName;
    private String bankStatus;
    private String amountTypeValue;
    private String offerType;
    private String createdDate;
    private String offerCode;
    private String offerCount;
    private String offerModifiedDate;
    private String offerModifiedTime;
    @Siren4JSubEntity
    private List<OfferConfigRepresentation> offerConfigRep = new ArrayList<OfferConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferExcludeConfigRepresentation> offerExcludeConfigRep = new ArrayList<OfferExcludeConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<BankOfferRepresentation> bankOfferRep = new ArrayList<BankOfferRepresentation>(0);
    @Siren4JSubEntity
    private List<UsersOfferRepresentation> usersOfferRep = new ArrayList<UsersOfferRepresentation>(0);

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
     * @return the bankOfferRep
     */
    public List<BankOfferRepresentation> getBankOfferRep() {
        return bankOfferRep;
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the invoiceAmount
     */
    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * @return the offerConfigRep
     */
    public List<OfferConfigRepresentation> getOfferConfigRep() {
        return offerConfigRep;
    }

    /**
     * @return the offerCouponStatus
     */
    public String getOfferCouponStatus() {
        return offerCouponStatus;
    }

    /**
     * @return the offerExcludeConfigRep
     */
    public List<OfferExcludeConfigRepresentation> getOfferExcludeConfigRep() {
        return offerExcludeConfigRep;
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
     * @return the usersOfferRep
     */
    public List<UsersOfferRepresentation> getUsersOfferRep() {
        return usersOfferRep;
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
     * @param bankOfferRep
     *            the bankOfferRep to set
     */
    public void setBankOfferRep(final List<BankOfferRepresentation> bankOfferRep) {
        this.bankOfferRep = bankOfferRep;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param invoiceAmount
     *            the invoiceAmount to set
     */
    public void setInvoiceAmount(final String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * @param offerConfigRep
     *            the offerConfigRep to set
     */
    public void setOfferConfigRep(final List<OfferConfigRepresentation> offerConfigRep) {
        this.offerConfigRep = offerConfigRep;
    }

    /**
     * @param offerCouponStatus
     *            the offerCouponStatus to set
     */
    public void setOfferCouponStatus(final String offerCouponStatus) {
        this.offerCouponStatus = offerCouponStatus;
    }

    /**
     * @param offerExcludeConfigRep
     *            the offerExcludeConfigRep to set
     */
    public void setOfferExcludeConfigRep(final List<OfferExcludeConfigRepresentation> offerExcludeConfigRep) {
        this.offerExcludeConfigRep = offerExcludeConfigRep;
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
     * @param usersOfferRep
     *            the usersOfferRep to set
     */
    public void setUsersOfferRep(final List<UsersOfferRepresentation> usersOfferRep) {
        this.usersOfferRep = usersOfferRep;
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
