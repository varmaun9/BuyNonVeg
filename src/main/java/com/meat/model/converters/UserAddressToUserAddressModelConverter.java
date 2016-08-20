/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserAddress;
import com.meat.model.UserAddressModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userAddressToUserAddressModelConverter")
public class UserAddressToUserAddressModelConverter implements Converter<UserAddress, UserAddressModel> {

    @Autowired
    private ObjectFactory<UserAddressModel> userAddressModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserAddressToUserAddressModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserAddressModel convert(final UserAddress source) {
        // TODO Auto-generated method stub
        UserAddressModel userAddressModel = userAddressModelFactory.getObject();

        BeanUtils.copyProperties(source, userAddressModel);

        return userAddressModel;

    }

    @Autowired
    public void setUserAddressFactory(final ObjectFactory<UserAddressModel> userAddressModelFactory) {
        this.userAddressModelFactory = userAddressModelFactory;
    }

}
