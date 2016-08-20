/**
 *
 */
package com.meat.service;

import com.meat.dao.ItemTagsRepository;
import com.meat.domain.ItemTags;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class ItemTagsService implements IItemTagsService {
    @Autowired
    private ItemTagsRepository itemTagsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemTagsService#create(com.meat.domain.ItemTags)
     */
    @Override
    public ItemTags create(final ItemTags itemTags) {
        // TODO Auto-generated method stub
        return itemTagsRepository.save(itemTags);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemTagsService#deleteItemTags(java.lang.String)
     */
    @Override
    public void deleteItemTags(final String itemTagsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemTagsService#getAll()
     */
    @Override
    public List<ItemTags> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemTagsService#getItemTags(java.lang.String)
     */
    @Override
    public ItemTags getItemTags(final String itemTagsId) {
        ItemTags itemTags = new ItemTags();
        itemTags = itemTagsRepository.findOne(itemTagsId);
        return itemTags;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemTagsService#updateItemTags(com.meat.domain.ItemTags)
     */
    @Override
    public ItemTags updateItemTags(final ItemTags itemTags) {
        // TODO Auto-generated method stub
        return itemTagsRepository.save(itemTags);
    }

}
