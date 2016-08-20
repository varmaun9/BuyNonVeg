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
@Component("invoiceModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class InvoiceModel extends AbstractModel {
    private String ordersId;
    private String invoiceOrder;
    private String invoiceDate;
    private String invoiceDetails;
    private List<InvoiceStatusCodesModel> invoiceStatusCodeModels = new ArrayList<InvoiceStatusCodesModel>(0);

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
     * @return the invoiceStatusCodeModels
     */
    public List<InvoiceStatusCodesModel> getInvoiceStatusCodeModels() {
        return invoiceStatusCodeModels;
    }

    /**
     * @return the ordersId
     */
    public String getOrdersId() {
        return ordersId;
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
     * @param invoiceStatusCodeModels
     *            the invoiceStatusCodeModels to set
     */
    public void setInvoiceStatusCodeModels(final List<InvoiceStatusCodesModel> invoiceStatusCodeModels) {
        this.invoiceStatusCodeModels = invoiceStatusCodeModels;
    }

    /**
     * @param ordersId
     *            the ordersId to set
     */
    public void setOrdersId(final String ordersId) {
        this.ordersId = ordersId;
    }

}
