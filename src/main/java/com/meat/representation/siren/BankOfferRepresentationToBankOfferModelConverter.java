/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.BankOfferModel;
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

@Component("bankOfferRepresentationToBankOfferModelConverter")
public class BankOfferRepresentationToBankOfferModelConverter extends PropertyCopyingConverter<BankOfferRepresentation, BankOfferModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public BankOfferModel convert(final BankOfferRepresentation source) {

        BankOfferModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getOfferConfigsRep())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigsRep(),
                    TypeDescriptor.forObject(source.getOfferConfigsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            target.getOfferConfigModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<BankOfferModel> factory) {
        super.setFactory(factory);
    }

}
