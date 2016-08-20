/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Attributes;
import com.meat.domain.CategoryAttributes;
import com.meat.domain.Item;
import com.meat.domain.ItemAttributes;
import com.meat.model.ItemAttributesModel;
import com.meat.service.IItemAttributesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class ItemAttributesBusinessDelegate
        implements IBusinessDelegate<ItemAttributesModel, ItemAttributesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IItemAttributesService itemAttributesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemAttributesModel create(final ItemAttributesModel model) {
        ItemAttributes itemAttributes = new ItemAttributes();
        itemAttributes.setId(model.getId());
        itemAttributes.setAttributeValue(model.getAttributeValue());
        itemAttributes.setStatus(model.getStatus());
        Attributes attributes = new Attributes();
        attributes.setId(model.getAttributesId());
        itemAttributes.setAttributes(attributes);
        CategoryAttributes catAtt = new CategoryAttributes();
        catAtt.setId(model.getCategoryAttributesId());
        itemAttributes.setCategoryAttributes(catAtt);
        Item item = new Item();
        item.setId(model.getItemId());
        itemAttributes.setItem(item);
        itemAttributes = itemAttributesService.create(itemAttributes);
        model.setId(itemAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ItemAttributesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemAttributesModel edit(final IKeyBuilder<String> keyBuilder, final ItemAttributesModel model) {
        ItemAttributes itemAttributes = itemAttributesService.getItemAttributes(keyBuilder.build().toString());
        itemAttributes.setId(model.getId());
        itemAttributes.setAttributeValue(model.getAttributeValue());
        itemAttributes.setStatus(model.getStatus());
        Attributes attributes = new Attributes();
        attributes.setId(model.getAttributesId());
        itemAttributes.setAttributes(attributes);
        CategoryAttributes catAtt = new CategoryAttributes();
        catAtt.setId(model.getCategoryAttributesId());
        itemAttributes.setCategoryAttributes(catAtt);
        Item item = new Item();
        item.setId(model.getItemId());
        itemAttributes.setItem(item);
        itemAttributes = itemAttributesService.updateItemAttributes(itemAttributes);
        model.setId(itemAttributes.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ItemAttributesModel getByKey(final IKeyBuilder<String> keyBuilder, final ItemAttributesContext context) {
        ItemAttributes itemAttributes = itemAttributesService.getItemAttributes(keyBuilder.build().toString());
        ItemAttributesModel itemAttributesModel = conversionService.convert(itemAttributes, ItemAttributesModel.class);
        return itemAttributesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ItemAttributesModel> getCollection(final ItemAttributesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}