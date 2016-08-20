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
@Component("sellerTimingsConfigModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerTimingsConfigModel extends AbstractModel {
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
