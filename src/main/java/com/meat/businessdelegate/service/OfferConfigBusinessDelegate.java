/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.*;
import com.meat.model.OfferConfigModel;
import com.meat.service.IOfferConfigService;

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
public class OfferConfigBusinessDelegate implements IBusinessDelegate<OfferConfigModel, OfferConfigContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOfferConfigService offerConfigService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferConfigModel create(final OfferConfigModel model) {
        OfferConfig offerConfig = new OfferConfig();
        offerConfig.setId(model.getId());
        if (model.getOfferId() != null) {
            Offer offer = new Offer();
            offer.setId(model.getOfferId());
            offerConfig.setOffer(offer);
        }
        if (model.getCategoryId() != null) {
            Category cat = new Category();
            cat.setId(model.getCategoryId());
            offerConfig.setCategory(cat);
        }
        if (model.getItemId() != null) {
            Item i = new Item();
            i.setId(model.getItemId());
            offerConfig.setItem(i);
        }
        if (model.getBankOfferId() != null) {
            BankOffer bo = new BankOffer();
            bo.setId(model.getBankOfferId());
            offerConfig.setBankOffer(bo);
        }
        if (model.getSellerBranchId() != null) {
            SellerBranch sb = new SellerBranch();
            sb.setId(model.getSellerBranchId());
            offerConfig.setSellerBranch(sb);
        }
        if (model.getSellerId() != null) {
            Seller s = new Seller();
            s.setId(model.getSellerId());
            offerConfig.setSeller(s);
        }
        if (model.getSellerItemId() != null) {
            SellerItem si = new SellerItem();
            si.setId(model.getSellerItemId());
            offerConfig.setSellerItem(si);
        }
        if (model.getSubCategoryId() != null) {
            SubCategory subC = new SubCategory();
            subC.setId(model.getSubCategoryId());
            offerConfig.setSubCategory(subC);
        }
        if (model.getTagsId() != null) {
            Tags tags = new Tags();
            tags.setId(model.getTagsId());
            offerConfig.setTags(tags);
        }
        offerConfig.setStatus(model.getStatus());
        // offerConfig.setStatusFlag(model.getStatusFlag());
        offerConfig.setPlacedByStatus(model.getPlacedByStatus());
        offerConfig.setOfferAttributeName(model.getOfferAttributeName());
        offerConfig.setOfferAttributeValue(model.getOfferAttributeValue());

        offerConfig = offerConfigService.create(offerConfig);

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OfferConfigContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferConfigModel edit(final IKeyBuilder<String> keyBuilder, final OfferConfigModel model) {
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
    public OfferConfigModel getByKey(final IKeyBuilder<String> keyBuilder, final OfferConfigContext context) {
        OfferConfig offerConfig = offerConfigService.getOfferConfig(keyBuilder.build().toString());
        OfferConfigModel offerConfigModel = conversionService.convert(offerConfig, OfferConfigModel.class);
        return offerConfigModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OfferConfigModel> getCollection(final OfferConfigContext context) {
        List<OfferConfig> offerConfig = new ArrayList<OfferConfig>();

        if (context.getAll() != null) {
            offerConfig = offerConfigService.getAll();
        }
        List<OfferConfigModel> offerConfigModels = (List<OfferConfigModel>) conversionService.convert(offerConfig,
                TypeDescriptor.forObject(offerConfig),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OfferConfigModel.class)));
        return offerConfigModels;
    }

}
