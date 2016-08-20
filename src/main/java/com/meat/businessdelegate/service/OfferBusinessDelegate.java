/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.domain.*;
import com.meat.model.OfferConfigModel;
import com.meat.model.OfferExcludeConfigModel;
import com.meat.model.OfferModel;
import com.meat.service.IOfferService;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class OfferBusinessDelegate implements IBusinessDelegate<OfferModel, OfferContext, IKeyBuilder<String>, String> {

    @Autowired
    private IOfferService offerService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferModel create(final OfferModel model) {

        Offer offer = new Offer();
        offer.setOfferName(model.getOfferName());
        offer.setCreatedDate(new Date());
        offer.setDescription(model.getDescription());
        offer.setStatus(model.getStatus());
        offer.setOfferType(model.getOfferType());
        offer.setOfferNoOfDays(Integer.parseInt(model.getOfferNoOfDays()));
        String value = model.getInvoiceAmount();
        if (value != null) {
            BigDecimal inamnt = new BigDecimal(value.replaceAll(",", " "));
            offer.setInvoiceAmount(inamnt);
        }

        Integer i = offerService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            offer.setOfferCount(bi);
        }
        else {
            long bi = (i + 1);
            offer.setOfferCount(bi);
        }
        Integer ca = i + 1;
        if (model.getOfferType().equals("OFFER")) {
            String m = DBSequences.OFFER.getSequenceName();
            String mc = m.concat(ca.toString());
            offer.setOfferCode(mc);
        }
        if (model.getOfferType().equals("COUPON")) {
            String m = DBSequences.COUPON.getSequenceName();
            String mc = m.concat(ca.toString());
            offer.setOfferCode(mc);
        }
        AmountType amntType = new AmountType();
        amntType.setId(model.getAmountTypeId());
        offer.setAmountType(amntType);
        offer.setAmountTypeValue(Integer.parseInt(model.getAmountTypeValue()));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = model.getOfferFromDate();
        if (dateInString != null && dateInString != "") {
            try {
                Date date = format.parse(dateInString);
                offer.setOfferFromDate(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String dateInString1 = model.getOfferToDate();
        if (dateInString1 != null && dateInString1 != "") {
            try {
                Date date = format.parse(dateInString1);
                offer.setOfferToDate(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (model.getOfferFromTime() != null) {
            String time = model.getOfferFromTime();
            DateFormat sdf = new SimpleDateFormat("HH:mm");
            Date fromTime = null;
            try {
                fromTime = sdf.parse(time);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            offer.setOfferFromTime(sdf.format(fromTime).toString());
        }
        if (model.getOfferToTime() != null) {
            String time1 = model.getOfferToTime();
            DateFormat sdf1 = new SimpleDateFormat("HH:mm");
            Date toTime = null;
            try {
                toTime = sdf1.parse(time1);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            //  System.out.println("to Tiem " + model.getOfferToTime() + " to tiem after parse" + toTime);
            offer.setOfferToTime(sdf1.format(toTime).toString());
        }
        if (model.getQuantity() != null) {
            offer.setQuantity(Integer.parseInt(model.getQuantity()));
        }
        if (model.getPlacedByStatus() != null) {
            offer.setPlacedByStatus(model.getPlacedByStatus());
        }
        if (model.getOfferType().equals("OFFER")) {
            offer.setOfferCouponStatus("OFFER");
        }
        if (model.getOfferType().equals("COUPON")) {
            offer.setOfferCouponStatus("COUPON");
        }

        if (offer.getId() != null) {
            //Offer Assignment implementation
            //** START **
            if (CollectionUtils.isNotEmpty(model.getOfferConfigModels())) {
                Set<OfferConfig> offerConfig = new HashSet<OfferConfig>();
                for (OfferConfigModel ocm : model.getOfferConfigModels()) {
                    OfferConfig ocfg = new OfferConfig();
                    ocfg.setId(ocm.getId());
                    ocfg.setOfferAttributeName(ocm.getOfferAttributeName());
                    ocfg.setOfferAttributeValue(ocm.getOfferAttributeValue());
                    ocfg.setStatus(ocm.getStatus());
                    ocfg.setPlacedByStatus(ocm.getPlacedByStatus());
                    if (ocm.getOfferId() != null) {
                        ocfg.setOffer(offer);
                    }
                    if (ocm.getCategoryId() != null) {
                        Category cat = new Category();
                        cat.setId(ocm.getCategoryId());
                        ocfg.setCategory(cat);
                    }
                    if (ocm.getItemId() != null) {
                        Item it = new Item();
                        it.setId(ocm.getItemId());
                        ocfg.setItem(it);
                    }
                    if (ocm.getBankOfferId() != null) {
                        BankOffer bo = new BankOffer();
                        bo.setId(ocm.getBankOfferId());
                        ocfg.setBankOffer(bo);
                    }
                    if (ocm.getSellerBranchId() != null) {
                        SellerBranch sb = new SellerBranch();
                        sb.setId(ocm.getSellerBranchId());
                        ocfg.setSellerBranch(sb);
                    }
                    if (ocm.getSellerId() != null) {
                        Seller s = new Seller();
                        s.setId(ocm.getSellerId());
                        ocfg.setSeller(s);
                    }
                    if (ocm.getSellerItemId() != null) {
                        SellerItem si = new SellerItem();
                        si.setId(ocm.getSellerItemId());
                        ocfg.setSellerItem(si);
                    }
                    if (ocm.getSubCategoryId() != null) {
                        SubCategory subC = new SubCategory();
                        subC.setId(ocm.getSubCategoryId());
                        ocfg.setSubCategory(subC);
                    }
                    if (ocm.getTagsId() != null) {
                        Tags tags = new Tags();
                        tags.setId(ocm.getTagsId());
                        ocfg.setTags(tags);
                    }
                    offerConfig.add(ocfg);
                }
                offer.setOfferConfigs(offerConfig);
            }
            // ** END **
            //Offer Exclude implementation
            // ** START **
            if (CollectionUtils.isNotEmpty(model.getOfferExcludeConfigModels())) {
                Set<OfferExcludeConfig> offerExcludeConfig = new HashSet<OfferExcludeConfig>();
                for (OfferExcludeConfigModel oecm : model.getOfferExcludeConfigModels()) {
                    OfferExcludeConfig oecfg = new OfferExcludeConfig();
                    oecfg.setId(oecm.getId());
                    oecfg.setPlacedByStatus(oecm.getPlacedByStatus());
                    oecfg.setStatus(oecm.getStatus());
                    if (oecm.getCategoryId() != null) {
                        Category cat = new Category();
                        cat.setId(oecm.getCategoryId());
                        oecfg.setCategory(cat);
                    }
                    if (oecm.getItemId() != null) {
                        Item it = new Item();
                        it.setId(oecm.getItemId());
                        oecfg.setItem(it);
                    }
                    if (oecm.getOfferId() != null) {
                        oecfg.setOffer(offer);
                    }
                    if (oecm.getSellerBranchId() != null) {
                        SellerBranch sb = new SellerBranch();
                        sb.setId(oecm.getSellerBranchId());
                        oecfg.setSellerBranch(sb);
                    }
                    if (oecm.getSellerId() != null) {
                        Seller seller = new Seller();
                        seller.setId(oecm.getSellerId());
                        oecfg.setSeller(seller);
                    }
                    if (oecm.getSellerItemId() != null) {
                        SellerItem sellerItem = new SellerItem();
                        sellerItem.setId(oecm.getSellerItemId());
                        oecfg.setSellerItem(sellerItem);
                    }
                    if (oecm.getTagsId() != null) {
                        Tags tags = new Tags();
                        tags.setId(oecm.getTagsId());
                        oecfg.setTags(tags);
                    }
                    if (oecm.getSubCategoryId() != null) {
                        SubCategory subCat = new SubCategory();
                        subCat.setId(oecm.getSubCategoryId());
                        oecfg.setSubCategory(subCat);
                    }
                    offerExcludeConfig.add(oecfg);
                }
                offer.setOfferExcludeConfigs(offerExcludeConfig);
            }
            // ** END **
        }
        offer = offerService.create(offer);
        model.setId(offer.getId());
        model.setAmountTypeId(offer.getAmountType().getId());
        model.setOfferCode(offer.getOfferCode());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final OfferContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public OfferModel edit(final IKeyBuilder<String> keyBuilder, final OfferModel model) {
        Offer offer = offerService.getOffers(keyBuilder.build().toString());
        offer.setId(model.getId());
        if (model.getStatus() != null) {
            offer.setStatus(model.getStatus());
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = model.getOfferFromDate();
        if (dateInString != null && dateInString != "") {
            try {
                Date date = format.parse(dateInString);
                offer.setOfferFromDate(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String dateInString1 = model.getOfferToDate();
        if (dateInString1 != null && dateInString1 != "") {
            try {
                Date date = format.parse(dateInString1);
                offer.setOfferToDate(date);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (model.getOfferFromTime() != null) {
            String time = model.getOfferFromTime();
            DateFormat sdf = new SimpleDateFormat("HH:mm");
            Date fromTime = null;
            try {
                fromTime = sdf.parse(time);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            offer.setOfferFromTime(sdf.format(fromTime).toString());
        }
        if (model.getOfferToTime() != null) {
            String time1 = model.getOfferToTime();
            DateFormat sdf1 = new SimpleDateFormat("HH:mm");
            Date toTime = null;
            try {
                toTime = sdf1.parse(time1);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            offer.setOfferToTime(sdf1.format(toTime).toString());
        }

        if (offer.getId() != null) {
            //Offer Assignment implementation
            //** START **
            if (CollectionUtils.isNotEmpty(model.getOfferConfigModels())) {
                Set<OfferConfig> offerConfig = new HashSet<OfferConfig>();
                for (OfferConfigModel ocm : model.getOfferConfigModels()) {
                    OfferConfig ocfg = new OfferConfig();
                    ocfg.setId(ocm.getId());
                    ocfg.setOfferAttributeName(ocm.getOfferAttributeName());
                    ocfg.setOfferAttributeValue(ocm.getOfferAttributeValue());
                    ocfg.setStatus(ocm.getStatus());
                    ocfg.setPlacedByStatus(ocm.getPlacedByStatus());
                    if (ocm.getOfferId() != null) {
                        ocfg.setOffer(offer);
                    }
                    if (ocm.getCategoryId() != null) {
                        Category cat = new Category();
                        cat.setId(ocm.getCategoryId());
                        ocfg.setCategory(cat);
                    }
                    if (ocm.getItemId() != null) {
                        Item it = new Item();
                        it.setId(ocm.getItemId());
                        ocfg.setItem(it);
                    }
                    if (ocm.getBankOfferId() != null) {
                        BankOffer bo = new BankOffer();
                        bo.setId(ocm.getBankOfferId());
                        ocfg.setBankOffer(bo);
                    }
                    if (ocm.getSellerBranchId() != null) {
                        SellerBranch sb = new SellerBranch();
                        sb.setId(ocm.getSellerBranchId());
                        ocfg.setSellerBranch(sb);
                    }
                    if (ocm.getSellerId() != null) {
                        Seller s = new Seller();
                        s.setId(ocm.getSellerId());
                        ocfg.setSeller(s);
                    }
                    if (ocm.getSellerItemId() != null) {
                        SellerItem si = new SellerItem();
                        si.setId(ocm.getSellerItemId());
                        ocfg.setSellerItem(si);
                    }
                    if (ocm.getSubCategoryId() != null) {
                        SubCategory subC = new SubCategory();
                        subC.setId(ocm.getSubCategoryId());
                        ocfg.setSubCategory(subC);
                    }
                    if (ocm.getTagsId() != null) {
                        Tags tags = new Tags();
                        tags.setId(ocm.getTagsId());
                        ocfg.setTags(tags);
                    }
                    offerConfig.add(ocfg);
                }
                offer = offerService.addOfferConfigs(offer, offerConfig);
            }
            // ** END **
            //Offer Exclude implementation
            // ** START **
            if (CollectionUtils.isNotEmpty(model.getOfferExcludeConfigModels())) {
                Set<OfferExcludeConfig> offerExcludeConfig = new HashSet<OfferExcludeConfig>();
                for (OfferExcludeConfigModel oecm : model.getOfferExcludeConfigModels()) {
                    OfferExcludeConfig oecfg = new OfferExcludeConfig();
                    oecfg.setId(oecm.getId());
                    oecfg.setPlacedByStatus(oecm.getPlacedByStatus());
                    oecfg.setStatus(oecm.getStatus());
                    if (oecm.getCategoryId() != null) {
                        Category cat = new Category();
                        cat.setId(oecm.getCategoryId());
                        oecfg.setCategory(cat);
                    }
                    if (oecm.getItemId() != null) {
                        Item it = new Item();
                        it.setId(oecm.getItemId());
                        oecfg.setItem(it);
                    }
                    if (oecm.getOfferId() != null) {

                        oecfg.setOffer(offer);
                    }
                    if (oecm.getSellerBranchId() != null) {
                        SellerBranch sb = new SellerBranch();
                        sb.setId(oecm.getSellerBranchId());
                        oecfg.setSellerBranch(sb);
                    }
                    if (oecm.getSellerId() != null) {
                        Seller seller = new Seller();
                        seller.setId(oecm.getSellerId());
                        oecfg.setSeller(seller);
                    }
                    if (oecm.getSellerItemId() != null) {
                        SellerItem sellerItem = new SellerItem();
                        sellerItem.setId(oecm.getSellerItemId());
                        oecfg.setSellerItem(sellerItem);
                    }
                    if (oecm.getTagsId() != null) {
                        Tags tags = new Tags();
                        tags.setId(oecm.getTagsId());
                        oecfg.setTags(tags);
                    }
                    if (oecm.getSubCategoryId() != null) {
                        SubCategory subCat = new SubCategory();
                        subCat.setId(oecm.getSubCategoryId());
                        oecfg.setSubCategory(subCat);
                    }
                    offerExcludeConfig.add(oecfg);
                }
                offer = offerService.addOfferExcludeConfigs(offer, offerExcludeConfig);
            }
            // ** END **
            offer = offerService.updateOffer(offer);
        }
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public OfferModel getByKey(final IKeyBuilder<String> keyBuilder, final OfferContext context) {
        Offer offer = offerService.getOffers(keyBuilder.build().toString());
        OfferModel offerModel = conversionService.convert(offer, OfferModel.class);
        return offerModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<OfferModel> getCollection(final OfferContext context) {
        List<Offer> offer = new ArrayList<Offer>();

        if (context.getAll() != null) {
            offer = offerService.getAll();
        }
        List<OfferModel> offerModels = (List<OfferModel>) conversionService.convert(offer, TypeDescriptor.forObject(offer),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(OfferModel.class)));
        return offerModels;
    }

}
