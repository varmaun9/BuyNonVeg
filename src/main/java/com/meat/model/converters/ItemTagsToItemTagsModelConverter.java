package com.meat.model.converters;

import com.meat.domain.ItemTags;
import com.meat.model.ItemTagsModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemTagsToItemTagsModelConverter")
public class ItemTagsToItemTagsModelConverter implements Converter<ItemTags, ItemTagsModel> {

    private static final Logger LOGGER = Logger.getLogger(ItemTagsToItemTagsModelConverter.class);
    @Autowired
    private ObjectFactory<ItemTagsModel> itemTagsModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ItemTagsModel convert(final ItemTags source) {
        // TODO Auto-generated method stub
        ItemTagsModel itemTagsModel = itemTagsModelFactory.getObject();

        BeanUtils.copyProperties(source, itemTagsModel);
        itemTagsModel.setId(source.getId());
        if (source.getTags() != null) {
            itemTagsModel.setTagsId(source.getTags().getId());
            itemTagsModel.setTagTypeName(source.getTags().getTagType().getTagTypeName());
            itemTagsModel.setTagName(source.getTags().getTagName());
        }

        if (source.getItem() != null) {
            itemTagsModel.setItemId(source.getItem().getId());
            itemTagsModel.setItemName(source.getItem().getItemName());
        }

        return itemTagsModel;

    }

    @Autowired
    public void setItemTagsFactory(final ObjectFactory<ItemTagsModel> itemTagsModelFactory) {
        this.itemTagsModelFactory = itemTagsModelFactory;
    }

}
