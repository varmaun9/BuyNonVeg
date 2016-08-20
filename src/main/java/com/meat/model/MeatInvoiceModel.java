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
@Component("meatInvoiceModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MeatInvoiceModel extends AbstractModel {
    private String sellerInvoiceId;
    private String totalAmount;
    private String tax;
    private String discount;
    private String grandTotalAmount;
    private String paidStatus;
    private List<InvoiceTransactionModel> invoiceTransactionModels = new ArrayList<InvoiceTransactionModel>(0);

    /**
     * @return the discount
     */
    public String getDiscount() {
        return discount;
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
     * @return the paidStatus
     */
    public String getPaidStatus() {
        return paidStatus;
    }

    /**
     * @return the sellerInvoiceId
     */
    public String getSellerInvoiceId() {
        return sellerInvoiceId;
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
     * @param discount
     *            the discount to set
     */
    public void setDiscount(final String discount) {
        this.discount = discount;
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
     * @param paidStatus
     *            the paidStatus to set
     */
    public void setPaidStatus(final String paidStatus) {
        this.paidStatus = paidStatus;
    }

    /**
     * @param sellerInvoiceId
     *            the sellerInvoiceId to set
     */
    public void setSellerInvoiceId(final String sellerInvoiceId) {
        this.sellerInvoiceId = sellerInvoiceId;
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

}
