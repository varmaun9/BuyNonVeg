package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cutTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CutTypeModel extends AbstractModel {

    private String categoryId;
    private String cutTypeName;
    private String status;
    private String description;
    private String createdDate;
    private String categoryName;
    private List<CategoryCutTypeModel> categoryCutTypeModels = new ArrayList<CategoryCutTypeModel>();

    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getCutTypeName() {
        return cutTypeName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param categoryName
     *            the categoryName to set
     */
    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCutTypeName(final String cutTypeName) {
        this.cutTypeName = cutTypeName;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setStatus(final String status) {
        this.status = status;
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
