package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryAttributesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryAttributesModel extends AbstractModel {

    private String attributesId;
    private String categoryId;
    private String attributeValue;
    private String categoryName;
    private String attributeName;

    private String status;

    private List<ItemAttributesModel> itemAttributeModels = new ArrayList<ItemAttributesModel>(0);

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributesId() {
        return attributesId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @return the itemAttributeModels
     */
    public List<ItemAttributesModel> getItemAttributeModels() {
        return itemAttributeModels;
    }

    public String getStatus() {
        return status;
    }

    public void setAttributeName(final String attributeName) {
        this.attributeName = attributeName;
    }

    public void setAttributesId(final String attributesId) {
        this.attributesId = attributesId;
    }

    public void setAttributeValue(final String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @param itemAttributeModels
     *            the itemAttributeModels to set
     */
    public void setItemAttributeModels(final List<ItemAttributesModel> itemAttributeModels) {
        this.itemAttributeModels = itemAttributeModels;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
