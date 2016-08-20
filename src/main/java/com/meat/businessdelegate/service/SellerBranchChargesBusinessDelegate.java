/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.AmountType;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchCharges;
import com.meat.model.SellerBranchChargesModel;
import com.meat.service.ISellerBranchChargesService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class SellerBranchChargesBusinessDelegate
        implements IBusinessDelegate<SellerBranchChargesModel, SellerBranchChargesContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBranchChargesService sellerBranchChargesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchChargesModel create(final SellerBranchChargesModel model) {
        // TODO Auto-generated method stub
        SellerBranchCharges sellerBranchCharges = new SellerBranchCharges();
        sellerBranchCharges.setChargesType(model.getChargesType());
        sellerBranchCharges.setChargesAmount(new BigDecimal(model.getChargesAmount()));
        sellerBranchCharges.setCreatedDate(new Date());
        sellerBranchCharges.setStatus(model.getStatus());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchCharges.setSellerBranch(sellerBranch);
        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());
        sellerBranchCharges.setAmountType(amountType);
        sellerBranchCharges = sellerBranchChargesService.create(sellerBranchCharges);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchChargesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchChargesModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchChargesModel model) {
        // TODO Auto-generated method stub
        SellerBranchCharges sellerBranchCharges = sellerBranchChargesService.getSellerBranchCharges(keyBuilder.build().toString());
        sellerBranchCharges.setId(model.getId());
        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());

        sellerBranchCharges.setAmountType(amountType);
        sellerBranchCharges.setSellerBranch(sellerBranchCharges.getSellerBranch());
        sellerBranchCharges.setStatus(model.getStatus());
        sellerBranchCharges.setChargesAmount(new BigDecimal(model.getChargesAmount()));
        sellerBranchCharges.setChargesType(model.getChargesType());
        sellerBranchCharges = sellerBranchChargesService.updateSellerBranchCharges(sellerBranchCharges);
        model.setId(sellerBranchCharges.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchChargesModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchChargesContext context) {
        SellerBranchCharges sellerBranchCharges = sellerBranchChargesService.getSellerBranchCharges(keyBuilder.build().toString());
        SellerBranchChargesModel sellerBranchChargesModel = conversionService.convert(sellerBranchCharges, SellerBranchChargesModel.class);

        return sellerBranchChargesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchChargesModel> getCollection(final SellerBranchChargesContext context) {
        List<SellerBranchCharges> sellerBranchCharges = new ArrayList<SellerBranchCharges>();

        if (context.getAll() != null) {
            sellerBranchCharges = sellerBranchChargesService.getAll();
        }

        List<SellerBranchChargesModel> sellerBranchChargesModels = (List<SellerBranchChargesModel>) conversionService.convert(
                sellerBranchCharges, TypeDescriptor.forObject(sellerBranchCharges),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchChargesModel.class)));
        return sellerBranchChargesModels;
    }
}
