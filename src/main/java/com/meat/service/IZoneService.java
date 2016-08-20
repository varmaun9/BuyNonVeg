/**
 *
 */
package com.meat.service;

import com.meat.domain.Zone;
import com.meat.domain.ZoneArea;

import java.util.List;
import java.util.Set;

/**
 * @author Dilli
 *
 */
public interface IZoneService {

    /**
     * @param zone
     * @param zoneAreas
     * @return
     */
    Zone addZoneAreas(Zone zone, Set<ZoneArea> zoneAreas);

    /**
     * @param zone
     * @param sllrBranchZone
     * @return
     */
    //Zone addSellerBranchZone(Zone zone, List<SellerBranchZone> sllrBranchZone);

    Zone create(Zone zone);

    void deleteZone(String zoneId);

    List<Zone> getAll();

    /**
     * @param zoneCityId
     * @return
     */
    List<Zone> getAllZonesByZoneCity(String zoneCityId);

    Zone getZone(String zoneId);

    /**
     * @return
     */
    List<Zone> getZoneOnly();

    Zone updateZone(Zone zone);

}
