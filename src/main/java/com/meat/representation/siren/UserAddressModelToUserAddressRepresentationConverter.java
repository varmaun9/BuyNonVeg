package com.meat.representation.siren;

import com.meat.model.UserAddressModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component("userAddressModelToUserAddressRepresentationConverter")
public class UserAddressModelToUserAddressRepresentationConverter extends
        PropertyCopyingConverter<UserAddressModel, UserAddressRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserAddressRepresentation convert(final UserAddressModel source) {

        UserAddressRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserAddressRepresentation> factory) {
        super.setFactory(factory);
    }

}
