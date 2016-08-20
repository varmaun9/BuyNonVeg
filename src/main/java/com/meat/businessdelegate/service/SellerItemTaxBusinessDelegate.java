/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerItem;
import com.meat.domain.SellerItemTax;
import com.meat.model.SellerItemTaxModel;
import com.meat.service.ISellerItemTaxService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class SellerItemTaxBusinessDelegate
        implements IBusinessDelegate<SellerItemTaxModel, SellerItemTaxContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerItemTaxService sellerItemTaxService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemTaxModel create(final SellerItemTaxModel model) {
        SellerItemTax sellerItemTax = new SellerItemTax();
        sellerItemTax.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        /*SellerBranchItemTax sellerBranchItemTax=new SellerItemBranchTax();
        sellerBranchItemTax.setId(model.getSellerBranchTaxId());
        sellerItemTax.setSellerBranchTax(sellerBranchTax);*/
        sellerItemTax.setSellerItemTaxStatus(model.getSellerItemTaxStatus());
        sellerItemTax.setSellerItemTaxValue(Float.parseFloat(model.getSellerItemTaxValue()));
        sellerItemTax.setCreatedDate(new Date());
        model.setId(sellerItemTax.getId());
        sellerItemTax = sellerItemTaxService.create(sellerItemTax);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerItemTaxContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemTaxModel edit(final IKeyBuilder<String> keyBuilder, final SellerItemTaxModel model) {
        SellerItemTax sellerItemTax = new SellerItemTax();
        sellerItemTax.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        /*SellerBranchItemTax sellerBranchItemTax=new SellerItemBranchTax();
        sellerBranchItemTax.setId(model.getSellerBranchTaxId());
        sellerItemTax.setSellerBranchTax(sellerBranchTax);*/
        sellerItemTax.setSellerItemTaxStatus(model.getSellerItemTaxStatus());
        sellerItemTax.setSellerItemTaxValue(Float.parseFloat(model.getSellerItemTaxValue()));
        sellerItemTax.setCreatedDate(new Date());
        model.setId(sellerItemTax.getId());
        sellerItemTax = sellerItemTaxService.updateSellerItemTax(sellerItemTax);
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerItemTaxModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerItemTaxContext context) {
        SellerItemTax sellerItemTax = sellerItemTaxService.getSellerItemTax(keyBuilder.build().toString());
        SellerItemTaxModel sellerItemTaxModel = conversionService.convert(sellerItemTax, SellerItemTaxModel.class);
        return sellerItemTaxModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerItemTaxModel> getCollection(final SellerItemTaxContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
