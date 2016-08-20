package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("categoryModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryModel extends AbstractModel {

    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String categoryName;
    private String categoryNameStatus;
    private String description;
    private String createdDate;
    private String sellingTag;
    private String status;
    private String categoryCode;
    private String categoryCount;
    private Integer countFlag;
    private List<CategoryAttributesModel> categoryAttributesModels = new ArrayList<CategoryAttributesModel>(0);
    private List<CategoryTagsModel> categoryTagsModels = new ArrayList<CategoryTagsModel>(0);
    private List<CategoryCriteriaModel> categoryCriteriaModels = new ArrayList<CategoryCriteriaModel>(0);
    private List<CategoryImagesModel> categoryImagesModels = new ArrayList<CategoryImagesModel>(0);
    private List<SubCategoryModel> subCategoriesModels = new ArrayList<SubCategoryModel>(0);
    private List<OfferExcludeConfigModel> offerExcludeConfigModels = new ArrayList<OfferExcludeConfigModel>(0);
    private List<OfferConfigModel> offerConfigModels = new ArrayList<OfferConfigModel>(0);
    private List<CategoryCutTypeModel> categoryCutTypeModels = new ArrayList<CategoryCutTypeModel>(0);

    /**
     * @return the categoryAttributesModels
     */
    public List<CategoryAttributesModel> getCategoryAttributesModels() {
        return categoryAttributesModels;
    }

    /**
     * @return the categoryCode
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * @return the categoryCount
     */
    public String getCategoryCount() {
        return categoryCount;
    }

    /**
     * @return the categoryCriteriaModels
     */
    public List<CategoryCriteriaModel> getCategoryCriteriaModels() {
        return categoryCriteriaModels;
    }

    /**
     * @return the categoryImagesModels
     */
    public List<CategoryImagesModel> getCategoryImagesModels() {
        return categoryImagesModels;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryNameStatus() {
        return categoryNameStatus;
    }

    /**
     * @return the categoryTagsModels
     */
    public List<CategoryTagsModel> getCategoryTagsModels() {
        return categoryTagsModels;
    }

    /**
     * @return the countFlag
     */
    public Integer getCountFlag() {
        return countFlag;
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
     * @return the offerConfigModels
     */
    public List<OfferConfigModel> getOfferConfigModels() {
        return offerConfigModels;
    }

    /**
     * @return the offerExcludeConfigModels
     */
    public List<OfferExcludeConfigModel> getOfferExcludeConfigModels() {
        return offerExcludeConfigModels;
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
     * @return the seoKeyWords
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
     * @return the subCategoriesModels
     */
    public List<SubCategoryModel> getSubCategoriesModels() {
        return subCategoriesModels;
    }

    /**
     * @param categoryAttributesModels
     *            the categoryAttributesModels to set
     */
    public void setCategoryAttributesModels(final List<CategoryAttributesModel> categoryAttributesModels) {
        this.categoryAttributesModels = categoryAttributesModels;
    }

    /**
     * @param categoryCode
     *            the categoryCode to set
     */
    public void setCategoryCode(final String categoryCode) {
        this.categoryCode = categoryCode;
    }

    /**
     * @param categoryCount
     *            the categoryCount to set
     */
    public void setCategoryCount(final String categoryCount) {
        this.categoryCount = categoryCount;
    }

    /**
     * @param categoryCriteriaModels
     *            the categoryCriteriaModels to set
     */
    public void setCategoryCriteriaModels(final List<CategoryCriteriaModel> categoryCriteriaModels) {
        this.categoryCriteriaModels = categoryCriteriaModels;
    }

    /**
     * @param categoryImagesModels
     *            the categoryImagesModels to set
     */
    public void setCategoryImagesModels(final List<CategoryImagesModel> categoryImagesModels) {
        this.categoryImagesModels = categoryImagesModels;
    }

    /**
     * @param categoryName
     *            the categoryName to set
     */
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryNameStatus(final String categoryNameStatus) {
        this.categoryNameStatus = categoryNameStatus;
    }

    /**
     * @param categoryTagsModels
     *            the categoryTagsModels to set
     */
    public void setCategoryTagsModels(final List<CategoryTagsModel> categoryTagsModels) {
        this.categoryTagsModels = categoryTagsModels;
    }

    /**
     * @param countFlag
     *            the countFlag to set
     */
    public void setCountFlag(final Integer countFlag) {
        this.countFlag = countFlag;
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
     * @param offerConfigModels
     *            the offerConfigModels to set
     */
    public void setOfferConfigModels(final List<OfferConfigModel> offerConfigModels) {
        this.offerConfigModels = offerConfigModels;
    }

    /**
     * @param offerExcludeConfigModels
     *            the offerExcludeConfigModels to set
     */
    public void setOfferExcludeConfigModels(final List<OfferExcludeConfigModel> offerExcludeConfigModels) {
        this.offerExcludeConfigModels = offerExcludeConfigModels;
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
     * @param seoKeyWords
     *            the seoKeyWords to set
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
     * @param subCategoriesModels
     *            the subCategoriesModels to set
     */
    public void setSubCategoriesModels(final List<SubCategoryModel> subCategoriesModels) {
        this.subCategoriesModels = subCategoriesModels;
    }

    /**
     * @return the categoryCutTypeModels
     */
    public List<CategoryCutTypeModel> getCategoryCutTypeModels() {
        return categoryCutTypeModels;
    }

    /**
     * @param categoryCutTypeModels the categoryCutTypeModels to set
     */
    public void setCategoryCutTypeModels(List<CategoryCutTypeModel> categoryCutTypeModels) {
        this.categoryCutTypeModels = categoryCutTypeModels;
    }

}
