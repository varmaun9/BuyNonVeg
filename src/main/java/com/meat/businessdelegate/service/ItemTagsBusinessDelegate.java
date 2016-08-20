/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Item;
import com.meat.domain.ItemTags;
import com.meat.domain.Tags;
import com.meat.model.ItemTagsModel;
import com.meat.service.IItemTagsService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ItemTagsBusinessDelegate implements IBusinessDelegate<ItemTagsModel, ItemTagsContext, IKeyBuilder<String>, String> {

    @Autowired
    private IItemTagsService itemTagsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemTagsModel create(final ItemTagsModel model) {
        ItemTags itemTags = new ItemTags();
        itemTags.setId(model.getId());
        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        itemTags.setTags(tags);
        Item item = new Item();
        item.setId(model.getItemId());
        itemTags.setItem(item);
        itemTags.setItemTagsStatus(model.getItemTagsStatus());
        itemTags = itemTagsService.create(itemTags);
        model.setId(itemTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ItemTagsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemTagsModel edit(final IKeyBuilder<String> keyBuilder, final ItemTagsModel model) {
        ItemTags itemTags = itemTagsService.getItemTags(keyBuilder.build().toString());
        itemTags.setId(model.getId());
        Tags tags = new Tags();
        tags.setId(model.getTagsId());
        itemTags.setTags(tags);
        Item item = new Item();
        item.setId(model.getItemId());
        itemTags.setItem(item);
        itemTags.setItemTagsStatus(model.getItemTagsStatus());
        itemTags = itemTagsService.updateItemTags(itemTags);
        model.setId(itemTags.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ItemTagsModel getByKey(final IKeyBuilder<String> keyBuilder, final ItemTagsContext context) {
        ItemTags itemTags = itemTagsService.getItemTags(keyBuilder.build().toString());
        ItemTagsModel itemTagsModel = conversionService.convert(itemTags, ItemTagsModel.class);
        return itemTagsModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ItemTagsModel> getCollection(final ItemTagsContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}