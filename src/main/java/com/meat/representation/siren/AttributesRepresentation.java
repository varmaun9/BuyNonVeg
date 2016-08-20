/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.AttributesModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("attributesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "attribute", uri = "/attributes/{id}")
@Representation(AttributesModel.class)
public class AttributesRepresentation extends BaseResource {

    private String id;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String attributeName;
    private String description;
    private String status;
    private String attributeCreatedDate;
    @Siren4JSubEntity
    private List<SubCategoryAttributesRepresentation> subCategoryAttributesRep = new ArrayList<SubCategoryAttributesRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryAttributesRepresentation> CategoryAttributesRep = new ArrayList<CategoryAttributesRepresentation>(0);
    @Siren4JSubEntity
    private List<ItemAttributesRepresentation> itemAttributesesRep = new ArrayList<ItemAttributesRepresentation>(0);

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
     * @return the categoryAttributesRep
     */
    public List<CategoryAttributesRepresentation> getCategoryAttributesRep() {
        return CategoryAttributesRep;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the itemAttributesesRep
     */
    public List<ItemAttributesRepresentation> getItemAttributesesRep() {
        return itemAttributesesRep;
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
     * @return the subCategoryAttributesRep
     */
    public List<SubCategoryAttributesRepresentation> getSubCategoryAttributesRep() {
        return subCategoryAttributesRep;
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
     * @param categoryAttributesRep
     *            the categoryAttributesRep to set
     */
    public void setCategoryAttributesRep(final List<CategoryAttributesRepresentation> categoryAttributesRep) {
        CategoryAttributesRep = categoryAttributesRep;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param itemAttributesesRep
     *            the itemAttributesesRep to set
     */
    public void setItemAttributesesRep(final List<ItemAttributesRepresentation> itemAttributesesRep) {
        this.itemAttributesesRep = itemAttributesesRep;
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
     * @param subCategoryAttributesRep
     *            the subCategoryAttributesRep to set
     */
    public void setSubCategoryAttributesRep(final List<SubCategoryAttributesRepresentation> subCategoryAttributesRep) {
        this.subCategoryAttributesRep = subCategoryAttributesRep;
    }

}