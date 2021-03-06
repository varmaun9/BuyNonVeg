package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * Tax generated by hbm2java
 */
@Entity
@Table(name = "tax", catalog = "meat_app")
public class Tax extends AbstractDomain implements java.io.Serializable {

    private String taxName;
    private String taxType;
    private String taxStatus;
    private Date createdDate;
    private String displayName;
    private Set<SellerBranchTax> sellerBranchTaxes = new HashSet<SellerBranchTax>(0);

    public Tax() {
    }

    public Tax(final String id, final String taxName, final String taxType, final String taxStatus, final Date createdDate,
            final Set<SellerBranchTax> sellerBranchTaxes) {
        this.id = id;
        this.taxName = taxName;
        this.taxType = taxType;
        this.taxStatus = taxStatus;
        this.createdDate = createdDate;
        this.sellerBranchTaxes = sellerBranchTaxes;
    }

    public Tax(final String id, final String taxName, final String taxType, final String taxStatus, final Date createdDate,
            final String displayName) {
        this.id = id;
        this.taxName = taxName;
        this.taxType = taxType;
        this.taxStatus = taxStatus;
        this.createdDate = createdDate;
        setDisplayName(displayName);
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false, length = 19)
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the displayName
     */
    @Column(name = "display_name")
    public String getDisplayName() {
        return displayName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tax")
    public Set<SellerBranchTax> getSellerBranchTaxes() {
        return sellerBranchTaxes;
    }

    @Column(name = "tax_name", nullable = false, length = 45)
    public String getTaxName() {
        return taxName;
    }

    @Column(name = "tax_status", nullable = false, length = 45)
    public String getTaxStatus() {
        return taxStatus;
    }

    @Column(name = "tax_type", nullable = false, length = 45)
    public String getTaxType() {
        return taxType;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param displayName
     *            the displayName to set
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public void setSellerBranchTaxes(final Set<SellerBranchTax> sellerBranchTaxes) {
        this.sellerBranchTaxes = sellerBranchTaxes;
    }

    public void setTaxName(final String taxName) {
        this.taxName = taxName;
    }

    public void setTaxStatus(final String taxStatus) {
        this.taxStatus = taxStatus;
    }

    public void setTaxType(final String taxType) {
        this.taxType = taxType;
    }

}
