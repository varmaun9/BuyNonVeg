/**
 *
 */
package com.meat.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

/**
 * @author Bhargavi
 *
 */
@Entity
@Table(name = "receipt", catalog = "meat_app")
public class Receipt extends AbstractDomain implements java.io.Serializable {
    private String receiptCode;
    private String referenceNo;
    private String referenceDocumentLink;
    private BigDecimal amount;
    private SellerInvoice sellerInvoice;
    private Date createdDate;

    public Receipt() {
    }

    public Receipt(final String receiptCode, final String referenceNo, final String referenceDocumentLink, final BigDecimal amount,
            final SellerInvoice sellerInvoice, final Date createdDate) {

        this.receiptCode = receiptCode;
        this.referenceNo = referenceNo;
        this.referenceDocumentLink = referenceDocumentLink;
        this.amount = amount;
        this.sellerInvoice = sellerInvoice;
        this.createdDate = createdDate;
    }

    @Column(name = "amount", precision = 7)
    public BigDecimal getAmount() {
        return amount;
    }

    @Column(name = "created_date")
    public Date getCreatedDate() {
        return createdDate;
    }

    @Column(name = "receipt_code", length = 45)
    public String getReceiptCode() {
        return receiptCode;
    }

    @Column(name = "reference_document_link", length = 100)
    public String getReferenceDocumentLink() {
        return referenceDocumentLink;
    }

    @Column(name = "reference_no", length = 45)
    public String getReferenceNo() {
        return referenceNo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_invoice_id", nullable = false)
    public SellerInvoice getSellerInvoice() {
        return sellerInvoice;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setReceiptCode(final String receiptCode) {
        this.receiptCode = receiptCode;
    }

    public void setReferenceDocumentLink(final String referenceDocumentLink) {
        this.referenceDocumentLink = referenceDocumentLink;
    }

    public void setReferenceNo(final String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public void setSellerInvoice(final SellerInvoice sellerInvoice) {
        this.sellerInvoice = sellerInvoice;
    }

}
