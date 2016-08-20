package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tagTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TagTypeModel extends AbstractModel {
    private String tagTypeName;
    private String tagTypeNameStatus;
    private String description;
    private String createdDate;
    private String status;
    private List<TagsModel> tagModel = new ArrayList<TagsModel>(0);

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public List<TagsModel> getTagModel() {
        return tagModel;
    }

    public String getTagTypeName() {
        return tagTypeName;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setTagModel(final List<TagsModel> tagModel) {
        this.tagModel = tagModel;
    }

    public void setTagTypeName(final String tagTypeName) {
        this.tagTypeName = tagTypeName;
    }

    public String getTagTypeNameStatus() {
        return tagTypeNameStatus;
    }

    public void setTagTypeNameStatus(String tagTypeNameStatus) {
        this.tagTypeNameStatus = tagTypeNameStatus;
    }
}
