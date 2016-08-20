/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchZoneModel;
import com.meat.model.ZoneAreaModel;
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
 * @author
 *
 */
@Component("zoneRepresentationToZoneModelConverter")
public class ZoneRepresentationToZoneModelConverter extends PropertyCopyingConverter<ZoneRepresentation, ZoneModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ZoneModel convert(final ZoneRepresentation source) {

        ZoneModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchZoneRep())) {
            List<SellerBranchZoneModel> converted = (List<SellerBranchZoneModel>) conversionService.convert(source.getSellerBranchZoneRep(),
                    TypeDescriptor.forObject(source.getSellerBranchZoneRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchZoneModel.class));
            target.getSellerBranchZoneModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getZoneAreaRep())) {
            List<ZoneAreaModel> converted = (List<ZoneAreaModel>) conversionService.convert(source.getZoneAreaRep(),
                    TypeDescriptor.forObject(source.getZoneAreaRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ZoneAreaModel.class));
            target.getZoneAreaModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ZoneModel> factory) {
        super.setFactory(factory);
    }
}
