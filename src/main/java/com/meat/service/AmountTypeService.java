/**
 *
 */
package com.meat.service;

import com.meat.dao.AmountTypeRepository;
import com.meat.domain.AmountType;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class AmountTypeService implements IAmountTypeService {
    @Autowired
    private AmountTypeRepository amountTypeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAmountTypeService#create(com.nonveg.domain.AmountType)
     */
    @Override
    public AmountType create(final AmountType amountType) {

        return amountTypeRepository.save(amountType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAmountTypeService#deleteAmountType(java.lang.String)
     */
    @Override
    public void deleteAmountType(final String amountTypeId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAmountTypeService#getAll()
     */
    @Override
    public List<AmountType> getAll() {
        List<AmountType> amountType = new ArrayList<AmountType>();
        amountType = (List<AmountType>) amountTypeRepository.findAll();
        return amountType;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAmountTypeService#getAmountType(java.lang.String)
     */
    /* @Override
    public Category getCategory(final String categoryId) {
        Category category = new Category();
        category = categoryRepository.findOne(categoryId);
        return category;
    }*/
    @Override
    public AmountType getAmountType(final String amountTypeId) {
        AmountType amountType = new AmountType();
        amountType = amountTypeRepository.findOne(amountTypeId);
        return amountType;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IAmountTypeService#getAmountTypeOnly()
     */
    @Override
    public List<AmountType> getAmountTypeOnly() {
        List<AmountType> amountType = (List<AmountType>) amountTypeRepository.findAll();
        List<AmountType> amountTypes = new ArrayList<AmountType>();
        for (AmountType amntType : amountType) {
            AmountType amountTyp = amntType;
            amountTypes.add(amountTyp);
        }
        return amountTypes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.IAmountTypeService#updateAmountType(com.nonveg.domain.AmountType)
     */
    @Override
    public AmountType updateAmountType(final AmountType amountType) {
        // TODO Auto-generated method stub
        return amountTypeRepository.save(amountType);
    }

}
