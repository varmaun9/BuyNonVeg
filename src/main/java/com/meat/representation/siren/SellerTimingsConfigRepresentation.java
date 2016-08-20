/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerTimingsConfigModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerTimingsConfigRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerTimingsConfig", uri = "/sellerTimingsConfigs/{id}")
@Representation(SellerTimingsConfigModel.class)
public class SellerTimingsConfigRepresentation extends BaseResource {
    private String id;
    private String sellerBranchTimingsId;
    private String status;
    private String createdDate;
    private String serviceOffDate;

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the sellerBranchTimingsId
     */
    public String getSellerBranchTimingsId() {
        return sellerBranchTimingsId;
    }

    /**
     * @return the serviceOffDate
     */
    public String getServiceOffDate() {
        return serviceOffDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */
    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param sellerBranchTimingsId
     *            the sellerBranchTimingsId to set
     */
    public void setSellerBranchTimingsId(final String sellerBranchTimingsId) {
        this.sellerBranchTimingsId = sellerBranchTimingsId;
    }

    /**
     * @param serviceOffDate
     *            the serviceOffDate to set
     */
    public void setServiceOffDate(final String serviceOffDate) {
        this.serviceOffDate = serviceOffDate;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

}
