/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserSearch;
import com.meat.model.UserSearchModel;

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
@Component("userSearchModelToUserSearchConverter")
public class UserSearchModelToUserSearchConverter implements Converter<UserSearchModel, UserSearch> {
    @Autowired
    private ObjectFactory<UserSearch> userSearchFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserSearch convert(final UserSearchModel source) {
        UserSearch userSearch = userSearchFactory.getObject();
        BeanUtils.copyProperties(source, userSearch);

        return userSearch;
    }

    @Autowired
    public void setUserSearchFactory(final ObjectFactory<UserSearch> userSearchFactory) {
        this.userSearchFactory = userSearchFactory;
    }
}
