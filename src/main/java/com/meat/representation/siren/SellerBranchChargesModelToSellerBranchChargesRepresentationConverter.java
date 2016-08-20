/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchChargesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerBranchChargesModelToSellerBranchChargesRepresentationConverter")
public class SellerBranchChargesModelToSellerBranchChargesRepresentationConverter
        extends PropertyCopyingConverter<SellerBranchChargesModel, SellerBranchChargesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchChargesRepresentation convert(final SellerBranchChargesModel source) {

        SellerBranchChargesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchChargesRepresentation> factory) {
        super.setFactory(factory);
    }
}
