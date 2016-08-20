/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchImages;
import com.meat.model.SellerBranchImagesModel;
import com.meat.service.ISellerBranchImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SellerBranchImagesBusinessDelegate implements
IBusinessDelegate<SellerBranchImagesModel, SellerBranchImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBranchImagesService sellerBranchImagesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchImagesModel create(final SellerBranchImagesModel model) {

        SellerBranchImages sellerBranchImages = new SellerBranchImages();
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchImages.setSellerBranch(sellerBranch);
        sellerBranchImages.setImageName(model.getImageName());
        sellerBranchImages.setImageType(model.getImageType());
        sellerBranchImages.setImageLocation(model.getImageLocation());
        sellerBranchImages = sellerBranchImagesService.create(sellerBranchImages);
        model.setId(sellerBranchImages.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchImagesModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchImagesModel model) {
        SellerBranchImages sellerBranchImages = sellerBranchImagesService.getSellerBranchImages(keyBuilder.build().toString());

        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchImages.setSellerBranch(sellerBranch);
        sellerBranchImages.setImageName(model.getImageName());
        sellerBranchImages.setImageType(model.getImageType());
        sellerBranchImages.setImageLocation(model.getImageLocation());
        sellerBranchImages = sellerBranchImagesService.updateSellerBranchImages(sellerBranchImages);
        model.setId(sellerBranchImages.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchImagesContext context) {
        SellerBranchImages sellerBranchImages = sellerBranchImagesService.getSellerBranchImages(keyBuilder.build().toString());
        SellerBranchImagesModel sellerBranchImagesModel = conversionService.convert(sellerBranchImages, SellerBranchImagesModel.class);

        return sellerBranchImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchImagesModel> getCollection(final SellerBranchImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
