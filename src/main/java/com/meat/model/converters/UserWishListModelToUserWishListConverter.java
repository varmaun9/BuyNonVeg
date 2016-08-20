/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserWishList;
import com.meat.model.UserWishListModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */

@Component("userWishListModelToUserWishListConverter")
public class UserWishListModelToUserWishListConverter implements Converter<UserWishListModel, UserWishList> {
    @Autowired
    private ObjectFactory<UserWishList> userWishListFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserWishList convert(final UserWishListModel source) {
        UserWishList userWishList = userWishListFactory.getObject();
        BeanUtils.copyProperties(source, userWishList);

        return userWishList;
    }

    @Autowired
    public void setUserWishListFactory(final ObjectFactory<UserWishList> userWishListFactory) {
        this.userWishListFactory = userWishListFactory;
    }

}
