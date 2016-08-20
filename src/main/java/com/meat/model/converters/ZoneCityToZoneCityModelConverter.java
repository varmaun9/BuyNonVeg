/**
 *
 */
package com.meat.model.converters;

import java.util.List;

import com.meat.domain.ZoneCity;
import com.meat.model.ZoneCityModel;
import com.meat.model.ZoneModel;
import com.meat.util.CollectionTypeDescriptor;

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
 * @author arthvedi5
 *
 */
@Component("zoneCityToZoneCityModelConverter")
public class ZoneCityToZoneCityModelConverter implements Converter<ZoneCity, ZoneCityModel> {

    private static final Logger LOGGER = Logger.getLogger(ZoneCityToZoneCityModelConverter.class);
    @Autowired
    private ObjectFactory<ZoneCityModel> zoneCityModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ZoneCityModel convert(final ZoneCity source) {
        // TODO Auto-generated method stub
        ZoneCityModel zoneCityModel = zoneCityModelFactory.getObject();

        BeanUtils.copyProperties(source, zoneCityModel);

         if (CollectionUtils.isNotEmpty(source.getZones())) {
            List<ZoneModel> converted = (List<ZoneModel>) conversionService.convert(source.getZones(),
                    TypeDescriptor.forObject(source.getZones()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneModel.class));
            zoneCityModel.getZoneModels().addAll(converted);
        }

        return zoneCityModel;

    }

    @Autowired
    public void setZoneCityFactory(final ObjectFactory<ZoneCityModel> zoneCityModelFactory) {
        this.zoneCityModelFactory = zoneCityModelFactory;
    }
}
