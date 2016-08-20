/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.BankOfferModel;
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

@Component("bankOfferModelToBankOfferRepresentationConverter")
public class BankOfferModelToBankOfferRepresentationConverter extends PropertyCopyingConverter<BankOfferModel, BankOfferRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public BankOfferRepresentation convert(final BankOfferModel source) {

        BankOfferRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfigRepresentation> converted = (List<OfferConfigRepresentation>) conversionService.convert(
                    source.getOfferConfigModels(), TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigRepresentation.class));
            target.getOfferConfigsRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<BankOfferRepresentation> factory) {
        super.setFactory(factory);
    }

}
