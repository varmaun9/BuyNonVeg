/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerRequestsRepository;
import com.meat.domain.SellerRequests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerRequestsService implements ISellerRequestsService {
    @Autowired
    private SellerRequestsRepository sellerRequestsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerRequestsService#create(com.meat.domain.SellerRequests)
     */
    @Override
    public SellerRequests create(final SellerRequests sellerRequests) {
        // TODO Auto-generated method stub
        return sellerRequestsRepository.save(sellerRequests);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerRequestsService#deleteSellerRequests(java.lang.String)
     */
    @Override
    public void deleteSellerRequests(final String sellerRequestsId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerRequestsService#getAll()
     */
    @Override
    public List<SellerRequests> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerRequestsService#getSellerRequests(java.lang.String)
     */
    @Override
    public SellerRequests getSellerRequests(final String sellerRequestsId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerRequestsService#updateSellerRequests(com.meat.domain.SellerRequests)
     */
    @Override
    public SellerRequests updateSellerRequests(final SellerRequests sellerRequests) {
        // TODO Auto-generated method stub
        return sellerRequestsRepository.save(sellerRequests);
    }

}
