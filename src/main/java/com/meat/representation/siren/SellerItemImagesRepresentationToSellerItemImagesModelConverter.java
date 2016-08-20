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
@Component("sellerItemImagesRepresentationToSellerItemImagesModelConverter")
public class SellerItemImagesRepresentationToSellerItemImagesModelConverter extends
        PropertyCopyingConverter<SellerItemImagesRepresentation, SellerItemImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemImagesModel convert(final SellerItemImagesRepresentation source) {

        SellerItemImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemImagesModel> factory) {
        super.setFactory(factory);
    }
}
