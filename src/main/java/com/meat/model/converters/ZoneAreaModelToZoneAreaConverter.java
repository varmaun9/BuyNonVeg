/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.ZoneArea;
import com.meat.model.ZoneAreaModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaModelToZoneAreaConverter")
public class ZoneAreaModelToZoneAreaConverter implements Converter<ZoneAreaModel, ZoneArea> {
    @Autowired
    private ObjectFactory<ZoneArea> zoneAreaFactory;
    /*   @Autowired
    private ConversionService conversionService;*/

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ZoneArea convert(final ZoneAreaModel source) {
        ZoneArea zoneArea = zoneAreaFactory.getObject();
        BeanUtils.copyProperties(source, zoneArea);

        return zoneArea;
    }

    @Autowired
    public void setZoneFactory(final ObjectFactory<ZoneArea> zoneAreaFactory) {
        this.zoneAreaFactory = zoneAreaFactory;
    }
}
