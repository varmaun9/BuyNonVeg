package com.meat.model.converters;

import com.meat.domain.ItemImages;
import com.meat.model.ItemImagesModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("entityBranchOfferToEntityBranchOfferModelConverter")
public class ItemImagesToItemImagesModelConverter implements Converter<ItemImages, ItemImagesModel> {

    @Autowired
    private ObjectFactory<ItemImagesModel> itemImagesModelFactory;
    private static final Logger LOGGER = Logger.getLogger(ItemImagesToItemImagesModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ItemImagesModel convert(final ItemImages source) {
        // TODO Auto-generated method stub
        ItemImagesModel itemImagesModel = itemImagesModelFactory.getObject();

        BeanUtils.copyProperties(source, itemImagesModel);

        return itemImagesModel;

    }

    @Autowired
    public void setItemImagesFactory(final ObjectFactory<ItemImagesModel> itemImagesModelFactory) {
        this.itemImagesModelFactory = itemImagesModelFactory;
    }

}
