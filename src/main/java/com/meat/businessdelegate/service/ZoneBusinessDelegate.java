/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Zone;
import com.meat.domain.ZoneArea;
import com.meat.domain.ZoneCity;
import com.meat.model.ZoneAreaModel;
import com.meat.model.ZoneModel;
import com.meat.service.ISellerBranchZoneService;
import com.meat.service.IZoneService;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author
 *
 */
@Service
public class ZoneBusinessDelegate implements IBusinessDelegate<ZoneModel, ZoneContext, IKeyBuilder<String>, String> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IZoneService zoneService;
    @Autowired
    private ISellerBranchZoneService sellerBranchZoneService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneModel create(final ZoneModel model) {

        Zone zone = new Zone();
        zone.setId(model.getId());
        zone.setZoneName(model.getZoneName());
        zone.setCreatedDate(new Date());
        zone.setDescription(model.getDescription());
        zone.setStatus(model.getStatus());
        ZoneCity zoneCity = new ZoneCity();
        zoneCity.setId(model.getZoneCityId());
        zone.setZoneCity(zoneCity);
        zone = zoneService.create(zone);

        if (zone.getZoneName() != null) {
            if (zone.getZoneName().equals("Duplicate")) {
                model.setZoneNameStatus(model.getZoneName() + " Already Exists!");
            }
        }
        model.setId(zone.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ZoneContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneModel edit(final IKeyBuilder<String> keyBuilder, final ZoneModel model) {
        Zone zone = zoneService.getZone(keyBuilder.build().toString());
        zone.setId(model.getId());
        if (model.getZoneName() != null) {
            zone.setZoneName(model.getZoneName());
        }
        zone.setDescription(model.getDescription());
        if (model.getStatus() != null) {
            zone.setStatus(model.getStatus());
        }
        Set<ZoneArea> zoneAreas = new HashSet<ZoneArea>();
        if (CollectionUtils.isNotEmpty(model.getZoneAreaModels())) {
            for (ZoneAreaModel zoneAreaModel : model.getZoneAreaModels()) {
                ZoneArea za = new ZoneArea();
                za.setId(zoneAreaModel.getId());
                za.setArea(zoneAreaModel.getArea());
                za.setPincode(zoneAreaModel.getPincode());
                za.setStatus(zoneAreaModel.getStatus());
                za.setZone(zone);
                za.setCreatedDate(new Date());
                zoneAreas.add(za);
            }
            zone = zoneService.addZoneAreas(zone, zoneAreas);
        }

        zone = zoneService.updateZone(zone);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ZoneModel getByKey(final IKeyBuilder<String> keyBuilder, final ZoneContext context) {
        Zone zone = zoneService.getZone(keyBuilder.build().toString());
        ZoneModel zoneModel = conversionService.convert(zone, ZoneModel.class);
        return zoneModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ZoneModel> getCollection(final ZoneContext context) {
        List<Zone> zone = new ArrayList<Zone>();

        if (context.getAll() != null) {
            zone = zoneService.getAll();
        }
        if (context.getZoneOnly() != null) {
            zone = zoneService.getZoneOnly();
        }
        if (context.getZoneCityId() != null) {
            zone = zoneService.getAllZonesByZoneCity(context.getZoneCityId());
        }
        List<ZoneModel> zoneModels = (List<ZoneModel>) conversionService.convert(zone, TypeDescriptor.forObject(zone),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ZoneModel.class)));

        return zoneModels;
    }

}
