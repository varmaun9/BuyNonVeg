/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserImages;
import com.meat.model.UserImagesModel;

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

@Component("userImagesModelToUserImagesConverter")
public class UserImagesModelToUserImagesConverter implements Converter<UserImagesModel, UserImages> {
    @Autowired
    private ObjectFactory<UserImages> userImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public UserImages convert(final UserImagesModel source) {
        UserImages userImages = userImagesFactory.getObject();
        BeanUtils.copyProperties(source, userImages);

        return userImages;
    }

    @Autowired
    public void setUserImagesFactory(final ObjectFactory<UserImages> userImagesFactory) {
        this.userImagesFactory = userImagesFactory;
    }

}
