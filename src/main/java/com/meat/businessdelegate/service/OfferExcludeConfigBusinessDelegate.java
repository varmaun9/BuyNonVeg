/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.*;
import com.meat.model.OfferExcludeConfigModel;
import com.meat.service.IOfferExcludeConfigService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class OfferExcludeConfigBusinessDelegate
        implements IBusinessDelegate<OfferExcludeConfigModel, OfferExcludeConfigContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOfferExcludeConfigService offerExcludeConfigService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferExcludeConfigModel create(final OfferExcludeConfigModel model) {
        OfferExcludeConfig offerExcludeConfig = new OfferExcludeConfig();
        offerExcludeConfig.setId(model.getId());
        if (model.getCategoryId() != null) {
            Category cat = new Category();
            cat.setId(model.getCategoryId());
            offerExcludeConfig.setCategory(cat);
        }
        if (model.getItemId() != null) {
            Item it = new Item();
            it.setId(model.getItemId());
            offerExcludeConfig.setItem(it);
        }
        if (model.getOfferId() != null) {
            Offer of = new Offer();
            of.setId(model.getOfferId());
            offerExcludeConfig.setOffer(of);
        }
        if (model.getSellerBranchId() != null) {
            SellerBranch sb = new SellerBranch();
            sb.setId(model.getSellerBranchId());
            offerExcludeConfig.setSellerBranch(sb);
        }
        if (model.getSellerId() != null) {
            Seller seller = new Seller();
            seller.setId(model.getSellerId());
            offerExcludeConfig.setSeller(seller);
        }
        if (model.getSellerItemId() != null) {
            SellerItem sellerItem = new SellerItem();
            sellerItem.setId(model.getSellerItemId());
            offerExcludeConfig.setSellerItem(sellerItem);
        }
        if (model.getTagsId() != null) {
            Tags tags = new Tags();
            tags.setId(model.getTagsId());
            offerExcludeConfig.setTags(tags);
        }
        if (model.getSubCategoryId() != null) {
            SubCategory subCat = new SubCategory();
            subCat.setId(model.getSubCategoryId());
            offerExcludeConfig.setSubCategory(subCat);
        }
        model.setId(offerExcludeConfig.getId());
        model.setOfferId(offerExcludeConfig.getOffer().getId());

        offerExcludeConfig = offerExcludeConfigService.create(offerExcludeConfig);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OfferExcludeConfigContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferExcludeConfigModel edit(final IKeyBuilder<String> keyBuilder, final OfferExcludeConfigModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OfferExcludeConfigModel getByKey(final IKeyBuilder<String> keyBuilder, final OfferExcludeConfigContext context) {
        OfferExcludeConfig offerExcludeConfig = offerExcludeConfigService.getOfferExcludeConfig(keyBuilder.build().toString());
        OfferExcludeConfigModel offerExcludeConfigModel = conversionService.convert(offerExcludeConfig, OfferExcludeConfigModel.class);
        return offerExcludeConfigModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OfferExcludeConfigModel> getCollection(final OfferExcludeConfigContext context) {
        List<OfferExcludeConfig> offerExcludeConfig = new ArrayList<OfferExcludeConfig>();
        if (context.getAll() != null) {
            offerExcludeConfig = offerExcludeConfigService.getAll();
        }
        List<OfferExcludeConfigModel> offerExcludeConfigModels = (List<OfferExcludeConfigModel>) conversionService.convert(
                offerExcludeConfig, TypeDescriptor.forObject(offerExcludeConfig),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OfferExcludeConfigModel.class)));
        return offerExcludeConfigModels;
    }

}
