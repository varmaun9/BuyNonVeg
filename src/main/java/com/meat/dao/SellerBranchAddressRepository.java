/**
 *
 */
package com.meat.dao;

import com.meat.domain.SellerBranchAddress;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerBranchAddressRepository extends PagingAndSortingRepository<SellerBranchAddress, Serializable> {

    /**
     * @param sellerBranchId
     * @return
     */
    @Query("SELECT sba FROM SellerBranchAddress sba JOIN sba.sellerBranch sb WHERE sb.id=?1")
    List<SellerBranchAddress> findSellerBranchAddressByBranchId(String sellerBranchId);

}
