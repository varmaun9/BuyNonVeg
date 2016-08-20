/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OfferExcludeConfig;
import com.meat.model.OfferExcludeConfigModel;

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
@Component("offerExcludeConfigModelToOfferExcludeConfigConverter")
public class OfferExcludeConfigModelToOfferExcludeConfigConverter implements Converter<OfferExcludeConfigModel, OfferExcludeConfig> {
    @Autowired
    private ObjectFactory<OfferExcludeConfig> offerExcludeConfigFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public OfferExcludeConfig convert(final OfferExcludeConfigModel source) {
        OfferExcludeConfig offerExcludeConfig = offerExcludeConfigFactory.getObject();
        BeanUtils.copyProperties(source, offerExcludeConfig);
        offerExcludeConfig.setStatus(source.getStatus());
        return offerExcludeConfig;
    }

    @Autowired
    public void setOfferExcludeConfigFactory(final ObjectFactory<OfferExcludeConfig> offerExcludeConfigFactory) {
        this.offerExcludeConfigFactory = offerExcludeConfigFactory;
    }

}
