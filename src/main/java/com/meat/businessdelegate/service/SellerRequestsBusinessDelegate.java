/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerRequests;
import com.meat.model.SellerRequestsModel;
import com.meat.service.ISellerRequestsService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class SellerRequestsBusinessDelegate implements
        IBusinessDelegate<SellerRequestsModel, SellerRequestsContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerRequestsService sellerRequestsService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerRequestsModel create(final SellerRequestsModel model) {
        SellerRequests sellerRequests = new SellerRequests();
        sellerRequests.setId(model.getId());
        sellerRequests.setRequestName(model.getRequestName());
        sellerRequests.setRequestType(model.getRequestType());
        sellerRequests.setRequestStatus(model.getRequestStatus());
        sellerRequests.setDescription(model.getDescription());
        sellerRequests.setRequestDate(new Date());
        sellerRequests.setUserCreated(model.getUserCreated());
        sellerRequests.setDateCreated(new Date());
        model.setId(sellerRequests.getId());
        sellerRequests = sellerRequestsService.create(sellerRequests);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerRequestsContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerRequestsModel edit(final IKeyBuilder<String> keyBuilder, final SellerRequestsModel model) {
        SellerRequests sellerRequests = new SellerRequests();
        sellerRequests.setId(model.getId());
        sellerRequests.setRequestName(model.getRequestName());
        sellerRequests.setRequestType(model.getRequestType());
        sellerRequests.setRequestStatus(model.getRequestStatus());
        sellerRequests.setDescription(model.getDescription());
        sellerRequests.setRequestDate(new Date());
        sellerRequests.setUserCreated(model.getUserCreated());
        sellerRequests.setDateCreated(new Date());
        model.setId(sellerRequests.getId());
        sellerRequests = sellerRequestsService.updateSellerRequests(sellerRequests);
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerRequestsModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerRequestsContext context) {
        SellerRequests sellerRequests = sellerRequestsService.getSellerRequests(keyBuilder.build().toString());
        SellerRequestsModel sellerRequestsModel = conversionService.convert(sellerRequests, SellerRequestsModel.class);
        return sellerRequestsModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerRequestsModel> getCollection(final SellerRequestsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
