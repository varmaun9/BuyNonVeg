/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerImagesRepository;
import com.meat.domain.SellerImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component
public class SellerImagesService implements ISellerImagesService {
    @Autowired
    private SellerImagesRepository sellerImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerImagesService#create(com.meat.domain.SellerImages)
     */
    @Override
    public SellerImages create(final SellerImages sellerImages) {
        // TODO Auto-generated method stub
        return sellerImagesRepository.save(sellerImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerImagesService#deleteSellerImages(java.lang.String)
     */
    @Override
    public void deleteSellerImages(final String sellerImagesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerImagesService#getAll()
     */
    @Override
    public List<SellerImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerImagesService#getSellerImages(java.lang.String)
     */
    @Override
    public SellerImages getSellerImages(final String sellerImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerImagesService#updateSellerImages(com.meat.domain.SellerImages)
     */
    @Override
    public SellerImages updateSellerImages(final SellerImages sellerImages) {
        // TODO Auto-generated method stub
        return sellerImagesRepository.save(sellerImages);
    }

}
