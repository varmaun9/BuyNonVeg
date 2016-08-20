/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserSearchModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userSearchModelToUserSearchRepresentationConverter")
public class UserSearchModelToUserSearchRepresentationConverter extends PropertyCopyingConverter<UserSearchModel, UserSearchRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSearchRepresentation convert(final UserSearchModel source) {

        UserSearchRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserSearchRepresentation> factory) {
        super.setFactory(factory);
    }
}
