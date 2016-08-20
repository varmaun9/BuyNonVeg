/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.AccountModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("accountRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "account", uri = "/accounts/{id}")
@Representation(AccountModel.class)
public class AccountRepresentation extends BaseResource {
    private String Id;
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
     * @return the id
     */
    public String getId() {
        return Id;
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
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        Id = id;
    }

    /**
     * @param sellerBranchId
     *            the sellerBranchId to set
     */
    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

}
