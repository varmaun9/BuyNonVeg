/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AmountTypeModel;
import com.meat.model.CouponModel;
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
 * @author arthvedi1
 *
 */
@Component("amountTypeRepresentationToAmountTypeModelConverter")
public class AmountTypeRepresentationToAmountTypeModelConverter extends PropertyCopyingConverter<AmountTypeRepresentation, AmountTypeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AmountTypeModel convert(final AmountTypeRepresentation source) {

        AmountTypeModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getCouponsRep())) {
            List<CouponModel> converted = (List<CouponModel>) conversionService.convert(source.getCouponsRep(),
                    TypeDescriptor.forObject(source.getCouponsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponModel.class));
            target.getCouponsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxesRep())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxesRep(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            target.getSellerBranchTaxesModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AmountTypeModel> factory) {
        super.setFactory(factory);
    }

}
