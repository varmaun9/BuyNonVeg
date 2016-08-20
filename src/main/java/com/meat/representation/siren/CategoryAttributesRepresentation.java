package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryAttributesModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryAttributesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryAttributes", uri = "/categoryAttributeses/{id}")
@Representation(CategoryAttributesModel.class)
public class CategoryAttributesRepresentation extends BaseResource {

    private String id;
    private String attributesId;
    private String categoryId;
    private String attributeValue;
    private String categoryName;
    private String attributeName;
    private String status;
    private List<ItemAttributesRepresentation> itemAttributeRep = new ArrayList<ItemAttributesRepresentation>(0);

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

    public String getId() {
        return id;
    }

    /**
     * @return the itemAttributeRep
     */
    public List<ItemAttributesRepresentation> getItemAttributeRep() {
        return itemAttributeRep;
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

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemAttributeRep
     *            the itemAttributeRep to set
     */
    public void setItemAttributeRep(final List<ItemAttributesRepresentation> itemAttributeRep) {
        this.itemAttributeRep = itemAttributeRep;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
