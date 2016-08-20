/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ItemAttributesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemAttributesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "itemAttributes", uri = "/itemAttributes/{id}")
@Representation(ItemAttributesModel.class)
public class ItemAttributesRepresentation extends BaseResource {
    private String id;
    private String attributesId;
    private String itemId;
    private String attributeName;
    private String attributeValue;
    private String status;
    private String categoryAttributesId;

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributesId() {
        return attributesId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * @return the categoryAttributesId
     */
    public String getCategoryAttributesId() {
        return categoryAttributesId;
    }

    public String getId() {
        return id;
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

    /**
     * @param categoryAttributesId
     *            the categoryAttributesId to set
     */
    public void setCategoryAttributesId(final String categoryAttributesId) {
        this.categoryAttributesId = categoryAttributesId;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
