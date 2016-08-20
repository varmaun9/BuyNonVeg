package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userAddressModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserAddressModel extends AbstractModel {

    private String addressId;
    private String userId;
    private String status;

    public String getAddressId() {
        return addressId;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}
