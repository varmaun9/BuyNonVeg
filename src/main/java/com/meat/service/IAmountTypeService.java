/**
 *
 */
package com.meat.service;

import com.meat.domain.AmountType;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IAmountTypeService {

    AmountType create(AmountType amountType);

    void deleteAmountType(String amountTypeId);

    List<AmountType> getAll();

    AmountType getAmountType(String amountTypeId);

    /**
     * @return
     */
    List<AmountType> getAmountTypeOnly();

    AmountType updateAmountType(AmountType amountType);

}
