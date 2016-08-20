/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserSellerItemRating;
import com.meat.model.UserSellerItemRatingModel;

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
@Component("userSellerItemRatingModelToUserSellerItemRatingConverter")
public class UserSellerItemRatingModelToUserSellerItemRatingConverter implements Converter<UserSellerItemRatingModel, UserSellerItemRating> {
    @Autowired
    private ObjectFactory<UserSellerItemRating> userSellerItemRatingFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSellerItemRating convert(final UserSellerItemRatingModel source) {
        UserSellerItemRating userSellerItemRating = userSellerItemRatingFactory.getObject();
        BeanUtils.copyProperties(source, userSellerItemRating);

        return userSellerItemRating;
    }

    @Autowired
    public void setUserSellerItemRatingFactory(final ObjectFactory<UserSellerItemRating> userSellerItemRatingFactory) {
        this.userSellerItemRatingFactory = userSellerItemRatingFactory;
    }

}
