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
@Component("zoneCityContext")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ZoneCityContext implements IBusinessDelegateContext {
    private String all;
    private String zoneCityOnly;
    private String zoneCityId;
    private String zoneCityZoneOnly;

    public String getAll() {
        return all;
    }

    public String getZoneCityId() {
        return zoneCityId;
    }

    public String getZoneCityOnly() {
        return zoneCityOnly;
    }

    public void setAll(final String all) {
        this.all = all;
    }

    public void setZoneCityId(final String zoneCityId) {
        this.zoneCityId = zoneCityId;
    }

    public void setZoneCityOnly(final String zoneCityOnly) {
        this.zoneCityOnly = zoneCityOnly;
    }

    /**
     * @return the zoneCityZoneOnly
     */
    public String getZoneCityZoneOnly() {
        return zoneCityZoneOnly;
    }

    /**
     * @param zoneCityZoneOnly the zoneCityZoneOnly to set
     */
    public void setZoneCityZoneOnly(String zoneCityZoneOnly) {
        this.zoneCityZoneOnly = zoneCityZoneOnly;
    }
}
