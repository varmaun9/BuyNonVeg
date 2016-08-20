/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchAddressModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerBranchAddressModelToSellerBranchAddressRepresentation")
public class SellerBranchAddressModelToSellerBranchAddressRepresentation
        extends PropertyCopyingConverter<SellerBranchAddressModel, SellerBranchAddressRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchAddressRepresentation convert(final SellerBranchAddressModel source) {

        SellerBranchAddressRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchAddressRepresentation> factory) {
        super.setFactory(factory);
    }
}
