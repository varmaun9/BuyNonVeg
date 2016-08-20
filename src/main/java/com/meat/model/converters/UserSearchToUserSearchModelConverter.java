/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserSearch;
import com.meat.model.UserSearchModel;

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
@Component("UserSearchToUserSearchModelConverter")
public class UserSearchToUserSearchModelConverter implements Converter<UserSearch, UserSearchModel> {

    @Autowired
    private ObjectFactory<UserSearchModel> userSearchModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserSearchToUserSearchModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserSearchModel convert(final UserSearch source) {
        // TODO Auto-generated method stub
        UserSearchModel userSearchModel = userSearchModelFactory.getObject();

        BeanUtils.copyProperties(source, userSearchModel);

        return userSearchModel;

    }

    @Autowired
    public void setUserSearchFactory(final ObjectFactory<UserSearchModel> userSearchModelFactory) {
        this.userSearchModelFactory = userSearchModelFactory;
    }

}
