/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.UserImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userImagesRepresentationToUserImagesModelConverter")
public class UserImagesRepresentationToUserImagesModelConverter extends PropertyCopyingConverter<UserImagesRepresentation, UserImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UserImagesModel convert(final UserImagesRepresentation source) {

        UserImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UserImagesModel> factory) {
        super.setFactory(factory);
    }
}
