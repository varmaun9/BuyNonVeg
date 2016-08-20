/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OfferExcludeConfig;
import com.meat.model.OfferExcludeConfigModel;

import org.apache.log4j.Logger;
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
@Component("offerExcludeConfigToOfferExcludeConfigModelConverter")
public class OfferExcludeConfigToOfferExcludeConfigModelConverter implements Converter<OfferExcludeConfig, OfferExcludeConfigModel> {

    private static final Logger LOGGER = Logger.getLogger(OfferExcludeConfigToOfferExcludeConfigModelConverter.class);
    @Autowired
    private ObjectFactory<OfferExcludeConfigModel> offerExcludeConfigModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public OfferExcludeConfigModel convert(final OfferExcludeConfig source) {
        // TODO Auto-generated method stub
        OfferExcludeConfigModel offerExcludeConfigModel = offerExcludeConfigModelFactory.getObject();

        BeanUtils.copyProperties(source, offerExcludeConfigModel);

        return offerExcludeConfigModel;

    }

    @Autowired
    public void setOfferExcludeConfigFactory(final ObjectFactory<OfferExcludeConfigModel> offerExcludeConfigModelFactory) {
        this.offerExcludeConfigModelFactory = offerExcludeConfigModelFactory;
    }

}
