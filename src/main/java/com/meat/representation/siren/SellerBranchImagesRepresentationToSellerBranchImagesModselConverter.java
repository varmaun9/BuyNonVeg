/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerBranchImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerBranchImagesRepresentationToSellerBranchImagesModselConverter")
public class SellerBranchImagesRepresentationToSellerBranchImagesModselConverter extends
        PropertyCopyingConverter<SellerBranchImagesRepresentation, SellerBranchImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchImagesModel convert(final SellerBranchImagesRepresentation source) {

        SellerBranchImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerBranchImagesModel> factory) {
        super.setFactory(factory);
    }
}
