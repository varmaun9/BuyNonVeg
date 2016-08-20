/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryCutTypeModel extends AbstractModel {

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
