/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("accountModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AccountModel extends AbstractModel {
    private String sellerBranchId;
    private String entityName;
    private String entityType;
    private String amount;

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @return the entityName
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * @return the entityType
     */
    public String getEntityType() {
        return entityType;
    }

    /**
     * @return the sellerBranchId
     */
    public String getSellerBranchId() {
        return sellerBranchId;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public void setAmount(final String amount) {
        this.amount = amount;
    }

    /**
     * @param entityName
     *            the entityName to set
     */
    public void setEntityName(final String entityName) {
        this.entityName = entityName;
    }

    /**
     * @param entityType
     *            the entityType to set
     */
    public void setEntityType(final String entityType) {
        this.entityType = entityType;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

}
