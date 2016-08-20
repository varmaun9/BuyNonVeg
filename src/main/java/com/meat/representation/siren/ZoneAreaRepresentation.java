/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ZoneAreaModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "zoneArea", uri = "/zoneAreas/{id}")
@Representation(ZoneAreaModel.class)
public class ZoneAreaRepresentation extends BaseResource {

    private String id;
    private String area;
    private String status;
    private String createdDate;
    private String zoneId;
    private String zoneName;
    private String pincode;

    public String getArea() {
        return area;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getId() {
        return id;
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

    public void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    public void setId(final String id) {
        this.id = id;
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

}
