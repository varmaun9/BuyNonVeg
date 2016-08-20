package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemAttributesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ItemAttributesModel extends AbstractModel {
    private String attributesId;
    private String attributeName;
    private String itemId;
    private String categoryAttributesId;
    private String attributeValue;
    private String status;

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributesId() {
        return attributesId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public String getCategoryAttributesId() {
        return categoryAttributesId;
    }

    public String getItemId() {
        return itemId;
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

    public void setCategoryAttributesId(final String categoryAttributesId) {
        this.categoryAttributesId = categoryAttributesId;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
