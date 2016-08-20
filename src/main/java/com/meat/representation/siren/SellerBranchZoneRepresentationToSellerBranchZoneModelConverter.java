/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchZoneModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerBranchZoneRepresentationToSellerBranchZoneModelConverter")
public class SellerBranchZoneRepresentationToSellerBranchZoneModelConverter extends
        PropertyCopyingConverter<SellerBranchZoneRepresentation, SellerBranchZoneModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchZoneModel convert(final SellerBranchZoneRepresentation source) {

        SellerBranchZoneModel target = super.convert(source);
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchZoneModel> factory) {
        super.setFactory(factory);
    }

}
