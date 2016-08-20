/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("usersOfferModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UsersOfferModel extends AbstractModel {

    private String usersId;
    private String offerId;
    private String offerConfigId;
    private String status;

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
