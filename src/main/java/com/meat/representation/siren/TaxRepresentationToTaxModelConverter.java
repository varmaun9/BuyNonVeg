/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTaxModel;
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

/**
 * @author arthvedi1
 *
 */
@Component("taxRepresentationToTaxModelConverter")
public class TaxRepresentationToTaxModelConverter extends PropertyCopyingConverter<TaxRepresentation, TaxModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TaxModel convert(final TaxRepresentation source) {

        TaxModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxRep())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxRep(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            target.getSellerBranchTaxModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TaxModel> factory) {
        super.setFactory(factory);
    }

}
