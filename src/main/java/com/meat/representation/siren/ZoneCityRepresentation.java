/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.annotations.Siren4JSubEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.ZoneCityModel;
import com.meat.util.Representation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi5
 *
 */
@Component("zoneCityRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "zoneCity", uri = "/zoneCities/{id}")
@Representation(ZoneCityModel.class)
public class ZoneCityRepresentation extends BaseResource {
    private String id;
    private String cityName;
    private String status;
    @Siren4JSubEntity
    private List<ZoneRepresentation> zoneRep = new ArrayList<ZoneRepresentation>(0);

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    public String getId() {
        return id;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the zoneRep
     */
    public List<ZoneRepresentation> getZoneRep() {
        return zoneRep;
    }

    /**
     * @param cityName
     *            the cityName to set
     */
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param zoneRep
     *            the zoneRep to set
     */
    public void setZoneRep(final List<ZoneRepresentation> zoneRep) {
        this.zoneRep = zoneRep;
    }

}
