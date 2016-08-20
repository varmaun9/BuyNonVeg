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
@Component("invoiceStatusCodesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InvoiceStatusCodesModel extends AbstractModel {
    private String invoiceId;
    private String invoiceStatusCode;
    private String invoiceStatusDescription;
    private String invoiceStatusDate;

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
