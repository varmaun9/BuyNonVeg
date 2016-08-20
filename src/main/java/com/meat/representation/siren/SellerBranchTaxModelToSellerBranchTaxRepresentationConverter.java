/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTaxModel;
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
 * @author Dilli
 *
 */
@Component("sellerBranchTaxModelToSellerBranchTaxRepresentationConverter")
public class SellerBranchTaxModelToSellerBranchTaxRepresentationConverter extends
        PropertyCopyingConverter<SellerBranchTaxModel, SellerBranchTaxRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTaxRepresentation convert(final SellerBranchTaxModel source) {

        SellerBranchTaxRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxModels())) {
            List<SellerItemTaxRepresentation> converted = (List<SellerItemTaxRepresentation>) conversionService.convert(
                    source.getSellerItemTaxModels(), TypeDescriptor.forObject(source.getSellerItemTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxRepresentation.class));
            target.getSellerItemTaxRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchTaxRepresentation> factory) {
        super.setFactory(factory);
    }
}
