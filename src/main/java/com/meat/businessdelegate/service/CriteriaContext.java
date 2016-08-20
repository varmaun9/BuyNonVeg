package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("criteriaContext")
public class CriteriaContext implements IBusinessDelegateContext {

    private String all;
    private String criteriaOnly;

    public String getAll() {
        return all;
    }

    public String getCriteriaOnly() {
        return criteriaOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setCriteriaOnly(final String criteriaOnly) {
        this.criteriaOnly = criteriaOnly;
    }

}
