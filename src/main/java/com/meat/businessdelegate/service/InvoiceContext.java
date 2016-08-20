/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("invoiceContext")
public class InvoiceContext implements IBusinessDelegateContext {

    private String all;
    private String invoiceOnly;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return
     */
    public String getInvoiceOnly() {
        // TODO Auto-generated method stub
        return invoiceOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
