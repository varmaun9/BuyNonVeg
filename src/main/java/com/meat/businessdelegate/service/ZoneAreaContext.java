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
@Component("zoneAreaContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneAreaContext implements IBusinessDelegateContext {

    private String all;
    private String zoneId;
    private String zoneAreaId;

    public String getAll() {
        return all;
    }

    public String getZoneAreaId() {
        return zoneAreaId;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setZoneAreaId(final String zoneAreaId) {
        this.zoneAreaId = zoneAreaId;
    }

    public void setZoneId(final String zoneId) {
        this.zoneId = zoneId;
    }

}
