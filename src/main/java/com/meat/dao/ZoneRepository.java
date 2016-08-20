/**
 *
 */
package com.meat.dao;

import com.meat.domain.Zone;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface ZoneRepository extends PagingAndSortingRepository<Zone, Serializable> {

    /**
     * @param zoneCityId
     * @return
     */
    @Query("select z from Zone z where z.zoneCity.id=?1")
    List<Zone> findByZoneCity(String zoneCityId);

    /**
     * @param id
     * @return
     */
    @Query("select distinct z from Zone z join z.zoneCity zc where zc.id=?1 and z.status='ACTIVE'")
    List<Zone> findZoneByZoneCityThymeleaf(String id);

}
