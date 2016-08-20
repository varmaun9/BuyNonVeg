/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerItemCriteriaModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemCriteriaRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerItemCriteria", uri = "/sellerItemCriteria/{id}")
@Representation(SellerItemCriteriaModel.class)
public class SellerItemCriteriaRepresentation extends BaseResource {
    private String id;
    private String sellerItemId;
    private String criteriaId;
    private String sellerItemCriteriaStatus;

    /**
     * @return the criteriaId
     */
    public String getCriteriaId() {
        return criteriaId;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the sellerItemCriteriaStatus
     */
    public String getSellerItemCriteriaStatus() {
        return sellerItemCriteriaStatus;
    }

    /**
     * @return the sellerItemId
     */
    public String getSellerItemId() {
        return sellerItemId;
    }

    /**
     * @param criteriaId
     *            the criteriaId to set
     */
    public void setCriteriaId(final String criteriaId) {
        this.criteriaId = criteriaId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param sellerItemCriteriaStatus
     *            the sellerItemCriteriaStatus to set
     */
    public void setSellerItemCriteriaStatus(final String sellerItemCriteriaStatus) {
        this.sellerItemCriteriaStatus = sellerItemCriteriaStatus;
    }

    /**
     * @param sellerItemId
     *            the sellerItemId to set
     */
    public void setSellerItemId(final String sellerItemId) {
        this.sellerItemId = sellerItemId;
    }

}
