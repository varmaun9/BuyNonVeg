/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerTimingsConfig;
import com.meat.model.SellerTimingsConfigModel;

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
@Component("sellerTimingsConfigToSellerTimingsConfigModelConverter")
public class SellerTimingsConfigToSellerTimingsConfigModelConverter implements Converter<SellerTimingsConfig, SellerTimingsConfigModel> {

    @Autowired
    private ObjectFactory<SellerTimingsConfigModel> sellerTimingsConfigModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerTimingsConfigToSellerTimingsConfigModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerTimingsConfigModel convert(final SellerTimingsConfig source) {
        // TODO Auto-generated method stub
        SellerTimingsConfigModel sellerTimingsConfigModel = sellerTimingsConfigModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerTimingsConfigModel);

        return sellerTimingsConfigModel;

    }

    @Autowired
    public void setSellerTimingsConfigModelFactory(final ObjectFactory<SellerTimingsConfigModel> sellerTimingsConfigModelFactory) {
        this.sellerTimingsConfigModelFactory = sellerTimingsConfigModelFactory;
    }

}
