/**
 *
 */
package com.meat.service;

import com.meat.dao.OfferConfigRepository;
import com.meat.domain.OfferConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi
 *
 */
@Component
public class OfferConfigService implements IOfferConfigService {

    @Autowired
    private OfferConfigRepository offerConfigRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#create(com.meat.domain.OfferConfig)
     */
    @Override
    @Transactional
    public OfferConfig create(final OfferConfig offerConfig) {
        // TODO Auto-generated method stub
        return offerConfigRepository.save(offerConfig);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#deleteOfferConfig(java.lang.String)
     */
    @Override
    public void deleteOfferConfig(final String offerConfigId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#getAll()
     */
    @Override
    public List<OfferConfig> getAll() {
        List<OfferConfig> offerConfigs = new ArrayList<OfferConfig>();
        offerConfigs = (List<OfferConfig>) offerConfigRepository.findAll();
        return offerConfigs;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#getOfferConfig(java.lang.String)
     */
    @Override
    public OfferConfig getOfferConfig(final String offerConfigId) {
        // TODO Auto-generated method stub
        return offerConfigRepository.findOne(offerConfigId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#getOfferConfigOnly()
     */
    @Override
    public List<OfferConfig> getOfferConfigOnly() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferConfigService#updateOfferConfig(com.meat.domain.OfferConfig)
     */
    @Override
    public OfferConfig updateOfferConfig(final OfferConfig offerConfig) {
        // TODO Auto-generated method stub
        return offerConfigRepository.save(offerConfig);
    }

}
