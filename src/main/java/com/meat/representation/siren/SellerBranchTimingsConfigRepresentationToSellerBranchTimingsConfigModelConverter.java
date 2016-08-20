/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchTimingsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBranchTimingsConfigRepresentationToSellerBranchTimingsConfigModelConverter")
public class SellerBranchTimingsConfigRepresentationToSellerBranchTimingsConfigModelConverter extends
        PropertyCopyingConverter<SellerBranchTimingsRepresentation, SellerBranchTimingsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchTimingsModel convert(final SellerBranchTimingsRepresentation source) {

        SellerBranchTimingsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchTimingsModel> factory) {
        super.setFactory(factory);
    }

}
