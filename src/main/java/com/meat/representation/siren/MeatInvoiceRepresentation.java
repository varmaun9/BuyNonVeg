/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.MeatInvoiceModel;
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
@Component("meatInvoiceRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "meatInvoice", uri = "/meatInvoices/{id}")
@Representation(MeatInvoiceModel.class)
public class MeatInvoiceRepresentation extends BaseResource {
    private String id;
    private String sellerInvoiceId;
    private String totalAmount;
    private String tax;
    private String discount;
    private String grandTotalAmount;
    private String paidStatus;
    @Siren4JSubEntity
    private List<InvoiceTransactionRepresentation> invoiceTransactionRep = new ArrayList<InvoiceTransactionRepresentation>(0);

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
