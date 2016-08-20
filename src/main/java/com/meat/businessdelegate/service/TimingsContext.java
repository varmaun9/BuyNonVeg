/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("timingsContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TimingsContext implements IBusinessDelegateContext {

    private String all;
    private String timingsOnly;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    public String getTimingsOnly() {
        return timingsOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setTimingsOnly(final String timingsOnly) {
        this.timingsOnly = timingsOnly;
    }

}
