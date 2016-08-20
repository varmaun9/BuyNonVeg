package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component("taxContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TaxContext implements IBusinessDelegateContext {

    private String all;

    /**
     * @return the all
     */
    public String getAll() {
        return all;
    }

    /**
     * @param all
     *            the all to set
     */
    public void setAll(final String all) {
        this.all = all;
    }

}
