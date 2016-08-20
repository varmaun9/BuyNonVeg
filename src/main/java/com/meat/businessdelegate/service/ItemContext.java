package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("itemContext")
public class ItemContext implements IBusinessDelegateContext {

    private String all;
    private String itemWithOutSellerItem;
    private String itemWithSellerItem;
    private String itemOnly;
    private String itemId;
    private String itemCategoryOnly;
    private String itemZoneOnly;
    private String zoneId;
    private String categoryId;
    private String subCategoryId;

    public String getAll() {
        return all;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getItemCategoryOnly() {
        return itemCategoryOnly;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemOnly() {
        return itemOnly;
    }

    public String getItemWithOutSellerItem() {
        return itemWithOutSellerItem;
    }

    /**
     * @return the itemWithSellerItem
     */
    public String getItemWithSellerItem() {
        return itemWithSellerItem;
    }

    public String getItemZoneOnly() {
        return itemZoneOnly;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setItemCategoryOnly(final String itemCategoryOnly) {
        this.itemCategoryOnly = itemCategoryOnly;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setItemOnly(final String itemOnly) {
        this.itemOnly = itemOnly;
    }

    public void setItemWithOutSellerItem(final String itemWithOutSellerItem) {
        this.itemWithOutSellerItem = itemWithOutSellerItem;
    }

    /**
     * @param itemWithSellerItem
     *            the itemWithSellerItem to set
     */
    public void setItemWithSellerItem(final String itemWithSellerItem) {
        this.itemWithSellerItem = itemWithSellerItem;
    }

    public void setItemZoneOnly(final String itemZoneOnly) {
        this.itemZoneOnly = itemZoneOnly;
    }

    public void setZoneId(final String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * @return the subCategoryId
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * @param subCategoryId the subCategoryId to set
     */
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

}