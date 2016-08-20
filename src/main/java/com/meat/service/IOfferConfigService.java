/**
 *
 */
package com.meat.service;

import com.meat.domain.OfferConfig;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IOfferConfigService {

    OfferConfig create(OfferConfig offerConfig);

    void deleteOfferConfig(String offerConfigId);

    List<OfferConfig> getAll();

    OfferConfig getOfferConfig(String offerConfigId);

    List<OfferConfig> getOfferConfigOnly();

    OfferConfig updateOfferConfig(OfferConfig offerConfig);

}
