/**
 *
 */
package com.meat.businessdelegate.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneContext implements IBusinessDelegateContext {

    private String all;
    private String zoneOnly;
    private String zoneCityId;

    public String getAll() {
        return all;
    }

    public String getZoneCityId() {
        return zoneCityId;
    }

    public String getZoneOnly() {
        return zoneOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setZoneCityId(final String zoneCityId) {
        this.zoneCityId = zoneCityId;
    }

    public void setZoneOnly(final String zoneOnly) {
        this.zoneOnly = zoneOnly;
    }

}
