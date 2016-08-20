package com.meat.model.converters;

import com.meat.domain.SellerItemCriteria;
import com.meat.model.SellerItemCriteriaModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerItemCriteriaModelToSellerItemCriteriaConverter")
public class SellerItemCriteriaModelToSellerItemCriteriaConverter implements Converter<SellerItemCriteriaModel, SellerItemCriteria> {
    @Autowired
    private ObjectFactory<SellerItemCriteria> sellerItemCriteriaFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemCriteria convert(final SellerItemCriteriaModel source) {
        SellerItemCriteria sellerItemCriteria = sellerItemCriteriaFactory.getObject();
        BeanUtils.copyProperties(source, sellerItemCriteria);

        return sellerItemCriteria;
    }

    @Autowired
    public void setSellerItemCriteriaFactory(final ObjectFactory<SellerItemCriteria> sellerItemCriteriaFactory) {
        this.sellerItemCriteriaFactory = sellerItemCriteriaFactory;
    }
}
