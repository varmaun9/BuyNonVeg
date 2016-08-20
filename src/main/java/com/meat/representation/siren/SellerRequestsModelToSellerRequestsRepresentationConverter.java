/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerRequestsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerRequestsModelToSellerRequestsRepresentationConverter")
public class SellerRequestsModelToSellerRequestsRepresentationConverter extends
        PropertyCopyingConverter<SellerRequestsModel, SellerRequestsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerRequestsRepresentation convert(final SellerRequestsModel source) {

        SellerRequestsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerRequestsRepresentation> factory) {
        super.setFactory(factory);
    }
}
