/**
 *
 */
package com.meat.dao;

import com.meat.domain.ZoneArea;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface ZoneAreaRepository extends PagingAndSortingRepository<ZoneArea, Serializable> {

    /**
     * @param zoneId
     * @return
     */
    @Query("select distinct za from ZoneArea za where za.zone.id=?1")
    List<ZoneArea> findZoneAreasByZoneId(String zoneId);

}
