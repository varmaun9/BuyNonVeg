/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchZone;
import com.meat.domain.Zone;
import com.meat.domain.ZoneArea;
import com.meat.model.ZoneModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("zoneModelToZoneConverter")
public class ZoneModelToZoneConverter implements Converter<ZoneModel, Zone> {
    @Autowired
    private ObjectFactory<Zone> zoneFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public Zone convert(final ZoneModel source) {
        Zone zone = zoneFactory.getObject();
        BeanUtils.copyProperties(source, zone);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneModels())) {
            List<SellerBranchZone> converted = (List<SellerBranchZone>) conversionService.convert(source.getSellerBranchZoneModels(),
                    TypeDescriptor.forObject(source.getSellerBranchZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZone.class));
            zone.getSellerBranchZones().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getZoneAreaModels())) {
            List<ZoneArea> converted = (List<ZoneArea>) conversionService.convert(source.getZoneAreaModels(),
                    TypeDescriptor.forObject(source.getZoneAreaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneArea.class));
            zone.getZoneAreas().addAll(converted);
        }

        return zone;
    }

    @Autowired
    public void setZoneFactory(final ObjectFactory<Zone> zoneFactory) {
        this.zoneFactory = zoneFactory;
    }

}
