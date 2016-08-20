/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ZoneModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author
 *
 */
@Component("zoneRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "zone", uri = "/zones/{id}")
@Representation(ZoneModel.class)
public class ZoneRepresentation extends BaseResource {

    private String id;
    private String zoneName;
    private String zoneNameStatus;
    private String description;
    private String status;
    private String createdDate;
    private String zoneCityId;
    private String cityName;
    @Siren4JSubEntity
    private List<SellerBranchZoneRepresentation> sellerBranchZoneRep = new ArrayList<SellerBranchZoneRepresentation>(0);
    @Siren4JSubEntity
    private List<ZoneAreaRepresentation> zoneAreaRep = new ArrayList<ZoneAreaRepresentation>(0);

    public String getCityName() {
        return cityName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public List<SellerBranchZoneRepresentation> getSellerBranchZoneRep() {
        return sellerBranchZoneRep;
    }

    public String getStatus() {
        return status;
    }

    public List<ZoneAreaRepresentation> getZoneAreaRep() {
        return zoneAreaRep;
    }

    public String getZoneCityId() {
        return zoneCityId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public String getZoneNameStatus() {
        return zoneNameStatus;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    /**
     * @param createdDate
     *            the createdDate to set
     */

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setSellerBranchZoneRep(final List<SellerBranchZoneRepresentation> sellerBranchZoneRep) {
        this.sellerBranchZoneRep = sellerBranchZoneRep;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZoneAreaRep(final List<ZoneAreaRepresentation> zoneAreaRep) {
        this.zoneAreaRep = zoneAreaRep;
    }

    public void setZoneCityId(final String zoneCityId) {
        this.zoneCityId = zoneCityId;
    }

    public void setZoneName(final String zoneName) {
        this.zoneName = zoneName;
    }

    public void setZoneNameStatus(final String zoneNameStatus) {
        this.zoneNameStatus = zoneNameStatus;
    }

}
