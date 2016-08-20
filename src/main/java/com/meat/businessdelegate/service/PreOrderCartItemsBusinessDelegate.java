/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
import com.meat.dao.PreOrderCartItemsRepository;
import com.meat.dao.SellerItemRepository;
import com.meat.domain.PreOrderCartItems;
import com.meat.domain.SellerItem;
import com.meat.domain.Timings;
import com.meat.domain.Users;
import com.meat.model.CategoryModel;
import com.meat.model.PreOrderCartItemsModel;
import com.meat.security.CustomUserDetails;
import com.meat.service.IPreOrderCartItemsService;
import com.meat.service.ISellerBranchTaxService;
import com.meat.service.ISellerItemService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class PreOrderCartItemsBusinessDelegate
        implements IBusinessDelegate<PreOrderCartItemsModel, PreOrderCartItemsContext, IKeyBuilder<String>, String> {

    @Autowired
    private IPreOrderCartItemsService preOrderCartItemsService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private PreOrderCartItemsRepository preOrderCartItemsRepository;
    @Autowired
    private SellerItemRepository sellerItemRepository;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private ISellerBranchTaxService sellerBranchTaxService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public PreOrderCartItemsModel create(final PreOrderCartItemsModel model) {
        PreOrderCartItems preOrderCartItems = new PreOrderCartItems();

        preOrderCartItems.setId(model.getId());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        Users users = new Users();
        users.setId(userDetails.getId());
        preOrderCartItems.setUsers(users);

        preOrderCartItems.setCreatedDate(new Date());
        Integer i = preOrderCartItemsService.getMaxCode();
        if (i == null || i == 0) {
            i = 9999;
            long bi = (i + 1);
            preOrderCartItems.setPreOrderCartItemsCount(bi);
        }
        else {
            long bi = (i + 1);
            preOrderCartItems.setPreOrderCartItemsCount(bi);
        }
        Integer ca = i + 1;
        if (model.getStatusFlag().equals("C")) {
            String m = DBSequences.PREORDERCARTITEMS.getSequenceName();
            String mc = m.concat(ca.toString());
            preOrderCartItems.setPreOrderCartItemsCode(mc);
        }
        if (model.getStatusFlag().equals("QC")) {
            String m = DBSequences.PREORDERQCARTITEMS.getSequenceName();
            String mc = m.concat(ca.toString());
            preOrderCartItems.setPreOrderCartItemsCode(mc);
        }

        if (model.getStatus() != null) {
            preOrderCartItems.setStatus(model.getStatus());
        }
        else {
            preOrderCartItems.setStatus("CARTADDED");
        }
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        preOrderCartItems.setSellerItem(sellerItem);
        if (model.getStatusFlag() != null) {
            preOrderCartItems.setStatusFlag(model.getStatusFlag());
        }
        else {
            preOrderCartItems.setStatusFlag("C");
        }
        if (model.getStatusFlag().equals("QC")) {
            PreOrderCartItems pocit = preOrderCartItemsRepository.findBySellerItemAndStatus(userDetails.getId(), model.getStatusFlag());
            if (pocit != null) {
                pocit.setStatusFlag("C");
                preOrderCartItemsRepository.save(pocit);
            }
        }
        if (model.getSellerItemId() != null) {
            PreOrderCartItems poci = preOrderCartItemsRepository.findBySellerItemAndStatusAndUser(model.getSellerItemId(),
                    model.getStatusFlag(), userDetails.getId());
            if (poci != null) {
                if (model.getSellerItemId().equals(poci.getSellerItem().getId())) {
                    model.setTimingName("ERROR:::The Product Is Already Added in Cart");
                    return model;
                }
            }
            SellerItem si = sellerItemService.getSellerItemAfterOfferApplied(model.getSellerItemId());
            SellerItem sItem = new SellerItem();
            sItem.setId(si.getId());
            preOrderCartItems.setSellerItem(sItem);
            // preOrderCartItems.setPrice(ri.getSellingPrice());
            preOrderCartItems.setQuantity(si.getQuantity());
            preOrderCartItems.setCutType(model.getCutType());
            if (model.getUnits() != null) {
                preOrderCartItems.setUnits(Float.parseFloat(model.getUnits()));
                preOrderCartItems.setPrice(si.getSellingPrice().multiply(new BigDecimal(model.getUnits())));
            }
            else {
                model.setUnits(si.getBaseUnit().toString());
                preOrderCartItems.setUnits(si.getBaseUnit());
                preOrderCartItems.setPrice(si.getSellingPrice().multiply(new BigDecimal(si.getBaseUnit())));
            }
            preOrderCartItems.setCartPrice(preOrderCartItems.getPrice());
            /* Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(si.getId(), "PERCENT");
            preOrderCartItems.setItemTax(itemTotalTax);
            preOrderCartItems.setCartPrice((preOrderCartItems.getPrice().multiply(new BigDecimal(itemTotalTax)))
                    .divide(new BigDecimal(100.00)).add(preOrderCartItems.getPrice()));*/
        }

        if (model.getTimingsId() != null)

        {
            Timings timings = new Timings();
            timings.setId(model.getTimingsId());
            preOrderCartItems.setTimings(timings);
            preOrderCartItems.setDeliveryTime(model.getDeliveryTime());
            preOrderCartItems.setTimingName(model.getTimingName());
        }

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dates = model.getDeliveryDate();
        if (dates != null && dates != "")

        {
            try {
                Date date1 = format.parse(dates);
                preOrderCartItems.setDeliveryDate(date1);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else

        {
            preOrderCartItems.setDeliveryDate(new Date());
        }
        preOrderCartItems = preOrderCartItemsService.create(preOrderCartItems);
        model.setId(preOrderCartItems.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final PreOrderCartItemsContext context) {
        preOrderCartItemsService.deletePreOrderCartItems(keyBuilder.build().toString());

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public PreOrderCartItemsModel edit(final IKeyBuilder<String> keyBuilder, final PreOrderCartItemsModel model) {
        PreOrderCartItems preOrderCartItem = preOrderCartItemsService.getPreOrderCartItems(keyBuilder.build().toString());
        SellerItem si = preOrderCartItem.getSellerItem();
        Float itemTotalTax = sellerBranchTaxService.getApplicableTaxesTypeSumBySellerItem(si.getId(), "PERCENT");
        preOrderCartItem.setId(model.getId());
        preOrderCartItem.setCutType(model.getCutType());
        if (model.getPrice() != null) {
            String value = model.getPrice();
            if (value != null) {
                BigDecimal price = new BigDecimal(value.replaceAll(",", " "));
                preOrderCartItem.setPrice(price);
            }
        }
        if (model.getCutType() != null) {
            preOrderCartItem.setCutType(model.getCutType());
        }
        if (model.getUnits() != null) {
            preOrderCartItem.setUnits(Float.parseFloat(model.getUnits()));
            preOrderCartItem.setPrice(si.getSellingPrice().multiply(new BigDecimal(model.getUnits())));
            preOrderCartItem.setCartPrice((preOrderCartItem.getPrice().multiply(new BigDecimal(itemTotalTax)))
                    .divide(new BigDecimal(100.00)).add(preOrderCartItem.getPrice()));

        }
        if (model.getQuantity() != null) {
            preOrderCartItem.setQuantity(model.getQuantity());
        }

        if (model.getDeliveryTime() != null) {
            preOrderCartItem.setDeliveryTime(model.getDeliveryTime());
        }

        if (model.getTimingsId() != null) {
            Timings timings = new Timings();
            timings.setId(model.getTimingsId());
            preOrderCartItem.setTimings(timings);
            preOrderCartItem.setDeliveryTime(model.getDeliveryTime());
        }

        preOrderCartItem = preOrderCartItemsService.updatePreOrderCartItems(preOrderCartItem);
        model.setId(preOrderCartItem.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public PreOrderCartItemsModel getByKey(final IKeyBuilder<String> keyBuilder, final PreOrderCartItemsContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<PreOrderCartItemsModel> getCollection(final PreOrderCartItemsContext context) {
        List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();

        if (context.getAll() != null) {
            preOrderCartItems = preOrderCartItemsService.getAll();
        }
        if (context.getPreOrderCartItemsOnly() != null) {
            preOrderCartItems = preOrderCartItemsService.getPreOrderCartItemsOnly();
        }

        List<PreOrderCartItemsModel> preOrderCartItemsModels = (List<PreOrderCartItemsModel>) conversionService.convert(preOrderCartItems,
                TypeDescriptor.forObject(preOrderCartItems),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryModel.class)));

        return preOrderCartItemsModels;
    }

}
