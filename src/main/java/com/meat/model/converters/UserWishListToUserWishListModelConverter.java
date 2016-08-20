/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserWishList;
import com.meat.model.UserWishListModel;

import org.apache.log4j.Logger;
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

@Component("userWishListToUserWishListModelConverter")
public class UserWishListToUserWishListModelConverter implements Converter<UserWishList, UserWishListModel> {

    @Autowired
    private ObjectFactory<UserWishListModel> userWishListModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserWishListToUserWishListModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserWishListModel convert(final UserWishList source) {
        // TODO Auto-generated method stub
        UserWishListModel userWishListModel = userWishListModelFactory.getObject();

        BeanUtils.copyProperties(source, userWishListModel);

        return userWishListModel;

    }

    @Autowired
    public void setUserWishListFactory(final ObjectFactory<UserWishListModel> userWishListModelFactory) {
        this.userWishListModelFactory = userWishListModelFactory;
    }

}
