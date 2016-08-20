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
@Component("bankOfferContext")
public class BankOfferContext implements IBusinessDelegateContext {

    private String all;
    private String bankOfferOnly;

    /**
     * @return the all
     */
    public String getAll() {
        return all;
    }

    /**
     * @return the bankOfferOnly
     */
    public String getBankOfferOnly() {
        return bankOfferOnly;
    }

    /**
     * @param all
     *            the all to set
     */
    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param bankOfferOnly
     *            the bankOfferOnly to set
     */
    public void setBankOfferOnly(final String bankOfferOnly) {
        this.bankOfferOnly = bankOfferOnly;
    }

}
