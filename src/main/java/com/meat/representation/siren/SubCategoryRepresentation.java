package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubCategoryModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategory", uri = "/subCategories/{id}")
@Representation(SubCategoryModel.class)
public class SubCategoryRepresentation extends BaseResource {
    private String id;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String categoryId;
    private String categoryName;
    private String subCategoryName;
    private String subCategoryNameStatus;
    private String description;
    private String createdDate;
    private String sellingTag;
    private String status;
    private String subCategoryCode;
    private String subCategoryCount;
    @Siren4JSubEntity
    private List<ItemRepresentation> itemRep = new ArrayList<ItemRepresentation>(0);
    @Siren4JSubEntity
    private List<SubCategoryAttributesRepresentation> subCategoryAttributesRep = new ArrayList<SubCategoryAttributesRepresentation>(0);
    @Siren4JSubEntity
    private List<SubCategoryTagsRepresentation> subCategoryTagsRep = new ArrayList<SubCategoryTagsRepresentation>(0);
    @Siren4JSubEntity
    private List<SubCategoryImagesRepresentation> subCategoryImagesRep = new ArrayList<SubCategoryImagesRepresentation>(0);

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
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
     * @return the itemRep
     */
    public List<ItemRepresentation> getItemRep() {
        return itemRep;
    }

    /**
     * @return the sellingTag
     */
    public String getSellingTag() {
        return sellingTag;
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
     * @return the subCategoryCode
     */
    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    /**
     * @return the subCategoryCount
     */
    public String getSubCategoryCount() {
        return subCategoryCount;
    }

    /**
     * @return the subCategoryImagesRep
     */
    public List<SubCategoryImagesRepresentation> getSubCategoryImagesRep() {
        return subCategoryImagesRep;
    }

    /**
     * @return the subCategoryName
     */
    public String getSubCategoryName() {
        return subCategoryName;
    }

    public String getSubCategoryNameStatus() {
        return subCategoryNameStatus;
    }

    /**
     * @return the subCategoryTagsRep
     */
    public List<SubCategoryTagsRepresentation> getSubCategoryTagsRep() {
        return subCategoryTagsRep;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
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
     * @param itemRep
     *            the itemRep to set
     */
    public void setItemRep(final List<ItemRepresentation> itemRep) {
        this.itemRep = itemRep;
    }

    /**
     * @param sellingTag
     *            the sellingTag to set
     */
    public void setSellingTag(final String sellingTag) {
        this.sellingTag = sellingTag;
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

    /**
     * @param subCategoryCode
     *            the subCategoryCode to set
     */
    public void setSubCategoryCode(final String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }

    /**
     * @param subCategoryCount
     *            the subCategoryCount to set
     */
    public void setSubCategoryCount(final String subCategoryCount) {
        this.subCategoryCount = subCategoryCount;
    }

    /**
     * @param subCategoryImagesRep
     *            the subCategoryImagesRep to set
     */
    public void setSubCategoryImagesRep(final List<SubCategoryImagesRepresentation> subCategoryImagesRep) {
        this.subCategoryImagesRep = subCategoryImagesRep;
    }

    /**
     * @param subCategoryName
     *            the subCategoryName to set
     */
    public void setSubCategoryName(final String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public void setSubCategoryNameStatus(final String subCategoryNameStatus) {
        this.subCategoryNameStatus = subCategoryNameStatus;
    }

    /**
     * @param subCategoryTagsRep
     *            the subCategoryTagsRep to set
     */
    public void setSubCategoryTagsRep(final List<SubCategoryTagsRepresentation> subCategoryTagsRep) {
        this.subCategoryTagsRep = subCategoryTagsRep;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}