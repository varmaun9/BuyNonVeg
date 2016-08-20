package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tagsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TagsModel extends AbstractModel {
    private String tagTypeId;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String tagName;
    private String tagTypeName;
    private String tagNameStatus;
    private String description;
    private String createdDate;
    private String status;
    private List<CategoryTagsModel> categoryTagModels = new ArrayList<CategoryTagsModel>(0);
    private List<ItemTagsModel> itemTagModels = new ArrayList<ItemTagsModel>(0);
    private List<SubCategoryTagsModel> subCategoryTagModels = new ArrayList<SubCategoryTagsModel>(0);

    /**
     * @return the categoryTagModels
     */
    public List<CategoryTagsModel> getCategoryTagModels() {
        return categoryTagModels;
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
     * @return the itemTagModels
     */
    public List<ItemTagsModel> getItemTagModels() {
        return itemTagModels;
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
     * @return the subCategoryTagModels
     */
    public List<SubCategoryTagsModel> getSubCategoryTagModels() {
        return subCategoryTagModels;
    }

    /**
     * @return the tagName
     */
    public String getTagName() {
        return tagName;
    }

    public String getTagNameStatus() {
        return tagNameStatus;
    }

    /**
     * @return the tagTypeId
     */
    public String getTagTypeId() {
        return tagTypeId;
    }

    /**
     * @param categoryTagModels
     *            the categoryTagModels to set
     */
    public void setCategoryTagModels(final List<CategoryTagsModel> categoryTagModels) {
        this.categoryTagModels = categoryTagModels;
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
     * @param itemTagModels
     *            the itemTagModels to set
     */
    public void setItemTagModels(final List<ItemTagsModel> itemTagModels) {
        this.itemTagModels = itemTagModels;
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
     * @param subCategoryTagModels
     *            the subCategoryTagModels to set
     */
    public void setSubCategoryTagModels(final List<SubCategoryTagsModel> subCategoryTagModels) {
        this.subCategoryTagModels = subCategoryTagModels;
    }

    /**
     * @param tagName
     *            the tagName to set
     */
    public void setTagName(final String tagName) {
        this.tagName = tagName;
    }

    public void setTagNameStatus(final String tagNameStatus) {
        this.tagNameStatus = tagNameStatus;
    }

    /**
     * @param tagTypeId
     *            the tagTypeId to set
     */
    public void setTagTypeId(final String tagTypeId) {
        this.tagTypeId = tagTypeId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setTagTypeName(String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

}