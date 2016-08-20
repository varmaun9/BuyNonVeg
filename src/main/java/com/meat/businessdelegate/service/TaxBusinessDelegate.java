/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Tax;
import com.meat.model.TaxModel;
import com.meat.service.ITaxService;

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
public class TaxBusinessDelegate implements IBusinessDelegate<TaxModel, TaxContext, IKeyBuilder<String>, String> {

    @Autowired
    private ITaxService taxService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public TaxModel create(final TaxModel model) {

        Tax tax = new Tax();
        tax.setTaxName(model.getTaxName());
        tax.setTaxType(model.getTaxType());
        tax.setTaxStatus(model.getTaxStatus());
        tax.setCreatedDate(new Date());
        tax.setId(model.getId());
        tax = taxService.create(tax);
        model.setId(tax.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final TaxContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public TaxModel edit(final IKeyBuilder<String> keyBuilder, final TaxModel model) {

        Tax tax = taxService.getTax(keyBuilder.build().toString());
        tax.setTaxName(model.getTaxName());
        tax.setTaxType(model.getTaxType());
        tax.setTaxStatus(model.getTaxStatus());
        tax.setId(model.getId());
        tax = taxService.updateTax(tax);
        model.setId(tax.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public TaxModel getByKey(final IKeyBuilder<String> keyBuilder, final TaxContext context) {
        Tax tax = taxService.getTax(keyBuilder.build().toString());
        TaxModel taxModel = conversionService.convert(tax, TaxModel.class);
        return taxModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<TaxModel> getCollection(final TaxContext context) {
        List<Tax> tax = new ArrayList<Tax>();

        if (context.getAll() != null) {
            tax = taxService.getAll();
        }
        List<TaxModel> taxModels = (List<TaxModel>) conversionService.convert(tax, TypeDescriptor.forObject(tax),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(TaxModel.class)));
        return taxModels;
    }

}
