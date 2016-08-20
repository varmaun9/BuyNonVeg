/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTimingsModel;
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
@Component("sellerBranchTimingsModelToSellerBranchTimingsRepresentationConverter")
public class SellerBranchTimingsModelToSellerBranchTimingsRepresentationConverter extends
        PropertyCopyingConverter<SellerBranchTimingsModel, SellerBranchTimingsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTimingsRepresentation convert(final SellerBranchTimingsModel source) {

        SellerBranchTimingsRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerTimingsConfigModels())) {
            List<SellerTimingsConfigRepresentation> converted = (List<SellerTimingsConfigRepresentation>) conversionService.convert(
                    source.getSellerTimingsConfigModels(), TypeDescriptor.forObject(source.getSellerTimingsConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerTimingsConfigRepresentation.class));
            target.getSellerTimingsConfigRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchTimingsRepresentation> factory) {
        super.setFactory(factory);
    }

}
