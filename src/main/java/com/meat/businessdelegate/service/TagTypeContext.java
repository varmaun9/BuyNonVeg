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
@Component("tagTypeContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TagTypeContext implements IBusinessDelegateContext {

    private String all;
    private String tagTypeOnly;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    /**
     * @return
     */
    public String getTagTypeOnly() {
        // TODO Auto-generated method stub
        return tagTypeOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param string
     */
    public void setTagTypeOnly(final String tagTypeOnly) {
        this.tagTypeOnly = tagTypeOnly;

    }
}
