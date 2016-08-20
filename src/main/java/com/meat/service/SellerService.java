/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchImagesRepository;
import com.meat.dao.SellerBranchRepository;
import com.meat.dao.SellerImagesRepository;
import com.meat.dao.SellerRepository;
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
public class SellerService implements ISellerService {
    @Autowired
    private ISeoService seoService;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private ISellerBranchService sellerBranchService;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;
    @Autowired
    private SellerBranchImagesRepository sellerBranchImagesRepository;
    @Autowired
    private SellerBranchRepository sellerBranchRepository;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private SellerImagesRepository sellerImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#addSellerBranch(com.meat.domain.Seller, java.util.List)
     */
    /*  @Override
      public Seller addSellerBranch(final Seller seller, final List<SellerBranch> slrBranch) {
          // TODO Auto-generated method stub
          return null;
      }*/

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#addSellerImages(com.meat.domain.Seller, java.util.Set)
     */
    @Override
    public Seller addSellerImages(final Seller seller, final Set<SellerImages> sellerImageses) {

        Validate.notNull(seller, "seller must not be null");
        Set<SellerImages> addImages = new HashSet<SellerImages>(sellerImageses);
        for (SellerImages sImages : sellerImageses) {

            SellerImages sellerImages = new SellerImages();
            String s = sImages.getImageName();

            if (sImages.getId() != null && sImages.getId() != "") {
                SellerImages sellerImages1 = sellerImagesRepository.findOne(sImages.getId());

                s = s.replaceAll("\\\\", "/");
                sellerImages1.setImageName(sImages.getImageName());
                sellerImages1.setImageType(sImages.getImageType());
                sellerImages1.setImageLocation(sImages.getImageLocation());
                sellerImages1.setSeller(seller);

                sellerImages = sellerImagesRepository.save(sellerImages1);

            }
            else {
                s = s.replaceAll("\\\\", "/");
                sellerImages.setImageName(s);
                sellerImages.setImageType(sImages.getImageType());
                sellerImages.setImageLocation(sImages.getImageLocation());
                sellerImages.setSeller(seller);

                sellerImages = sellerImagesRepository.save(sellerImages);

            }

        }
        seller.setSellerImageses(addImages);

        return seller;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#create(com.meat.domain.Seller)
     */

    @Override
    @Transactional
    public Seller create(final Seller seller) {
        Seo seo = new Seo();
        if (seller.getSeo() != null) {
            seo.setId(seller.getSeo().getId());
            seo.setSeoTitle(seller.getSeo().getSeoTitle());
            seo.setSeoKeywords(seller.getSeo().getSeoKeywords());
            seo.setSeoMetaDescription(seller.getSeo().getSeoMetaDescription());
            seo = seoService.create(seo);

            seller.setSeo(seo);
        }
        Seller sllr = sellerRepository.save(seller);

        Set<SellerBranch> sellerBranches = new HashSet<SellerBranch>();
        if (CollectionUtils.isNotEmpty(seller.getSellerBranches())) {
            for (SellerBranch sellrBranch : seller.getSellerBranches()) {
                SellerBranch sllrBranch = sellrBranch;
                sllrBranch.setSeller(sllr);

                Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
                if (CollectionUtils.isNotEmpty(sellrBranch.getSellerBranchAddresses())) {
                    for (SellerBranchAddress sellerBranchaddres : sellrBranch.getSellerBranchAddresses()) {
                        SellerBranchAddress sellerBranchAddress = sellerBranchaddres;
                        sellerBranchAddress.setAddress(sellerBranchaddres.getAddress());
                        sellerBranchAddress.setSellerBranch(sellrBranch);
                        sellerBranchAddresses.add(sellerBranchAddress);
                    }
                    sllrBranch.setSellerBranchAddresses(sellerBranchAddresses);
                }
                Set<SellerBranchTax> sellerBranchTaxes = new HashSet<SellerBranchTax>();
                if (CollectionUtils.isNotEmpty(sellrBranch.getSellerBranchTaxes())) {
                    for (SellerBranchTax sbTax : sellrBranch.getSellerBranchTaxes()) {
                        SellerBranchTax sbt = new SellerBranchTax();
                        sbt.setTax(sbTax.getTax());
                        sbt.setAmountType(sbTax.getAmountType());
                        sbt.setTaxValue(sbTax.getTaxValue());
                        sbt.setSellerBranch(sbTax.getSellerBranch());
                        sbt.setSellerBranchTaxStatus(sbTax.getSellerBranchTaxStatus());
                        sbt.setCreatedDate(new Date());
                        sellerBranchTaxes.add(sbt);
                    }
                    sllrBranch.setSellerBranchTaxes(sellerBranchTaxes);
                }

                Set<SellerBranchZone> sbzs = new HashSet<SellerBranchZone>();
                if (CollectionUtils.isNotEmpty(sellrBranch.getSellerBranchZones())) {
                    for (SellerBranchZone sbzone : sellrBranch.getSellerBranchZones()) {
                        SellerBranchZone sllrBranchZone = new SellerBranchZone();
                        Zone z = new Zone();
                        z.setId(sbzone.getZone().getId());
                        sllrBranchZone.setZone(z);
                        sllrBranchZone.setSellerBranch(sllrBranch);
                        sllrBranchZone.setStatus(sbzone.getStatus());
                        sllrBranchZone.setCreatedDate(new Date());
                        sbzs.add(sllrBranchZone);
                    }
                    sllrBranch.setSellerBranchZones(sbzs);
                }

                sllrBranch = sellerBranchService.create(sllrBranch);
                sellerBranches.add(sllrBranch);
            }
        }
        sllr.setSellerBranches(sellerBranches);
        return sllr;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#deleteSeller(java.lang.String)
     */
    @Override
    public void deleteSeller(final String sellerId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#getAll()
     */
    @Override
    public List<Seller> getAll() {
        List<Seller> seller = new ArrayList<Seller>();
        seller = (List<Seller>) sellerRepository.findAll();
        return seller;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return sellerRepository.getMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#getSeller(java.lang.String)
     */
    @Override
    public Seller getSeller(final String sellerId) {
        Seller seller = new Seller();
        seller = sellerRepository.findOne(sellerId);
        return seller;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#getSellerOnly()
     */

    @Override
    public List<Seller> getSellerOnly() {
        List<Seller> seller = new ArrayList<Seller>();
        seller = (List<Seller>) sellerRepository.findAll();
        List<Seller> sellers = new ArrayList<Seller>();
        for (Seller s : seller) {
            Seller slr = new Seller();
            slr.setId(s.getId());
            slr.setSellerName(s.getSellerName());
            slr.setDescription(s.getDescription());
            slr.setCreatedDate(s.getCreatedDate());
            slr.setStatus(s.getStatus());
            slr.setSellerCode(s.getSellerCode());
            slr.setSellerCount(s.getSellerCount());
            slr.setSellerType(s.getSellerType());
            slr.setSeo(s.getSeo());
            sellers.add(slr);
        }
        return sellers;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerService#updateSeller(com.meat.domain.Seller)
     */
    @Override
    public Seller updateSeller(final Seller seller) {
        // TODO Auto-generated method stub
        return sellerRepository.save(seller);
    }

}
