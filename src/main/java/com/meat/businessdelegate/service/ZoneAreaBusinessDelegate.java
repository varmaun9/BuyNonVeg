/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Zone;
import com.meat.domain.ZoneArea;
import com.meat.model.ZoneAreaModel;
import com.meat.service.IZoneAreaService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class ZoneAreaBusinessDelegate implements IBusinessDelegate<ZoneAreaModel, ZoneAreaContext, IKeyBuilder<String>, String> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IZoneAreaService zoneAreaService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneAreaModel create(final ZoneAreaModel model) {
        ZoneArea za = new ZoneArea();
        za.setId(model.getId());
        za.setArea(model.getArea());
        za.setPincode(model.getPincode());
        za.setStatus(model.getStatus());
        Zone zone = new Zone();
        zone.setId(model.getZoneId());
        za.setZone(zone);
        za.setCreatedDate(new Date());
        za = zoneAreaService.create(za);

        model.setId(za.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ZoneAreaContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneAreaModel edit(final IKeyBuilder<String> keyBuilder, final ZoneAreaModel model) {
        ZoneArea zoneArea = zoneAreaService.getZoneArea(keyBuilder.build().toString());
        zoneArea.setId(model.getId());
        zoneArea.setArea(model.getArea());
        zoneArea.setPincode(model.getPincode());
        zoneArea.setStatus(model.getStatus());
        Zone z = new Zone();
        z.setId(model.getZoneId());
        zoneArea.setZone(z);
        zoneArea = zoneAreaService.updateZoneArea(zoneArea);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ZoneAreaModel getByKey(final IKeyBuilder<String> keyBuilder, final ZoneAreaContext context) {
        ZoneArea zoneArea = zoneAreaService.getZoneArea(keyBuilder.build().toString());
        ZoneAreaModel zoneAreaModel = conversionService.convert(zoneArea, ZoneAreaModel.class);
        return zoneAreaModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ZoneAreaModel> getCollection(final ZoneAreaContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
