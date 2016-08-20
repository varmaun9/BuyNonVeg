/**
 *
 */
package com.meat.service;

import com.meat.domain.OfferExcludeConfig;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IOfferExcludeConfigService {

    OfferExcludeConfig create(OfferExcludeConfig offerExcludeConfig);

    void deleteOfferExcludeConfig(String offerExcludeConfigId);

    List<OfferExcludeConfig> getAll();

    OfferExcludeConfig getOfferExcludeConfig(String offerExcludeConfigId);

    List<OfferExcludeConfig> getOfferExcludeConfigOnly();

    OfferExcludeConfig updateOfferExcludeConfig(OfferExcludeConfig offerExcludeConfig);

}
