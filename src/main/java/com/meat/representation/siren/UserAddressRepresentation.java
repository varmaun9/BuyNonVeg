/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UserAddressModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("userAddressRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "userAddress", uri = "/userAddresses/{id}")
@Representation(UserAddressModel.class)
public class UserAddressRepresentation extends BaseResource {

    private String id;
    private String addressId;
    private String userId;
    private String status;

    public String getAddressId() {
        return addressId;
    }

    public String getId() {
        return id;
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

    public void setId(final String id) {
        this.id = id;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}