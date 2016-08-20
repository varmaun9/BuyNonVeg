/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.BankOfferModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */

@Component("bankOfferRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "bankOffer", uri = "/bankOffers/{id}")
@Representation(BankOfferModel.class)
public class BankOfferRepresentation extends BaseResource {
    private String id;
    private String offerId;
    private String bankName;
    private String status;
    @Siren4JSubEntity
    private List<OfferConfigRepresentation> offerConfigsRep = new ArrayList<OfferConfigRepresentation>(0);

    /**
     * @return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the offerConfigsRep
     */
    public List<OfferConfigRepresentation> getOfferConfigsRep() {
        return offerConfigsRep;
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
     * @param bankName
     *            the bankName to set
     */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param offerConfigsRep
     *            the offerConfigsRep to set
     */
    public void setOfferConfigsRep(final List<OfferConfigRepresentation> offerConfigsRep) {
        this.offerConfigsRep = offerConfigsRep;
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

}
