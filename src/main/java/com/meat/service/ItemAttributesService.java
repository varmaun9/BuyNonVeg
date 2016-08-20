/**
 *
 */
package com.meat.service;

import com.meat.dao.ItemAttributesRepository;
import com.meat.domain.ItemAttributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi1
 *
 */

@Component
public class ItemAttributesService implements IItemAttributesService {
    @Autowired
    private ItemAttributesRepository itemAttributesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#create(com.meat.domain.ItemAttributes)
     */
    @Override
    public ItemAttributes create(final ItemAttributes itemAttributes) {
        // TODO Auto-generated method stub
        return itemAttributesRepository.save(itemAttributes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#deleteItemAttributes(java.lang.String)
     */
    @Override
    public void deleteItemAttributes(final String itemAttributesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#getAll()
     */
    @Override
    public List<ItemAttributes> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#getItemAttributes(java.lang.String)
     */
    @Override
    public ItemAttributes getItemAttributes(final String itemAttributesId) {
        // TODO Auto-generated method stub
        return itemAttributesRepository.findOne(itemAttributesId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#getItemAttributesByThymeleafCategory(java.lang.String)
     */
    @Override
    public List<ItemAttributes> getItemAttributesByThymeleafCategory(final String categoryId) {
        // TODO Auto-generated method stub
        return itemAttributesRepository.findItemAttributesByThymeleafCategory(categoryId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#getItemAttributesByThymeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public List<ItemAttributes> getItemAttributesByThymeleafCategoryZone(final String categoryId, final String zoneId) {
        // TODO Auto-generated method stub
        return itemAttributesRepository.findItemAttributesByThymeleafCategoryZone(categoryId, zoneId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemAttributesService#updateItemAttributes(com.meat.domain.ItemAttributes)
     */
    @Override
    @Transactional
    public ItemAttributes updateItemAttributes(final ItemAttributes itemAttributes) {
        // TODO Auto-generated method stub
        return itemAttributesRepository.save(itemAttributes);
    }

}
