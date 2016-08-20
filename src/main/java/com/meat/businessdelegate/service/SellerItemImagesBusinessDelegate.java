/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerItem;
import com.meat.domain.SellerItemImages;
import com.meat.model.SellerItemImagesModel;
import com.meat.service.ISellerItemImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SellerItemImagesBusinessDelegate implements
        IBusinessDelegate<SellerItemImagesModel, SellerItemImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerItemImagesService sellerItemImagesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemImagesModel create(final SellerItemImagesModel model) {
        SellerItemImages sellerItemImages = new SellerItemImages();
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        sellerItemImages.setSellerItem(sellerItem);
        sellerItemImages.setImageName(model.getImageName());
        sellerItemImages.setImageLocation(model.getImageLocation());
        sellerItemImages.setImageType(model.getImageType());
        sellerItemImages = sellerItemImagesService.create(sellerItemImages);
        model.setId(sellerItemImages.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerItemImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemImagesModel edit(final IKeyBuilder<String> keyBuilder, final SellerItemImagesModel model) {
        SellerItemImages sellerItemImages = sellerItemImagesService.getSellerItemImages(keyBuilder.build().toString());

        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        sellerItemImages.setSellerItem(sellerItem);
        sellerItemImages.setImageName(model.getImageName());
        sellerItemImages.setImageLocation(model.getImageLocation());
        sellerItemImages.setImageType(model.getImageType());
        sellerItemImages = sellerItemImagesService.updateSellerItemImages(sellerItemImages);
        model.setId(sellerItemImages.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerItemImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerItemImagesContext context) {
        SellerItemImages sellerItemImages = sellerItemImagesService.getSellerItemImages(keyBuilder.build().toString());
        SellerItemImagesModel sellerItemImagesModel = conversionService.convert(sellerItemImages, SellerItemImagesModel.class);

        return sellerItemImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerItemImagesModel> getCollection(final SellerItemImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
