/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("categoryAttributesContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryAttributesContext implements IBusinessDelegateContext {

    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
