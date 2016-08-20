/**
 *
 */
package com.meat.service;

import com.meat.domain.Offer;
import com.meat.domain.OfferConfig;
import com.meat.domain.OfferExcludeConfig;

import java.util.List;
import java.util.Set;

/**
 * @author varma
 *
 */
public interface IOfferService {

    /**
     * @param offer
     * @param offerConfig
     * @return
     */
    Offer addOfferConfigs(Offer offer, Set<OfferConfig> offerConfig);

    /**
     * @param offer
     * @param offerExcludeConfig
     * @return
     */
    Offer addOfferExcludeConfigs(Offer offer, Set<OfferExcludeConfig> offerExcludeConfig);

    Offer create(Offer offers);

    void deleteOffers(String offersId);

    List<Offer> getAll();

    /**
     * @return
     */
    Integer getMaxCode();

    /**
     * @param id
     * @return
     */
    List<String> getOfferIdsBySellerItemAlongWithItsParents(String id);

    Offer getOffers(String offersId);

    /**
     * @param id
     * @return
     */
    List<Offer> getOffersBySellerItemAlongWithItsParents(String id);

    /**
     * @param id
     * @param itm
     * @param subCategory
     * @param category
     * @param sellerBranch
     * @param seller
     * @return
     */

    Offer updateOffer(Offer offers);

}
