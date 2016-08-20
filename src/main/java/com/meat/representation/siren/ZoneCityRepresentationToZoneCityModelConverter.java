/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ZoneCityModel;
import com.meat.model.ZoneModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

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

@Component("zoneCityRepresentationToZoneCityModelConverter")
public class ZoneCityRepresentationToZoneCityModelConverter extends PropertyCopyingConverter<ZoneCityRepresentation, ZoneCityModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneCityModel convert(final ZoneCityRepresentation source) {

        ZoneCityModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getZoneRep())) {
            List<ZoneModel> converted = (List<ZoneModel>) conversionService.convert(source.getZoneRep(),
                    TypeDescriptor.forObject(source.getZoneRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneModel.class));
            target.getZoneModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneCityModel> factory) {
        super.setFactory(factory);
    }
}
