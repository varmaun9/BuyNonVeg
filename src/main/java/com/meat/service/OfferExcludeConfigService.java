/**
 *
 */
package com.meat.service;

import com.meat.dao.OfferExcludeConfigRepository;
import com.meat.domain.OfferExcludeConfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi
 *
 */
@Component
public class OfferExcludeConfigService implements IOfferExcludeConfigService {

    @Autowired
    private OfferExcludeConfigRepository offerExcludeConfigRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#create(com.meat.domain.OfferExcludeConfig)
     */
    @Override
    @Transactional
    public OfferExcludeConfig create(final OfferExcludeConfig offerExcludeConfig) {
        // TODO Auto-generated method stub
        return offerExcludeConfigRepository.save(offerExcludeConfig);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#deleteOfferExcludeConfig(java.lang.String)
     */
    @Override
    public void deleteOfferExcludeConfig(final String offerExcludeConfigId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#getAll()
     */
    @Override
    public List<OfferExcludeConfig> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#getOfferConfig(java.lang.String)
     */
    @Override
    public OfferExcludeConfig getOfferExcludeConfig(final String offerExcludeConfigId) {
        // TODO Auto-generated method stub
        return offerExcludeConfigRepository.findOne(offerExcludeConfigId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#getOfferExcludeConfigOnly()
     */
    @Override
    public List<OfferExcludeConfig> getOfferExcludeConfigOnly() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferExcludeConfigService#updateOfferExcludeConfig(com.meat.domain.OfferExcludeConfig)
     */
    @Override
    public OfferExcludeConfig updateOfferExcludeConfig(final OfferExcludeConfig offerExcludeConfig) {
        // TODO Auto-generated method stub
        return offerExcludeConfigRepository.save(offerExcludeConfig);
    }

}
