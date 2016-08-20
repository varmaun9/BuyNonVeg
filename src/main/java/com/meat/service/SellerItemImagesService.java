/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerItemImagesRepository;
import com.meat.domain.SellerItemImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerItemImagesService implements ISellerItemImagesService {
    @Autowired
    private SellerItemImagesRepository sellerItemImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemImagesService#create(com.meat.domain.SellerItemImages)
     */
    @Override
    public SellerItemImages create(final SellerItemImages sellerItemImages) {
        // TODO Auto-generated method stub
        return sellerItemImagesRepository.save(sellerItemImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemImagesService#deleteSellerItemImages(java.lang.String)
     */
    @Override
    public void deleteSellerItemImages(final String sellerItemImagesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemImagesService#getAll()
     */
    @Override
    public List<SellerItemImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemImagesService#getSellerItemImages(java.lang.String)
     */
    @Override
    public SellerItemImages getSellerItemImages(final String sellerItemImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemImagesService#updateSellerItemImages(com.meat.domain.SellerItemImages)
     */
    @Override
    public SellerItemImages updateSellerItemImages(final SellerItemImages sellerItemImages) {
        // TODO Auto-generated method stub
        return sellerItemImagesRepository.save(sellerItemImages);
    }

}
