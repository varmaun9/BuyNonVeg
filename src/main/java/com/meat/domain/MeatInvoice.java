package com.meat.domain;

// Generated Feb 8, 2016 5:13:42 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * MeatInvoice generated by hbm2java
 */
@Entity
@Table(name = "meat_invoice", catalog = "meat_app")
public class MeatInvoice extends AbstractDomain implements java.io.Serializable {

    private SellerInvoice sellerInvoice;
    private BigDecimal totalAmount;
    private String tax;
    private BigDecimal discount;
    private BigDecimal grandTotalAmount;
    private String paidStatus;
    private Set<InvoiceTransaction> invoiceTransactions = new HashSet<InvoiceTransaction>(0);

    public MeatInvoice() {
    }

    public MeatInvoice(final String id, final SellerInvoice sellerInvoice, final BigDecimal totalAmount, final String tax,
            final BigDecimal grandTotalAmount) {
        this.id = id;
        this.sellerInvoice = sellerInvoice;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.grandTotalAmount = grandTotalAmount;
    }

    public MeatInvoice(final String id, final SellerInvoice sellerInvoice, final BigDecimal totalAmount, final String tax,
            final BigDecimal discount, final BigDecimal grandTotalAmount, final String paidStatus,
            final Set<InvoiceTransaction> invoiceTransactions) {
        this.id = id;
        this.sellerInvoice = sellerInvoice;
        this.totalAmount = totalAmount;
        this.tax = tax;
        this.discount = discount;
        this.grandTotalAmount = grandTotalAmount;
        this.paidStatus = paidStatus;
        this.invoiceTransactions = invoiceTransactions;
    }

    @Column(name = "discount", precision = 3)
    public BigDecimal getDiscount() {
        return discount;
    }

    @Column(name = "grand_total_amount", nullable = false, precision = 7)
    public BigDecimal getGrandTotalAmount() {
        return grandTotalAmount;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "meatInvoice")
    public Set<InvoiceTransaction> getInvoiceTransactions() {
        return invoiceTransactions;
    }

    @Column(name = "paid_status", length = 45)
    public String getPaidStatus() {
        return paidStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_invoice_id", nullable = false)
    public SellerInvoice getSellerInvoice() {
        return sellerInvoice;
    }

    @Column(name = "tax", nullable = false, length = 45)
    public String getTax() {
        return tax;
    }

    @Column(name = "total_amount", nullable = false, precision = 7)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setDiscount(final BigDecimal discount) {
        this.discount = discount;
    }

    public void setGrandTotalAmount(final BigDecimal grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    public void setInvoiceTransactions(final Set<InvoiceTransaction> invoiceTransactions) {
        this.invoiceTransactions = invoiceTransactions;
    }

    public void setPaidStatus(final String paidStatus) {
        this.paidStatus = paidStatus;
    }

    public void setSellerInvoice(final SellerInvoice sellerInvoice) {
        this.sellerInvoice = sellerInvoice;
    }

    public void setTax(final String tax) {
        this.tax = tax;
    }

    public void setTotalAmount(final BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

}
