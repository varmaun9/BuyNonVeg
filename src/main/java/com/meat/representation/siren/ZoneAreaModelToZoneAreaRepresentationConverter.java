/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ZoneAreaModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("zoneAreaModelToZoneAreaRepresentationConverter")
public class ZoneAreaModelToZoneAreaRepresentationConverter extends PropertyCopyingConverter<ZoneAreaModel, ZoneAreaRepresentation> {

    @Override
    public ZoneAreaRepresentation convert(final ZoneAreaModel source) {
        ZoneAreaRepresentation target = super.convert(source);

        return target;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneAreaRepresentation> factory) {
        super.setFactory(factory);
    }
}
