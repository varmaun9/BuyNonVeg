/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.BankOffer;
import com.meat.domain.OfferConfig;
import com.meat.model.BankOfferModel;
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
 * @author arthvedi
 *
 */
@Component("bankOfferModelToBankOfferConverter")
public class BankOfferModelToBankOfferConverter implements Converter<BankOfferModel, BankOffer> {
    @Autowired
    private ObjectFactory<BankOffer> bankOfferFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public BankOffer convert(final BankOfferModel source) {
        BankOffer bankOffer = bankOfferFactory.getObject();
        BeanUtils.copyProperties(source, bankOffer);

        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfig> converted = (List<OfferConfig>) conversionService.convert(source.getOfferConfigModels(),
                    TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfig.class));
            bankOffer.getOfferConfigs().addAll(converted);
        }

        return bankOffer;
    }

    @Autowired
    public void setBankOfferFactory(final ObjectFactory<BankOffer> bankOfferFactory) {
        this.bankOfferFactory = bankOfferFactory;
    }

}
