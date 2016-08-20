/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.UserImages;
import com.meat.model.UserImagesModel;

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

@Component("userImagesToUserImagesModelConverter")
public class UserImagesToUserImagesModelConverter implements Converter<UserImages, UserImagesModel> {

    @Autowired
    private ObjectFactory<UserImagesModel> userImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UserImagesToUserImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public UserImagesModel convert(final UserImages source) {
        // TODO Auto-generated method stub
        UserImagesModel userImagesModel = userImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, userImagesModel);

        return userImagesModel;

    }

    @Autowired
    public void setUserImagesFactory(final ObjectFactory<UserImagesModel> userImagesModelFactory) {
        this.userImagesModelFactory = userImagesModelFactory;
    }

}
