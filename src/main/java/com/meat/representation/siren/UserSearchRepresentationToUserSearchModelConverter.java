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
@Component("userSearchRepresentationToUserSearchModelConverter")
public class UserSearchRepresentationToUserSearchModelConverter extends PropertyCopyingConverter<UserSearchRepresentation, UserSearchModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSearchModel convert(final UserSearchRepresentation source) {

        UserSearchModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserSearchModel> factory) {
        super.setFactory(factory);
    }
}
