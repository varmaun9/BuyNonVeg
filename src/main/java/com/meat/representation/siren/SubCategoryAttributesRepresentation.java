/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubCategoryAttributesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("subCategoryAttributesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategoryAttribute", uri = "/subCategoryAttributes/{id}")
@Representation(SubCategoryAttributesModel.class)
public class SubCategoryAttributesRepresentation extends BaseResource {
    private String id;
    private String attributesId;
    private String subCategoryId;
    private String attributeValue;
    private String status;

    public String getAttributesId() {
        return attributesId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setAttributesId(final String attributesId) {
        this.attributesId = attributesId;
    }

    public void setAttributeValue(final String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}
