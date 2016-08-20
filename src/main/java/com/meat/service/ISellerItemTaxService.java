/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerItemTax;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerItemTaxService {
    SellerItemTax create(SellerItemTax sellerItemTax);

    void deleteSellerItemTax(String sellerItemTaxId);

    List<SellerItemTax> getAll();

    SellerItemTax getSellerItemTax(String sellerItemTaxId);

    SellerItemTax updateSellerItemTax(SellerItemTax sellerItemTax);

    /**
     * @param string
     * @return
     */

}
