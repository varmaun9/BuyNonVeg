/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.TagsModel;
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
@Component("tagRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "tags", uri = "/tagses/{id}")
@Representation(TagsModel.class)
public class TagsRepresentation extends BaseResource {
    private String id;
    private String tagTypeId;
    private String tagTypeName;
    private String seoId;
    private String seoTitle;
    private String seoKeywords;
    private String seoMetaDescription;
    private String tagName;
    private String tagNameStatus;
    private String description;
    private String createdDate;
    private String status;
    @Siren4JSubEntity
    private List<CategoryTagsRepresentation> categoryTagRep = new ArrayList<CategoryTagsRepresentation>(0);
    @Siren4JSubEntity
    private List<ItemTagsRepresentation> itemTagRep = new ArrayList<ItemTagsRepresentation>(0);
    @Siren4JSubEntity
    private List<SubCategoryTagsRepresentation> subCategoryTagRep = new ArrayList<SubCategoryTagsRepresentation>(0);

    /**
     * @return the categoryTagRep
     */
    public List<CategoryTagsRepresentation> getCategoryTagRep() {
        return categoryTagRep;
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
     * @return the itemTagRep
     */
    public List<ItemTagsRepresentation> getItemTagRep() {
        return itemTagRep;
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
     * @return the subCategoryTagRep
     */
    public List<SubCategoryTagsRepresentation> getSubCategoryTagRep() {
        return subCategoryTagRep;
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
     * @param categoryTagRep
     *            the categoryTagRep to set
     */
    public void setCategoryTagRep(final List<CategoryTagsRepresentation> categoryTagRep) {
        this.categoryTagRep = categoryTagRep;
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
     * @param itemTagRep
     *            the itemTagRep to set
     */
    public void setItemTagRep(final List<ItemTagsRepresentation> itemTagRep) {
        this.itemTagRep = itemTagRep;
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
     * @param subCategoryTagRep
     *            the subCategoryTagRep to set
     */
    public void setSubCategoryTagRep(final List<SubCategoryTagsRepresentation> subCategoryTagRep) {
        this.subCategoryTagRep = subCategoryTagRep;
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