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
@Component("sellerBranchChargesContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchChargesContext implements IBusinessDelegateContext {

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
