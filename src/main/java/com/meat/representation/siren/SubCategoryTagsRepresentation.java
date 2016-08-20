package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubCategoryTagsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryTagsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategoryTags", uri = "/subCategoryTagses/{id}")
@Representation(SubCategoryTagsModel.class)
public class SubCategoryTagsRepresentation extends BaseResource {
    private String id;
    private String tagsId;
    private String tagName;
    private String tagTypeName;
    private String subCategoryId;
    private String subCategoryTagsStatus;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the subCategoryId
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * @return the subCategoryTagsStatus
     */
    public String getSubCategoryTagsStatus() {
        return subCategoryTagsStatus;
    }

    public String getTagName() {
        return tagName;
    }

    /**
     * @return the tagsId
     */
    public String getTagsId() {
        return tagsId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param subCategoryId
     *            the subCategoryId to set
     */
    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    /**
     * @param subCategoryTagsStatus
     *            the subCategoryTagsStatus to set
     */
    public void setSubCategoryTagsStatus(final String subCategoryTagsStatus) {
        this.subCategoryTagsStatus = subCategoryTagsStatus;
    }

    public void setTagName(final String tagName) {
        this.tagName = tagName;
    }

    /**
     * @param tagsId
     *            the tagsId to set
     */
    public void setTagsId(final String tagsId) {
        this.tagsId = tagsId;
    }

    public void setTagTypeName(final String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

}