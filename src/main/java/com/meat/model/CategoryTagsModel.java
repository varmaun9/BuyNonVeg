package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryTagsModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryTagsModel extends AbstractModel {

    private String tagsId;
    private String tagName;
    private String tagTypeName;
    private String categoryId;
    private String categoryTagsStatus;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryTagsStatus() {
        return categoryTagsStatus;
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
