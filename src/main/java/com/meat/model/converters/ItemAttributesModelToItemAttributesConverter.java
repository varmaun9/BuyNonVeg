package com.meat.model.converters;

import com.meat.domain.ItemAttributes;
import com.meat.model.ItemAttributesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemAttributesModelToItemAttributesConverter")
public class ItemAttributesModelToItemAttributesConverter implements Converter<ItemAttributesModel, ItemAttributes> {
    @Autowired
    private ObjectFactory<ItemAttributes> temAttributesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemAttributes convert(final ItemAttributesModel source) {
        ItemAttributes temAttributes = temAttributesFactory.getObject();
        BeanUtils.copyProperties(source, temAttributes);

        return temAttributes;
    }

    @Autowired
    public void setItemAttributesFactory(final ObjectFactory<ItemAttributes> temAttributesFactory) {
        this.temAttributesFactory = temAttributesFactory;
    }

}
