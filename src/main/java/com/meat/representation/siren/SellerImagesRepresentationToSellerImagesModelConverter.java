/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerImagesRepresentationToSellerImagesModelConverter")
public class SellerImagesRepresentationToSellerImagesModelConverter extends
        PropertyCopyingConverter<SellerImagesRepresentation, SellerImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerImagesModel convert(final SellerImagesRepresentation source) {

        SellerImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerImagesModel> factory) {
        super.setFactory(factory);
    }
}
