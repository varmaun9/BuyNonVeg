package com.meat.model.converters;

import com.meat.domain.SellerItemCriteria;
import com.meat.domain.SellerItemTax;
import com.meat.model.SellerItemCriteriaModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("sellerItemCriteriaToSellerItemCriteriaModelConverter")
public class SellerItemCriteriaToSellerItemCriteriaModelConverter implements Converter<SellerItemCriteria, SellerItemCriteriaModel> {

    @Autowired
    private ObjectFactory<SellerItemCriteriaModel> sellerItemCriteriaModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerItemCriteriaToSellerItemCriteriaModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerItemCriteriaModel convert(final SellerItemCriteria source) {
        // TODO Auto-generated method stub
        SellerItemCriteriaModel sellerItemCriteriaModel = sellerItemCriteriaModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerItemCriteriaModel);

       
        return sellerItemCriteriaModel;

    }

    @Autowired
    public void setSellerItemCriteriaFactory(final ObjectFactory<SellerItemCriteriaModel> sellerItemCriteriaModelFactory) {
        this.sellerItemCriteriaModelFactory = sellerItemCriteriaModelFactory;
    }

}
