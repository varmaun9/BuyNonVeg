package com.meat.domain;

// Generated Feb 13, 2016 10:49:53 PM by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Offer generated by hbm2java
 */
@Entity
@Table(name = "offer", catalog = "meat_app")
public class Offer extends AbstractDomain implements java.io.Serializable {

    private AmountType amountType;
    private String description;
    private String offerName;
    private int offerNoOfDays;
    private String status;
    private String offerCouponStatus;
    private Date offerFromDate;
    private Date offerToDate;
    private String offerFromTime;
    private String offerToTime;
    private String offerCode;
    private long offerCount;
    private String placedByStatus;
    private BigDecimal invoiceAmount;
    private Integer quantity;
    private String bankName;
    private String bankStatus;
    private int amountTypeValue;
    private String offerType;
    private Date createdDate;
    private Date offerModifiedDate;
    private String offerModifiedTime;
    private Set<OfferConfig> offerConfigs = new HashSet<OfferConfig>(0);
    private Set<OfferExcludeConfig> offerExcludeConfigs = new HashSet<OfferExcludeConfig>(0);
    private Set<BankOffer> bankOffers = new HashSet<BankOffer>(0);
    private Set<UsersOffer> usersOffers = new HashSet<UsersOffer>(0);
    private Set<PreOrderCartItems> preOrderCartItems = new HashSet<PreOrderCartItems>(0);

    public Offer() {
    }

    public Offer(final String id, final AmountType amountType, final String description, final int offerNoOfDays, final String status,
            final String offerCouponStatus, final Date offerFromDate, final String offerCode, final long offerCount, final Date offerToDate,
            final String offerFromTime, final String offerToTime, final String placedByStatus, final int amountTypeValue,
            final String offerType) {
        this.id = id;
        this.amountType = amountType;
        this.description = description;
        this.offerNoOfDays = offerNoOfDays;
        this.status = status;
        this.offerCouponStatus = offerCouponStatus;
        this.offerFromDate = offerFromDate;
        this.offerToDate = offerToDate;
        this.offerFromTime = offerFromTime;
        this.offerToTime = offerToTime;
        this.offerCode = offerCode;
        this.offerCount = offerCount;
        this.placedByStatus = placedByStatus;
        this.amountTypeValue = amountTypeValue;
        this.offerType = offerType;
    }

    public Offer(final String id, final AmountType amountType, final String description, final String offerName, final int offerNoOfDays,
            final String status, final String offerCouponStatus, final Date offerFromDate, final Date offerToDate,
            final String offerFromTime, final String offerToTime, final String placedByStatus, final BigDecimal invoiceAmount,
            final Integer quantity, final String bankName, final String offerCode, final long offerCount, final String bankStatus,
            final int amountTypeValue, final String offerType, final Date createdDate, final Date offerModifiedDate,
            final String offerModifiedTime, final Set<OfferConfig> offerConfigs, final Set<OfferExcludeConfig> offerExcludeConfigs,
            final Set<PreOrderCartItems> preOrderCartItems, final Set<BankOffer> bankOffers, final Set<UsersOffer> usersOffers) {
        this.id = id;
        this.amountType = amountType;
        this.description = description;
        this.offerName = offerName;
        this.offerNoOfDays = offerNoOfDays;
        this.status = status;
        this.offerCode = offerCode;
        this.offerCount = offerCount;
        this.offerCouponStatus = offerCouponStatus;
        this.offerFromDate = offerFromDate;
        this.offerToDate = offerToDate;
        this.offerFromTime = offerFromTime;
        this.offerToTime = offerToTime;
        this.placedByStatus = placedByStatus;
        this.invoiceAmount = invoiceAmount;
        this.quantity = quantity;
        this.bankName = bankName;
        this.bankStatus = bankStatus;
        this.amountTypeValue = amountTypeValue;
        this.offerType = offerType;
        this.createdDate = createdDate;
        this.offerModifiedDate = offerModifiedDate;
        this.offerModifiedTime = offerModifiedTime;
        this.offerConfigs = offerConfigs;
        this.preOrderCartItems = preOrderCartItems;
        this.offerExcludeConfigs = offerExcludeConfigs;
        this.bankOffers = bankOffers;
        this.usersOffers = usersOffers;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amount_type_id", nullable = false)
    public AmountType getAmountType() {
        return amountType;
    }

    @Column(name = "amount_type_value", nullable = false)
    public int getAmountTypeValue() {
        return amountTypeValue;
    }

    @Column(name = "bank_name", length = 100)
    public String getBankName() {
        return bankName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    public Set<BankOffer> getBankOffers() {
        return bankOffers;
    }

    @Column(name = "bank_status", length = 45)
    public String getBankStatus() {
        return bankStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "description", length = 45)
    public String getDescription() {
        return description;
    }

    @Column(name = "invoice_amount", precision = 7)
    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * @return the offerCode
     */
    @Column(name = "offer_code", nullable = false, length = 45)
    public String getOfferCode() {
        return offerCode;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    public Set<OfferConfig> getOfferConfigs() {
        return offerConfigs;
    }

    /**
     * @return the offerCount
     */
    @Column(name = "offer_count", nullable = false)
    public long getOfferCount() {
        return offerCount;
    }

    @Column(name = "offer_coupon_status", nullable = false, length = 45)
    public String getOfferCouponStatus() {
        return offerCouponStatus;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    public Set<OfferExcludeConfig> getOfferExcludeConfigs() {
        return offerExcludeConfigs;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "offer_from_date", nullable = false, length = 19)
    public Date getOfferFromDate() {
        return offerFromDate;
    }

    @Column(name = "offer_from_time", nullable = false, length = 45)
    public String getOfferFromTime() {
        return offerFromTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "offer_modified_date", length = 19)
    public Date getOfferModifiedDate() {
        return offerModifiedDate;
    }

    @Column(name = "offer_modified_time", length = 45)
    public String getOfferModifiedTime() {
        return offerModifiedTime;
    }

    @Column(name = "offer_name", length = 45)
    public String getOfferName() {
        return offerName;
    }

    @Column(name = "offer_no_of_days", nullable = false)
    public int getOfferNoOfDays() {
        return offerNoOfDays;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "offer_to_date", nullable = false, length = 19)
    public Date getOfferToDate() {
        return offerToDate;
    }

    @Column(name = "offer_to_time", nullable = false, length = 45)
    public String getOfferToTime() {
        return offerToTime;
    }

    @Column(name = "offer_type", nullable = false, length = 45)
    public String getOfferType() {
        return offerType;
    }

    @Column(name = "placed_by_status", nullable = false, length = 45)
    public String getPlacedByStatus() {
        return placedByStatus;
    }

    /**
     * @return the preOrderCartItems
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    public Set<PreOrderCartItems> getPreOrderCartItems() {
        return preOrderCartItems;
    }

    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "offer")
    public Set<UsersOffer> getUsersOffers() {
        return usersOffers;
    }

    public void setAmountType(final AmountType amountType) {
        this.amountType = amountType;
    }

    public void setAmountTypeValue(final int amountTypeValue) {
        this.amountTypeValue = amountTypeValue;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public void setBankOffers(final Set<BankOffer> bankOffers) {
        this.bankOffers = bankOffers;
    }

    public void setBankStatus(final String bankStatus) {
        this.bankStatus = bankStatus;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setInvoiceAmount(final BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * @param offerCode
     *            the offerCode to set
     */
    public void setOfferCode(final String offerCode) {
        this.offerCode = offerCode;
    }

    public void setOfferConfigs(final Set<OfferConfig> offerConfigs) {
        this.offerConfigs = offerConfigs;
    }

    /**
     * @param offerCount
     *            the offerCount to set
     */
    public void setOfferCount(final long offerCount) {
        this.offerCount = offerCount;
    }

    public void setOfferCouponStatus(final String offerCouponStatus) {
        this.offerCouponStatus = offerCouponStatus;
    }

    public void setOfferExcludeConfigs(final Set<OfferExcludeConfig> offerExcludeConfigs) {
        this.offerExcludeConfigs = offerExcludeConfigs;
    }

    public void setOfferFromDate(final Date offerFromDate) {
        this.offerFromDate = offerFromDate;
    }

    public void setOfferFromTime(final String offerFromTime) {
        this.offerFromTime = offerFromTime;
    }

    public void setOfferModifiedDate(final Date offerModifiedDate) {
        this.offerModifiedDate = offerModifiedDate;
    }

    public void setOfferModifiedTime(final String offerModifiedTime) {
        this.offerModifiedTime = offerModifiedTime;
    }

    public void setOfferName(final String offerName) {
        this.offerName = offerName;
    }

    public void setOfferNoOfDays(final int offerNoOfDays) {
        this.offerNoOfDays = offerNoOfDays;
    }

    public void setOfferToDate(final Date offerToDate) {
        this.offerToDate = offerToDate;
    }

    public void setOfferToTime(final String offerToTime) {
        this.offerToTime = offerToTime;
    }

    public void setOfferType(final String offerType) {
        this.offerType = offerType;
    }

    public void setPlacedByStatus(final String placedByStatus) {
        this.placedByStatus = placedByStatus;
    }

    /**
     * @param preOrderCartItems
     *            the preOrderCartItems to set
     */
    public void setPreOrderCartItems(final Set<PreOrderCartItems> preOrderCartItems) {
        this.preOrderCartItems = preOrderCartItems;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUsersOffers(final Set<UsersOffer> usersOffers) {
        this.usersOffers = usersOffers;
    }

}
