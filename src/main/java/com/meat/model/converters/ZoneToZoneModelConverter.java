/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Zone;
import com.meat.model.SellerBranchZoneModel;
import com.meat.model.ZoneAreaModel;
import com.meat.model.ZoneModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */

@Component("zoneToZoneModelConverter")
public class ZoneToZoneModelConverter implements Converter<Zone, ZoneModel> {
    private static final Logger LOGGER = Logger.getLogger(ZoneToZoneModelConverter.class);
    @Autowired
    private ObjectFactory<ZoneModel> zoneModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ZoneModel convert(final Zone source) {
        ZoneModel zoneModel = zoneModelFactory.getObject();
        BeanUtils.copyProperties(source, zoneModel);
        if (source.getZoneCity() != null) {
            zoneModel.setZoneCityId(source.getZoneCity().getId());
            zoneModel.setCityName(source.getZoneCity().getCityName());
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchZones())) {
            List<SellerBranchZoneModel> converted = (List<SellerBranchZoneModel>) conversionService.convert(source.getSellerBranchZones(),
                    TypeDescriptor.forObject(source.getSellerBranchZones()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneModel.class));
            zoneModel.getSellerBranchZoneModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getZoneAreas())) {
            List<ZoneAreaModel> converted = (List<ZoneAreaModel>) conversionService.convert(source.getZoneAreas(),
                    TypeDescriptor.forObject(source.getZoneAreas()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneAreaModel.class));
            zoneModel.getZoneAreaModels().addAll(converted);
        }
        return zoneModel;
    }

    @Autowired
    public void setZoneFactory(final ObjectFactory<ZoneModel> zoneModelFactory) {
        this.zoneModelFactory = zoneModelFactory;
    }

}
