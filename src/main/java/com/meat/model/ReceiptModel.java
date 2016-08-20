/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("receiptModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReceiptModel extends AbstractModel {
    private String receiptCode;
    private String referenceNo;
    private String referenceDocumentLink;
    private String amount;
    private String sellerInvoiceId;
    private String createdDate;

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the receiptCode
     */
    public String getReceiptCode() {
        return receiptCode;
    }

    /**
     * @return the referenceDocumentLink
     */
    public String getReferenceDocumentLink() {
        return referenceDocumentLink;
    }

    /**
     * @return the referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * @return the sellerInvoiceId
     */
    public String getSellerInvoiceId() {
        return sellerInvoiceId;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param receiptCode
     *            the receiptCode to set
     */
    public void setReceiptCode(final String receiptCode) {
        this.receiptCode = receiptCode;
    }

    /**
     * @param referenceDocumentLink
     *            the referenceDocumentLink to set
     */
    public void setReferenceDocumentLink(final String referenceDocumentLink) {
        this.referenceDocumentLink = referenceDocumentLink;
    }

    /**
     * @param referenceNo
     *            the referenceNo to set
     */
    public void setReferenceNo(final String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * @param sellerInvoiceId
     *            the sellerInvoiceId to set
     */
    public void setSellerInvoiceId(final String sellerInvoiceId) {
        this.sellerInvoiceId = sellerInvoiceId;
    }

}
