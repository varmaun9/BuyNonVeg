/**
 *
 */
package com.meat.service;

import com.meat.dao.ZoneAreaRepository;
import com.meat.domain.ZoneArea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author varma
 *
 */
@Component
public class ZoneAreaService implements IZoneAreaService {

    @Autowired
    private ZoneAreaRepository zoneAreaRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneAreaService#create(com.meat.domain.ZoneArea)
     */
    @Override
    @Transactional
    public ZoneArea create(final ZoneArea zoneArea) {
        // TODO Auto-generated method stub
        return zoneAreaRepository.save(zoneArea);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneAreaService#deleteZoneArea(java.lang.String)
     */
    @Override
    public void deleteZoneArea(final String zoneAreaId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneAreaService#getAll()
     */
    @Override
    public List<ZoneArea> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneAreaService#getZoneArea(java.lang.String)
     */
    @Override
    public ZoneArea getZoneArea(final String zoneAreaId) {
        // TODO Auto-generated method stub
        return zoneAreaRepository.findOne(zoneAreaId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IZoneAreaService#updateZoneArea(com.meat.domain.ZoneArea)
     */
    @Override
    public ZoneArea updateZoneArea(final ZoneArea zoneArea) {
        // TODO Auto-generated method stub
        return zoneAreaRepository.save(zoneArea);
    }

}
