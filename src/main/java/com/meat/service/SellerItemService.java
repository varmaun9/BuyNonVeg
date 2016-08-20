/**
 *
 */
package com.meat.service;

import com.meat.dao.*;
import com.meat.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

import javax.transaction.Transactional;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerItemService implements ISellerItemService {
    @Autowired
    private SellerItemImagesRepository selleritemImagesRepository;
    @Autowired
    private SellerItemRepository sellerItemRepository;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private SellerItemCriteriaRepository sellerItemCriteriaRepository;
    @Autowired
    private SellerItemPieceTypeRepository sellerItemPieceTypeRepository;
    @Autowired
    private SellerItemTaxRepository sellerItemTaxRepository;
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private IOfferService offerService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#addSellerItemCriteria(com.meat.domain.SellerItem, java.util.List)
     */
    @Override
    public SellerItem addSellerItemCriteria(final SellerItem sellerItem, final List<SellerItemCriteria> sllrItemCriteria) {

        Validate.notNull(sellerItem, "sellerItem must not be null");
        Set<SellerItemCriteria> addSlrItemCriterias = new HashSet<SellerItemCriteria>(sllrItemCriteria);
        for (SellerItemCriteria sllrItmCri : sllrItemCriteria) {
            SellerItemCriteria slrItemCri = new SellerItemCriteria();
            slrItemCri.setSellerItem(sllrItmCri.getSellerItem());
            slrItemCri.setCriteria(sllrItmCri.getCriteria());
            slrItemCri.setSellerItemCriteriaStatus(sllrItmCri.getSellerItemCriteriaStatus());
            addSlrItemCriterias.add(slrItemCri);
            slrItemCri = sellerItemCriteriaRepository.save(slrItemCri);
        }
        //sellerItem.setSellerItemCriterias(addSlrItemCriterias);
        return sellerItem;
    }

    @Override
    public SellerItem addSellerItemImages(final SellerItem sellerItem, final List<SellerItemImages> sllrItemImages) {

        Validate.notNull(sellerItem, "sellerItem must not be null");
        Set<SellerItemImages> addImages = new HashSet<SellerItemImages>(sllrItemImages);
        for (SellerItemImages sllrItemImg : sllrItemImages) {
            SellerItemImages slrItemImg = new SellerItemImages();
            slrItemImg.setImageLocation(sllrItemImg.getImageLocation());
            slrItemImg.setImageName(sllrItemImg.getImageName());
            slrItemImg.setImageType(sllrItemImg.getImageType());
            slrItemImg.setSellerItem(sellerItem);
            addImages.add(slrItemImg);
            slrItemImg = selleritemImagesRepository.save(slrItemImg);

        }
        sellerItem.setSellerItemImageses(addImages);
        return sellerItem;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#addSellerItemPieceTypes(com.meat.domain.SellerItem, java.util.List)
     */
    @Override
    public SellerItem addSellerItemPieceTypes(final SellerItem sellerItem, final List<SellerItemPieceType> sllrItemPieceTypes) {
        Validate.notNull(sellerItem, "sellerItem must not be null");
        Set<SellerItemPieceType> addSlrItemPieceTypes = new HashSet<SellerItemPieceType>(sllrItemPieceTypes);
        for (SellerItemPieceType sllrItmPieceType : sllrItemPieceTypes) {
            SellerItemPieceType slrItemPieceType = sllrItmPieceType;
            slrItemPieceType.setSellerItem(sllrItmPieceType.getSellerItem());
            slrItemPieceType = sellerItemPieceTypeRepository.save(slrItemPieceType);
            addSlrItemPieceTypes.add(slrItemPieceType);
        }
        sellerItem.setSellerItemPieceTypes(addSlrItemPieceTypes);

        return sellerItem;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#addSellerItemTax(com.meat.domain.SellerItem, java.util.List)
     */
    @Override
    public SellerItem addSellerItemTax(final SellerItem sellerItem, final List<SellerItemTax> slrItemTax) {

        Validate.notNull(sellerItem, "sellerItem must not be null");
        Set<SellerItemTax> addTax = new HashSet<SellerItemTax>(slrItemTax);
        for (SellerItemTax sllrItmTax : slrItemTax) {
            SellerItemTax slrIT = new SellerItemTax();

            slrIT.setSellerItem(sllrItmTax.getSellerItem());
            slrIT.setSellerBranchTax(sllrItmTax.getSellerBranchTax());
            slrIT.setSellerItemTaxStatus(sllrItmTax.getSellerItemTaxStatus());
            slrIT.setSellerItemTaxValue(sllrItmTax.getSellerItemTaxValue());
            slrIT.setCreatedDate(new Date());
            addTax.add(slrIT);
            slrIT = sellerItemTaxRepository.save(slrIT);
        }
        return sellerItem;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#create(com.meat.domain.SellerItem)
     */
    @Transactional
    @Override
    public SellerItem create(final SellerItem sellerItem) {
        SellerItem sellrItem = new SellerItem();
        if (sellerItem.getItem() != null) {
            SellerItem si = sellerItemRepository.findByItemSellerBranch(sellerItem.getItem().getId(), sellerItem.getSellerBranch().getId());
            if (si != null) {
                sellerItem.setDescription("DUPLICATE");
                sellerItem.setItem(si.getItem());
                sellerItem.setSellerBranch(si.getSellerBranch());
                sellerItem.setItemAvailableStatus(sellerItem.getItem().getItemName() + " Already Exists For SellerBranch !!" + " "
                        + sellerItem.getSellerBranch().getBranchName());
                return sellerItem;
            }
            else {
                if (sellerItem.getSeo() != null) {
                    Seo seo = new Seo();
                    seo.setSeoTitle(sellerItem.getSeo().getSeoTitle());
                    seo.setSeoKeywords(sellerItem.getSeo().getSeoKeywords());
                    seo.setSeoMetaDescription(sellerItem.getSeo().getSeoMetaDescription());
                    seo = seoService.create(seo);
                    sellerItem.setSeo(seo);
                }
                sellrItem = sellerItemRepository.save(sellerItem);
            }
        }

        return sellrItem;

    }

    /**
     * .
     *
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#deleteSellerItem(java.lang.String)
     */
    @Override
    public void deleteSellerItem(final String sellerItemId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getAll()
     */

    @Override
    public List<SellerItem> getAll() {
        List<SellerItem> sellerItem = new ArrayList<SellerItem>();
        sellerItem = (List<SellerItem>) sellerItemRepository.findAll();
        return sellerItem;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getItemSellerItemByThymeleafCategory(java.lang.String, int, int, java.lang.String,
     *      java.lang.String)
     */
    @Override
    public List<SellerItem> getItemSellerItemByThymeleafCategory(final String categoryId, final int page, final int pageSize,
            final String sort, final String type) {
        int p = page;
        int ps = pageSize;
        Pageable pageable = new PageRequest(p, ps);

        PageRequest request = null; // new PageRequest(p - 1, ps,
                                    // Sort.Direction.DESC,
                                    // "restaurantItemName");
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "sellerItemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
        }

        List<SellerItem> sellerItems = sellerItemRepository.findItemSellerItemByThymeleafCategory(categoryId, request);
        return sellerItems;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemByThymeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerItem> getItemSellerItemByThymeleafCategoryZone(final String categoryId, final String zoneId, final int page,
            final int pageSize, final String sort, final String type) {
        int p = page;
        int ps = pageSize;
        Pageable pageable = new PageRequest(p, ps);

        PageRequest request = null; // new PageRequest(p - 1, ps,
                                    // Sort.Direction.DESC,
                                    // "restaurantItemName");
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "sellerItemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
        }

        List<SellerItem> sellerItems = sellerItemRepository.findItemSellerItemByThymeleafCategoryZone(categoryId, zoneId, request);
        return sellerItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getItemSellerItemByThymeleafSellerZone(java.lang.String, java.lang.String, int, int,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerItem> getItemSellerItemByThymeleafSellerZone(final String sellerId, final String zoneId, final int page,
            final int pageSize, final String sort, final String type) {
        int p = page;
        int ps = pageSize;
        Pageable pageable = new PageRequest(p, ps);

        PageRequest request = null; // new PageRequest(p - 1, ps,
                                    // Sort.Direction.DESC,
                                    // "restaurantItemName");
        if (sort.equals("price")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "price");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "price");
            }
        }

        else if (sort.equals("item")) {
            if (type.equals("dsc")) {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
            }
            else {
                request = new PageRequest(page - 1, pageSize, Sort.Direction.ASC, "sellerItemName");
            }
        }
        else {
            request = new PageRequest(page - 1, pageSize, Sort.Direction.DESC, "sellerItemName");
        }

        List<SellerItem> sellerItems = sellerItemRepository.findItemSellerItemByThymeleafSellerZone(sellerId, zoneId, request);
        return sellerItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getMaxSellerItemPagesByThemeleafCategory(java.lang.String)
     */
    @Override
    public BigDecimal getMaxSellerItemPagesByThemeleafCategory(final String categoryId) {
        BigDecimal maxPrice = sellerItemRepository.findMaxPriceSellerItemByThymeleafCategory(categoryId);
        return maxPrice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getMaxSellerItemPagesByThemeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public BigDecimal getMaxSellerItemPagesByThemeleafCategoryZone(final String zoneId, final String categoryId) {
        BigDecimal maxPrice = sellerItemRepository.findMaxPriceSellerItemByThymeleafCategoryZone(zoneId, categoryId);
        return maxPrice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getMinSellerItemPagesByThemeleafCategory(java.lang.String)
     */
    @Override
    public BigDecimal getMinSellerItemPagesByThemeleafCategory(final String categoryId) {
        BigDecimal minPrice = sellerItemRepository.findMinPriceSellerItemByThymeleafCategory(categoryId);
        return minPrice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getMinSellerItemPagesByThemeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public BigDecimal getMinSellerItemPagesByThemeleafCategoryZone(final String zoneId, final String categoryId) {
        BigDecimal minPrice = sellerItemRepository.findMinPriceSellerItemByThymeleafCategoryZone(zoneId, categoryId);
        return minPrice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerBranchItemOnly(java.lang.String)
     */
    @Override
    public List<SellerItem> getSellerBranchItemOnly(final String sellerBranchId) {
        // TODO Auto-generated method stub
        List<SellerItem> sellerItem = new ArrayList<SellerItem>();
        sellerItem = sellerItemRepository.findSellerBranchItemsOnly(sellerBranchId);
        List<SellerItem> sellerBranchItemsOnly = new ArrayList<SellerItem>();
        for (SellerItem sI : sellerItem) {
            SellerItem slrIt = new SellerItem();
            slrIt.setId(sI.getId());
            slrIt.setItem(sI.getItem());
            slrIt.setSeo(sI.getSeo());
            slrIt.setSellerBranch(sI.getSellerBranch());
            slrIt.setSellerItemName(sI.getSellerItemName());
            slrIt.setSellingTag(sI.getSellingTag());
            slrIt.setQuantity(sI.getQuantity());
            slrIt.setSpecialTag(sI.getSpecialTag());
            slrIt.setDescription(sI.getDescription());
            //slrIt.setIngredients(sI.getIngredients());
            slrIt.setSellingPrice(sI.getSellingPrice());
            slrIt.setItemAvailableStatus(sI.getItemAvailableStatus());
            slrIt.setCreatedDate(sI.getCreatedDate());
            slrIt.setSellerStock(sI.getSellerStock());
            slrIt.setCutTypes(sI.getCutTypes());
            slrIt.setMarketPrice(sI.getMarketPrice());
            sellerBranchItemsOnly.add(slrIt);
        }

        return sellerBranchItemsOnly;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItem(java.lang.String)
     */
    @Override
    public SellerItem getSellerItem(final String sellerItemId) {
        SellerItem sellerItem = new SellerItem();
        sellerItem = sellerItemRepository.findOne(sellerItemId);

        return sellerItem;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemAfterOfferApplied(java.lang.String)
     */
    @Override
    public SellerItem getSellerItemAfterOfferApplied(final String sellerItemId) {
        SellerItem si = sellerItemRepository.findOne(sellerItemId);
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(si.getId());
        sellerItem.setSellerItemName(si.getSellerItemName());
        sellerItem.setSellerBranch(si.getSellerBranch());
        sellerItem.setItem(si.getItem());
        sellerItem.setCutTypes(si.getCutTypes());
        sellerItem.setSeo(si.getSeo());
        sellerItem.setPieceCount(si.getPieceCount());
        sellerItem.setPieceName(si.getPieceName());
        String category = si.getItem().getSubCategory().getCategory().getId();
        String subCategory = si.getItem().getSubCategory().getId();
        String sellerBranch = si.getSellerBranch().getId();
        String seller = si.getSellerBranch().getSeller().getId();
        String itm = si.getItem().getId();

        List<Offer> offers = offerRepository.findOfferByItemListCategoryZone(si.getId(), itm, subCategory, category, sellerBranch, seller);
        BigDecimal offrPrice = new BigDecimal(0.0);
        double offerPercentage = 0.0;

        double offerAmount = 0.0;
        for (Offer of : offers) {
            Offer o = new Offer();
            o.setAmountTypeValue(of.getAmountTypeValue());
            if (of.getAmountType().getAmountDescription().equals("PERCENT")) {
                offerPercentage = offerPercentage + of.getAmountTypeValue();//always percentage
            }
            else if (of.getAmountType().getAmountDescription().equals("AMOUNT")) {
                offerAmount = offerAmount + of.getAmountTypeValue();//always Amount
            }
        }
        BigDecimal discountedValue = ((si.getMarketPrice().multiply(new BigDecimal(offerPercentage))).divide(new BigDecimal(100.00)))
                .add(new BigDecimal(offerAmount));
        sellerItem.setDescription(discountedValue.toString());
        sellerItem.setSellerPrice(si.getSellingPrice());
        offrPrice = (si.getSellingPrice()).subtract(discountedValue);
        sellerItem.setMarketPrice(si.getMarketPrice());
        if (discountedValue.compareTo(new BigDecimal(0.00)) == 0) {
            sellerItem.setSellingPrice(si.getSellingPrice());
        }
        else {
            sellerItem.setSellingPrice(offrPrice);
        }
        BigDecimal offerPercntage = ((sellerItem.getMarketPrice().subtract(sellerItem.getSellingPrice()).divide(sellerItem.getMarketPrice(),
                2, RoundingMode.HALF_EVEN)).multiply(new BigDecimal(100.00)));
        sellerItem.setOfferPrice(offerPercntage);
        return sellerItem;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemByThymeleafItem(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerItem> getSellerItemByThymeleafItem(final String itemId) {
        List<SellerItem> sellerItems = sellerItemRepository.findSellerItemByThymeleafItem(itemId);
        sellerItems = getSellerItemWithOffer(sellerItems);
        return sellerItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemByThymeleafItemZone(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerItem> getSellerItemByThymeleafItemZone(final String itemId, final String zoneId) {
        List<SellerItem> sellerItems = sellerItemRepository.findSellerItemByThymeleafItemZone(itemId, zoneId);
        sellerItems = getSellerItemWithOffer(sellerItems);
        return sellerItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemOnly()
     */

    @Override
    public List<SellerItem> getSellerItemOnly() {
        List<SellerItem> sellerItem = new ArrayList<SellerItem>();
        sellerItem = (List<SellerItem>) sellerItemRepository.findAll();
        List<SellerItem> sellerItemes = new ArrayList<SellerItem>();
        for (SellerItem sI : sellerItem) {
            SellerItem slrIt = new SellerItem();
            slrIt.setId(sI.getId());
            slrIt.setItem(sI.getItem());
            slrIt.setSeo(sI.getSeo());
            slrIt.setSellerBranch(sI.getSellerBranch());
            slrIt.setSellerItemName(sI.getSellerItemName());
            slrIt.setSellingTag(sI.getSellingTag());
            slrIt.setQuantity(sI.getQuantity());
            slrIt.setSpecialTag(sI.getSpecialTag());
            slrIt.setDescription(sI.getDescription());
            // slrIt.setIngredients(sI.getIngredients());
            slrIt.setSellingPrice(sI.getSellingPrice());
            slrIt.setItemAvailableStatus(sI.getItemAvailableStatus());
            slrIt.setCreatedDate(sI.getCreatedDate());
            slrIt.setCutTypes(sI.getCutTypes());
            slrIt.setSellerStock(sI.getSellerStock());
            sellerItemes.add(slrIt);
        }
        return sellerItemes;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemOnly(java.lang.String)
     */
    @Override
    public List<SellerItem> getSellerItemOnly(final String sellerBranchId) {
        List<SellerItem> sellerItem = new ArrayList<SellerItem>();
        sellerItem = sellerItemRepository.findSellerItemBySellerBranch(sellerBranchId);
        List<SellerItem> sellerItemes = new ArrayList<SellerItem>();
        for (SellerItem sI : sellerItem) {
            SellerItem slrIt = new SellerItem();
            slrIt.setId(sI.getId());
            slrIt.setItem(sI.getItem());
            slrIt.setSeo(sI.getSeo());
            slrIt.setSellerBranch(sI.getSellerBranch());
            slrIt.setSellerItemName(sI.getSellerItemName());
            slrIt.setSellingTag(sI.getSellingTag());
            slrIt.setQuantity(sI.getQuantity());
            slrIt.setSpecialTag(sI.getSpecialTag());
            slrIt.setDescription(sI.getDescription());
            slrIt.setSellingPrice(sI.getSellingPrice());
            slrIt.setItemAvailableStatus(sI.getItemAvailableStatus());
            slrIt.setCreatedDate(sI.getCreatedDate());
            slrIt.setSellerStock(sI.getSellerStock());
            slrIt.setCutTypes(sI.getCutTypes());
            slrIt.setSellerItemImageses(sI.getSellerItemImageses());
            Set<OfferConfig> offerConfigs = new HashSet<OfferConfig>();
            if (sI.getOfferConfigs().size() > 0) {
                for (OfferConfig oc : sI.getOfferConfigs()) {
                    OfferConfig ofc = new OfferConfig();
                    ofc.setId(oc.getId());
                    ofc.setOfferAttributeName(oc.getOfferAttributeName());
                    ofc.setOfferAttributeValue(oc.getOfferAttributeValue());
                    ofc.setPlacedByStatus(oc.getPlacedByStatus());
                    ofc.setStatus(oc.getStatus());
                    ofc.setOffer(oc.getOffer());
                    offerConfigs.add(ofc);
                }
                slrIt.setOfferConfigs(offerConfigs);
            }
            sellerItemes.add(slrIt);
        }
        return sellerItemes;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemsBySellerBranch(java.lang.String)
     */
    @Override
    public List<SellerItem> getSellerItemsBySellerBranch(final String branchId) {
        // TODO Auto-generated method stub
        return sellerItemRepository.findSellerItemBySellerBranch(branchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemsByThymeleafItem(java.lang.String)
     */
    @Override
    public Set<SellerItem> getSellerItemsByThymeleafItem(final String id) {
        // TODO Auto-generated method stub
        //  PageRequest request = new PageRequest(Sort.Direction.DESC, "price");
        return sellerItemRepository.findSellerItemByItemThymeleaf(id);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemsBySellerBranchStatus(java.lang.String, java.lang.String)
     */
    @Override
    public String getSellerItemsCountBySellerBranchStatus(final String branchId, final String status) {
        // TODO Auto-generated method stub
        return sellerItemRepository.findSellerItemsCountBySellerBranchStatus(branchId, status);
    }

    /**
     * @param sellerItems
     * @return
     */
    @Override
    public List<SellerItem> getSellerItemWithOffer(final List<SellerItem> sellerItems) {

        List<SellerItem> sellerItemsWithOffer = new ArrayList<SellerItem>();
        for (SellerItem si : sellerItems) {
            SellerItem sellrItm = si;
            sellrItm.setId(si.getId());
            String category = si.getItem().getSubCategory().getCategory().getId();
            String subCategory = si.getItem().getSubCategory().getId();
            String sellerBranch = si.getSellerBranch().getId();
            String seller = si.getSellerBranch().getSeller().getId();
            String itm = si.getItem().getId();

            List<Offer> offers = offerRepository.findOfferByItemListCategoryZone(si.getId(), itm, subCategory, category, sellerBranch,
                    seller);
            BigDecimal offrPrice = new BigDecimal(0.0);
            double offerPercentage = 0.0;
            double offerAmount = 0.0;
            for (Offer of : offers) {
                Offer o = new Offer();

                o.setAmountTypeValue(of.getAmountTypeValue());
                if (of.getAmountType().getAmountDescription().equals("PERCENT")) {
                    offerPercentage = offerPercentage + of.getAmountTypeValue();//always percentage
                }
                else if (of.getAmountType().getAmountDescription().equals("AMOUNT")) {
                    offerAmount = offerAmount + of.getAmountTypeValue();//always Amount
                }

            }
            BigDecimal discountedValue = ((si.getMarketPrice().multiply(new BigDecimal(offerPercentage))).divide(new BigDecimal(100.00)))
                    .add(new BigDecimal(offerAmount));
            si.setSellerPrice(si.getSellingPrice());
            offrPrice = (si.getSellingPrice()).subtract(discountedValue);
            sellrItm.setMarketPrice(si.getMarketPrice());
            if (discountedValue.compareTo(new BigDecimal(0.00)) == 0) {
                sellrItm.setSellingPrice(si.getSellingPrice());
            }
            else {
                sellrItm.setSellingPrice(offrPrice);
            }
            BigDecimal offerPercntage = (si.getMarketPrice().subtract(si.getSellingPrice()).divide(si.getMarketPrice(), 2,
                    RoundingMode.HALF_UP)).multiply(new BigDecimal(100.00));
            si.setOfferPrice(offerPercntage);

            sellerItemsWithOffer.add(sellrItm);
        }

        return sellerItemsWithOffer;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#getSellerItemWithOffersShortInfo(java.lang.String)
     */
    @Override
    public Map<SellerItem, List<Offer>> getSellerItemWithOffersShortInfo(final String sellerItemId) {
        // TODO Auto-generated method stub

        SellerItem si = getSellerItem(sellerItemId);
        SellerItem sellerItem = new SellerItem();
        sellerItem.setSellerBranch(si.getSellerBranch());
        String category = si.getItem().getSubCategory().getCategory().getId();
        String subCategory = si.getItem().getSubCategory().getId();
        String sellerBranch = si.getSellerBranch().getId();
        String seller = si.getSellerBranch().getSeller().getId();
        String itm = si.getItem().getId();

        List<Offer> offers = offerRepository.findOfferByItemListCategoryZone(si.getId(), itm, subCategory, category, sellerBranch, seller);

        BigDecimal offrPrice = new BigDecimal(0.0);
        double offerPercentage = 0.0;
        double offerAmount = 0.0;
        List<Offer> offersWithShortInfo = new ArrayList<Offer>();
        for (Offer of : offers) {
            Offer o = new Offer();
            Offer offer = new Offer();
            offer.setOfferName(of.getOfferName());
            o.setAmountTypeValue(of.getAmountTypeValue());
            if (of.getAmountType().getAmountDescription().equals("PERCENT")) {
                offerPercentage = offerPercentage + of.getAmountTypeValue();//always percentage
                BigDecimal offerAmountTypeValue = (si.getMarketPrice().multiply(new BigDecimal(of.getAmountTypeValue())))
                        .divide(new BigDecimal(100.00));
                offer.setAmountTypeValue(offerAmountTypeValue.toBigInteger().intValueExact());

            }
            else if (of.getAmountType().getAmountDescription().equals("AMOUNT")) {
                offerAmount = offerAmount + of.getAmountTypeValue();//always Amount
                offer.setAmountTypeValue(of.getAmountTypeValue());
            }
            offersWithShortInfo.add(offer);
        }
        BigDecimal discountedValue = ((si.getMarketPrice().multiply(new BigDecimal(offerPercentage))).divide(new BigDecimal(100.00)))
                .add(new BigDecimal(offerAmount));
        si.setSellerPrice(si.getSellingPrice());
        offrPrice = (si.getSellingPrice()).subtract(discountedValue);

        if (discountedValue.compareTo(new BigDecimal(0.00)) == 0) {
            si.setSellingPrice(si.getSellingPrice());

        }
        else {
            si.setSellingPrice(offrPrice);

        }
        BigDecimal offerPercntage = ((si.getMarketPrice().subtract(si.getSellingPrice()).divide(si.getMarketPrice(), 2,
                RoundingMode.HALF_UP)).multiply(new BigDecimal(100.00)));
        si.setOfferPrice(offerPercntage);
        Map<SellerItem, List<Offer>> sellerItemWithOffersShortInfo = new HashMap<SellerItem, List<Offer>>();
        sellerItemWithOffersShortInfo.put(si, offersWithShortInfo);
        return sellerItemWithOffersShortInfo;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemService#updateSellerItem(com.meat.domain.SellerItem)
     */
    @Override
    public SellerItem updateSellerItem(final SellerItem sellerItem) {
        // TODO Auto-generated method stub
        return sellerItemRepository.save(sellerItem);
    }

}
