/**
 *
 */
package com.meat.service;

import com.meat.dao.OfferRepository;
import com.meat.domain.Offer;
import com.meat.domain.OfferConfig;
import com.meat.domain.OfferExcludeConfig;
import com.meat.domain.SellerItem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author varma
 *
 */
@Component
public class OfferService implements IOfferService {

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private IOfferConfigService offerConfigService;
    @Autowired
    private IOfferExcludeConfigService offerExcludeConfigService;
    @Autowired
    private ISellerItemService sellerItemService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#addOfferConfigs(com.meat.domain.Offer, java.util.Set)
     */
    @Override
    @Transactional
    public Offer addOfferConfigs(final Offer offer, final Set<OfferConfig> offerConfig) {
        Validate.notNull(offer, "offer must not be null");
        Set<OfferConfig> offerConfgs = new HashSet<OfferConfig>(offerConfig);
        for (OfferConfig offrConfg : offerConfig) {
            OfferConfig ofcg = offrConfg;
            ofcg.setOffer(offer);
            offerConfgs.add(ofcg);
            ofcg = offerConfigService.create(ofcg);
        }
        offer.setOfferConfigs(offerConfgs);
        return offer;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#addOfferExcludeConfigs(com.meat.domain.Offer, java.util.Set)
     */
    @Override
    @Transactional
    public Offer addOfferExcludeConfigs(final Offer offer, final Set<OfferExcludeConfig> offerExcludeConfig) {
        Validate.notNull(offer, "offer must not be null");
        Set<OfferExcludeConfig> offerExcludeConfgs = new HashSet<OfferExcludeConfig>(offerExcludeConfig);
        for (OfferExcludeConfig offrExcludeConfg : offerExcludeConfig) {
            OfferExcludeConfig ofexcg = new OfferExcludeConfig();
            ofexcg.setCategory(offrExcludeConfg.getCategory());
            ofexcg.setItem(offrExcludeConfg.getItem());
            ofexcg.setOffer(offer);
            ofexcg.setPlacedByStatus(offrExcludeConfg.getPlacedByStatus());
            ofexcg.setStatus(offrExcludeConfg.getStatus());
            ofexcg.setSeller(offrExcludeConfg.getSeller());
            ofexcg.setSellerBranch(offrExcludeConfg.getSellerBranch());
            ofexcg.setSellerItem(offrExcludeConfg.getSellerItem());
            ofexcg.setSubCategory(offrExcludeConfg.getSubCategory());
            ofexcg.setOffer(offer);
            offerExcludeConfgs.add(ofexcg);
            ofexcg = offerExcludeConfigService.create(ofexcg);
        }
        offer.setOfferExcludeConfigs(offerExcludeConfgs);
        return offer;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#create(com.meat.domain.Offer)
     */
    @Override
    public Offer create(final Offer offers) {
        Offer offr = offerRepository.save(offers);
        if (offr.getId() != null) {
            //OfferConfig Creation
            // ** Start **
            if (offers.getOfferConfigs() != null) {
                Set<OfferConfig> offerConfigs = new HashSet<OfferConfig>();
                for (OfferConfig ofc : offers.getOfferConfigs()) {
                    OfferConfig ofconfg = ofc;
                    //ofconfg.setId(ofc.getId());
                    ofconfg.setOffer(offr);
                    ofconfg.setStatus(ofc.getStatus());
                    offerConfigs.add(ofconfg);
                    ofconfg = offerConfigService.create(ofconfg);
                }
                offers.setOfferConfigs(offerConfigs);
            }

            // ** end **

            // Offer exclude config
            // ** start **
            if (offers.getOfferExcludeConfigs() != null) {
                Set<OfferExcludeConfig> offerExcludeConfigs = new HashSet<OfferExcludeConfig>();
                for (OfferExcludeConfig oecfg : offers.getOfferExcludeConfigs()) {
                    OfferExcludeConfig ofec = new OfferExcludeConfig();
                    ofec.setId(oecfg.getId());
                    ofec.setOffer(offr);
                    ofec.setStatus(oecfg.getStatus());
                    offerExcludeConfigs.add(ofec);
                    ofec = offerExcludeConfigService.create(ofec);
                }
                offers.setOfferExcludeConfigs(offerExcludeConfigs);
            }
        }

        return offers;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#deleteOffers(java.lang.String)
     */
    @Override
    public void deleteOffers(final String offersId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#getAll()
     */
    @Override
    public List<Offer> getAll() {
        List<Offer> offers = new ArrayList<Offer>();
        offers = (List<Offer>) offerRepository.findAll();
        return offers;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {

        return offerRepository.findByMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#getOfferIdsBySellerItemAlongWithItsParents(java.lang.String)
     */
    @Override
    public List<String> getOfferIdsBySellerItemAlongWithItsParents(final String sellerItemId) {
        // TODO Auto-generated method stub

        SellerItem sellerItem = sellerItemService.getSellerItem(sellerItemId);
        return offerRepository.findOfferIdBySellerItemAlongwithParents(sellerItem.getId(), sellerItem.getItem().getId(),
                sellerItem.getItem().getSubCategory().getId(), sellerItem.getItem().getSubCategory().getCategory().getId(),
                sellerItem.getSellerBranch().getId(), sellerItem.getSellerBranch().getSeller().getId());

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#getOffers(java.lang.String)
     */
    @Override
    public Offer getOffers(final String offersId) {
        // TODO Auto-generated method stub
        return offerRepository.findOne(offersId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#getOffersBySellerItemAlongWithItsParents(java.lang.String)
     */
    @Override
    public List<Offer> getOffersBySellerItemAlongWithItsParents(final String sellerItemId) {

        SellerItem sellerItem = sellerItemService.getSellerItem(sellerItemId);
        return offerRepository.findOfferByItemListCategoryZone(sellerItem.getId(), sellerItem.getItem().getId(),
                sellerItem.getItem().getSubCategory().getId(), sellerItem.getItem().getSubCategory().getCategory().getId(),
                sellerItem.getSellerBranch().getId(), sellerItem.getSellerBranch().getSeller().getId());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IOfferService#updateOffer(com.meat.domain.Offer)
     */
    @Override
    @Transactional
    public Offer updateOffer(final Offer offers) {
        Offer offer = offerRepository.save(offers);
        /*  if (offers.getId() != null) {
            //OfferConfig Creation
            // ** Start **
            if (offers.getOfferConfigs() != null) {
                Set<OfferConfig> offerConfigs = new HashSet<OfferConfig>();
                for (OfferConfig ofc : offers.getOfferConfigs()) {
                    OfferConfig ofconfg = ofc;
                    System.out.println("bnsksabv" + ofc.getStatus());
                    ofconfg.setId(ofc.getId());
                    ofconfg.setOffer(offers);
                    System.out.println("vndk bdv" + offer.getId());
                    offerConfigs.add(ofconfg);
                    System.out.println("sksabvsd" + ofc.getPlacedByStatus());
                    ofconfg = offerConfigService.create(ofconfg);
                }
                offers.setOfferConfigs(offerConfigs);
            }
            // ** end **

            // Offer exclude config
            // ** start **

            if (offers.getOfferExcludeConfigs() != null) {
                // System.out.println("offercnakdscb" + offers.getOfferExcludeConfigs().size());
                Set<OfferExcludeConfig> offerExcludeConfigs = new HashSet<OfferExcludeConfig>();
                for (OfferExcludeConfig oecfg : offers.getOfferExcludeConfigs()) {
                    OfferExcludeConfig ofec = oecfg;
                    System.out.println("cscvsbvs" + oecfg.getStatus());
                    ofec.setId(oecfg.getId());
                    ofec.setOffer(offers);
                    offerExcludeConfigs.add(ofec);
                    ofec = offerExcludeConfigService.create(ofec);
                }
                offers.setOfferExcludeConfigs(offerExcludeConfigs);
            }
        }*/

        return offer;

    }

}
