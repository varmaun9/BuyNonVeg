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
@Component("userWishListRepresentationToUserWishListModelConverter")
public class UserWishListRepresentationToUserWishListModelConverter extends
        PropertyCopyingConverter<UserWishListRepresentation, UserWishListModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserWishListModel convert(final UserWishListRepresentation source) {

        UserWishListModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserWishListModel> factory) {
        super.setFactory(factory);
    }
}
