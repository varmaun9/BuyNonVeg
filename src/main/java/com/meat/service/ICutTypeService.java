package com.meat.service;

import com.meat.domain.CutType;

import java.util.List;

public interface ICutTypeService {

    CutType create(CutType cutType);

    void deleteCutType(String cutTypeId);

    List<CutType> getAll();

    CutType getCutType(String cutTypeId);

    /**
     * @param categoryId
     * @return
     */
    List<CutType> getCutTypeByCategory(String categoryId);

    /**
     * @param itemId
     * @return
     */
    List<CutType> getCutTypeByItem(String itemId);

    /**
     * @param sellerItemId
     * @return
     */
    List<CutType> getCutTypeBySellerItem(String sellerItemId);

    /**
     * @return
     */
    List<CutType> getCutTypeOnly();

    CutType updateCutType(CutType cutType);
}