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
@Component("sellerUserRepresentationToSellerUserModelConverter")
public class SellerUserRepresentationToSellerUserModelConverter
        extends PropertyCopyingConverter<SellerUserRepresentation, SellerUserModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerUserModel convert(final SellerUserRepresentation source) {

        SellerUserModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerUserModel> factory) {
        super.setFactory(factory);
    }

}
