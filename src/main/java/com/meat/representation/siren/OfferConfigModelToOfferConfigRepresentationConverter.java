/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OfferConfigModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */

@Component("offerConfigModelToOfferConfigRepresentationConverter")
public class OfferConfigModelToOfferConfigRepresentationConverter
        extends PropertyCopyingConverter<OfferConfigModel, OfferConfigRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferConfigRepresentation convert(final OfferConfigModel source) {
        OfferConfigRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getUsersOfferModels())) {
            List<UsersOfferRepresentation> converted = (List<UsersOfferRepresentation>) conversionService.convert(
                    source.getUsersOfferModels(), TypeDescriptor.forObject(source.getUsersOfferModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersOfferRepresentation.class));
            target.getUsersOfferRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OfferConfigRepresentation> factory) {
        super.setFactory(factory);
    }

}
