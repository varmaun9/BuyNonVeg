package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userSellerItemRatingModelModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserSellerItemRatingModel extends AbstractModel {
    private String sellerItemId;
    private String userId;
    private String description;
    private String createdDate;
    private String rating;
    private String title;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return rating;
    }

    public String getSellerItemId() {
        return sellerItemId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
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

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}
