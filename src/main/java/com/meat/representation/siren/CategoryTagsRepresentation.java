package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryTagsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("CategoryTagsRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryTag", uri = "/categoryTagses/{id}")
@Representation(CategoryTagsModel.class)
public class CategoryTagsRepresentation extends BaseResource {

    private String id;
    private String tagsId;
    private String tagTypeName;
    private String tagName;
    private String categoryId;
    private String categoryTagsStatus;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryTagsStatus() {
        return categoryTagsStatus;
    }

    public String getId() {
        return id;
    }

    /**
     * @return the tagName
     */
    public String getTagName() {
        return tagName;
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTagsStatus(final String categoryTagsStatus) {
        this.categoryTagsStatus = categoryTagsStatus;
    }

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param tagName
     *            the tagName to set
     */
    public void setTagName(final String tagName) {
        this.tagName = tagName;
    }

    public void setTagsId(final String tagsId) {
        this.tagsId = tagsId;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setTagTypeName(String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

}