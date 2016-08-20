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
@Component("sellerBankAccountContext")
public class SellerBankAccountContext implements IBusinessDelegateContext {

    private String all;
    private String sellerBankAccountOnly;

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
    public String getSellerBankAccountOnly() {
        // TODO Auto-generated method stub
        return sellerBankAccountOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
