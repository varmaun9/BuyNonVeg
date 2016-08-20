/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.InvoiceStatusCodesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("invoiceStatusCodesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "invoiceStatusCodes", uri = "/invoicesStatusCodeses/{id}")
@Representation(InvoiceStatusCodesModel.class)
public class InvoiceStatusCodesRepresentation extends BaseResource {
    private String id;
    private String invoiceId;
    private String invoiceStatusCode;
    private String invoiceStatusDescription;
    private String invoiceStatusDate;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the invoiceId
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * @return the invoiceStatusCode
     */
    public String getInvoiceStatusCode() {
        return invoiceStatusCode;
    }

    /**
     * @return the invoiceStatusDate
     */
    public String getInvoiceStatusDate() {
        return invoiceStatusDate;
    }

    /**
     * @return the invoiceStatusDescription
     */
    public String getInvoiceStatusDescription() {
        return invoiceStatusDescription;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param invoiceId
     *            the invoiceId to set
     */
    public void setInvoiceId(final String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * @param invoiceStatusCode
     *            the invoiceStatusCode to set
     */
    public void setInvoiceStatusCode(final String invoiceStatusCode) {
        this.invoiceStatusCode = invoiceStatusCode;
    }

    /**
     * @param invoiceStatusDate
     *            the invoiceStatusDate to set
     */
    public void setInvoiceStatusDate(final String invoiceStatusDate) {
        this.invoiceStatusDate = invoiceStatusDate;
    }

    /**
     * @param invoiceStatusDescription
     *            the invoiceStatusDescription to set
     */
    public void setInvoiceStatusDescription(final String invoiceStatusDescription) {
        this.invoiceStatusDescription = invoiceStatusDescription;
    }

}
