/**
 *
 */
package com.meat.dao;

import com.meat.domain.Seller;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface SellerRepository extends PagingAndSortingRepository<Seller, Serializable> {

    @Query("select MAX(sellerCount) from Seller s")
    Integer getMaxCode();

}
