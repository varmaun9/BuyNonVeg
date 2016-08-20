/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OfferConfigModel;
import com.meat.model.UsersOfferModel;
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
 * @author varma
 *
 */

@Component("offerConfigRepresentationToOfferConfigModelConverter")
public class OfferConfigRepresentationToOfferConfigModelConverter
        extends PropertyCopyingConverter<OfferConfigRepresentation, OfferConfigModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferConfigModel convert(final OfferConfigRepresentation source) {
        OfferConfigModel target = super.convert(source);
        target.setOfferId(source.getOfferId());
        if (CollectionUtils.isNotEmpty(source.getUsersOfferRep())) {
            List<UsersOfferModel> converted = (List<UsersOfferModel>) conversionService.convert(source.getUsersOfferRep(),
                    TypeDescriptor.forObject(source.getUsersOfferRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersOfferModel.class));
            target.getUsersOfferModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<OfferConfigModel> factory) {
        super.setFactory(factory);
    }

}
