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
@Component("meatInvoiceContext")
public class MeatInvoiceContext implements IBusinessDelegateContext {

    private String all;
    private String meatInvoiceOnly;

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
    public String getMeatInvoiceOnly() {
        // TODO Auto-generated method stub
        return meatInvoiceOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }
}
