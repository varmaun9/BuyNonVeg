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
@Component("accountContext")
public class AccountContext implements IBusinessDelegateContext {

    private String all;
    private String accountOnly;
    private String branch;

    /**
     * @return
     */
    public String getAccountOnly() {
        // TODO Auto-generated method stub
        return accountOnly;
    }

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param branch
     *            the branch to set
     */
    public void setBranch(final String branch) {
        this.branch = branch;
    }

}
