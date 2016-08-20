/**
 *
 */
package com.meat.service;

import com.meat.domain.ZoneArea;

import java.util.List;

/**
 * @author varma
 *
 */
public interface IZoneAreaService {

    ZoneArea create(ZoneArea zoneArea);

    void deleteZoneArea(String zoneAreaId);

    List<ZoneArea> getAll();

    ZoneArea getZoneArea(String zoneAreaId);

    ZoneArea updateZoneArea(ZoneArea zoneArea);

}
