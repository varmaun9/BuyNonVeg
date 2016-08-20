/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryCriteriaModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCriteriaRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryCriteria", uri = "/categoryCriterias/{id}")
@Representation(CategoryCriteriaModel.class)
public class CategoryCriteriaRepresentation extends BaseResource {
    private String id;
    private String criteriaId;
    private String categoryId;
    private String criteriaValue;
    private String criteriaName;
    private String categoryName;
    private String status;

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the criteriaId
     */
    public String getCriteriaId() {
        return criteriaId;
    }

    /**
     * @return the criteriaName
     */
    public String getCriteriaName() {
        return criteriaName;
    }

    /**
     * @return the criteriaValue
     */
    public String getCriteriaValue() {
        return criteriaValue;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param criteriaId
     *            the criteriaId to set
     */
    public void setCriteriaId(final String criteriaId) {
        this.criteriaId = criteriaId;
    }

    /**
     * @param criteriaName
     *            the criteriaName to set
     */
    public void setCriteriaName(final String criteriaName) {
        this.criteriaName = criteriaName;
    }

    /**
     * @param criteriaValue
     *            the criteriaValue to set
     */
    public void setCriteriaValue(final String criteriaValue) {
        this.criteriaValue = criteriaValue;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
