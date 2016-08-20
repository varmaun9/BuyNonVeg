/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerRequests;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerRequestsService {
    SellerRequests create(SellerRequests sellerRequests);

    void deleteSellerRequests(String sellerRequestsId);

    List<SellerRequests> getAll();

    SellerRequests getSellerRequests(String sellerRequestsId);

    SellerRequests updateSellerRequests(SellerRequests sellerRequests);

}
