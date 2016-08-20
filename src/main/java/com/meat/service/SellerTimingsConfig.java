/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerTimingsConfigRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class SellerTimingsConfig implements ISellerTimingsConfigService {
    @Autowired
    private SellerTimingsConfigRepository sellerTimingsConfigRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerTimingsConfigService#create(com.meat.domain.SellerTimingsConfig)
     */
    @Override
    public com.meat.domain.SellerTimingsConfig create(final com.meat.domain.SellerTimingsConfig sellerTimingsConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerTimingsConfigService#deleteSellerTimingsConfig(java.lang.String)
     */
    @Override
    public void deleteSellerTimingsConfig(final String sellerTimingsConfigId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerTimingsConfigService#getAll()
     */
    @Override
    public List<com.meat.domain.SellerTimingsConfig> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerTimingsConfigService#getSellerTimingsConfig(java.lang.String)
     */
    @Override
    public com.meat.domain.SellerTimingsConfig getSellerTimingsConfig(final String sellerTimingsConfigId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerTimingsConfigService#updateSellerTimingsConfig(com.meat.domain.SellerTimingsConfig)
     */
    @Override
    public com.meat.domain.SellerTimingsConfig updateSellerTimingsConfig(final com.meat.domain.SellerTimingsConfig sellerTimingsConfig) {
        // TODO Auto-generated method stub
        return null;
    }

}
