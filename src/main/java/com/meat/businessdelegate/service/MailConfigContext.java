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

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("mailConfigContext")
public class MailConfigContext implements IBusinessDelegateContext {

    private String all;

    public String getAll() {
        return all;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
