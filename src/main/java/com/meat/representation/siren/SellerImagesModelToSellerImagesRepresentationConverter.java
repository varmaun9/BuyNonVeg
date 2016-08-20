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
@Component("sellerImagesModelToSellerImagesRepresentationConverter")
public class SellerImagesModelToSellerImagesRepresentationConverter extends
        PropertyCopyingConverter<SellerImagesModel, SellerImagesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerImagesRepresentation convert(final SellerImagesModel source) {

        SellerImagesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerImagesRepresentation> factory) {
        super.setFactory(factory);
    }
}
