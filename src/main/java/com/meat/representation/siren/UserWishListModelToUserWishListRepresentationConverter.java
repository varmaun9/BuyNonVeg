/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserWishListModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userWishListModelToUserWishListRepresentationConverter")
public class UserWishListModelToUserWishListRepresentationConverter extends
        PropertyCopyingConverter<UserWishListModel, UserWishListRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserWishListRepresentation convert(final UserWishListModel source) {

        UserWishListRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserWishListRepresentation> factory) {
        super.setFactory(factory);
    }
}