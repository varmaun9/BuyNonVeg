/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.BankOffer;
import com.meat.domain.Offer;
import com.meat.domain.OfferConfig;
import com.meat.domain.OfferExcludeConfig;
import com.meat.model.OfferModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("offerModelToOfferConverter")
public class OfferModelToOfferConverter implements Converter<OfferModel, Offer> {
    @Autowired
    private ObjectFactory<Offer> offerFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Offer convert(final OfferModel source) {
        Offer offer = offerFactory.getObject();
        BeanUtils.copyProperties(source, offer);
        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfig> converted = (List<OfferConfig>) conversionService.convert(source.getOfferConfigModels(),
                    TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfig.class));
            offer.getOfferConfigs().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigModels())) {
            List<OfferExcludeConfig> converted = (List<OfferExcludeConfig>) conversionService.convert(source.getOfferExcludeConfigModels(),
                    TypeDescriptor.forObject(source.getOfferExcludeConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfig.class));
            offer.getOfferExcludeConfigs().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getBankOfferModels())) {
            List<BankOffer> converted = (List<BankOffer>) conversionService.convert(source.getBankOfferModels(),
                    TypeDescriptor.forObject(source.getBankOfferModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), BankOffer.class));
            offer.getBankOffers().addAll(converted);
        }

        return offer;
    }

    @Autowired
    public void setOfferFactory(final ObjectFactory<Offer> offerFactory) {
        this.offerFactory = offerFactory;
    }

}
