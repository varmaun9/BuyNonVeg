/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemCriteriaModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerItemCriteriaModel extends AbstractModel {
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
