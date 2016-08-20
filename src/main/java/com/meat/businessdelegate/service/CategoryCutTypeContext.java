/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryCutTypeContext implements IBusinessDelegateContext {

    private String all;
    private String categoryId;
    private String categoryCutTypeId;

    public String getAll() {
        return all;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return the categoryCutTypeId
     */
    public String getCategoryCutTypeId() {
        return categoryCutTypeId;
    }

    /**
     * @param categoryCutTypeId the categoryCutTypeId to set
     */
    public void setCategoryCutTypeId(String categoryCutTypeId) {
        this.categoryCutTypeId = categoryCutTypeId;
    }

}
