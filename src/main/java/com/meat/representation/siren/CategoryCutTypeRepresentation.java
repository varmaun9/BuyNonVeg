/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryCutTypeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryCutType", uri = "/categoryCutTypes/{id}")
@Representation(CategoryCutTypeModel.class)
public class CategoryCutTypeRepresentation extends BaseResource {

    private String id;
    private String categoryId;
    private String cutTypeId;
    private String cutTypeName;
    private String status;
    private String description;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCutTypeId() {
        return cutTypeId;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCutTypeId(final String cutTypeId) {
        this.cutTypeId = cutTypeId;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the cutTypeName
     */
    public String getCutTypeName() {
        return cutTypeName;
    }

    /**
     * @param cutTypeName the cutTypeName to set
     */
    public void setCutTypeName(String cutTypeName) {
        this.cutTypeName = cutTypeName;
    }

}
