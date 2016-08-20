/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UsersOffer;
import com.meat.model.UsersOfferModel;

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
@Component("usersOfferToUsersOfferModelConverter")
public class UsersOfferToUsersOfferModelConverter implements Converter<UsersOffer, UsersOfferModel> {

    private static final Logger LOGGER = Logger.getLogger(UsersOfferToUsersOfferModelConverter.class);
    @Autowired
    private ObjectFactory<UsersOfferModel> usersOfferModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UsersOfferModel convert(final UsersOffer source) {
        // TODO Auto-generated method stub
        UsersOfferModel usersOfferModel = usersOfferModelFactory.getObject();

        BeanUtils.copyProperties(source, usersOfferModel);

        return usersOfferModel;

    }

    @Autowired
    public void setUsersOfferFactory(final ObjectFactory<UsersOfferModel> usersOfferModelFactory) {
        this.usersOfferModelFactory = usersOfferModelFactory;
    }

}
