/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerBranchZoneContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchZoneContext implements IBusinessDelegateContext {

    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(String all) {
        this.all = all;
    }

}
