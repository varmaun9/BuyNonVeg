/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UserSearchModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userSearchRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "userSearch", uri = "/userSearch/{id}")
@Representation(UserSearchModel.class)
public class UserSearchRepresentation extends BaseResource {
    private String id;
    private String userId;
    private String itemId;
    private String userSearchItemStatus;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserSearchItemStatus() {
        return userSearchItemStatus;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public void setUserSearchItemStatus(final String userSearchItemStatus) {
        this.userSearchItemStatus = userSearchItemStatus;
    }

}
