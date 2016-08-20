/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OfferModel;
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
 * @author Administrator
 *
 */
@Component("offerModelToOfferRepresentationConverter")
public class OfferModelToOfferRepresentationConverter extends PropertyCopyingConverter<OfferModel, OfferRepresentation> {
    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferRepresentation convert(final OfferModel source) {

        OfferRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfigRepresentation> converted = (List<OfferConfigRepresentation>) conversionService.convert(
                    source.getOfferConfigModels(), TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigRepresentation.class));
            target.getOfferConfigRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getBankOfferModels())) {
            List<BankOfferRepresentation> converted = (List<BankOfferRepresentation>) conversionService.convert(source.getBankOfferModels(),
                    TypeDescriptor.forObject(source.getBankOfferModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), BankOfferRepresentation.class));
            target.getBankOfferRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigModels())) {
            List<OfferExcludeConfigRepresentation> converted = (List<OfferExcludeConfigRepresentation>) conversionService.convert(
                    source.getOfferExcludeConfigModels(), TypeDescriptor.forObject(source.getOfferExcludeConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfigRepresentation.class));
            target.getOfferExcludeConfigRep().addAll(converted);
        }

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
    public void setFactory(final ObjectFactory<OfferRepresentation> factory) {
        super.setFactory(factory);
    }
}
