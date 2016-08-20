/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Criteria;
import com.meat.domain.SellerItem;
import com.meat.domain.SellerItemCriteria;
import com.meat.model.SellerItemCriteriaModel;
import com.meat.service.ISellerItemCriteriaService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SellerItemCriteriaBusinessDelegate implements
IBusinessDelegate<SellerItemCriteriaModel, SellerItemCriteriaContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerItemCriteriaService sellerItemCriteriaService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemCriteriaModel create(final SellerItemCriteriaModel model) {
        SellerItemCriteria sellerItemCriteria = new SellerItemCriteria();
        sellerItemCriteria.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        sellerItemCriteria.setSellerItem(sellerItem);
        Criteria criteria = new Criteria();
        criteria.setId(model.getCriteriaId());
        sellerItemCriteria.setCriteria(criteria);
        sellerItemCriteria.setSellerItemCriteriaStatus(model.getSellerItemCriteriaStatus());
        sellerItemCriteria = sellerItemCriteriaService.create(sellerItemCriteria);
        model.setId(sellerItemCriteria.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerItemCriteriaContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemCriteriaModel edit(final IKeyBuilder<String> keyBuilder, final SellerItemCriteriaModel model) {
        SellerItemCriteria sellerItemCriteria = sellerItemCriteriaService.getSellerItemCriteria(keyBuilder.build().toString());
        sellerItemCriteria.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        sellerItemCriteria.setSellerItem(sellerItem);
        Criteria criteria = new Criteria();
        criteria.setId(model.getCriteriaId());
        sellerItemCriteria.setCriteria(criteria);
        sellerItemCriteria.setSellerItemCriteriaStatus(model.getSellerItemCriteriaStatus());
        sellerItemCriteria = sellerItemCriteriaService.updateSellerItemCriteria(sellerItemCriteria);
        model.setId(sellerItemCriteria.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerItemCriteriaModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerItemCriteriaContext context) {
        SellerItemCriteria sellerItemCriteria = sellerItemCriteriaService.getSellerItemCriteria(keyBuilder.build().toString());
        SellerItemCriteriaModel sellerItemCriteriaModel = conversionService.convert(sellerItemCriteria, SellerItemCriteriaModel.class);

        return sellerItemCriteriaModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerItemCriteriaModel> getCollection(final SellerItemCriteriaContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
