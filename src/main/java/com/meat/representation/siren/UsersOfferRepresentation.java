/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.UsersOfferModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("usersOfferRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "usersOffer", uri = "/usersOffers/{id}")
@Representation(UsersOfferModel.class)
public class UsersOfferRepresentation extends BaseResource {

    private String Id;
    private String usersId;
    private String offerId;
    private String offerConfigId;
    private String status;

    /**
     * @return the id
     */
    public String getId() {
        return Id;
    }

    /**
     * @return the offerConfigId
     */
    public String getOfferConfigId() {
        return offerConfigId;
    }

    /**
     * @return the offerId
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the usersId
     */
    public String getUsersId() {
        return usersId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        Id = id;
    }

    /**
     * @param offerConfigId
     *            the offerConfigId to set
     */
    public void setOfferConfigId(final String offerConfigId) {
        this.offerConfigId = offerConfigId;
    }

    /**
     * @param offerId
     *            the offerId to set
     */
    public void setOfferId(final String offerId) {
        this.offerId = offerId;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param usersId
     *            the usersId to set
     */
    public void setUsersId(final String usersId) {
        this.usersId = usersId;
    }

}
