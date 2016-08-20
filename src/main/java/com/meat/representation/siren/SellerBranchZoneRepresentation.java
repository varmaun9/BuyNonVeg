/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerBranchZoneModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerBranchZoneRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranchZone", uri = "/sellerBranchZones/{id}")
@Representation(SellerBranchZoneModel.class)
public class SellerBranchZoneRepresentation extends BaseResource {
    private String id;
    private String zoneId;
    private String sellerBranchId;
    private String status;
    private String createdDate;

    public String getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
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

    public void setId(final String id) {
        this.id = id;
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
