/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTimingsModel;
import com.meat.model.SubOrderModel;
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
@Component("timingsRepresentationToTimingsModelConverter")
public class TimingsRepresentationToTimingsModelConverter extends PropertyCopyingConverter<TimingsRepresentation, TimingsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TimingsModel convert(final TimingsRepresentation source) {

        TimingsModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubOrderRep())) {
            List<SubOrderModel> converted = (List<SubOrderModel>) conversionService.convert(source.getSubOrderRep(),
                    TypeDescriptor.forObject(source.getSubOrderRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderModel.class));
            target.getSubOrderModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTimingsRep())) {
            List<SellerBranchTimingsModel> converted = (List<SellerBranchTimingsModel>) conversionService.convert(
                    source.getSellerBranchTimingsRep(), TypeDescriptor.forObject(source.getSellerBranchTimingsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTimingsModel.class));
            target.getSellerBranchTimingsModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TimingsModel> factory) {
        super.setFactory(factory);
    }

}
