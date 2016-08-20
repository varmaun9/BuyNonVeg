/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.*;
import com.meat.model.SellerBranchAddressModel;
import com.meat.model.SellerBranchModel;
import com.meat.model.SellerBranchTaxModel;
import com.meat.model.SellerModel;
import com.meat.service.IAddressService;
import com.meat.service.ISellerBranchService;
import com.meat.service.ISellerService;
import com.meat.service.ISeoService;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */

@Service
public class SellerBusinessDelegate implements IBusinessDelegate<SellerModel, SellerContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerService sellerService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ISellerBranchService sellerBranchService;
    @Autowired
    private IAddressService addressService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerModel create(final SellerModel model) {

        Seller seller = new Seller();
        Seo seo = new Seo();
        seo.setId(model.getSeoId());
        seller.setSeo(seo);
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());

        seller.setDescription(model.getDescription());
        seller.setSellerName(model.getSellerName());
        seller.setSellerType(model.getSellerType());
        seller.setCreatedDate(new Date());
        seller.setStatus(model.getStatus());
        Integer i = sellerService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            seller.setSellerCount(bi);
        }
        else {
            long bi = (i + 1);
            seller.setSellerCount(bi);
        }
        Integer ca = i + 1;
        String m = DBSequences.SELLER.getSequenceName();
        String mc = m.concat(ca.toString());
        seller.setSellerCode(mc);

        Set<SellerBranch> sellerBranches = new HashSet<SellerBranch>();
        if (CollectionUtils.isNotEmpty(model.getSellerBranchModels())) {
            for (SellerBranchModel sllrBranchModel : model.getSellerBranchModels()) {
                SellerBranch sllrBranch = new SellerBranch();
                sllrBranch.setSeller(seller);
                sllrBranch.setId(sllrBranchModel.getId());
                sllrBranch.setBranchName(sllrBranchModel.getBranchName());
                sllrBranch.setSellerEmailId(sllrBranchModel.getSellerEmailId());
                sllrBranch.setSellerPhoneNo(sllrBranchModel.getSellerPhoneNo());
                sllrBranch.setLandlineNo(sllrBranchModel.getLandlineNo());
                sllrBranch.setBranchStatus(sllrBranchModel.getBranchStatus());
                sllrBranch.setMinimumOrderTime(sllrBranchModel.getMinimumOrderTime());
                sllrBranch.setDeliveryCutoffDays(Integer.parseInt(sllrBranchModel.getDeliveryCutoffDays()));

                Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
                if (CollectionUtils.isNotEmpty(sllrBranchModel.getSellerBranchAddressModels())) {
                    for (SellerBranchAddressModel adModel : sllrBranchModel.getSellerBranchAddressModels()) {
                        SellerBranchAddress sellerBranchAddress = new SellerBranchAddress();
                        Address address = new Address();
                        address.setLine1(adModel.getLine1());
                        address.setTown(adModel.getTown());
                        address.setType(adModel.getType());
                        address.setCity(adModel.getCity());
                        address.setDistrict(adModel.getDistrict());
                        address.setState(adModel.getState());
                        address.setCountry(adModel.getCountry());
                        address.setZipcode(adModel.getZipcode());
                        address = addressService.create(address);
                        sellerBranchAddress.setAddress(address);
                        sellerBranchAddress.setSellerBranch(sllrBranch);
                        sellerBranchAddresses.add(sellerBranchAddress);
                    }
                    sllrBranch.setSellerBranchAddresses(sellerBranchAddresses);
                }

                if (sllrBranchModel.getSellerBranchTaxModels() != null) {
                    Set<SellerBranchTax> sbt = new HashSet<SellerBranchTax>();
                    for (SellerBranchTaxModel sbtModel : sllrBranchModel.getSellerBranchTaxModels()) {
                        SellerBranchTax sellerBranchTax = new SellerBranchTax();
                        Tax tax = new Tax();
                        tax.setId(sbtModel.getTaxId());
                        sellerBranchTax.setTax(tax);
                        AmountType amountType = new AmountType();
                        amountType.setId(sbtModel.getAmountTypeId());
                        sellerBranchTax.setAmountType(amountType);
                        String value = sbtModel.getTaxValue();
                        if (sbtModel.getTaxValue() != null) {
                            BigDecimal taxValue = new BigDecimal(value.replaceAll(",", " "));
                            sellerBranchTax.setTaxValue(taxValue);
                        }
                        sellerBranchTax.setSellerBranch(sllrBranch);
                        sellerBranchTax.setSellerBranchTaxStatus(sbtModel.getSellerBranchTaxStatus());
                        sellerBranchTax.setCreatedDate(new Date());
                        sbt.add(sellerBranchTax);
                    }
                    sllrBranch.setSellerBranchTaxes(sbt);
                }
            }
            seller.setSellerBranches(sellerBranches);
        }
        seller = sellerService.create(seller);
        model.setId(seller.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerModel edit(final IKeyBuilder<String> keyBuilder, final SellerModel model) {

        Seller seller = sellerService.getSeller(keyBuilder.build().toString());
        seller.setSellerName(model.getSellerName());
        seller.setDescription(model.getDescription());
        seller.setStatus(model.getStatus());
        seller.setSellerType(model.getSellerType());
        if (model.getSeoId() != null) {
            Seo seo = seoService.getSeo(seller.getSeo().getId());
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            seller.setSeo(seo);
        }
        Set<SellerBranch> sellerBranches = new HashSet<SellerBranch>();
        if (CollectionUtils.isNotEmpty(model.getSellerBranchModels())) {
            for (SellerBranchModel sbModel : model.getSellerBranchModels()) {
                SellerBranch sellerBranch = sellerBranchService.getSellerBranch(sbModel.getId());
                sellerBranch.setBranchName(sbModel.getBranchName());
                sellerBranch.setMinimumOrderTime(sbModel.getMinimumOrderTime());
                sellerBranch.setSellerEmailId(sbModel.getSellerEmailId());
                sellerBranch.setSellerPhoneNo(sbModel.getSellerPhoneNo());
                sellerBranch.setBranchStatus(sbModel.getBranchStatus());
                sellerBranch.setSeller(seller);
                sellerBranches.add(sellerBranch);

                Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
                if (CollectionUtils.isNotEmpty(sbModel.getSellerBranchAddressModels())) {
                    for (SellerBranchAddressModel adModel : sbModel.getSellerBranchAddressModels()) {
                        SellerBranchAddress sellerBranchAddress = new SellerBranchAddress();
                        Address address = new Address();
                        address.setLine1(adModel.getLine1());
                        address.setTown(adModel.getTown());
                        address.setType(adModel.getType());
                        address.setCity(adModel.getCity());
                        address.setDistrict(adModel.getDistrict());
                        address.setState(adModel.getState());
                        address.setCountry(adModel.getCountry());
                        address.setZipcode(adModel.getZipcode());
                        sellerBranchAddresses.add(sellerBranchAddress);
                    }
                    sellerBranch.setSellerBranchAddresses(sellerBranchAddresses);
                }

                seller.setSellerBranches(sellerBranches);
            }
        }
        seller = sellerService.updateSeller(seller);

        model.setId(seller.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerContext context) {
        Seller seller = sellerService.getSeller(keyBuilder.build().toString());
        SellerModel sellerModel = conversionService.convert(seller, SellerModel.class);

        return sellerModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerModel> getCollection(final SellerContext context) {
        List<Seller> seller = new ArrayList<Seller>();
        if (context.getAll() != null) {
            seller = sellerService.getAll();
        }
        if (context.getSellerOnly() != null) {
            seller = sellerService.getSellerOnly();
        }
        List<SellerModel> slrModels = (List<SellerModel>) conversionService.convert(seller, TypeDescriptor.forObject(seller),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerModel.class)));
        return slrModels;
    }
}