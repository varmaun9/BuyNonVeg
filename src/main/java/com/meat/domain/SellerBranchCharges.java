/**
 *
 */
package com.meat.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * @author varma
 *
 */
@Entity
@Table(name = "seller_branch_charges", catalog = "meat_app")
public class SellerBranchCharges extends AbstractDomain implements java.io.Serializable {

    private SellerBranch sellerBranch;
    private String chargesType;
    private BigDecimal chargesAmount;
    private AmountType amountType;
    private String status;
    private Date createdDate;
    private String displayName;

    public SellerBranchCharges() {
    }

    public SellerBranchCharges(final String id, final SellerBranch sellerBranch, final Date createdDate, final String status,
            final BigDecimal chargesAmount, final String chargesType, final AmountType amountType, final String displayName) {
        this.id = id;
        this.sellerBranch = sellerBranch;
        this.amountType = amountType;
        this.chargesAmount = chargesAmount;
        this.chargesType = chargesType;
        this.status = status;
        this.createdDate = createdDate;
        this.displayName = displayName;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "amount_type_id", nullable = false)
    public AmountType getAmountType() {
        return amountType;
    }

    @Column(name = "charges_amount")
    public BigDecimal getChargesAmount() {
        return chargesAmount;
    }

    @Column(name = "charges_type")
    public String getChargesType() {
        return chargesType;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", length = 19)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_branch_id", nullable = false)
    public SellerBranch getSellerBranch() {
        return sellerBranch;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setAmountType(final AmountType amountType) {
        this.amountType = amountType;
    }

    public void setChargesAmount(final BigDecimal chargesAmount) {
        this.chargesAmount = chargesAmount;
    }

    public void setChargesType(final String chargesType) {
        this.chargesType = chargesType;
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

    public void setSellerBranch(final SellerBranch sellerBranch) {
        this.sellerBranch = sellerBranch;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
