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
@Component("sellerInvoiceContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerInvoiceContext implements IBusinessDelegateContext {

    private String all;
    private String sellerInvoiceOnly;
    private String generate;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return the generate
     */
    public String getGenerate() {
        return generate;
    }

    /**
     * @return
     */
    public String getSellerInvoiceOnly() {
        // TODO Auto-generated method stub
        return sellerInvoiceOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param generate
     *            the generate to set
     */
    public void setGenerate(final String generate) {
        this.generate = generate;
    }

}
