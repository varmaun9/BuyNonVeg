/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("emailSubscriptionContext")
public class EmailSubscriptionContext implements IBusinessDelegateContext {

    private String all;
    private String allEmails;

    public String getAll() {
        return all;
    }

    /**
     * @return the allEmails
     */
    public String getAllEmails() {
        return allEmails;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param allEmails
     *            the allEmails to set
     */
    public void setAllEmails(final String allEmails) {
        this.allEmails = allEmails;
    }

}
