/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserSellerItemRatingModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userSellerItemRatingModelToUserSellerItemRatingRepresentationConverter")
public class UserSellerItemRatingModelToUserSellerItemRatingRepresentationConverter extends
        PropertyCopyingConverter<UserSellerItemRatingModel, UserSellerItemRatingRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSellerItemRatingRepresentation convert(final UserSellerItemRatingModel source) {

        UserSellerItemRatingRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserSellerItemRatingRepresentation> factory) {
        super.setFactory(factory);
    }
}