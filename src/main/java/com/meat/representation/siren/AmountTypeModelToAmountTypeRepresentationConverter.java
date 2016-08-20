/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AmountTypeModel;
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
 * @author arthvedi1
 *
 */
@Component("amountTypeModelToAmountTypeRepresentationConverter")
public class AmountTypeModelToAmountTypeRepresentationConverter extends PropertyCopyingConverter<AmountTypeModel, AmountTypeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AmountTypeRepresentation convert(final AmountTypeModel source) {

        AmountTypeRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCouponsModels())) {
            List<CouponRepresentation> converted = (List<CouponRepresentation>) conversionService.convert(source.getCouponsModels(),
                    TypeDescriptor.forObject(source.getCouponsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponRepresentation.class));
            target.getCouponsRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxesModels())) {
            List<SellerBranchTaxRepresentation> converted = (List<SellerBranchTaxRepresentation>) conversionService.convert(
                    source.getSellerBranchTaxesModels(), TypeDescriptor.forObject(source.getSellerBranchTaxesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxRepresentation.class));
            target.getSellerBranchTaxesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AmountTypeRepresentation> factory) {
        super.setFactory(factory);
    }

}
