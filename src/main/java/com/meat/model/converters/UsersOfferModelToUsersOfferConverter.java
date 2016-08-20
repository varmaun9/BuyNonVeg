/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UsersOffer;
import com.meat.model.UsersOfferModel;

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
@Component("usersOfferModelToUsersOfferConverter")
public class UsersOfferModelToUsersOfferConverter implements Converter<UsersOfferModel, UsersOffer> {
    @Autowired
    private ObjectFactory<UsersOffer> usersOfferFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersOffer convert(final UsersOfferModel source) {
        UsersOffer usersOffer = usersOfferFactory.getObject();
        BeanUtils.copyProperties(source, usersOffer);

        return usersOffer;
    }

    @Autowired
    public void setUsersOfferFactory(final ObjectFactory<UsersOffer> usersOfferFactory) {
        this.usersOfferFactory = usersOfferFactory;
    }

}
