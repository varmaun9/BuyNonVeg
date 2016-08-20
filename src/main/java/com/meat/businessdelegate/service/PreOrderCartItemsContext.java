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
@Component("preOrderCartItemsContext")
public class PreOrderCartItemsContext implements IBusinessDelegateContext {

    private String all;
    private String preOrderCartItemsOnly;
    private String preOrderCartItemsId;

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
    public String getPreOrderCartItemsOnly() {
        // TODO Auto-generated method stub
        return preOrderCartItemsOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @return the preOrderCartItemsId
     */
    public String getPreOrderCartItemsId() {
        return preOrderCartItemsId;
    }

    /**
     * @param preOrderCartItemsId the preOrderCartItemsId to set
     */
    public void setPreOrderCartItemsId(String preOrderCartItemsId) {
        this.preOrderCartItemsId = preOrderCartItemsId;
    }

}
