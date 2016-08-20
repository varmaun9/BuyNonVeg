package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("attributesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AttributesModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String attributeName;
    private String description;
    private String status;
    private String attributeCreatedDate;
    private List<ItemAttributesModel> itemAttributesesModels = new ArrayList<ItemAttributesModel>(0);
    private List<SubCategoryAttributesModel> subCategoryAttributesModels = new ArrayList<SubCategoryAttributesModel>(0);
    private List<CategoryAttributesModel> CategoryAttributesModels = new ArrayList<CategoryAttributesModel>(0);

    /**
     * @return the attributeCreatedDate
     */
    public String getAttributeCreatedDate() {
        return attributeCreatedDate;
    }

    /**
     * @return the attributeName
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @return the categoryAttributesModels
     */
    public List<CategoryAttributesModel> getCategoryAttributesModels() {
        return CategoryAttributesModels;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the itemAttributesesModels
     */
    public List<ItemAttributesModel> getItemAttributesesModels() {
        return itemAttributesesModels;
    }

    /**
     * @return the seoId
     */
    public String getSeoId() {
        return seoId;
    }

    /**
     * @return the seoKeywords
     */
    public String getSeoKeywords() {
        return seoKeywords;
    }

    /**
     * @return the seoMetaDescription
     */
    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    /**
     * @return the seoTitle
     */
    public String getSeoTitle() {
        return seoTitle;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the subCategoryAttributesModels
     */
    public List<SubCategoryAttributesModel> getSubCategoryAttributesModels() {
        return subCategoryAttributesModels;
    }

    /**
     * @param attributeCreatedDate
     *            the attributeCreatedDate to set
     */
    public void setAttributeCreatedDate(final String attributeCreatedDate) {
        this.attributeCreatedDate = attributeCreatedDate;
    }

    /**
     * @param attributeName
     *            the attributeName to set
     */
    public void setAttributeName(final String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @param categoryAttributesModels
     *            the categoryAttributesModels to set
     */
    public void setCategoryAttributesModels(final List<CategoryAttributesModel> categoryAttributesModels) {
        CategoryAttributesModels = categoryAttributesModels;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param itemAttributesesModels
     *            the itemAttributesesModels to set
     */
    public void setItemAttributesesModels(final List<ItemAttributesModel> itemAttributesesModels) {
        this.itemAttributesesModels = itemAttributesesModels;
    }

    /**
     * @param seoId
     *            the seoId to set
     */
    public void setSeoId(final String seoId) {
        this.seoId = seoId;
    }

    /**
     * @param seoKeywords
     *            the seoKeywords to set
     */
    public void setSeoKeywords(final String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    /**
     * @param seoMetaDescription
     *            the seoMetaDescription to set
     */
    public void setSeoMetaDescription(final String seoMetaDescription) {
        this.seoMetaDescription = seoMetaDescription;
    }

    /**
     * @param seoTitle
     *            the seoTitle to set
     */
    public void setSeoTitle(final String seoTitle) {
        this.seoTitle = seoTitle;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param subCategoryAttributesModels
     *            the subCategoryAttributesModels to set
     */
    public void setSubCategoryAttributesModels(final List<SubCategoryAttributesModel> subCategoryAttributesModels) {
        this.subCategoryAttributesModels = subCategoryAttributesModels;
    }

}
