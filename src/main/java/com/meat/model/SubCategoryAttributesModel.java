package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryAttributesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubCategoryAttributesModel extends AbstractModel {

    private String attributesId;
    private String subCategoryId;
    private String attributeValue;
    private String status;

    /**
     * @return the attributesId
     */
    public String getAttributesId() {
        return attributesId;
    }

    /**
     * @return the attributeValue
     */
    public String getAttributeValue() {
        return attributeValue;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the subCategoryId
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * @param attributesId
     *            the attributesId to set
     */
    public void setAttributesId(final String attributesId) {
        this.attributesId = attributesId;
    }

    /**
     * @param attributeValue
     *            the attributeValue to set
     */
    public void setAttributeValue(final String attributeValue) {
        this.attributeValue = attributeValue;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param subCategoryId
     *            the subCategoryId to set
     */
    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

}
