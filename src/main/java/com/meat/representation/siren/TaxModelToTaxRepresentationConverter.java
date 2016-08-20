package com.meat.representation.siren;

import com.meat.model.TaxModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("taxModelToTaxRepresentationConverter")
public class TaxModelToTaxRepresentationConverter extends PropertyCopyingConverter<TaxModel, TaxRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TaxRepresentation convert(final TaxModel source) {

        TaxRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxModels())) {
            List<SellerBranchTaxRepresentation> converted = (List<SellerBranchTaxRepresentation>) conversionService.convert(
                    source.getSellerBranchTaxModels(), TypeDescriptor.forObject(source.getSellerBranchTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxRepresentation.class));
            target.getSellerBranchTaxRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TaxRepresentation> factory) {
        super.setFactory(factory);
    }

}
