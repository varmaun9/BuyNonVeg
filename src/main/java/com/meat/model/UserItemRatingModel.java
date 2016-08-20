package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userItemRatingModelModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserItemRatingModel extends AbstractModel {
    private String userId;
    private String itemId;
    private String rating;
    private String itemRatingStatus;
    private String comments;
    private String createdDate;

    public String getComments() {
        return comments;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemRatingStatus() {
        return itemRatingStatus;
    }

    public String getRating() {
        return rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setComments(final String comments) {
        this.comments = comments;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

    public void setItemRatingStatus(final String itemRatingStatus) {
        this.itemRatingStatus = itemRatingStatus;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
