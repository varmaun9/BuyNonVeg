/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.ZoneCity;
import com.meat.model.ZoneCityModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi5
 *
 */
@Component("zoneCityModelToZoneCityConverter")
public class ZoneCityModelToZoneCityConverter implements Converter<ZoneCityModel, ZoneCity> {
    @Autowired
    private ObjectFactory<ZoneCity> zoneCityFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneCity convert(final ZoneCityModel source) {
        ZoneCity zoneCity = zoneCityFactory.getObject();
        BeanUtils.copyProperties(source, zoneCity);

        /* if (CollectionUtils.isNotEmpty(source.getZoneModels())) {
            List<Zone> converted = (List<Zone>) conversionService.convert(source.getZoneModels(),
                    TypeDescriptor.forObject(source.getZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Zone.class));
            zoneCity.getZones().addAll(converted);
        }*/
        return zoneCity;
    }

    @Autowired
    public void setZoneCityFactory(final ObjectFactory<ZoneCity> zoneCityFactory) {
        this.zoneCityFactory = zoneCityFactory;
    }

}
