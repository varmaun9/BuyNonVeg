/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.TimingsModel;
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
 * @author arthvedi
 *
 */
@Component("timingsModelToTimingsRepresentationConverter")
public class TimingsModelToTimingsRepresentationConverter extends PropertyCopyingConverter<TimingsModel, TimingsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TimingsRepresentation convert(final TimingsModel source) {

        TimingsRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubOrderModels())) {
            List<SubOrderRepresentation> converted = (List<SubOrderRepresentation>) conversionService.convert(source.getSubOrderModels(),
                    TypeDescriptor.forObject(source.getSubOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderRepresentation.class));
            target.getSubOrderRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsModels())) {
            List<SellerBranchTimingsRepresentation> converted = (List<SellerBranchTimingsRepresentation>) conversionService.convert(
                    source.getSellerBranchTimingsModels(), TypeDescriptor.forObject(source.getSellerBranchTimingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsRepresentation.class));
            target.getSellerBranchTimingsRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TimingsRepresentation> factory) {
        super.setFactory(factory);
    }

}
