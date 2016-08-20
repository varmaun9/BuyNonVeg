package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SeoModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("seoRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "seo", uri = "/seoses/{id}")
@Representation(SeoModel.class)
public class SeoRepresentation extends BaseResource {
    private String id;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    @Siren4JSubEntity
    private List<SubCategoryRepresentation> subCategoryRep = new ArrayList<SubCategoryRepresentation>(0);
    @Siren4JSubEntity
    private List<CriteriaRepresentation> criteriaRep = new ArrayList<CriteriaRepresentation>(0);
    @Siren4JSubEntity
    private List<TagsRepresentation> tagRep = new ArrayList<TagsRepresentation>(0);
    @Siren4JSubEntity
    private List<CategoryRepresentation> categorieRep = new ArrayList<CategoryRepresentation>(0);
    @Siren4JSubEntity
    private List<AttributesRepresentation> attributesRep = new ArrayList<AttributesRepresentation>(0);
    @Siren4JSubEntity
    private List<ItemRepresentation> itemRep = new ArrayList<ItemRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerRepresentation> sellerRep = new ArrayList<SellerRepresentation>(0);
    @Siren4JSubEntity
    private List<SellerItemRepresentation> sellerItemRep = new ArrayList<SellerItemRepresentation>(0);

    public List<AttributesRepresentation> getAttributesRep() {
        return attributesRep;
    }

    public List<CategoryRepresentation> getCategorieRep() {
        return categorieRep;
    }

    public List<CriteriaRepresentation> getCriteriaRep() {
        return criteriaRep;
    }

    public String getId() {
        return id;
    }

    public List<ItemRepresentation> getItemRep() {
        return itemRep;
    }

    public List<SellerItemRepresentation> getSellerItemRep() {
        return sellerItemRep;
    }

    public List<SellerRepresentation> getSellerRep() {
        return sellerRep;
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

    public List<SubCategoryRepresentation> getSubCategoryRep() {
        return subCategoryRep;
    }

    public List<TagsRepresentation> getTagRep() {
        return tagRep;
    }

    public void setAttributesRep(final List<AttributesRepresentation> attributesRep) {
        this.attributesRep = attributesRep;
    }

    public void setCategorieRep(final List<CategoryRepresentation> categorieRep) {
        this.categorieRep = categorieRep;
    }

    public void setCriteriaRep(final List<CriteriaRepresentation> criteriaRep) {
        this.criteriaRep = criteriaRep;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemRep(final List<ItemRepresentation> itemRep) {
        this.itemRep = itemRep;
    }

    public void setSellerItemRep(final List<SellerItemRepresentation> sellerItemRep) {
        this.sellerItemRep = sellerItemRep;
    }

    public void setSellerRep(final List<SellerRepresentation> sellerRep) {
        this.sellerRep = sellerRep;
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

    public void setSubCategoryRep(final List<SubCategoryRepresentation> subCategoryRep) {
        this.subCategoryRep = subCategoryRep;
    }

    public void setTagRep(final List<TagsRepresentation> tagRep) {
        this.tagRep = tagRep;
    }

}
