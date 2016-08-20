/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerInvoiceModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerInvoiceRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerInvoice", uri = "/sellerInvoices/{id}")
@Representation(SellerInvoiceModel.class)
public class SellerInvoiceRepresentation extends BaseResource {

    private String id;
    private String sellerBranchId;
    private String totalAmount;
    private String tax;
    private String discount;
    private String grandTotalAmount;
    private String period;
    private String meatInvoiceAmount;
    private String meatInvoiceTax;
    private String meatInvoiceDiscount;
    private String paidStatus;
    private String createdDate;
    private String referenceDocumentNo;
    private String transferMode;
    private String receiptNo;
    private String amountToBePaid;
    private String previousInvoiceAmount;
    private String dueAmount;
    private String cancelledSubOrdersAmount;
    @Siren4JSubEntity
    private List<ReceiptRepresentation> receiptRep = new ArrayList<ReceiptRepresentation>(0);
    @Siren4JSubEntity
    private List<InvoiceTransactionRepresentation> invoiceTransactionRep = new ArrayList<InvoiceTransactionRepresentation>(0);
    @Siren4JSubEntity
    private List<MeatInvoiceRepresentation> meatInvoiceRep = new ArrayList<MeatInvoiceRepresentation>(0);
    @Siren4JSubEntity
    private List<SubOrderRepresentation> subOrderRep = new ArrayList<SubOrderRepresentation>(0);

    /**
     * @return the amountToBePaid
     */
    public String getAmountToBePaid() {
        return amountToBePaid;
    }

    /**
     * @return the cancelledSubOrdersAmount
     */
    public String getCancelledSubOrdersAmount() {
        return cancelledSubOrdersAmount;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @return the dueAmount
     */
    public String getDueAmount() {
        return dueAmount;
    }

    /**
     * @return the grandTotalAmount
     */
    public String getGrandTotalAmount() {
        return grandTotalAmount;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the invoiceTransactionRep
     */
    public List<InvoiceTransactionRepresentation> getInvoiceTransactionRep() {
        return invoiceTransactionRep;
    }

    /**
     * @return the meatInvoiceAmount
     */
    public String getMeatInvoiceAmount() {
        return meatInvoiceAmount;
    }

    /**
     * @return the meatInvoiceDiscount
     */
    public String getMeatInvoiceDiscount() {
        return meatInvoiceDiscount;
    }

    /**
     * @return the meatInvoiceRep
     */
    public List<MeatInvoiceRepresentation> getMeatInvoiceRep() {
        return meatInvoiceRep;
    }

    /**
     * @return the meatInvoiceTax
     */
    public String getMeatInvoiceTax() {
        return meatInvoiceTax;
    }

    /**
     * @return the paidStatus
     */
    public String getPaidStatus() {
        return paidStatus;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @return the previousInvoiceAmount
     */
    public String getPreviousInvoiceAmount() {
        return previousInvoiceAmount;
    }

    /**
     * @return the receiptNo
     */
    public String getReceiptNo() {
        return receiptNo;
    }

    /**
     * @return the receiptRep
     */
    public List<ReceiptRepresentation> getReceiptRep() {
        return receiptRep;
    }

    /**
     * @return the referenceDocumentNo
     */
    public String getReferenceDocumentNo() {
        return referenceDocumentNo;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the subOrderRep
     */
    public List<SubOrderRepresentation> getSubOrderRep() {
        return subOrderRep;
    }

    /**
     * @return the tax
     */
    public String getTax() {
        return tax;
    }

    /**
     * @return the totalAmount
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * @return the transferMode
     */
    public String getTransferMode() {
        return transferMode;
    }

    /**
     * @param amountToBePaid
     *            the amountToBePaid to set
     */
    public void setAmountToBePaid(final String amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    /**
     * @param cancelledSubOrdersAmount
     *            the cancelledSubOrdersAmount to set
     */
    public void setCancelledSubOrdersAmount(final String cancelledSubOrdersAmount) {
        this.cancelledSubOrdersAmount = cancelledSubOrdersAmount;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param discount
     *            the discount to set
     */
    public void setDiscount(final String discount) {
        this.discount = discount;
    }

    /**
     * @param dueAmount
     *            the dueAmount to set
     */
    public void setDueAmount(final String dueAmount) {
        this.dueAmount = dueAmount;
    }

    /**
     * @param grandTotalAmount
     *            the grandTotalAmount to set
     */
    public void setGrandTotalAmount(final String grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param invoiceTransactionRep
     *            the invoiceTransactionRep to set
     */
    public void setInvoiceTransactionRep(final List<InvoiceTransactionRepresentation> invoiceTransactionRep) {
        this.invoiceTransactionRep = invoiceTransactionRep;
    }

    /**
     * @param meatInvoiceAmount
     *            the meatInvoiceAmount to set
     */
    public void setMeatInvoiceAmount(final String meatInvoiceAmount) {
        this.meatInvoiceAmount = meatInvoiceAmount;
    }

    /**
     * @param meatInvoiceDiscount
     *            the meatInvoiceDiscount to set
     */
    public void setMeatInvoiceDiscount(final String meatInvoiceDiscount) {
        this.meatInvoiceDiscount = meatInvoiceDiscount;
    }

    /**
     * @param meatInvoiceRep
     *            the meatInvoiceRep to set
     */
    public void setMeatInvoiceRep(final List<MeatInvoiceRepresentation> meatInvoiceRep) {
        this.meatInvoiceRep = meatInvoiceRep;
    }

    /**
     * @param meatInvoiceTax
     *            the meatInvoiceTax to set
     */
    public void setMeatInvoiceTax(final String meatInvoiceTax) {
        this.meatInvoiceTax = meatInvoiceTax;
    }

    /**
     * @param paidStatus
     *            the paidStatus to set
     */
    public void setPaidStatus(final String paidStatus) {
        this.paidStatus = paidStatus;
    }

    /**
     * @param period
     *            the period to set
     */
    public void setPeriod(final String period) {
        this.period = period;
    }

    /**
     * @param previousInvoiceAmount
     *            the previousInvoiceAmount to set
     */
    public void setPreviousInvoiceAmount(final String previousInvoiceAmount) {
        this.previousInvoiceAmount = previousInvoiceAmount;
    }

    /**
     * @param receiptNo
     *            the receiptNo to set
     */
    public void setReceiptNo(final String receiptNo) {
        this.receiptNo = receiptNo;
    }

    /**
     * @param receiptRep
     *            the receiptRep to set
     */
    public void setReceiptRep(final List<ReceiptRepresentation> receiptRep) {
        this.receiptRep = receiptRep;
    }

    /**
     * @param referenceDocumentNo
     *            the referenceDocumentNo to set
     */
    public void setReferenceDocumentNo(final String referenceDocumentNo) {
        this.referenceDocumentNo = referenceDocumentNo;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param subOrderRep
     *            the subOrderRep to set
     */
    public void setSubOrderRep(final List<SubOrderRepresentation> subOrderRep) {
        this.subOrderRep = subOrderRep;
    }

    /**
     * @param tax
     *            the tax to set
     */
    public void setTax(final String tax) {
        this.tax = tax;
    }

    /**
     * @param totalAmount
     *            the totalAmount to set
     */
    public void setTotalAmount(final String totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @param transferMode
     *            the transferMode to set
     */
    public void setTransferMode(final String transferMode) {
        this.transferMode = transferMode;
    }

}
