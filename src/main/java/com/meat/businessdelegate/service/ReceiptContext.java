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
@Component("receiptContext")
public class ReceiptContext implements IBusinessDelegateContext {

    private String all;
    private String receiptOnly;

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
    public String getReceiptOnly() {
        // TODO Auto-generated method stub
        return receiptOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
