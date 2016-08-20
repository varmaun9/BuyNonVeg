package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cutTypeContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CutTypeContext implements IBusinessDelegateContext {

    private String all;
    private String cutTypeOnly;
    private String categoryId;
    private String sellerItemId;
    private String itemId;

    public String getAll() {
        return all;
    }

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the cutTypeOnly
     */
    public String getCutTypeOnly() {
        return cutTypeOnly;
    }

    /**
     * @return the sellerItemId
     */
    public String getSellerItemId() {
        return sellerItemId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param cutTypeOnly
     *            the cutTypeOnly to set
     */
    public void setCutTypeOnly(final String cutTypeOnly) {
        this.cutTypeOnly = cutTypeOnly;
    }

    /**
     * @param sellerItemId
     *            the sellerItemId to set
     */
    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
