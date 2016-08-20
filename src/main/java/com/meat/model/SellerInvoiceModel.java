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
 * @author arthvedi
 *
 */
@Component("sellerInvoiceModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerInvoiceModel extends AbstractModel {

    private String sellerBranchId;
    private String sellerBranchName;
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
    private List<ReceiptModel> receiptModels = new ArrayList<ReceiptModel>(0);
    private List<InvoiceTransactionModel> invoiceTransactionModels = new ArrayList<InvoiceTransactionModel>(0);
    private List<MeatInvoiceModel> meatInvoiceModels = new ArrayList<MeatInvoiceModel>(0);
    private List<SubOrderModel> subOrderModels = new ArrayList<SubOrderModel>(0);

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
     * @return the invoiceTransactionModels
     */
    public List<InvoiceTransactionModel> getInvoiceTransactionModels() {
        return invoiceTransactionModels;
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
     * @return the meatInvoiceModels
     */
    public List<MeatInvoiceModel> getMeatInvoiceModels() {
        return meatInvoiceModels;
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
     * @return the receiptModels
     */
    public List<ReceiptModel> getReceiptModels() {
        return receiptModels;
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
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the sellerBranchName
     */
    public String getSellerBranchName() {
        return sellerBranchName;
    }

    /**
     * @return the subOrderModels
     */
    public List<SubOrderModel> getSubOrderModels() {
        return subOrderModels;
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
     * @param invoiceTransactionModels
     *            the invoiceTransactionModels to set
     */
    public void setInvoiceTransactionModels(final List<InvoiceTransactionModel> invoiceTransactionModels) {
        this.invoiceTransactionModels = invoiceTransactionModels;
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
     * @param meatInvoiceModels
     *            the meatInvoiceModels to set
     */
    public void setMeatInvoiceModels(final List<MeatInvoiceModel> meatInvoiceModels) {
        this.meatInvoiceModels = meatInvoiceModels;
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
     * @param receiptModels
     *            the receiptModels to set
     */
    public void setReceiptModels(final List<ReceiptModel> receiptModels) {
        this.receiptModels = receiptModels;
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
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param sellerBranchName
     *            the sellerBranchName to set
     */
    public void setSellerBranchName(final String sellerBranchName) {
        this.sellerBranchName = sellerBranchName;
    }

    /**
     * @param subOrderModels
     *            the subOrderModels to set
     */
    public void setSubOrderModels(final List<SubOrderModel> subOrderModels) {
        this.subOrderModels = subOrderModels;
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
