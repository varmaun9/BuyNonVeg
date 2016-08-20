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
@Component("userSellerItemRatingRepresentationToUserSellerItemRatingModelConverter")
public class UserSellerItemRatingRepresentationToUserSellerItemRatingModelConverter extends
        PropertyCopyingConverter<UserSellerItemRatingRepresentation, UserSellerItemRatingModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSellerItemRatingModel convert(final UserSellerItemRatingRepresentation source) {

        UserSellerItemRatingModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserSellerItemRatingModel> factory) {
        super.setFactory(factory);
    }
}
