/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerUserModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerUserModelToSellerUserRepresentationConverter")
public class SellerUserModelToSellerUserRepresentationConverter
        extends PropertyCopyingConverter<SellerUserModel, SellerUserRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerUserRepresentation convert(final SellerUserModel source) {

        SellerUserRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerUserRepresentation> factory) {
        super.setFactory(factory);
    }

}
