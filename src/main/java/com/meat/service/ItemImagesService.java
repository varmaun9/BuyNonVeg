/**
 *
 */
package com.meat.service;

import com.meat.dao.ItemImagesRepository;
import com.meat.domain.ItemImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class ItemImagesService implements IItemImagesService {
    @Autowired
    private ItemImagesRepository itemImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#create(com.meat.domain.ItemImages)
     */
    @Override
    public ItemImages create(final ItemImages itemImages) {
        // TODO Auto-generated method stub
        return itemImagesRepository.save(itemImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#deleteItemImages(java.lang.String)
     */
    @Override
    public void deleteItemImages(final String itemImagesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#getAll()
     */
    @Override
    public List<ItemImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#getItemImages(java.lang.String)
     */
    @Override
    public ItemImages getItemImages(final String itemImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#getItemImagesByItem(java.lang.String)
     */
    @Override
    public List<ItemImages> getItemImagesByItem(final String itemId) {
        // TODO Auto-generated method stub
        return itemImagesRepository.findItemImagesByItem(itemId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IItemImagesService#updateItemImages(com.meat.domain.ItemImages)
     */
    @Override
    public ItemImages updateItemImages(final ItemImages itemImages) {
        // TODO Auto-generated method stub
        return itemImagesRepository.save(itemImages);
    }

}
