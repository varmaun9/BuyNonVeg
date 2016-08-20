package com.meat.model.converters;

import com.meat.domain.ItemTags;
import com.meat.model.ItemTagsModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemTagsModelModelToItemTagsModelConverter ")
public class ItemTagsModelModelToItemTagsModelConverter implements Converter<ItemTagsModel, ItemTags> {
    @Autowired
    private ObjectFactory<ItemTags> itemTagsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemTags convert(final ItemTagsModel source) {
        ItemTags itemTagsAddress = itemTagsFactory.getObject();
        BeanUtils.copyProperties(source,itemTagsAddress);

        return itemTagsAddress;
    }

    @Autowired
    public void setItemTagsFactory(final ObjectFactory<ItemTags> itemTagsFactory) {
        this.itemTagsFactory = itemTagsFactory;
    }

}
