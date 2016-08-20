package com.meat.model.converters;

import com.meat.domain.ItemImages;
import com.meat.model.ItemImagesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemImagesModelToItemImagesConverter")
public class ItemImagesModelToItemImagesConverter implements Converter<ItemImagesModel, ItemImages> {
    @Autowired
    private ObjectFactory<ItemImages> itemImagesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemImages convert(final ItemImagesModel source) {
        ItemImages itemImages = itemImagesFactory.getObject();
        BeanUtils.copyProperties(source, itemImages);

        return itemImages;
    }

    @Autowired
    public void setItemImagesFactory(final ObjectFactory<ItemImages> itemImagesFactory) {
        this.itemImagesFactory = itemImagesFactory;
    }
}
