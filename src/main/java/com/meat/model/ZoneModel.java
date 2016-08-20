/**
 *
 */
package com.meat.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("zoneModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneModel extends AbstractModel {

    private String zoneName;
    private String zoneNameStatus;
    private String description;
    private String status;
    private String createdDate;
    private String zoneCityId;
    private String cityName;
    List<SellerBranchZoneModel> sellerBranchZoneModels = new ArrayList<SellerBranchZoneModel>(0);
    List<ZoneAreaModel> zoneAreaModels = new ArrayList<ZoneAreaModel>(0);

    public String getCityName() {
        return cityName;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the sellerBranchZoneModels
     */
    public List<SellerBranchZoneModel> getSellerBranchZoneModels() {
        return sellerBranchZoneModels;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    public List<ZoneAreaModel> getZoneAreaModels() {
        return zoneAreaModels;
    }

    public String getZoneCityId() {
        return zoneCityId;
    }

    /**
     * @return the zoneName
     */
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

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param sellerBranchZoneModels
     *            the sellerBranchZoneModels to set
     */
    public void setSellerBranchZoneModels(final List<SellerBranchZoneModel> sellerBranchZoneModels) {
        this.sellerBranchZoneModels = sellerBranchZoneModels;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZoneAreaModels(final List<ZoneAreaModel> zoneAreaModels) {
        this.zoneAreaModels = zoneAreaModels;
    }

    public void setZoneCityId(final String zoneCityId) {
        this.zoneCityId = zoneCityId;
    }

    /**
     * @param zoneName
     *            the zoneName to set
     */
    public void setZoneName(final String zoneName) {
        this.zoneName = zoneName;
    }

    public void setZoneNameStatus(final String zoneNameStatus) {
        this.zoneNameStatus = zoneNameStatus;
    }

}
