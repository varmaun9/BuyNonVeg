package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("seoModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SeoModel extends AbstractModel {
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private List<SubCategoryModel> subCategoryModels = new ArrayList<SubCategoryModel>(0);
    private List<CriteriaModel> criteriaModels = new ArrayList<CriteriaModel>(0);
    private List<TagsModel> tagModels = new ArrayList<TagsModel>(0);
    private List<CategoryModel> categorieModels = new ArrayList<CategoryModel>(0);
    private List<AttributesModel> attributeModels = new ArrayList<AttributesModel>(0);
    private List<ItemModel> itemModels = new ArrayList<ItemModel>(0);
    private List<SellerModel> sellerModels = new ArrayList<SellerModel>(0);
    private List<SellerItemModel> sellerItemModels = new ArrayList<SellerItemModel>(0);

    public List<AttributesModel> getAttributeModels() {
        return attributeModels;
    }

    public List<CategoryModel> getCategorieModels() {
        return categorieModels;
    }

    public List<CriteriaModel> getCriteriaModels() {
        return criteriaModels;
    }

    public List<ItemModel> getItemModels() {
        return itemModels;
    }

    public List<SellerItemModel> getSellerItemModels() {
        return sellerItemModels;
    }

    public List<SellerModel> getSellerModels() {
        return sellerModels;
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

    public List<SubCategoryModel> getSubCategoryModels() {
        return subCategoryModels;
    }

    public List<TagsModel> getTagModels() {
        return tagModels;
    }

    public void setAttributeModels(final List<AttributesModel> attributeModels) {
        this.attributeModels = attributeModels;
    }

    public void setCategorieModels(final List<CategoryModel> categorieModels) {
        this.categorieModels = categorieModels;
    }

    public void setCriteriaModels(final List<CriteriaModel> criteriaModels) {
        this.criteriaModels = criteriaModels;
    }

    public void setItemModels(final List<ItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    public void setSellerItemModels(final List<SellerItemModel> sellerItemModels) {
        this.sellerItemModels = sellerItemModels;
    }

    public void setSellerModels(final List<SellerModel> sellerModels) {
        this.sellerModels = sellerModels;
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

    public void setSubCategoryModels(final List<SubCategoryModel> subCategoryModels) {
        this.subCategoryModels = subCategoryModels;
    }

    public void setTagModels(final List<TagsModel> tagModels) {
        this.tagModels = tagModels;
    }

}
