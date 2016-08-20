/**
 *
 */
package com.meat.service;

import com.meat.domain.Seller;
import com.meat.domain.SellerImages;

import java.util.List;
import java.util.Set;

/**
 * @author arthvedi1
 *
 */
public interface ISellerService {

    /**
     * @param seller
     * @param sellerImageses
     * @return
     */
    Seller addSellerImages(Seller seller, Set<SellerImages> sellerImageses);

    /**
     * @param seller
     * @param slrBranch
     * @return
     */
    // Seller addSellerBranch(Seller seller, List<SellerBranch> slrBranch);

    Seller create(Seller seller);

    void deleteSeller(String sellerId);

    List<Seller> getAll();

    /**
     * @return
     */
    Integer getMaxCode();

    Seller getSeller(String sellerId);

    /**
     * @return
     */
    List<Seller> getSellerOnly();

    Seller updateSeller(Seller seller);

}
