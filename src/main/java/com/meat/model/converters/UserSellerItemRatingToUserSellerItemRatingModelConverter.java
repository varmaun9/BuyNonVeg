/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserSellerItemRating;
import com.meat.model.UserSellerItemRatingModel;

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

@Component("userSellerItemRatingToUserSellerItemRatingModelConverter")
public class UserSellerItemRatingToUserSellerItemRatingModelConverter implements Converter<UserSellerItemRating, UserSellerItemRatingModel> {

    @Autowired
    private ObjectFactory<UserSellerItemRatingModel> userSellerItemRatingModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserSellerItemRatingToUserSellerItemRatingModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserSellerItemRatingModel convert(final UserSellerItemRating source) {
        // TODO Auto-generated method stub
        UserSellerItemRatingModel userSellerItemRatingModel = userSellerItemRatingModelFactory.getObject();

        BeanUtils.copyProperties(source, userSellerItemRatingModel);

        return userSellerItemRatingModel;

    }

    @Autowired
    public void setUserSellerItemRatingFactory(final ObjectFactory<UserSellerItemRatingModel> userSellerItemRatingModelFactory) {
        this.userSellerItemRatingModelFactory = userSellerItemRatingModelFactory;
    }

}
