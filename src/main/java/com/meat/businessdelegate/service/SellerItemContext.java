package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component("sellerItemContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerItemContext implements IBusinessDelegateContext {

    private String all;
    private String sellerItemOnly;
    private String sellerBranchItemsOnly;
    private String sellerBranchId;

    /**
     * @return
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
    public String getSellerItemOnly() {
        return sellerItemOnly;
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
    public void setSellerItemOnly(final String sellerItemOnly) {
        this.sellerItemOnly = sellerItemOnly;
    }

}