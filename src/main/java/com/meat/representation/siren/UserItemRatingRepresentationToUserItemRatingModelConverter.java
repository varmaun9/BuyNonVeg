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
@Component("userItemRatingRepresentationToUserItemRatingModelConverter")
public class UserItemRatingRepresentationToUserItemRatingModelConverter extends
        PropertyCopyingConverter<UserItemRatingRepresentation, UserItemRatingModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserItemRatingModel convert(final UserItemRatingRepresentation source) {

        UserItemRatingModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserItemRatingModel> factory) {
        super.setFactory(factory);
    }
}
