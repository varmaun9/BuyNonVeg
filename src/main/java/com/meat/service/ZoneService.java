/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchZoneRepository;
import com.meat.dao.ZoneRepository;
import com.meat.domain.Zone;
import com.meat.domain.ZoneArea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author varma
 *
 */
@Component
public class ZoneService implements IZoneService {
    @Autowired
    private SellerBranchZoneRepository sellerBranchZoneRepository;

    @Autowired
    private ZoneRepository zoneRepository;
    @Autowired
    private IZoneAreaService zoneAreaService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#addSellerBranchZone(com.meat.domain.Zone, java.util.List)
     */
    /* @Override
     public Zone addSellerBranchZone(final Zone zone, final List<SellerBranchZone> sllrBranchZone) {
         Validate.notNull(zone, "zone must not be null");
         Set<SellerBranchZone> slrBranchZone = new HashSet<SellerBranchZone>(sllrBranchZone);
         for (SellerBranchZone sBZone : sllrBranchZone) {
             SellerBranchZone sellerBranchZone = new SellerBranchZone();
             sellerBranchZone.setStatus(sBZone.getStatus());
             sellerBranchZone.setCreatedDate(new Date());
             sellerBranchZone.setZone(zone);
             sellerBranchZone.setSellerBranch(sellerBranchZone.getSellerBranch());
             slrBranchZone.add(sellerBranchZone);
             sellerBranchZone = sellerBranchZoneRepository.save(sellerBranchZone);

         }

         return zone;
     }*/

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#addZoneAreas(com.meat.domain.Zone, java.util.Set)
     */
    @Override
    @Transactional
    public Zone addZoneAreas(final Zone zone, final Set<ZoneArea> zoneAreas) {
        Validate.notNull(zone, "zone must not be null");
        Set<ZoneArea> zoneArs = new HashSet<ZoneArea>(zoneAreas);
        for (ZoneArea zoneArea : zoneAreas) {
            ZoneArea zoneA = zoneArea;
            zoneA.setZone(zone);

            zoneA = zoneAreaService.create(zoneA);
            zoneArs.add(zoneA);
        }

        return zone;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#create(com.meat.domain.Zone)
     */

    @Override
    @Transactional
    public Zone create(Zone zone) {
        Validate.notNull(zone, "zone must not be null" + zone.getZoneName());

        List<Zone> zones = new ArrayList<Zone>();
        zones = (List<Zone>) zoneRepository.findAll();
        if (zones != null) {
            for (Zone z : zones) {
                String m = z.getZoneName();
                String mc = m.replaceAll("\\s", "");
                String mc1 = mc.toLowerCase();
                if (zone.getZoneName() != null) {
                    String mc2 = zone.getZoneName().replaceAll("\\s", "").toLowerCase();
                    if (mc1.equals(mc2)) {
                        zone.setZoneName("Duplicate");
                    }
                }
            }
        }
        if (zone.getZoneName() != null) {

            if (zone.getZoneName().equals("Duplicate")) {
                zone.getZoneName().equals("Duplicate");
                return zone;
            }
            else {
                zone = zoneRepository.save(zone);
            }
        }
        return zone;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#deleteZone(java.lang.String)
     */
    @Override
    public void deleteZone(final String zoneId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#getAll()
     */
    @Override
    public List<Zone> getAll() {
        List<Zone> zones = new ArrayList<Zone>();
        zones = (List<Zone>) zoneRepository.findAll();
        return zones;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#getAllZonesByZoneCity(java.lang.String)
     */
    @Override
    public List<Zone> getAllZonesByZoneCity(final String zoneCityId) {
        List<Zone> zones = new ArrayList<Zone>();
        zones = zoneRepository.findByZoneCity(zoneCityId);
        return zones;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#getZone(java.lang.String)
     */
    @Override
    public Zone getZone(final String zoneId) {
        // TODO Auto-generated method stub
        return zoneRepository.findOne(zoneId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#getZoneOnly()
     */
    @Override
    public List<Zone> getZoneOnly() {
        List<Zone> zones = new ArrayList<Zone>();
        zones = (List<Zone>) zoneRepository.findAll();
        List<Zone> zone = new ArrayList<Zone>();
        for (Zone z : zones) {
            Zone zon = new Zone();
            zon.setId(z.getId());
            zon.setZoneName(z.getZoneName());
            zon.setDescription(z.getDescription());
            zon.setStatus(z.getStatus());
            zone.add(zon);
        }
        return zone;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneService#updateZone(com.meat.domain.Zone)
     */
    @Override
    public Zone updateZone(final Zone zone) {
        // TODO Auto-generated method stub
        return zoneRepository.save(zone);
    }

}
