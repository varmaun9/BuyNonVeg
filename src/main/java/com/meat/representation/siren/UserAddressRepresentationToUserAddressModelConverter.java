/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserAddressModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("userAddressRepresentationToUserAddressModelConverter")
public class UserAddressRepresentationToUserAddressModelConverter extends
        PropertyCopyingConverter<UserAddressRepresentation, UserAddressModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserAddressModel convert(final UserAddressRepresentation source) {

        UserAddressModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserAddressModel> factory) {
        super.setFactory(factory);
    }

}
