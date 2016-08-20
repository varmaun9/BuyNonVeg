/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ZoneAreaModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaRepresentationToZoneAreaModelConverter")
public class ZoneAreaRepresentationToZoneAreaModelConverter extends PropertyCopyingConverter<ZoneAreaRepresentation, ZoneAreaModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneAreaModel convert(final ZoneAreaRepresentation source) {

        ZoneAreaModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneAreaModel> factory) {
        super.setFactory(factory);
    }
}
