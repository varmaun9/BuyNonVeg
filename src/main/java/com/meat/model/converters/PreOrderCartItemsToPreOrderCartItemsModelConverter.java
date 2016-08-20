/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.PreOrderCartItems;
import com.meat.model.PreOrderCartItemsModel;

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
@Component("preOrderCartItemsToPreOrderCartItemsModelConverter")
public class PreOrderCartItemsToPreOrderCartItemsModelConverter implements Converter<PreOrderCartItems, PreOrderCartItemsModel> {

    @Autowired
    private ObjectFactory<PreOrderCartItemsModel> preOrderCartItemsModelFactory;
    private static final Logger LOGGER = Logger.getLogger(PreOrderCartItemsToPreOrderCartItemsModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public PreOrderCartItemsModel convert(final PreOrderCartItems source) {
        // TODO Auto-generated method stub
        PreOrderCartItemsModel preOrderCartItemsModel = preOrderCartItemsModelFactory.getObject();

        BeanUtils.copyProperties(source, preOrderCartItemsModel);

        return preOrderCartItemsModel;

    }

    @Autowired
    public void setPreOrderCartItemsFactory(final ObjectFactory<PreOrderCartItemsModel> preOrderCartItemsModelFactory) {
        this.preOrderCartItemsModelFactory = preOrderCartItemsModelFactory;
    }

}
