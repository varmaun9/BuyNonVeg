package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubCategoryModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String categoryId;
    private String categoryName;
    private String subCategoryName;
    private String description;
    private String createdDate;
    private String sellingTag;
    private String status;
    private String subCategoryCode;
    private String subCategoryCount;
    private String subCategoryNameStatus;
    private List<ItemModel> itemModels = new ArrayList<ItemModel>(0);
    private List<SubCategoryAttributesModel> subCategoryAttributeModels = new ArrayList<SubCategoryAttributesModel>(0);
    private List<SubCategoryTagsModel> subCategoryTagModels = new ArrayList<SubCategoryTagsModel>(0);
    private List<SubCategoryImagesModel> subCategoryImageModels = new ArrayList<SubCategoryImagesModel>(0);

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
     * @return the itemModels
     */
    public List<ItemModel> getItemModels() {
        return itemModels;
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
     * @return the subCategoryAttributeModels
     */
    public List<SubCategoryAttributesModel> getSubCategoryAttributeModels() {
        return subCategoryAttributeModels;
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
     * @return the subCategoryImageModels
     */
    public List<SubCategoryImagesModel> getSubCategoryImageModels() {
        return subCategoryImageModels;
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
     * @return the subCategoryTagModels
     */
    public List<SubCategoryTagsModel> getSubCategoryTagModels() {
        return subCategoryTagModels;
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
     * @param itemModels
     *            the itemModels to set
     */
    public void setItemModels(final List<ItemModel> itemModels) {
        this.itemModels = itemModels;
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
     * @param subCategoryAttributeModels
     *            the subCategoryAttributeModels to set
     */
    public void setSubCategoryAttributeModels(final List<SubCategoryAttributesModel> subCategoryAttributeModels) {
        this.subCategoryAttributeModels = subCategoryAttributeModels;
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
     * @param subCategoryImageModels
     *            the subCategoryImageModels to set
     */
    public void setSubCategoryImageModels(final List<SubCategoryImagesModel> subCategoryImageModels) {
        this.subCategoryImageModels = subCategoryImageModels;
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
     * @param subCategoryTagModels
     *            the subCategoryTagModels to set
     */
    public void setSubCategoryTagModels(final List<SubCategoryTagsModel> subCategoryTagModels) {
        this.subCategoryTagModels = subCategoryTagModels;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
