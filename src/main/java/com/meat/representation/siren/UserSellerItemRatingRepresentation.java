/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UserSellerItemRatingModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("userSellerItemRatingRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "userSellerItemRating", uri = "/userSellerItemRatings/{id}")
@Representation(UserSellerItemRatingModel.class)
public class UserSellerItemRatingRepresentation extends BaseResource {
    private String id;
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

    public String getId() {
        return id;
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

    public void setId(final String id) {
        this.id = id;
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
