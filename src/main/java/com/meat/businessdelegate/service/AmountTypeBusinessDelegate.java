/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.Percentage;
import com.meat.domain.AmountType;
import com.meat.model.AmountTypeModel;
import com.meat.service.IAmountTypeService;

import java.util.ArrayList;
import java.util.Collection;
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
public class AmountTypeBusinessDelegate implements IBusinessDelegate<AmountTypeModel, AmountTypeContext, IKeyBuilder<String>, String> {

    @Autowired
    private IAmountTypeService amountTypeService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#create(com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public AmountTypeModel create(final AmountTypeModel model) {
        AmountType amountType = new AmountType();
        if (model.getAmountTypeName().equals("Percent")) {
            String s = Percentage.Percent.getSequenceName();
            amountType.setAmountTypeName(Integer.parseInt(s));
        }

        if (model.getAmountTypeName().equals("Direct")) {
            String s1 = Percentage.Direct.getSequenceName();
            amountType.setAmountTypeName(Integer.parseInt(s1));
        }
        else {
        }

        amountType.setAmountDescription(model.getAmountDescription());

        //amountType.setId(model.getId());
        amountType = amountTypeService.create(amountType);
        // model.setId(amountType.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#delete(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final AmountTypeContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#edit(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.domain.IModel)
     */
    @Override
    public AmountTypeModel edit(final IKeyBuilder<String> keyBuilder, final AmountTypeModel model) {
        AmountType amountType = amountTypeService.getAmountType(keyBuilder.build().toString());
        if (model.getAmountTypeName().equals("Percent")) {
            String s = Percentage.Percent.getSequenceName();
            amountType.setAmountTypeName(Integer.parseInt(s));
        }
        if (model.getAmountTypeName().equals("Direct")) {
            String s1 = Percentage.Direct.getSequenceName();
            amountType.setAmountTypeName(Integer.parseInt(s1));
        }
        amountType.setAmountDescription(model.getAmountDescription());
        amountType.setId(model.getId());
        amountType = amountTypeService.updateAmountType(amountType);
        amountType.setId(model.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getByKey(com.nonveg.businessdelegate.domain.IKeyBuilder,
     *      com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public AmountTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final AmountTypeContext context) {
        AmountType amountType = amountTypeService.getAmountType(keyBuilder.build().toString());
        AmountTypeModel amountTypeModel = conversionService.convert(amountType, AmountTypeModel.class);
        return amountTypeModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.businessdelegate.service.IBusinessDelegate#getCollection(com.nonveg.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public Collection<AmountTypeModel> getCollection(final AmountTypeContext context) {
        List<AmountType> amountType = new ArrayList<AmountType>();

        if (context.getAll() != null) {
            amountType = amountTypeService.getAll();
        }
        if (context.getAmountTypeOnly() != null) {
            amountType = amountTypeService.getAmountTypeOnly();
        }
        List<AmountTypeModel> amountTypeModels = (List<AmountTypeModel>) conversionService.convert(amountType,
                TypeDescriptor.forObject(amountType), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AmountTypeModel.class)));
        return amountTypeModels;
    }

}
