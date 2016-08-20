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
@Component("sellerRequestsRepresentationToSellerRequestsModelConverter")
public class SellerRequestsRepresentationToSellerRequestsModelConverter extends
        PropertyCopyingConverter<SellerRequestsRepresentation, SellerRequestsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerRequestsModel convert(final SellerRequestsRepresentation source) {

        SellerRequestsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerRequestsModel> factory) {
        super.setFactory(factory);
    }
}
