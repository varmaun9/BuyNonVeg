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
@Component("sellerBranchZoneModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerBranchZoneModel extends AbstractModel {
    private String zoneId;
    private String sellerBranchId;
    private String status;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getSellerBranchId() {
        return sellerBranchId;
    }

    public String getStatus() {
        return status;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setSellerBranchId(final String sellerBranchId) {
        this.sellerBranchId = sellerBranchId;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZoneId(final String zoneId) {
        this.zoneId = zoneId;
    }

}
