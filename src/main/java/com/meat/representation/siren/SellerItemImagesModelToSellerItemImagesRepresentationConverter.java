/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemImagesModelToSellerItemImagesRepresentationConverter")
public class SellerItemImagesModelToSellerItemImagesRepresentationConverter extends
        PropertyCopyingConverter<SellerItemImagesModel, SellerItemImagesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemImagesRepresentation convert(final SellerItemImagesModel source) {

        SellerItemImagesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemImagesRepresentation> factory) {
        super.setFactory(factory);
    }
}
