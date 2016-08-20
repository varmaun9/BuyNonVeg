/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserItemRatingModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userItemRatingModelToUserItemRatingRepresentationConverter")
public class UserItemRatingModelToUserItemRatingRepresentationConverter extends
        PropertyCopyingConverter<UserItemRatingModel, UserItemRatingRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserItemRatingRepresentation convert(final UserItemRatingModel source) {

        UserItemRatingRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserItemRatingRepresentation> factory) {
        super.setFactory(factory);
    }
}
