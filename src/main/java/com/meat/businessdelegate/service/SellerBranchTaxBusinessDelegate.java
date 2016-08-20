/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.AmountType;
import com.meat.domain.SellerBranch;
import com.meat.domain.SellerBranchTax;
import com.meat.domain.Tax;
import com.meat.model.SellerBranchTaxModel;
import com.meat.service.ISellerBranchTaxService;

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
 * @author arthvedi
 *
 */
@Service
public class SellerBranchTaxBusinessDelegate
        implements IBusinessDelegate<SellerBranchTaxModel, SellerBranchTaxContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchTaxModel create(final SellerBranchTaxModel model) {

        SellerBranchTax sellerBranchTax = new SellerBranchTax();
        sellerBranchTax.setId(model.getId());

        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());
        sellerBranchTax.setAmountType(amountType);

        Tax tax = new Tax();
        tax.setId(model.getTaxId());
        sellerBranchTax.setTax(tax);

        String value = model.getTaxValue();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            sellerBranchTax.setTaxValue(b);
        }

        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchTax.setSellerBranch(sellerBranch);

        sellerBranchTax.setSellerBranchTaxStatus(model.getSellerBranchTaxStatus());
        sellerBranchTax.setCreatedDate(new Date());
        sellerBranchTax = sellerBranchTaxService.create(sellerBranchTax);
        //model.setId(sellerBranchTax.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchTaxContext context) {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchTaxModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchTaxModel model) {
        SellerBranchTax sellerBranchTax = sellerBranchTaxService.getSellerBranchTax(keyBuilder.build().toString());
        sellerBranchTax.setId(model.getId());
        AmountType amountType = new AmountType();
        amountType.setId(model.getAmountTypeId());
        sellerBranchTax.setAmountType(amountType);
        Tax tax = new Tax();
        tax.setId(model.getTaxId());
        sellerBranchTax.setTax(tax);
        String value = model.getTaxValue();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            sellerBranchTax.setTaxValue(b);
        }
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerBranchTax.setSellerBranch(sellerBranch);
        sellerBranchTax.setSellerBranchTaxStatus(model.getSellerBranchTaxStatus());
        sellerBranchTax.setCreatedDate(new Date());
        sellerBranchTax = sellerBranchTaxService.updateSellerBranchTax(sellerBranchTax);
        model.setId(sellerBranchTax.getId());

        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchTaxModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchTaxContext context) {
        SellerBranchTax sellerBranchTax = sellerBranchTaxService.getSellerBranchTax(keyBuilder.build().toString());
        SellerBranchTaxModel sellerBranchTaxModel = conversionService.convert(sellerBranchTax, SellerBranchTaxModel.class);

        return sellerBranchTaxModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchTaxModel> getCollection(final SellerBranchTaxContext context) {
        List<SellerBranchTax> sellerBranchTax = new ArrayList<SellerBranchTax>();
        if (context.getAll() != null) {
            sellerBranchTax = sellerBranchTaxService.getAll();
        }

        List<SellerBranchTaxModel> slrBranchTaxModels = (List<SellerBranchTaxModel>) conversionService.convert(sellerBranchTax,
                TypeDescriptor.forObject(sellerBranchTax),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchTaxModel.class)));

        return slrBranchTaxModels;
    }

}
