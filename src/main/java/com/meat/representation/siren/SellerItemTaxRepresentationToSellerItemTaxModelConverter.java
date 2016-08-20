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
@Component("sellerItemTaxRepresentationToSellerItemTaxModelConverter")
public class SellerItemTaxRepresentationToSellerItemTaxModelConverter extends
        PropertyCopyingConverter<SellerItemTaxRepresentation, SellerItemTaxModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemTaxModel convert(final SellerItemTaxRepresentation source) {

        SellerItemTaxModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemTaxModel> factory) {
        super.setFactory(factory);
    }
}
