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
@Component("sellerBranchAddressRepresentationToSellerBranchAddressModelConverter")
public class SellerBranchAddressRepresentationToSellerBranchAddressModelConverter
        extends PropertyCopyingConverter<SellerBranchAddressRepresentation, SellerBranchAddressModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchAddressModel convert(final SellerBranchAddressRepresentation source) {

        SellerBranchAddressModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchAddressModel> factory) {
        super.setFactory(factory);
    }
}