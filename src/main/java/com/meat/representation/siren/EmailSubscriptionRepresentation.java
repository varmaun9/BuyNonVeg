/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.EmailSubscriptionModel;
import com.meat.util.Representation;

import java.util.Date;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("emailSubscriptionRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "emailSubscription", uri = "/emailSubscriptions/{id}")
@Representation(EmailSubscriptionModel.class)
public class EmailSubscriptionRepresentation extends BaseResource {

    private String id;
    private String userEmail;
    private String subscriptionStatus;
    private Date createdDate;
    private Date modifiedDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setSubscriptionStatus(final String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public void setUserEmail(final String userEmail) {
        this.userEmail = userEmail;
    }

}
