/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UsersOfferModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("usersOfferModelToUsersOfferRepresentationConverter")
public class UsersOfferModelToUsersOfferRepresentationConverter extends PropertyCopyingConverter<UsersOfferModel, UsersOfferRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersOfferRepresentation convert(final UsersOfferModel source) {

        UsersOfferRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UsersOfferRepresentation> factory) {
        super.setFactory(factory);
    }

}
