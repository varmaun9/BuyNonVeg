/**
 *
 */
package com.meat.service;

import com.meat.dao.ZoneCityRepository;
import com.meat.dao.ZoneRepository;
import com.meat.domain.Zone;
import com.meat.domain.ZoneCity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class ZoneCityService implements IZoneCityService {

    @Autowired
    private ZoneCityRepository zoneCityRepository;
    @Autowired
    private ZoneRepository zoneRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#create(com.meat.service.ZoneCity)
     */
    @Override
    public ZoneCity create(final ZoneCity zoneCity) {
        // TODO Auto-generated method stub
        return zoneCityRepository.save(zoneCity);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#deleteZoneCity(java.lang.String)
     */
    @Override
    public void deleteZoneCity(final String zoneCityId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#getAll()
     */
    @Override
    public List<ZoneCity> getAll() {
        // TODO Auto-generated method stub
        return (List<ZoneCity>) zoneCityRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#getZoneCity(java.lang.String)
     */
    @Override
    public ZoneCity getZoneCity(final String zoneCityId) {
        // TODO Auto-generated method stub
        return zoneCityRepository.findOne(zoneCityId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#getZoneCityOnly()
     */
    @Override
    public List<ZoneCity> getZoneCityOnly() {
        // TODO Auto-generated method stub
        List<ZoneCity> zoneCities = new ArrayList<ZoneCity>();
        zoneCities = (List<ZoneCity>) zoneCityRepository.findAll();
        List<ZoneCity> zoneCity = new ArrayList<ZoneCity>();
        for (ZoneCity z : zoneCities) {

            ZoneCity zonCity = new ZoneCity();
            zonCity.setId(z.getId());
            zonCity.setCityName(z.getCityName());
            zonCity.setStatus(z.getStatus());
            zoneCity.add(zonCity);
        }
        return zoneCity;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#getZoneCityWithZoneByThymeleaf()
     */
    @Override
    public List<ZoneCity> getZoneCityWithZoneByThymeleaf() {
        List<ZoneCity> zoneCities = new ArrayList<ZoneCity>();
        zoneCities = (List<ZoneCity>) zoneCityRepository.findAll();
        List<ZoneCity> zoneCity = new ArrayList<ZoneCity>();
        for (ZoneCity z : zoneCities) {
            ZoneCity zonCity = new ZoneCity();
            zonCity.setId(z.getId());
            zonCity.setCityName(z.getCityName());
            zonCity.setStatus(z.getStatus());
            List<Zone> zones = zoneRepository.findZoneByZoneCityThymeleaf(z.getId());
            List<Zone> zns = new ArrayList<Zone>();
            for (Zone zn : zones) {
                Zone zne = new Zone();
                zne.setId(zn.getId());
                zne.setZoneName(zn.getZoneName());
                zne.setZoneCity(zn.getZoneCity());
                zne.setStatus(zn.getStatus());
                zne.setDescription(zn.getDescription());
                zns.add(zne);
            }
            Set<Zone> zon = new HashSet<Zone>(zns);
            zonCity.setZones(zon);
            zoneCity.add(zonCity);
        }
        return zoneCity;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#getZoneCityZoneOnly()
     */
    @Override
    public List<ZoneCity> getZoneCityZoneOnly() {
        List<ZoneCity> zoneCities = new ArrayList<ZoneCity>();
        zoneCities = (List<ZoneCity>) zoneCityRepository.findAll();
        List<ZoneCity> zoneCity = new ArrayList<ZoneCity>();
        for (ZoneCity zc : zoneCities) {
            ZoneCity zonCity = new ZoneCity();
            zonCity.setId(zc.getId());
            zonCity.setCityName(zc.getCityName());
            zonCity.setStatus(zc.getStatus());
            List<Zone> zones = zoneRepository.findZoneByZoneCityThymeleaf(zc.getId());
            List<Zone> zns = new ArrayList<Zone>();
            for (Zone zn : zones) {
                Zone zne = new Zone();
                zne.setId(zn.getId());
                zne.setZoneName(zn.getZoneName());
                zne.setZoneCity(zn.getZoneCity());
                zne.setStatus(zn.getStatus());
                zne.setDescription(zn.getDescription());
                zns.add(zne);
            }
            Set<Zone> zon = new HashSet<Zone>(zns);
            zonCity.setZones(zon);
            zoneCity.add(zonCity);
        }
        return zoneCity;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneCityService#updateZoneCity(com.meat.service.ZoneCity)
     */
    @Override
    public ZoneCity updateZoneCity(final ZoneCity zoneCity) {
        // TODO Auto-generated method stub
        return zoneCityRepository.save(zoneCity);
    }

}
