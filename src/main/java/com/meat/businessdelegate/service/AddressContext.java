/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component("addressContext")
public class AddressContext implements IBusinessDelegateContext {

    private String all;
    private String addressId;

    /**
     * @return the all
     */
    public String getAll() {
        return all;
    }

    /**
     * @param all
     *            the all to set
     */
    public void setAll(final String all) {
        this.all = all;
    }

    /**
     * @return the addressId
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * @param addressId the addressId to set
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

}
