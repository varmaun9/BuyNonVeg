/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTaxModel;
import com.meat.model.SellerItemTaxModel;
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
@Component("sellerBranchTaxRepresentationToSellerBranchTaxModelConverter")
public class SellerBranchTaxRepresentationToSellerBranchTaxModelConverter extends
        PropertyCopyingConverter<SellerBranchTaxRepresentation, SellerBranchTaxModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTaxModel convert(final SellerBranchTaxRepresentation source) {

        SellerBranchTaxModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxRep())) {
            List<SellerItemTaxModel> converted = (List<SellerItemTaxModel>) conversionService.convert(source.getSellerItemTaxRep(),
                    TypeDescriptor.forObject(source.getSellerItemTaxRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxModel.class));
            target.getSellerItemTaxModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchTaxModel> factory) {
        super.setFactory(factory);
    }
}
