package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userWishListModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserWishListModel extends AbstractModel {
    private String itemId;
    private String userId;
    private String createdDate;
    private String description;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getItemId() {
        return itemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}
