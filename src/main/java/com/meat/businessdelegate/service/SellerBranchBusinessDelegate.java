/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.dao.AddressRepository;
import com.meat.dao.SellerBranchRepository;
import com.meat.domain.*;
import com.meat.model.*;
import com.meat.service.*;

import java.math.BigDecimal;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author venky
 *
 */
@Service
public class SellerBranchBusinessDelegate
        implements IBusinessDelegate<SellerBranchModel, SellerBranchContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBranchImagesService sellerBranchImagesService;
    @Autowired
    private ISellerBranchAddressService sellerBranchAddressService;
    @Autowired
    private ISellerBranchService sellerBranchService;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISellerService sellerService;
    @Autowired
    private SellerBranchRepository sellerBranchRepository;

    /* @Autowired
     private IAmountTypeService amountTypeService;
     @Autowired
     private ITaxService taxService;*/

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchModel create(final SellerBranchModel model) {

        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getId());
        Seller seller = new Seller();
        seller.setId(model.getSellerId());
        sellerBranch.setSeller(seller);
        sellerBranch.setBranchName(model.getBranchName());
        sellerBranch.setSellerEmailId(model.getSellerEmailId());
        sellerBranch.setSellerPhoneNo(model.getSellerPhoneNo());
        sellerBranch.setLandlineNo(model.getLandlineNo());
        sellerBranch.setBranchStatus(model.getBranchStatus());
        sellerBranch.setMinimumOrderTime(model.getMinimumOrderTime());
        sellerBranch.setDeliveryCutoffDays(Integer.parseInt(model.getDeliveryCutoffDays()));
        if (model.getSellerBranchAddressModels() != null) {
            Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
            if (CollectionUtils.isNotEmpty(model.getSellerBranchAddressModels())) {
                for (SellerBranchAddressModel adModel : model.getSellerBranchAddressModels()) {
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
                    sellerBranchAddress.setSellerBranch(sellerBranch);
                    sellerBranchAddress.setStatus(adModel.getStatus());
                    sellerBranchAddresses.add(sellerBranchAddress);
                }
                sellerBranch.setSellerBranchAddresses(sellerBranchAddresses);
            }
        }
        if (model.getSellerBranchZoneModels() != null) {
            Set<SellerBranchZone> sbz = new HashSet<SellerBranchZone>();
            for (SellerBranchZoneModel sbzModels : model.getSellerBranchZoneModels()) {
                SellerBranchZone sllrBranchZone = new SellerBranchZone();
                Zone zone = new Zone();
                zone.setId(sbzModels.getZoneId());
                sllrBranchZone.setZone(zone);
                sllrBranchZone.setSellerBranch(sellerBranch);
                sllrBranchZone.setStatus(sbzModels.getStatus());
                sllrBranchZone.setCreatedDate(new Date());
                sbz.add(sllrBranchZone);
            }
            sellerBranch.setSellerBranchZones(sbz);
        }
        if (model.getSellerBranchTaxModels() != null) {
            Set<SellerBranchTax> sbt = new HashSet<SellerBranchTax>();
            for (SellerBranchTaxModel sbtModel : model.getSellerBranchTaxModels()) {
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
                sellerBranchTax.setSellerBranch(sellerBranch);
                sellerBranchTax.setSellerBranchTaxStatus(sbtModel.getSellerBranchTaxStatus());
                sellerBranchTax.setCreatedDate(new Date());
                sbt.add(sellerBranchTax);
            }
            sellerBranch.setSellerBranchTaxes(sbt);
        }

        Set<SellerBranchImages> sellerBranchImages = new HashSet<SellerBranchImages>();
        if (CollectionUtils.isNotEmpty(model.getSellerBranchImagesModels())) {
            for (SellerBranchImagesModel sbiModel : model.getSellerBranchImagesModels()) {
                SellerBranchImages sbi = new SellerBranchImages();
                sbi.setImageName(sbiModel.getImageName());
                sbi.setImageType(sbiModel.getImageType());
                sbi.setImageLocation(sbiModel.getImageLocation());
                sbi.setSellerBranch(sellerBranch);
                sellerBranchImages.add(sbi);
            }

            sellerBranch.setSellerBranchImageses(sellerBranchImages);
        }

        sellerBranch = sellerBranchService.create(sellerBranch);
        model.setId(sellerBranch.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBranchContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBranchModel edit(final IKeyBuilder<String> keyBuilder, final SellerBranchModel model) {

        SellerBranch sellerBranch = sellerBranchService.getSellerBranch(keyBuilder.build().toString());
        sellerBranch.setId(model.getId());
        if (model.getSellerId() != null) {
            Seller seller = new Seller();
            seller.setId(model.getSellerId());
            sellerBranch.setSeller(seller);
        }
        else {
            sellerBranch.setSeller(sellerBranch.getSeller());
        }
        if (model.getBranchName() != null) {
            sellerBranch.setBranchName(model.getBranchName());
        }
        //sellerBranch.setSellerEmailId(model.getSellerEmailId());
        if (model.getSellerPhoneNo() != null) {
            sellerBranch.setSellerPhoneNo(model.getSellerPhoneNo());
        }
        sellerBranch.setLandlineNo(model.getLandlineNo());
        if (model.getBranchStatus() != null) {
            sellerBranch.setBranchStatus(model.getBranchStatus());
        }
        if (model.getMinimumOrderTime() != null) {
            sellerBranch.setMinimumOrderTime(model.getMinimumOrderTime());
        }
        if (model.getMinimumOrderAmount() != null) {
            sellerBranch.setMinimumOrderAmount(new BigDecimal(model.getMinimumOrderAmount()));
        }
        if (model.getMinimunOrderDeliveryAmount() != null) {
            sellerBranch.setMinimumOrderDeliveryAmount(new BigDecimal(model.getMinimunOrderDeliveryAmount()));
        }
        if (model.getMinimumPickupTime() != null) {
            sellerBranch.setMinimumPickupTime(model.getMinimumPickupTime());
        }
        if (model.getDeliveryCutoffDays() != null) {
            sellerBranch.setDeliveryCutoffDays(Integer.parseInt(model.getDeliveryCutoffDays()));
        }
        if (model.getDeliveryCharges() != null) {
            sellerBranch.setDeliveryCharges(new BigDecimal(model.getDeliveryCharges()));
        }
        Set<SellerBranchAddress> sellerBranchAddresses = new HashSet<SellerBranchAddress>();
        if (CollectionUtils.isNotEmpty(model.getSellerBranchAddressModels())) {
            for (SellerBranchAddressModel adModel : model.getSellerBranchAddressModels()) {
                SellerBranchAddress sellerBranchAddress = new SellerBranchAddress();
                sellerBranchAddress.setId(adModel.getId());
                Address address = new Address();
                address.setId(adModel.getAddressId());
                address.setLine1(adModel.getLine1());
                address.setTown(adModel.getTown());
                address.setType(adModel.getType());
                address.setCity(adModel.getCity());
                address.setDistrict(adModel.getDistrict());
                address.setState(adModel.getState());
                address.setCountry(adModel.getCountry());
                address.setZipcode(adModel.getZipcode());
                address = addressService.updateAddress(address);
                sellerBranchAddress.setAddress(address);
                sellerBranchAddress.setSellerBranch(sellerBranch);
                sellerBranchAddress.setStatus(adModel.getStatus());
                sellerBranchAddresses.add(sellerBranchAddress);
            }
            sellerBranch.setSellerBranchAddresses(sellerBranchAddresses);
        }

        if (sellerBranch.getId() != null) {
            Set<SellerItem> sellerItems = new HashSet<SellerItem>();
            if (CollectionUtils.isNotEmpty(model.getSellerItemModels())) {
                for (SellerItemModel siModel : model.getSellerItemModels()) {
                    SellerItem slrItem = new SellerItem();
                    slrItem.setId(siModel.getId());
                    //slrItem.setIngredients(siModel.getIngredients());
                    slrItem.setDescription(siModel.getDescription());
                    Item it = new Item();
                    it.setId(siModel.getId());
                    slrItem.setItem(it);
                    slrItem.setItemAvailableStatus(siModel.getItemAvailableStatus());
                    slrItem.setSpecialTag(siModel.getSpecialTag());
                    String value = siModel.getSellingPrice();
                    if (value != null) {
                        BigDecimal price = new BigDecimal(value.replaceAll(",", " "));
                        slrItem.setSellingPrice(price);
                    }
                    slrItem.setQuantity(siModel.getQuantity());
                    slrItem.setSellerBranch(sellerBranch);
                    slrItem.setSellerItemName(siModel.getSellerItemName());
                    slrItem.setSellerStock(siModel.getSellerStock());
                    Seo seo = new Seo();
                    seo.setSeoTitle(siModel.getSeoTitle());
                    seo.setSeoKeywords(siModel.getSeoKeywords());
                    seo.setSeoMetaDescription(siModel.getSeoMetaDescription());
                    slrItem.setSeo(seo);
                    sellerItems.add(slrItem);
                }
                sellerBranch = sellerBranchService.addSellerItems(sellerBranch, sellerItems);
            }

            if (model.getSellerBranchTaxModels() != null) {
                Set<SellerBranchTax> sbt = new HashSet<SellerBranchTax>();
                for (SellerBranchTaxModel sbtModel : model.getSellerBranchTaxModels()) {
                    SellerBranchTax sellerBranchTax = new SellerBranchTax();
                    sellerBranchTax.setId(sbtModel.getId());
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
                    sellerBranchTax.setSellerBranch(sellerBranch);
                    sellerBranchTax.setSellerBranchTaxStatus(sbtModel.getSellerBranchTaxStatus());
                    sellerBranchTax.setCreatedDate(new Date());
                    sbt.add(sellerBranchTax);
                }
                sellerBranch = sellerBranchService.addSellerBranchTaxes(sellerBranch, sbt);

            }
            List<SellerBranchImages> sellerBranchImages = new ArrayList<SellerBranchImages>();
            if (CollectionUtils.isNotEmpty(model.getSellerBranchImagesModels())) {
                for (SellerBranchImagesModel sbiModel : model.getSellerBranchImagesModels()) {
                    SellerBranchImages slrBranchImages = new SellerBranchImages();
                    slrBranchImages.setId(sbiModel.getId());
                    slrBranchImages.setSellerBranch(sellerBranch);
                    slrBranchImages.setImageLocation(sbiModel.getImageLocation());
                    slrBranchImages.setImageName(sbiModel.getImageName());
                    slrBranchImages.setImageType(sbiModel.getImageType());
                    sellerBranchImages.add(slrBranchImages);

                }
                sellerBranch = sellerBranchService.addSellerBranchImages(sellerBranch, sellerBranchImages);
            }

            if (model.getSellerBranchZoneModels() != null) {
                Set<SellerBranchZone> sbz = new HashSet<SellerBranchZone>();
                for (SellerBranchZoneModel sbzModels : model.getSellerBranchZoneModels()) {
                    SellerBranchZone sllrBranchZone = new SellerBranchZone();
                    sllrBranchZone.setId(sbzModels.getId());
                    Zone zone = new Zone();
                    zone.setId(sbzModels.getZoneId());
                    sllrBranchZone.setZone(zone);
                    sllrBranchZone.setSellerBranch(sellerBranch);
                    sllrBranchZone.setStatus(sbzModels.getStatus());
                    sllrBranchZone.setCreatedDate(new Date());
                    sbz.add(sllrBranchZone);
                }
                sellerBranch = sellerBranchService.addSellerBranchZones(sellerBranch, sbz);
            }
            Set<SellerBranchTimings> sellerBranchTimings = new HashSet<SellerBranchTimings>();
            if (CollectionUtils.isNotEmpty(model.getSellerBranchTimingsModels())) {
                for (SellerBranchTimingsModel sbtModel : model.getSellerBranchTimingsModels()) {
                    SellerBranchTimings sbt = new SellerBranchTimings();
                    sbt.setId(sbtModel.getId());
                    sbt.setSellerBranch(sellerBranch);
                    sbt.setStatus(sbtModel.getStatus());
                    Timings t = new Timings();
                    t.setId(sbtModel.getTimingsId());
                    sbt.setTimings(t);
                    sellerBranchTimings.add(sbt);
                }
                sellerBranch = sellerBranchService.addSellerBranchTimings(sellerBranch, sellerBranchTimings);
            }
        }
        sellerBranch = sellerBranchService.updateSellerBranch(sellerBranch);
        model.setId(sellerBranch.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerBranchModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBranchContext context) {
        SellerBranch sellerBranch = sellerBranchService.getSellerBranch(keyBuilder.build().toString());
        SellerBranchModel sellerBranchModel = conversionService.convert(sellerBranch, SellerBranchModel.class);

        return sellerBranchModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBranchModel> getCollection(final SellerBranchContext context) {
        List<SellerBranch> sellerBranch = new ArrayList<SellerBranch>();
        if (context.getAll() != null) {
            sellerBranch = sellerBranchService.getAll();
        }
        if (context.getSellerBranchOnly() != null) {
            sellerBranch = sellerBranchService.getSellerBranchOnly();
        }
        if (context.getSellerId() != null) {
            sellerBranch = sellerBranchService.getSellerBranchBySeller(context.getSellerId());
        }
        if (context.getSellerBranchId() != null && context.getSellerBranchOnly() != null) {
            sellerBranch = sellerBranchService.getSellerBranchOnlyBySellerBranch(context.getSellerBranchId());
        }

        List<SellerBranchModel> slrBranchModels = (List<SellerBranchModel>) conversionService.convert(sellerBranch,
                TypeDescriptor.forObject(sellerBranch),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBranchModel.class)));

        return slrBranchModels;
    }

}
