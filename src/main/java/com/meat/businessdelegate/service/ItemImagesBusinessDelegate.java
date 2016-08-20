/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Item;
import com.meat.domain.ItemImages;
import com.meat.model.ItemImagesModel;
import com.meat.service.IItemImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ItemImagesBusinessDelegate implements IBusinessDelegate<ItemImagesModel, ItemImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IItemImagesService itemImagesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemImagesModel create(final ItemImagesModel model) {
        ItemImages itemImages = new ItemImages();
        Item item = new Item();
        item.setId(model.getItemId());
        itemImages.setItem(item);
        itemImages.setId(model.getId());
        itemImages.setImageLocation(model.getImageLocation());
        itemImages.setImageName(model.getImageName());
        itemImages.setImageType(model.getImageType());
        itemImages = itemImagesService.create(itemImages);
        model.setId(itemImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ItemImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemImagesModel edit(final IKeyBuilder<String> keyBuilder, final ItemImagesModel model) {
        ItemImages itemImages = itemImagesService.getItemImages(keyBuilder.build().toString());
        Item item = new Item();
        item.setId(model.getItemId());
        itemImages.setItem(item);
        itemImages.setId(model.getId());
        itemImages.setImageLocation(model.getImageLocation());
        itemImages.setImageName(model.getImageName());
        itemImages.setImageType(model.getImageType());
        itemImages = itemImagesService.updateItemImages(itemImages);
        model.setId(itemImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ItemImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final ItemImagesContext context) {
        ItemImages itemImages = itemImagesService.getItemImages(keyBuilder.build().toString());
        ItemImagesModel itemImagesModel = conversionService.convert(itemImages, ItemImagesModel.class);
        return itemImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ItemImagesModel> getCollection(final ItemImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}