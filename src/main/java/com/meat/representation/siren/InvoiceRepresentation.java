/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.InvoiceModel;
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
@Component("invoiceRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "invoice", uri = "/invoices/{id}")
@Representation(InvoiceModel.class)
public class InvoiceRepresentation extends BaseResource {
    private String id;
    private String ordersId;
    private String invoiceOrder;
    private String invoiceDate;
    private String invoiceDetails;
    @Siren4JSubEntity
    private List<InvoiceStatusCodesRepresentation> invoiceStatusCodeRep = new ArrayList<InvoiceStatusCodesRepresentation>(0);

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the invoiceDate
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * @return the invoiceDetails
     */
    public String getInvoiceDetails() {
        return invoiceDetails;
    }

    /**
     * @return the invoiceOrder
     */
    public String getInvoiceOrder() {
        return invoiceOrder;
    }

    /**
     * @return the invoiceStatusCodeRep
     */
    public List<InvoiceStatusCodesRepresentation> getInvoiceStatusCodeRep() {
        return invoiceStatusCodeRep;
    }

    /**
     * @return the ordersId
     */
    public String getOrdersId() {
        return ordersId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param invoiceDate
     *            the invoiceDate to set
     */
    public void setInvoiceDate(final String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * @param invoiceDetails
     *            the invoiceDetails to set
     */
    public void setInvoiceDetails(final String invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    /**
     * @param invoiceOrder
     *            the invoiceOrder to set
     */
    public void setInvoiceOrder(final String invoiceOrder) {
        this.invoiceOrder = invoiceOrder;
    }

    /**
     * @param invoiceStatusCodeRep
     *            the invoiceStatusCodeRep to set
     */
    public void setInvoiceStatusCodeRep(final List<InvoiceStatusCodesRepresentation> invoiceStatusCodeRep) {
        this.invoiceStatusCodeRep = invoiceStatusCodeRep;
    }

    /**
     * @param ordersId
     *            the ordersId to set
     */
    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

}
