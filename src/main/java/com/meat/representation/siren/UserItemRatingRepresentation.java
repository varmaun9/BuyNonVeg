/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UserItemRatingModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userItemRatingRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "userItemRating", uri = "/userItemRatings/{id}")
@Representation(UserItemRatingModel.class)
public class UserItemRatingRepresentation extends BaseResource {
    private String id;
    private String userId;
    private String sellerItemId;
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

    public String getId() {
        return id;
    }

    public String getItemRatingStatus() {
        return itemRatingStatus;
    }

    public String getRating() {
        return rating;
    }

    public String getSellerItemId() {
        return sellerItemId;
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

    public void setId(final String id) {
        this.id = id;
    }

    public void setItemRatingStatus(final String itemRatingStatus) {
        this.itemRatingStatus = itemRatingStatus;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}
