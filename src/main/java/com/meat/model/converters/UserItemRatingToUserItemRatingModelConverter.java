/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserItemRating;
import com.meat.model.UserItemRatingModel;

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

@Component("userItemRatingToUserItemRatingModelConverter")
public class UserItemRatingToUserItemRatingModelConverter implements Converter<UserItemRating, UserItemRatingModel> {

    @Autowired
    private ObjectFactory<UserItemRatingModel> userItemRatingModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserItemRatingToUserItemRatingModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserItemRatingModel convert(final UserItemRating source) {
        // TODO Auto-generated method stub
        UserItemRatingModel userItemRatingModel = userItemRatingModelFactory.getObject();

        BeanUtils.copyProperties(source, userItemRatingModel);

        return userItemRatingModel;

    }

    @Autowired
    public void setUserItemRatingFactory(final ObjectFactory<UserItemRatingModel> userItemRatingModelFactory) {
        this.userItemRatingModelFactory = userItemRatingModelFactory;
    }

}
