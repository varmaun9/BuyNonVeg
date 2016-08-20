package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryCriteriaModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryCriteriaModel extends AbstractModel {

    private String criteriaId;
    private String categoryId;
    private String criteriaValue;
    private String criteriaName;
    private String categoryName;
    private String status;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCriteriaId() {
        return criteriaId;
    }

    /**
     * @return the criteriaName
     */
    public String getCriteriaName() {
        return criteriaName;
    }

    public String getCriteriaValue() {
        return criteriaValue;
    }

    public String getStatus() {
        return status;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

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

    public void setCriteriaValue(final String criteriaValue) {
        this.criteriaValue = criteriaValue;
    }

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
