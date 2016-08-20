/**
 *
 */
package com.meat.service;

import com.meat.domain.ZoneCity;

import java.util.List;

/**
 * @author Dilli
 *
 */
public interface IZoneCityService {

    ZoneCity create(ZoneCity zoneCity);

    void deleteZoneCity(String zoneCityId);

    List<ZoneCity> getAll();

    ZoneCity getZoneCity(String zoneCityId);

    List<ZoneCity> getZoneCityOnly();

    /**
     * @return
     */
    List<ZoneCity> getZoneCityWithZoneByThymeleaf();

    /**
     * @return
     */
    List<ZoneCity> getZoneCityZoneOnly();

    ZoneCity updateZoneCity(ZoneCity zoneCity);

}
