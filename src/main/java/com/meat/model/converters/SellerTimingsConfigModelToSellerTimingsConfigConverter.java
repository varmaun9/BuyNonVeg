/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerTimingsConfig;
import com.meat.model.SellerTimingsConfigModel;

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
@Component("sellerTimingsConfigModelToSellerTimingsConfigConverter")
public class SellerTimingsConfigModelToSellerTimingsConfigConverter implements Converter<SellerTimingsConfigModel, SellerTimingsConfig> {
    @Autowired
    private ObjectFactory<SellerTimingsConfig> sellerTimingsConfigFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerTimingsConfig convert(final SellerTimingsConfigModel source) {
        SellerTimingsConfig sellerTimingsConfig = sellerTimingsConfigFactory.getObject();
        BeanUtils.copyProperties(source, sellerTimingsConfig);

        return sellerTimingsConfig;
    }

    @Autowired
    public void setSellerTimingsConfigFactory(final ObjectFactory<SellerTimingsConfig> sellerTimingsConfigFactory) {
        this.sellerTimingsConfigFactory = sellerTimingsConfigFactory;
    }

}
