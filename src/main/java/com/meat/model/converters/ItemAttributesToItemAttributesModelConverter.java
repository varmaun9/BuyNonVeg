package com.meat.model.converters;

import com.meat.domain.ItemAttributes;
import com.meat.model.ItemAttributesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemAttributesToItemAttributesModelConverter")
public class ItemAttributesToItemAttributesModelConverter implements Converter<ItemAttributes, ItemAttributesModel> {

    private static final Logger LOGGER = Logger.getLogger(ItemAttributesToItemAttributesModelConverter.class);
    @Autowired
    private ObjectFactory<ItemAttributesModel> itemAttributesModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ItemAttributesModel convert(final ItemAttributes source) {
        // TODO Auto-generated method stub
        ItemAttributesModel itemAttributesModel = itemAttributesModelFactory.getObject();

        BeanUtils.copyProperties(source, itemAttributesModel);
        itemAttributesModel.setId(source.getId());
        if (source.getAttributes() != null) {
            itemAttributesModel.setAttributesId(source.getAttributes().getId());
            itemAttributesModel.setAttributeName(source.getAttributes().getAttributeName());
        }
        if (source.getCategoryAttributes() != null) {
            itemAttributesModel.setCategoryAttributesId(source.getCategoryAttributes().getId());
        }
        if (source.getItem() != null) {
            itemAttributesModel.setItemId(source.getItem().getId());

        }

        return itemAttributesModel;

    }

    @Autowired
    public void setItemAttributesFactory(final ObjectFactory<ItemAttributesModel> itemAttributesModelFactory) {
        this.itemAttributesModelFactory = itemAttributesModelFactory;
    }

}
