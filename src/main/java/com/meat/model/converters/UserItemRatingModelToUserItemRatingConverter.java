/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserItemRating;
import com.meat.model.UserItemRatingModel;

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

@Component("userItemRatingModelToUserItemRatingConverter")
public class UserItemRatingModelToUserItemRatingConverter implements Converter<UserItemRatingModel, UserItemRating> {
    @Autowired
    private ObjectFactory<UserItemRating> userItemRatingFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserItemRating convert(final UserItemRatingModel source) {
        UserItemRating userItemRating = userItemRatingFactory.getObject();
        BeanUtils.copyProperties(source, userItemRating);

        return userItemRating;
    }

    @Autowired
    public void setUserItemRatingFactory(final ObjectFactory<UserItemRating> userItemRatingFactory) {
        this.userItemRatingFactory = userItemRatingFactory;
    }

}
