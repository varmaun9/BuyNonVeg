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
 * @author arthvedi5
 *
 */
@Component("zoneCityModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneCityModel extends AbstractModel {
    private String cityName;
    private String status;
    private List<ZoneModel> zoneModels = new ArrayList<ZoneModel>(0);

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the zoneModels
     */
    public List<ZoneModel> getZoneModels() {
        return zoneModels;
    }

    /**
     * @param cityName
     *            the cityName to set
     */
    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @param zoneModels
     *            the zoneModels to set
     */
    public void setZoneModels(final List<ZoneModel> zoneModels) {
        this.zoneModels = zoneModels;
    }

}
