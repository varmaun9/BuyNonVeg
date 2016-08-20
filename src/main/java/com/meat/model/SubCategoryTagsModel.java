package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryTagsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubCategoryTagsModel extends AbstractModel {

    private String tagsId;
    private String subCategoryId;
    private String tagName;
    private String tagTypeName;
    private String subCategoryTagsStatus;

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public String getSubCategoryTagsStatus() {
        return subCategoryTagsStatus;
    }

    public String getTagsId() {
        return tagsId;
    }

    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setSubCategoryTagsStatus(final String subCategoryTagsStatus) {
        this.subCategoryTagsStatus = subCategoryTagsStatus;
    }

    public void setTagsId(final String tagsId) {
        this.tagsId = tagsId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setTagTypeName(String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

}