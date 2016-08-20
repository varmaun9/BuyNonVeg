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

@Component("usersOfferRepresentationToUsersOfferModelConverter")
public class UsersOfferRepresentationToUsersOfferModelConverter extends PropertyCopyingConverter<UsersOfferRepresentation, UsersOfferModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersOfferModel convert(final UsersOfferRepresentation source) {

        UsersOfferModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UsersOfferModel> factory) {
        super.setFactory(factory);
    }

}
