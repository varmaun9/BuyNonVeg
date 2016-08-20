package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "category", uri = "/categories/{id}")
@Representation(CategoryModel.class)
public class CategoryRepresentation extends BaseResource {

    private String id;
    private String categoryName;
    private String description;
    private String status;
    private String categoryNameStatus;
    private String createdDate;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String sellingTag;
    private String categoryCode;
    private String categoryCount;
    @Siren4JSubEntity
    private List<CategoryAttributesRepresentation> categoryAttributesRep = new ArrayList<CategoryAttributesRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryTagsRepresentation> categoryTagsRep = new ArrayList<CategoryTagsRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryCriteriaRepresentation> categoryCriteriaRep = new ArrayList<CategoryCriteriaRepresentation>(0);
    @Siren4JSubEntity
    private List<SubCategoryRepresentation> subCategoryRep = new ArrayList<SubCategoryRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryImagesRepresentation> categoryImagesRep = new ArrayList<CategoryImagesRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferExcludeConfigRepresentation> offerExcludeConfigsRep = new ArrayList<OfferExcludeConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<OfferConfigRepresentation> offerConfigsRep = new ArrayList<OfferConfigRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryCutTypeRepresentation> categoryCutTypeRep = new ArrayList<CategoryCutTypeRepresentation>(0);

    public List<CategoryAttributesRepresentation> getCategoryAttributesRep() {
        return categoryAttributesRep;
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

    public List<CategoryCriteriaRepresentation> getCategoryCriteriaRep() {
        return categoryCriteriaRep;
    }

    public List<CategoryCutTypeRepresentation> getCategoryCutTypeRep() {
        return categoryCutTypeRep;
    }

    public List<CategoryImagesRepresentation> getCategoryImagesRep() {
        return categoryImagesRep;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryNameStatus() {
        return categoryNameStatus;
    }

    public List<CategoryTagsRepresentation> getCategoryTagsRep() {
        return categoryTagsRep;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    /**
     * @return the offerConfigsRep
     */
    public List<OfferConfigRepresentation> getOfferConfigsRep() {
        return offerConfigsRep;
    }

    /**
     * @return the offerExcludeConfigsRep
     */
    public List<OfferExcludeConfigRepresentation> getOfferExcludeConfigsRep() {
        return offerExcludeConfigsRep;
    }

    /**
     * @return the sellingTag
     */
    public String getSellingTag() {
        return sellingTag;
    }

    public String getSeoId() {
        return seoId;
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public String getSeoMetaDescription() {
        return seoMetaDescription;
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public String getStatus() {
        return status;
    }

    public List<SubCategoryRepresentation> getSubCategoryRep() {
        return subCategoryRep;
    }

    public void setCategoryAttributesRep(final List<CategoryAttributesRepresentation> categoryAttributesRep) {
        this.categoryAttributesRep = categoryAttributesRep;
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

    public void setCategoryCriteriaRep(final List<CategoryCriteriaRepresentation> categoryCriteriaRep) {
        this.categoryCriteriaRep = categoryCriteriaRep;
    }

    public void setCategoryCutTypeRep(final List<CategoryCutTypeRepresentation> categoryCutTypeRep) {
        this.categoryCutTypeRep = categoryCutTypeRep;
    }

    public void setCategoryImagesRep(final List<CategoryImagesRepresentation> categoryImagesRep) {
        this.categoryImagesRep = categoryImagesRep;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryNameStatus(final String categoryNameStatus) {
        this.categoryNameStatus = categoryNameStatus;
    }

    public void setCategoryTagsRep(final List<CategoryTagsRepresentation> categoryTagsRep) {
        this.categoryTagsRep = categoryTagsRep;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param offerConfigsRep
     *            the offerConfigsRep to set
     */
    public void setOfferConfigsRep(final List<OfferConfigRepresentation> offerConfigsRep) {
        this.offerConfigsRep = offerConfigsRep;
    }

    /**
     * @param offerExcludeConfigsRep
     *            the offerExcludeConfigsRep to set
     */
    public void setOfferExcludeConfigsRep(final List<OfferExcludeConfigRepresentation> offerExcludeConfigsRep) {
        this.offerExcludeConfigsRep = offerExcludeConfigsRep;
    }

    /**
     * @param sellingTag
     *            the sellingTag to set
     */
    public void setSellingTag(final String sellingTag) {
        this.sellingTag = sellingTag;
    }

    public void setSeoId(final String seoId) {
        this.seoId = seoId;
    }

    public void setSeoKeywords(final String seoKeywords) {
        this.seoKeywords = seoKeywords;
    }

    public void setSeoMetaDescription(final String seoMetaDescription) {
        this.seoMetaDescription = seoMetaDescription;
    }

    public void setSeoTitle(final String seoTitle) {
        this.seoTitle = seoTitle;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setSubCategoryRep(final List<SubCategoryRepresentation> subCategoryRep) {
        this.subCategoryRep = subCategoryRep;
    }

}