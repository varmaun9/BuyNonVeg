/**
 *
 */
package com.meat.representation.siren;

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
 * @author Administrator
 *
 */
@Component("zoneModelToZoneRepresentationConverter")
public class ZoneModelToZoneRepresentationConverter extends PropertyCopyingConverter<ZoneModel, ZoneRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneRepresentation convert(final ZoneModel source) {
        ZoneRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneModels())) {
            List<SellerBranchZoneRepresentation> converted = (List<SellerBranchZoneRepresentation>) conversionService.convert(
                    source.getSellerBranchZoneModels(), TypeDescriptor.forObject(source.getSellerBranchZoneModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneRepresentation.class));
            target.getSellerBranchZoneRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getZoneAreaModels())) {
            List<ZoneAreaRepresentation> converted = (List<ZoneAreaRepresentation>) conversionService.convert(source.getZoneAreaModels(),
                    TypeDescriptor.forObject(source.getZoneAreaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneAreaRepresentation.class));
            target.getZoneAreaRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneRepresentation> factory) {
        super.setFactory(factory);
    }
}
