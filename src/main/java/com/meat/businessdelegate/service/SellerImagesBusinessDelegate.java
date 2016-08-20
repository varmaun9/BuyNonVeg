/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.model.SellerImagesModel;
import com.meat.service.ISellerImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */

@Service
public class SellerImagesBusinessDelegate implements IBusinessDelegate<SellerImagesModel, SellerImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerImagesService sellerImagesService;
    @Autowired
    private ConversionService conversionService;
    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerImagesModel create(SellerImagesModel model) {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder, com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(IKeyBuilder<String> keyBuilder, SellerImagesContext context) {
        // TODO Auto-generated method stub
        
    }
    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder, com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerImagesModel edit(IKeyBuilder<String> keyBuilder, SellerImagesModel model) {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder, com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerImagesModel getByKey(IKeyBuilder<String> keyBuilder, SellerImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerImagesModel> getCollection(SellerImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }
}
