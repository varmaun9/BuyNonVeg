/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerItemCriteria;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerItemCriteriaService {

    /**
     * @param product
     * @param productAttribute
     * @return
     */

    SellerItemCriteria create(SellerItemCriteria sellerItemCriteria);

    void deleteSellerItemCriteria(String sellerItemCriteriaId);

    List<SellerItemCriteria> getAll();

    SellerItemCriteria getSellerItemCriteria(String sellerItemCriteriaId);

    SellerItemCriteria updateSellerItemCriteria(SellerItemCriteria sellerItemCriteria);

}
