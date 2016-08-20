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
@Component("ordersContext")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrdersContext implements IBusinessDelegateContext {

    private String all;

    /**
     * @return
     */
    public String getAll() {
        // TODO Auto-generated method stub
        return all;
    }

    public void setAll(final String all) {
        this.all = all;
    }

}
