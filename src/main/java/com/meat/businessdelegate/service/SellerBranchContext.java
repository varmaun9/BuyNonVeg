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
@Component("sellerBranchContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchContext implements IBusinessDelegateContext {

    private String all;
    private String sellerBranchOnly;
    private String sellerId;
    private String sellerBranchId;
    private String sellerBranchItemsOnly;

    /**
     * @return the all
     */
    public String getAll() {
        return all;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @return the sellerBranchItemsOnly
     */
    public String getSellerBranchItemsOnly() {
        return sellerBranchItemsOnly;
    }

    /**
     * @return
     */
    public String getSellerBranchOnly() {
        // TODO Auto-generated method stub
        return sellerBranchOnly;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    /**
     * @param sellerBranchItemsOnly
     *            the sellerBranchItemsOnly to set
     */
    public void setSellerBranchItemsOnly(final String sellerBranchItemsOnly) {
        this.sellerBranchItemsOnly = sellerBranchItemsOnly;
    }

    /**
     * @param string
     */
    public void setSellerBranchOnly(final String sellerBranchOnly) {
        this.sellerBranchOnly = sellerBranchOnly;
    }

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

}
