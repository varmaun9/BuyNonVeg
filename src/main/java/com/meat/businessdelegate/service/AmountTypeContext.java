/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("amountTypeContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AmountTypeContext implements IBusinessDelegateContext {

    private String all;
    private String amountTypeOnly;

    public String getAll() {
        return all;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @return the amountTypeOnly
     */
    public String getAmountTypeOnly() {
        return amountTypeOnly;
    }

    /**
     * @param amountTypeOnly the amountTypeOnly to set
     */
    public void setAmountTypeOnly(String amountTypeOnly) {
        this.amountTypeOnly = amountTypeOnly;
    }

}
