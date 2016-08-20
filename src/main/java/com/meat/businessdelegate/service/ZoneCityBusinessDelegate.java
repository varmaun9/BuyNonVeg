/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.ZoneCity;
import com.meat.model.ZoneCityModel;
import com.meat.service.IZoneCityService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ZoneCityBusinessDelegate implements IBusinessDelegate<ZoneCityModel, ZoneCityContext, IKeyBuilder<String>, String> {

    @Autowired
    private IZoneCityService zoneCityService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneCityModel create(final ZoneCityModel model) {

        ZoneCity zoneCity = new ZoneCity();
        zoneCity.setId(model.getId());
        zoneCity.setCityName(model.getCityName());
        zoneCity.setStatus(model.getStatus());

        zoneCity = zoneCityService.create(zoneCity);

        model.setId(zoneCity.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ZoneCityContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ZoneCityModel edit(final IKeyBuilder<String> keyBuilder, final ZoneCityModel model) {
        ZoneCity zoneCity = zoneCityService.getZoneCity(keyBuilder.build().toString());
        zoneCity.setId(model.getId());
        zoneCity.setCityName(model.getCityName());
        zoneCity.setStatus(model.getStatus());
        zoneCity = zoneCityService.updateZoneCity(zoneCity);
        model.setId(zoneCity.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ZoneCityModel getByKey(final IKeyBuilder<String> keyBuilder, final ZoneCityContext context) {
        ZoneCity zoneCity = zoneCityService.getZoneCity(keyBuilder.build().toString());
        ZoneCityModel zoneCityModel = conversionService.convert(zoneCity, ZoneCityModel.class);
        return zoneCityModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ZoneCityModel> getCollection(final ZoneCityContext context) {
        List<ZoneCity> zoneCity = new ArrayList<ZoneCity>();

        if (context.getAll() != null) {
            zoneCity = zoneCityService.getAll();
        }
        if (context.getZoneCityOnly() != null) {
            zoneCity = zoneCityService.getZoneCityOnly();
        }
        if (context.getAll() != null && context.getZoneCityZoneOnly() != null) {
            zoneCity = zoneCityService.getZoneCityZoneOnly();
        }
        List<ZoneCityModel> zoneCityModels = (List<ZoneCityModel>) conversionService.convert(zoneCity, TypeDescriptor.forObject(zoneCity),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ZoneCityModel.class)));

        return zoneCityModels;
    }
}
