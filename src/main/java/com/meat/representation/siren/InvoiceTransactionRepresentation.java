/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.InvoiceTransactionModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("invoiceTransactionRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "invoiceTransaction", uri = "/invoiceTransactions/{id}")
@Representation(InvoiceTransactionModel.class)
public class InvoiceTransactionRepresentation extends BaseResource {
    private String id;
    private String sellerInvoiceId;
    private String meatInvoiceId;
    private String transactionType;
    private String receiptNo;
    private String referenceDocumentNo;
    private String date;
    private String amount;
    private String transactionCode;

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the meatInvoiceId
     */
    public String getMeatInvoiceId() {
        return meatInvoiceId;
    }

    /**
     * @return the receiptNo
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * @return the referenceDocumentNo
     */
    public String getReferenceDocumentNo() {
        return referenceDocumentNo;
    }

    /**
     * @return the sellerInvoiceId
     */
    public String getSellerInvoiceId() {
        return sellerInvoiceId;
    }

    /**
     * @return the transactionCode
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(final String date) {
        this.date = date;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param meatInvoiceId
     *            the meatInvoiceId to set
     */
    public void setMeatInvoiceId(final String meatInvoiceId) {
        this.meatInvoiceId = meatInvoiceId;
    }

    /**
     * @param receiptNo
     *            the receiptNo to set
     */
    public void setReceiptNo(final String receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     * @param referenceDocumentNo
     *            the referenceDocumentNo to set
     */
    public void setReferenceDocumentNo(final String referenceDocumentNo) {
        this.referenceDocumentNo = referenceDocumentNo;
    }

    /**
     * @param sellerInvoiceId
     *            the sellerInvoiceId to set
     */
    public void setSellerInvoiceId(final String sellerInvoiceId) {
        this.sellerInvoiceId = sellerInvoiceId;
    }

    /**
     * @param transactionCode
     *            the transactionCode to set
     */
    public void setTransactionCode(final String transactionCode) {
        this.transactionCode = transactionCode;
    }

    /**
     * @param transactionType
     *            the transactionType to set
     */
    public void setTransactionType(final String transactionType) {
        this.transactionType = transactionType;
    }

}
