/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.MeatInvoice;
import com.meat.domain.SellerInvoice;
import com.meat.model.CategoryModel;
import com.meat.model.MeatInvoiceModel;
import com.meat.service.IMeatInvoiceService;

import java.math.BigDecimal;
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
public class MeatInvoiceBusinessDelegate implements IBusinessDelegate<MeatInvoiceModel, MeatInvoiceContext, IKeyBuilder<String>, String> {

    @Autowired
    private IMeatInvoiceService meatInvoiceService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public MeatInvoiceModel create(final MeatInvoiceModel model) {
        MeatInvoice meatInvoice = new MeatInvoice();
        String value = model.getTotalAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            meatInvoice.setTotalAmount(b);
        }
        meatInvoice.setTax(model.getTax());
        String value1 = model.getDiscount();
        if (value1 != null) {
            BigDecimal b = new BigDecimal(value1.replaceAll(",", " "));
            meatInvoice.setDiscount(b);
        }
        String value2 = model.getGrandTotalAmount();
        if (value2 != null) {
            BigDecimal b = new BigDecimal(value2.replaceAll(",", " "));
            meatInvoice.setGrandTotalAmount(b);
        }
        SellerInvoice sellerInvoice = new SellerInvoice();
        sellerInvoice.setId(model.getSellerInvoiceId());
        meatInvoice.setSellerInvoice(sellerInvoice);
        meatInvoice.setPaidStatus(model.getPaidStatus());
        meatInvoice.setId(model.getId());
        meatInvoice = meatInvoiceService.create(meatInvoice);
        model.setId(meatInvoice.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final MeatInvoiceContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public MeatInvoiceModel edit(final IKeyBuilder<String> keyBuilder, final MeatInvoiceModel model) {
        MeatInvoice meatInvoice = meatInvoiceService.getMeatInvoice(keyBuilder.build().toString());
        String value = model.getTotalAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            meatInvoice.setTotalAmount(b);
        }
        meatInvoice.setTax(model.getTax());
        String value1 = model.getDiscount();
        if (value1 != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            meatInvoice.setDiscount(b);
        }
        String value2 = model.getGrandTotalAmount();
        if (value2 != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            meatInvoice.setGrandTotalAmount(b);
        }
        SellerInvoice sellerInvoice = new SellerInvoice();
        sellerInvoice.setId(model.getSellerInvoiceId());
        meatInvoice.setSellerInvoice(sellerInvoice);
        meatInvoice.setPaidStatus(model.getPaidStatus());
        meatInvoice.setId(model.getId());
        meatInvoice = meatInvoiceService.updateMeatInvoice(meatInvoice);
        model.setId(meatInvoice.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public MeatInvoiceModel getByKey(final IKeyBuilder<String> keyBuilder, final MeatInvoiceContext context) {
        MeatInvoice meatInvoice = meatInvoiceService.getMeatInvoice(keyBuilder.build().toString());
        MeatInvoiceModel meatInvoiceModel = conversionService.convert(meatInvoice, MeatInvoiceModel.class);

        return meatInvoiceModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<MeatInvoiceModel> getCollection(final MeatInvoiceContext context) {
        List<MeatInvoice> meatInvoice = new ArrayList<MeatInvoice>();

        if (context.getAll() != null) {
            meatInvoice = meatInvoiceService.getAll();
        }
        if (context.getMeatInvoiceOnly() != null) {
            meatInvoice = meatInvoiceService.getMeatInvoiceOnly();
        }
        List<MeatInvoiceModel> meatInvoiceModels = (List<MeatInvoiceModel>) conversionService.convert(meatInvoice,
                TypeDescriptor.forObject(meatInvoice), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryModel.class)));

        return meatInvoiceModels;
    }

}
