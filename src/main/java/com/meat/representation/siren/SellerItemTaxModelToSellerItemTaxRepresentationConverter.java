/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemTaxModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerItemTaxModelToSellerItemTaxRepresentationConverter")
public class SellerItemTaxModelToSellerItemTaxRepresentationConverter extends
        PropertyCopyingConverter<SellerItemTaxModel, SellerItemTaxRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemTaxRepresentation convert(final SellerItemTaxModel source) {

        SellerItemTaxRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemTaxRepresentation> factory) {
        super.setFactory(factory);
    }
}