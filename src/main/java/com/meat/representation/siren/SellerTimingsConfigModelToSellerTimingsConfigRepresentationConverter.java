/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerTimingsConfigModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerTimingsConfigModelToSellerTimingsConfigRepresentationConverter")
public class SellerTimingsConfigModelToSellerTimingsConfigRepresentationConverter extends
        PropertyCopyingConverter<SellerTimingsConfigModel, SellerTimingsConfigRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerTimingsConfigRepresentation convert(final SellerTimingsConfigModel source) {

        SellerTimingsConfigRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerTimingsConfigRepresentation> factory) {
        super.setFactory(factory);
    }

}
