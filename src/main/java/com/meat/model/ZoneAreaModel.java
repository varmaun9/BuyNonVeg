/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneAreaModel extends AbstractModel {

    private String area;
    private String status;
    private String createdDate;
    private String zoneId;
    private String zoneName;
    private String pincode;

    public String getArea() {
        return area;
    }

    public String getPincode() {
        return pincode;
    }

    public String getStatus() {
        return status;
    }

    public String getZoneId() {
        return zoneId;
    }

    /**
     * @return the zoneName
     */
    public String getZoneName() {
        return zoneName;
    }

    public void setArea(final String area) {
        this.area = area;
    }

    public void setPincode(final String pincode) {
        this.pincode = pincode;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setZoneId(final String zoneId) {
        this.zoneId = zoneId;
    }

    /**
     * @param zoneName
     *            the zoneName to set
     */
    public void setZoneName(final String zoneName) {
        this.zoneName = zoneName;
    }

    /**
     * @return the createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}
