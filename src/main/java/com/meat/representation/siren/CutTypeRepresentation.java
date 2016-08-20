package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CutTypeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cutTypeRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "cutType", uri = "/cutTypes/{id}")
@Representation(CutTypeModel.class)
public class CutTypeRepresentation extends BaseResource {
    private String id;
    private String categoryId;
    private String cutTypeName;
    private String status;
    private String description;
    private String createdDate;
    private String categoryName;

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

    /**
     * @return the id
     */
    public String getId() {
        return id;
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

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}
