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
@Component("sellerBranchTimingsContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchTimingsContext implements IBusinessDelegateContext {

    private String all;
    private String sellerBranchId;

    public String getAll() {
        return all;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public void setSellerBranchId(String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

}
