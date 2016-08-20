package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component("tagsContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TagsContext implements IBusinessDelegateContext {

    private String all;
    private String tagOnly;

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
    public String getTagsOnly() {
        // TODO Auto-generated method stub
        return tagOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @param string
     */
    public void setTagsOnly(final String tagOnly) {
        this.tagOnly = tagOnly;

    }
}
