/**
 *
 */
package com.meat.representation.siren;

import java.util.List;

import com.meat.model.ZoneCityModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi5
 *
 */
@Component("zoneCityModelToZoneCityRepresentation")
public class ZoneCityModelToZoneCityRepresentation extends PropertyCopyingConverter<ZoneCityModel, ZoneCityRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneCityRepresentation convert(final ZoneCityModel source) {

        ZoneCityRepresentation target = super.convert(source);

         if (CollectionUtils.isNotEmpty(source.getZoneModels())) {
            List<ZoneRepresentation> converted = (List<ZoneRepresentation>) conversionService.convert(source.getZoneModels(),
                    TypeDescriptor.forObject(source.getZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneRepresentation.class));
            target.getZoneRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneCityRepresentation> factory) {
        super.setFactory(factory);
    }
}
