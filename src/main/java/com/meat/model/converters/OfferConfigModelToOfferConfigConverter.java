/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OfferConfig;
import com.meat.domain.UsersOffer;
import com.meat.model.OfferConfigModel;
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
@Component("offerConfigModelToOfferConfigConverter")
public class OfferConfigModelToOfferConfigConverter implements Converter<OfferConfigModel, OfferConfig> {
    @Autowired
    private ObjectFactory<OfferConfig> offerConfigFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferConfig convert(final OfferConfigModel source) {
        OfferConfig offerConfig = offerConfigFactory.getObject();
        BeanUtils.copyProperties(source, offerConfig);

        if (CollectionUtils.isNotEmpty(source.getUsersOfferModels())) {
            List<UsersOffer> converted = (List<UsersOffer>) conversionService.convert(source.getUsersOfferModels(),
                    TypeDescriptor.forObject(source.getUsersOfferModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersOffer.class));
            offerConfig.getUsersOffers().addAll(converted);
        }

        return offerConfig;
    }

    @Autowired
    public void setOfferConfigFactory(final ObjectFactory<OfferConfig> offerConfigFactory) {
        this.offerConfigFactory = offerConfigFactory;
    }

}
