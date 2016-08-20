package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userSearchModelModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserSearchModel extends AbstractModel {
    private String userId;
    private String itemId;
    private String userSearchItemStatus;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
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
