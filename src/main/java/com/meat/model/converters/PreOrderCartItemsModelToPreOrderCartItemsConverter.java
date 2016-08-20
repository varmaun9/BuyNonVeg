/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.PreOrderCartItems;
import com.meat.model.PreOrderCartItemsModel;

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
@Component("preOrderCartItemsModelToPreOrderCartItemsConverter")
public class PreOrderCartItemsModelToPreOrderCartItemsConverter implements Converter<PreOrderCartItemsModel, PreOrderCartItems> {
    @Autowired
    private ObjectFactory<PreOrderCartItems> preOrderCartItemsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public PreOrderCartItems convert(final PreOrderCartItemsModel source) {
        PreOrderCartItems preOrderCartItems = preOrderCartItemsFactory.getObject();
        BeanUtils.copyProperties(source, preOrderCartItems);

        return preOrderCartItems;
    }

    @Autowired
    public void setPreOrderCartItemsFactory(final ObjectFactory<PreOrderCartItems> preOrderCartItemsFactory) {
        this.preOrderCartItemsFactory = preOrderCartItemsFactory;
    }

}
