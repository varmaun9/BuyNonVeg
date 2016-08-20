/**
 *
 */
package com.meat.service;


import com.meat.dao.SellerBranchImagesRepository;
import com.meat.domain.SellerBranchImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component
public class SellerBranchImagesService implements ISellerBranchImagesService {
    @Autowired
    private SellerBranchImagesRepository sellerBranchImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchImagesService#create(com.meat.domain.SellerBranchImages)
     */
    @Override
    public SellerBranchImages create(SellerBranchImages sellerBranchImages) {
        // TODO Auto-generated method stub
        return sellerBranchImagesRepository.save(sellerBranchImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchImagesService#deleteSellerBranchImages(java.lang.String)
     */
    @Override
    public void deleteSellerBranchImages(String sellerBranchImagesId) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchImagesService#getAll()
     */
    @Override
    public List<SellerBranchImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchImagesService#getSellerBranchImages(java.lang.String)
     */
    @Override
    public SellerBranchImages getSellerBranchImages(String sellerBranchImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchImagesService#updateSellerBranchImages(com.meat.domain.SellerBranchImages)
     */
    @Override
    public SellerBranchImages updateSellerBranchImages(SellerBranchImages sellerBranchImages) {
        // TODO Auto-generated method stub
        return sellerBranchImagesRepository.save(sellerBranchImages);
    }

   
}
