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
@Component("userImagesContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserImagesContext implements IBusinessDelegateContext {

    private String all;

    public void setAll(final String all) {
        this.all = all;
    }

}
