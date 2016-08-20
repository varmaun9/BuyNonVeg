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
@Component("subCategoryContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubCategoryContext implements IBusinessDelegateContext {

    private String all;
    private String subCategoryOnly;
    private String categoryId;
    private String sellerId;
    private String sellerBranchId;

    /* *//**
          * @return
          */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSubCategoryOnly() {
        return subCategoryOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setSubCategoryOnly(final String subCategoryOnly) {
        this.subCategoryOnly = subCategoryOnly;
    }

    /**
     * @return the sellerId
     */
    public String getSellerId() {
        return sellerId;
    }

    /**
     * @param sellerId the sellerId to set
     */
    public void setSellerId(String sellerId) {
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
