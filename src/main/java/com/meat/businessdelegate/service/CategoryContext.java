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
@Component("categoryContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryContext implements IBusinessDelegateContext {

    private String all;
    private String categoryOnly;
    private String sellerId;
    private String sellerBranchId;
    private String categoryId;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryOnly() {
        return categoryOnly;
    }

    /**
     * @return the sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryOnly(final String categoryOnly) {
        this.categoryOnly = categoryOnly;
    }

    /**
     * @param sellerId
     *            the sellerId to set
     */
    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @param sellerBranchId the sellerBranchId to set
     */
    public void setSellerBranchId(String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

}
