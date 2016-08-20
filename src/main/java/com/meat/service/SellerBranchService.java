/**
 *
 */
package com.meat.service;

import com.meat.dao.*;
import com.meat.domain.*;

import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi1
 *
 */
@Component
public class SellerBranchService implements ISellerBranchService {

    @Autowired
    private SellerBranchRepository sellerBranchRepository;
    @Autowired
    private ISellerBranchAddressService sellerBranchAddressService;
    @Autowired
    private SellerBranchZoneRepository sellerBranchZoneRepository;
    @Autowired
    private ISellerBranchZoneService sellerBranchZoneService;
    @Autowired
    private SellerBranchImagesRepository sellerBranchImagesRepository;
    @Autowired
    private ISellerBranchImagesService sellerBranchImagesService;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;
    @Autowired
    private ISellerBranchTimingsService sellerBranchTimingsService;
    @Autowired
    private SellerBranchTimingsRepository sellerBranchTimingsRepository;
    @Autowired
    private SellerBranchTaxRepository sellerBranchTaxRepository;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private TaxRepository taxRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#addSellerBranchImages(com.meat.domain.SellerBranch, java.util.List)
     */
    @Override
    @Transactional
    public SellerBranch addSellerBranchImages(final SellerBranch sellerBranch, final List<SellerBranchImages> sbImages) {
        Validate.notNull(sellerBranch, "sellerBranch must not be null");
        Set<SellerBranchImages> addImages = new HashSet<SellerBranchImages>(sbImages);
        for (SellerBranchImages sbrImages : sbImages) {
            SellerBranchImages sellrBranchImages1 = new SellerBranchImages();
            String s = sbrImages.getImageName();
            s = s.replaceAll("\\\\", "/");
            if (sbrImages.getId() != null) {
                sellrBranchImages1 = sellerBranchImagesService.getSellerBranchImages(sbrImages.getId());
                //categoryImages1.setId(categoryImages1.getId());
                sellrBranchImages1.setImageName(s);
                sellrBranchImages1.setImageType(sbrImages.getImageType());
                sellrBranchImages1.setImageLocation(sbrImages.getImageLocation());
                sellrBranchImages1.setSellerBranch(sellrBranchImages1.getSellerBranch());
                sellrBranchImages1 = sellerBranchImagesService.updateSellerBranchImages(sellrBranchImages1);
            }
            else {
                sellrBranchImages1.setImageName(s);
                sellrBranchImages1.setImageType(sbrImages.getImageType());
                sellrBranchImages1.setImageLocation(sbrImages.getImageLocation());
                sellrBranchImages1.setSellerBranch(sellerBranch);
                addImages.add(sellrBranchImages1);
                sellrBranchImages1 = sellerBranchImagesRepository.save(sellrBranchImages1);
            }

        }
        sellerBranch.setSellerBranchImageses(addImages);
        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#addSellerBranchTaxes(com.meat.domain.SellerBranch, java.util.Set)
     */
    @Override
    public SellerBranch addSellerBranchTaxes(final SellerBranch sellerBranch, final Set<SellerBranchTax> sbt) {
        Validate.notNull(sellerBranch, "sellerBranch must not be null");
        Set<SellerBranchTax> addsbTaxes = new HashSet<SellerBranchTax>(sbt);
        for (SellerBranchTax sbTax : sbt) {
            SellerBranchTax sbranchTax = new SellerBranchTax();
            if (sbTax.getId() != null) {
                sbranchTax = sellerBranchTaxService.getSellerBranchTax(sbTax.getId());
                sbranchTax.setId(sbTax.getId());
                sbranchTax.setTax(sbTax.getTax());
                sbranchTax.setAmountType(sbTax.getAmountType());
                sbranchTax.setTaxValue(sbTax.getTaxValue());
                sbranchTax.setSellerBranchTaxStatus(sbTax.getSellerBranchTaxStatus());
                sbranchTax.setSellerBranch(sellerBranch);
                sbranchTax = sellerBranchTaxService.updateSellerBranchTax(sbranchTax);
            }
            sbranchTax.setTax(sbTax.getTax());
            sbranchTax.setAmountType(sbTax.getAmountType());
            sbranchTax.setTaxValue(sbTax.getTaxValue());
            sbranchTax.setSellerBranchTaxStatus(sbTax.getSellerBranchTaxStatus());
            sbranchTax.setSellerBranch(sellerBranch);
            sbranchTax.setCreatedDate(new Date());
            addsbTaxes.add(sbranchTax);
            sbranchTax = sellerBranchTaxRepository.save(sbranchTax);
        }
        sellerBranch.setSellerBranchTaxes(addsbTaxes);

        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#addSellerBranchTimings(com.meat.domain.SellerBranch, java.util.Set)
     */
    @Override
    public SellerBranch addSellerBranchTimings(final SellerBranch sellerBranch, final Set<SellerBranchTimings> sellerBranchTimings) {
        Validate.notNull(sellerBranch, "sellerBranch must not be null");
        Set<SellerBranchTimings> addsbTimings = new HashSet<SellerBranchTimings>(sellerBranchTimings);
        //        SellerBranchTimings sbts = sellerBranchTimingsRepository.findBySellerBranch(sellerBranch.getId());
        for (SellerBranchTimings sbTimings : sellerBranchTimings) {
            SellerBranchTimings sbranchTimings = new SellerBranchTimings();
            if (sbTimings.getId() != null) {
                sbranchTimings = sellerBranchTimingsService.getSellerBranchTimings(sbTimings.getId());
                sbranchTimings.setId(sbTimings.getId());
                sbranchTimings.setTimings(sbTimings.getTimings());
                sbranchTimings.setStatus(sbTimings.getStatus());
                sbranchTimings.setSellerBranch(sbranchTimings.getSellerBranch());
                sbranchTimings = sellerBranchTimingsService.updateSellerBranchTimings(sbranchTimings);
            }

            sbranchTimings.setTimings(sbTimings.getTimings());
            sbranchTimings.setStatus(sbTimings.getStatus());
            sbranchTimings.setSellerBranch(sbTimings.getSellerBranch());
            sbranchTimings.setCreatedDate(new Date());
            addsbTimings.add(sbranchTimings);
            sbranchTimings = sellerBranchTimingsRepository.save(sbranchTimings);
        }
        sellerBranch.setSellerBranchTimingses(addsbTimings);

        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#addSellerBranchZones(com.meat.domain.SellerBranch, java.util.Set)
     */
    @Override
    public SellerBranch addSellerBranchZones(final SellerBranch sellerBranch, final Set<SellerBranchZone> sbz) {
        Validate.notNull(sellerBranch, "sellerBranch must not be null");
        Set<SellerBranchZone> addsbZones = new HashSet<SellerBranchZone>(sbz);
        for (SellerBranchZone sbZone : sbz) {
            SellerBranchZone sbranchZone = new SellerBranchZone();
            if (sbZone.getId() != null) {
                sbranchZone = sellerBranchZoneService.getSellerBranchZone(sbZone.getId());
                sbranchZone.setId(sbZone.getId());
                sbranchZone.setZone(sbZone.getZone());
                sbranchZone.setStatus(sbZone.getStatus());
                sbranchZone.setSellerBranch(sbranchZone.getSellerBranch());
                sbranchZone = sellerBranchZoneService.updateSellerBranchZone(sbranchZone);
            }
            sbranchZone.setZone(sbZone.getZone());
            sbranchZone.setStatus(sbZone.getStatus());
            sbranchZone.setSellerBranch(sbZone.getSellerBranch());
            sbranchZone.setCreatedDate(new Date());
            addsbZones.add(sbranchZone);
            sbranchZone = sellerBranchZoneRepository.save(sbranchZone);
        }
        sellerBranch.setSellerBranchZones(addsbZones);

        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#addSellerItems(com.meat.domain.SellerBranch, java.util.Set)
     */
    @Override
    public SellerBranch addSellerItems(final SellerBranch sellerBranch, final Set<SellerItem> sellerItems) {
        Validate.notNull(sellerBranch, "sellerBranch must not be null");
        Set<SellerItem> addsiTimings = new HashSet<SellerItem>(sellerItems);
        for (SellerItem si : sellerItems) {
            SellerItem sellerItm = new SellerItem();
            if (si.getId() != null) {
                sellerItm = sellerItemService.getSellerItem(si.getId());
                sellerItm.setId(si.getId());
                sellerItm.setSellerItemName(si.getSellerItemName());
                sellerItm.setItemAvailableStatus(si.getItemAvailableStatus());
                sellerItm.setSellerBranch(sellerItm.getSellerBranch());
                sellerItm.setDescription(si.getDescription());
                //  sellerItm.setIngredients(si.getIngredients());
                sellerItm.setSellingPrice(si.getSellingPrice());
                sellerItm.setQuantity(si.getQuantity());
                sellerItm.setSellerStock(si.getSellerStock());
                sellerItm.setSpecialTag(si.getSpecialTag());
                sellerItm.setSeo(si.getSeo());
                sellerItm.setSellingTag(si.getSellingTag());
                sellerItm = sellerItemService.updateSellerItem(sellerItm);
            }
            sellerItm.setSellerItemName(si.getSellerItemName());
            sellerItm.setItemAvailableStatus(si.getItemAvailableStatus());
            sellerItm.setSellerBranch(si.getSellerBranch());
            sellerItm.setDescription(si.getDescription());
            //sellerItm.setIngredients(si.getIngredients());
            sellerItm.setSellingPrice(si.getSellingPrice());
            sellerItm.setQuantity(si.getQuantity());
            sellerItm.setSellerStock(si.getSellerStock());
            sellerItm.setSpecialTag(si.getSpecialTag());
            Seo seo = new Seo();
            seo.setSeoTitle(si.getSeo().getSeoTitle());
            seo.setSeoKeywords(si.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(si.getSeo().getSeoMetaDescription());
            /* seo = seoService.create(seo);*/
            sellerItm.setSeo(seo);
            sellerItm.setSellingTag(si.getSellingTag());
            sellerItm.setCreatedDate(new Date());
            addsiTimings.add(sellerItm);
            sellerItm = sellerItemService.create(sellerItm);
        }
        sellerBranch.setSellerItems(addsiTimings);
        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#create(com.meat.domain.SellerBranch)
     */

    @Override
    @Transactional
    public SellerBranch create(final SellerBranch sellerBranch) {
        SellerBranch sellerBrnch = new SellerBranch();
        sellerBrnch = sellerBranchRepository.save(sellerBranch);
        Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
        if (CollectionUtils.isNotEmpty(sellerBranch.getSellerBranchAddresses())) {
            for (SellerBranchAddress sllrBranchAddress : sellerBranch.getSellerBranchAddresses()) {
                SellerBranchAddress slrBranchAddress = sllrBranchAddress;
                slrBranchAddress.setAddress(sllrBranchAddress.getAddress());
                slrBranchAddress.setSellerBranch(sellerBrnch);
                slrBranchAddress.setStatus(sllrBranchAddress.getStatus());
                slrBranchAddress = sellerBranchAddressService.create(slrBranchAddress);
                sellerBranchAddresses.add(slrBranchAddress);
            }
            sellerBrnch.setSellerBranchAddresses(sellerBranchAddresses);
        }

        Set<SellerBranchImages> sellBranchImages = new HashSet<SellerBranchImages>();
        if (CollectionUtils.isNotEmpty(sellerBranch.getSellerBranchImageses())) {
            for (SellerBranchImages sbiModel : sellerBranch.getSellerBranchImageses()) {
                SellerBranchImages sellBranchImage = new SellerBranchImages();
                sellBranchImage.setImageName(sbiModel.getImageName());
                sellBranchImage.setImageLocation(sbiModel.getImageLocation());
                sellBranchImage.setImageType(sbiModel.getImageType());
                sellBranchImage.setSellerBranch(sellerBrnch);
                sellBranchImage = sellerBranchImagesService.create(sellBranchImage);
                sellBranchImages.add(sellBranchImage);
            }
            sellerBrnch.setSellerBranchImageses(sellBranchImages);
        }

        if (sellerBranch.getId() != null) {
            Set<SellerBranchZone> selBranchZones = new HashSet<SellerBranchZone>();
            if (sellerBranch.getSellerBranchZones() != null) {
                for (SellerBranchZone sbz : sellerBranch.getSellerBranchZones()) {
                    SellerBranchZone selBranchZone = new SellerBranchZone();
                    selBranchZone.setSellerBranch(sellerBrnch);
                    Zone zone = new Zone();
                    zone.setId(sbz.getZone().getId());
                    selBranchZone.setZone(zone);
                    selBranchZone.setStatus(sbz.getStatus());
                    selBranchZone.setCreatedDate(new Date());

                    selBranchZone = sellerBranchZoneService.create(selBranchZone);
                    selBranchZones.add(selBranchZone);
                }
                sellerBrnch.setSellerBranchZones(selBranchZones);
            }
            if (sellerBranch.getSellerBranchTaxes() != null) {
                Set<SellerBranchTax> sellerBranchTaxes = new HashSet<SellerBranchTax>();
                for (SellerBranchTax sellerBranchTax : sellerBranch.getSellerBranchTaxes()) {
                    SellerBranchTax sellerBranchT = sellerBranchTax;
                    sellerBranchT.setSellerBranch(sellerBranch);
                    sellerBranchT = sellerBranchTaxService.create(sellerBranchT);
                    sellerBranchTaxes.add(sellerBranchT);
                }
                sellerBrnch.setSellerBranchTaxes(sellerBranchTaxes);
            }

        }
        return sellerBrnch;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#deleteSellerBranch(java.lang.String)
     */
    @Override
    public void deleteSellerBranch(final String sellerBranchId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getAll()
     */
    @Override
    public List<SellerBranch> getAll() {
        List<SellerBranch> sellerBranch = new ArrayList<SellerBranch>();
        sellerBranch = (List<SellerBranch>) sellerBranchRepository.findAll();
        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getBranchBySellerItem(java.lang.String)
     */
    @Override
    public SellerBranch getBranchBySellerItem(final String sellerItemId) {
        // TODO Auto-generated method stub

        return sellerBranchRepository.findSellerBranchBySellerItem(sellerItemId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranch(java.lang.String)
     */
    @Override
    public SellerBranch getSellerBranch(final String sellerBranchId) {
        // TODO Auto-generated method stub
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch = sellerBranchRepository.findOne(sellerBranchId);
        return sellerBranch;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchBySeller(java.lang.String)
     */
    @Override
    public List<SellerBranch> getSellerBranchBySeller(final String sellerId) {
        List<SellerBranch> sellerBranch = new ArrayList<SellerBranch>();
        sellerBranch = sellerBranchRepository.findSellerBranchBySeller(sellerId);
        List<SellerBranch> sellerBranches = new ArrayList<SellerBranch>();
        for (SellerBranch sd : sellerBranch) {
            SellerBranch slrBranch = new SellerBranch();
            slrBranch.setId(sd.getId());
            slrBranch.setBranchName(sd.getBranchName());
            slrBranch.setBranchStatus(sd.getBranchStatus());
            /*slrBranch.setSellerEmailId(sd.getSellerEmailId());
            slrBranch.setSellerPhoneNo(sd.getSellerPhoneNo());
            slrBranch.setBranchStatus(sd.getBranchStatus());
            slrBranch.setLandlineNo(sd.getLandlineNo());
            slrBranch.setMinimumOrderTime(sd.getMinimumOrderTime());
            slrBranch.setSeller(sd.getSeller());*/
            sellerBranches.add(slrBranch);
        }
        return sellerBranches;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchItemsOnly(java.lang.String)
     */

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchByUserId(java.lang.String)
     */
    @Override
    public SellerBranch getSellerBranchByUserId(final String userId) {
        //  SellerBranch sb = sellerBranchRepository.findSellerBranchByUserId(userId);
        return sellerBranchRepository.findSellerBranchByUserId(userId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchesByThemeleafCategory(java.lang.String)
     */
    @Override
    public List<SellerBranch> getSellerBranchesByThemeleafCategory(final String categoryId) {
        List<SellerBranch> sellerBranches = sellerBranchRepository.findSellerBranchByThymeleafCategory(categoryId);
        return sellerBranches;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchesByThemeleafCategoryZone(java.lang.String, java.lang.String)
     */
    @Override
    public List<SellerBranch> getSellerBranchesByThemeleafCategoryZone(final String categoryId, final String zoneId) {
        List<SellerBranch> sellerBranches = sellerBranchRepository.findSellerBranchByThymeleafCategoryZone(categoryId, zoneId);
        return sellerBranches;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchOnly()
     */

    @Override
    public List<SellerBranch> getSellerBranchOnly() {
        List<SellerBranch> sellerBranch = new ArrayList<SellerBranch>();
        sellerBranch = (List<SellerBranch>) sellerBranchRepository.findAll();
        List<SellerBranch> sellerBranches = new ArrayList<SellerBranch>();
        for (SellerBranch sb : sellerBranch) {
            SellerBranch slrBranch = new SellerBranch();
            slrBranch.setId(sb.getId());
            slrBranch.setBranchName(sb.getBranchName());
            slrBranch.setSellerEmailId(sb.getSellerEmailId());
            slrBranch.setSellerPhoneNo(sb.getSellerPhoneNo());
            slrBranch.setBranchStatus(sb.getBranchStatus());
            slrBranch.setLandlineNo(sb.getLandlineNo());
            slrBranch.setMinimumOrderTime(sb.getMinimumOrderTime());
            slrBranch.setSeller(sb.getSeller());
            sellerBranches.add(slrBranch);

            /*   List<Tax> taxs = (List<Tax>) taxRepository.findAll();
            for (Tax t : taxs) {
                Tax tax = new Tax();
                tax.setId(t.getId());

                SellerBranchTax sellerBranchTaxes = new SellerBranchTax();
                AmountType amntType = new AmountType();
                amntType.setId("402880f4522d661501522d6ee1a30007");
                sellerBranchTaxes.setAmountType(amntType);
                sellerBranchTaxes.setCreatedDate(new Date());
                sellerBranchTaxes.setSellerBranch(slrBranch);
                sellerBranchTaxes.setSellerBranchTaxStatus("ACTIVE");
                sellerBranchTaxes.setTax(tax);
                String value = "10.00";
                if (value != null) {
                    BigDecimal taxValue = new BigDecimal(value.replaceAll(",", " "));
                    sellerBranchTaxes.setTaxValue(taxValue);
                }

                sellerBranchTaxes = sellerBranchTaxService.create(sellerBranchTaxes);
            }*/
        }

        return sellerBranches;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#getSellerBranchOnlyBySellerBranch(java.lang.String)
     */
    @Override
    public List<SellerBranch> getSellerBranchOnlyBySellerBranch(final String sellerBranchId) {
        List<SellerBranch> sellerBranch = new ArrayList<SellerBranch>();
        sellerBranch = sellerBranchRepository.findSellerBranchOnlyBySellerBranch(sellerBranchId);
        List<SellerBranch> sellerBranches = new ArrayList<SellerBranch>();
        for (SellerBranch sd : sellerBranch) {
            SellerBranch slrBranch = new SellerBranch();
            slrBranch.setId(sd.getId());
            slrBranch.setBranchName(sd.getBranchName());
            slrBranch.setBranchStatus(sd.getBranchStatus());
            slrBranch.setSellerEmailId(sd.getSellerEmailId());
            slrBranch.setSellerPhoneNo(sd.getSellerPhoneNo());
            slrBranch.setBranchStatus(sd.getBranchStatus());
            slrBranch.setLandlineNo(sd.getLandlineNo());
            slrBranch.setMinimumOrderTime(sd.getMinimumOrderTime());
            slrBranch.setSeller(sd.getSeller());
            slrBranch.setDeliveryCharges(sd.getDeliveryCharges());
            slrBranch.setDeliveryCutoffDays(sd.getDeliveryCutoffDays());
            slrBranch.setSellerBranchAddresses(sd.getSellerBranchAddresses());
            slrBranch.setSellerBranchTimingses(sd.getSellerBranchTimingses());
            slrBranch.setSellerBranchTaxes(sd.getSellerBranchTaxes());
            slrBranch.setSellerUser(sd.getSellerUser());
            slrBranch.setSellerBranchCharges(sd.getSellerBranchCharges());
            sellerBranches.add(slrBranch);
        }
        return sellerBranches;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerBranchService#updateSellerBranch(com.meat.domain.SellerBranch)
     */
    @Override
    @Transactional
    public SellerBranch updateSellerBranch(final SellerBranch sellerBranch) {
        Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
        if (CollectionUtils.isNotEmpty(sellerBranch.getSellerBranchAddresses())) {
            for (SellerBranchAddress sllrBranchAddress : sellerBranch.getSellerBranchAddresses()) {
                SellerBranchAddress slrBranchAddress = sllrBranchAddress;
                slrBranchAddress.setId(sllrBranchAddress.getId());
                slrBranchAddress.setAddress(sllrBranchAddress.getAddress());
                slrBranchAddress.setSellerBranch(sellerBranch);
                slrBranchAddress.setStatus(sllrBranchAddress.getStatus());
                slrBranchAddress = sellerBranchAddressService.updateSellerBranchAddress(slrBranchAddress);
                sellerBranchAddresses.add(slrBranchAddress);
            }
            sellerBranch.setSellerBranchAddresses(sellerBranchAddresses);
        }

        return sellerBranchRepository.save(sellerBranch);
    }

}
