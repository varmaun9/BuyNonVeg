/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.*;
import com.meat.model.SellerItemCriteriaModel;
import com.meat.model.SellerItemImagesModel;
import com.meat.model.SellerItemModel;
import com.meat.model.SellerItemPieceTypeModel;
import com.meat.service.*;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class SellerItemBusinessDelegate implements IBusinessDelegate<SellerItemModel, SellerItemContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerItemCriteriaService sellerItemCriteriaService;
    @Autowired
    private ISellerItemImagesService sellerItemImagesService;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IItemService itemService;
    @Autowired
    private ISeoService seoService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemModel create(final SellerItemModel model) {

        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getId());

        Item item = new Item();
        item.setId(model.getItemId());
        sellerItem.setItem(item);
        Seo seo = new Seo();
        //seo.setId(model.getSeoId());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        seo.setSeoTitle(model.getSeoTitle());
        sellerItem.setSeo(seo);

        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerItem.setSellerBranch(sellerBranch);

        sellerItem.setSellerItemName(model.getSellerItemName());

        sellerItem.setQuantity(model.getQuantity());
        if (model.getSpecialTag() != null) {
            sellerItem.setSpecialTag(model.getSpecialTag());
        }
        sellerItem.setDescription(model.getDescription());
        // sellerItem.setIngredients(model.getIngredients());
        String value = model.getSellingPrice();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            sellerItem.setSellingPrice(b);
        }
        String marketValue = model.getMarketPrice();
        if (value != null) {
            BigDecimal bm = new BigDecimal(marketValue.replaceAll(",", " "));
            sellerItem.setMarketPrice(bm);
        }
        sellerItem.setMeasurementUnit(model.getMeasurementUnit());
        String value1 = model.getBaseUnit();
        sellerItem.setBaseUnit(Float.parseFloat(value1));
        sellerItem.setItemAvailableStatus(model.getItemAvailableStatus());
        sellerItem.setCountFlag(0);
        sellerItem.setCreatedDate(new Date());
        sellerItem.setSellerStock(model.getSellerStock());
        sellerItem.setCutTypes(model.getCutTypes());
        sellerItem = sellerItemService.create(sellerItem);

        if (sellerItem.getItemAvailableStatus() != null) {
            if (sellerItem.getDescription().equals("DUPLICATE")) {
                model.setItemExistsStatus("DUPLICATE");
                model.setItemAvailableStatus(sellerItem.getItemAvailableStatus());
            }
        }
        if (sellerItem.getId() != null) {
            if (model.getSellerItemCriteriaModels() != null) {
                List<SellerItemCriteria> sllrItemCriteria = new ArrayList<SellerItemCriteria>();
                for (SellerItemCriteriaModel slrItemCriteriaModels : model.getSellerItemCriteriaModels()) {
                    SellerItemCriteria sellerItemCriteria = new SellerItemCriteria();
                    sellerItemCriteria.setId(slrItemCriteriaModels.getId());
                    sellerItemCriteria.setId(model.getId());
                    sellerItemCriteria.setSellerItem(sellerItem);
                    sellerItemCriteria.setSellerItemCriteriaStatus(slrItemCriteriaModels.getSellerItemCriteriaStatus());
                    Criteria criteria = new Criteria();
                    criteria.setId(slrItemCriteriaModels.getCriteriaId());
                    sellerItemCriteria.setCriteria(criteria);
                    sllrItemCriteria.add(sellerItemCriteria);
                    //sellerItem.setId(model.getId());

                }
                sellerItem = sellerItemService.addSellerItemCriteria(sellerItem, sllrItemCriteria);
            }

            if (model.getSellerItemImageModels() != null) {
                List<SellerItemImages> sllrItemImages = new ArrayList<SellerItemImages>();
                for (SellerItemImagesModel slrItemImages : model.getSellerItemImageModels()) {
                    SellerItemImages sellerItemImages = new SellerItemImages();
                    sellerItemImages.setId(model.getId());
                    sellerItemImages.setImageLocation(slrItemImages.getImageLocation());
                    sellerItemImages.setImageName(slrItemImages.getImageName());
                    sellerItemImages.setImageType(slrItemImages.getImageType());
                    sellerItemImages.setSellerItem(sellerItem);
                    sllrItemImages.add(sellerItemImages);
                }
                sellerItem = sellerItemService.addSellerItemImages(sellerItem, sllrItemImages);
            }
            if (model.getSellerItemPieceTypeModels() != null) {
                List<SellerItemPieceType> sllrItemPieceTypes = new ArrayList<SellerItemPieceType>();
                for (SellerItemPieceTypeModel slrItemPieceTypeModel : model.getSellerItemPieceTypeModels()) {
                    SellerItemPieceType sellerItemPieceType = new SellerItemPieceType();
                    sellerItemPieceType.setId(model.getId());
                    PieceType pt = new PieceType();
                    pt.setId(slrItemPieceTypeModel.getPieceTypeId());
                    sellerItemPieceType.setPieceType(pt);
                    sellerItemPieceType.setPieceCount(Integer.parseInt(slrItemPieceTypeModel.getPieceCount()));
                    sellerItemPieceType.setMinQuantity(Integer.parseInt((slrItemPieceTypeModel.getMinQuantity())));
                    sellerItemPieceType.setStatus(slrItemPieceTypeModel.getStatus());
                    sellerItemPieceType.setDescription(slrItemPieceTypeModel.getDescription());
                    sellerItemPieceType.setCreatedDate(new Date());
                    sellerItemPieceType.setSellerItem(sellerItem);
                    sllrItemPieceTypes.add(sellerItemPieceType);
                }
                sellerItem = sellerItemService.addSellerItemPieceTypes(sellerItem, sllrItemPieceTypes);
            }

        }
        //sellerItem.setId(model.getId());
        model.setId(sellerItem.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerItemContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerItemModel edit(final IKeyBuilder<String> keyBuilder, final SellerItemModel model) {
        SellerItem sellerItem = sellerItemService.getSellerItem(keyBuilder.build().toString());
        if (model.getItemId() != null) {
            Item item = new Item();
            item.setId(model.getItemId());
            sellerItem.setItem(item);
        }
        if (model.getSeoId() != null) {
            Seo seo = new Seo();
            seo.setId(model.getSeoId());
            sellerItem.setSeo(seo);
        }
        if (model.getSellerItemName() != null) {
            sellerItem.setSellerItemName(model.getSellerItemName());
        }
        if (model.getSellingTag() != null) {
            sellerItem.setSellingTag(Integer.parseInt(model.getSellingTag()));
        }
        if (model.getQuantity() != null) {
            sellerItem.setQuantity(model.getQuantity());
        }
        if (model.getSpecialTag() != null) {
            sellerItem.setSpecialTag(model.getSpecialTag());
        }
        sellerItem.setDescription(model.getDescription());
        if (model.getCutTypes() != null) {
            sellerItem.setCutTypes(model.getCutTypes());
        }
        //sellerItem.setIngredients(model.getIngredients());
        if (model.getSellingPrice() != null) {
            String value = model.getSellingPrice();
            if (value != null) {
                BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
                sellerItem.setSellingPrice(b);
            }
        }
        if (model.getBaseUnit() != null) {
            String value1 = model.getBaseUnit();
            sellerItem.setBaseUnit(Float.parseFloat(value1));
        }
        if (model.getMeasurementUnit() != null) {
            sellerItem.setMeasurementUnit(model.getMeasurementUnit());
        }
        if (model.getItemAvailableStatus() != null) {
            sellerItem.setItemAvailableStatus(model.getItemAvailableStatus());
        }
        if (model.getSellingPrice() != null) {
            sellerItem.setSellingPrice(new BigDecimal(model.getSellingPrice()));
        }
        sellerItem.setId(model.getId());
        if (model.getSellerBranchId() != null) {
            SellerBranch sellerBranch = new SellerBranch();
            sellerBranch.setId(model.getSellerBranchId());
            sellerItem.setSellerBranch(sellerBranch);
        }
        sellerItem.setSellerStock(model.getSellerStock());
        sellerItem = sellerItemService.updateSellerItem(sellerItem);

        if (sellerItem.getId() != null) {
            Set<SellerItemCriteria> sllrItemCriteria = new HashSet<SellerItemCriteria>();
            if (model.getSellerItemCriteriaModels() != null) {
                for (SellerItemCriteriaModel sellerItemCriteriaModels : model.getSellerItemCriteriaModels()) {
                    SellerItemCriteria sellerItemCriteria = new SellerItemCriteria();
                    sellerItemCriteria.setId(sellerItemCriteriaModels.getId());
                    Criteria crite = new Criteria();
                    crite.setId(sellerItemCriteriaModels.getCriteriaId());
                    sellerItemCriteria.setCriteria(crite);
                    sellerItemCriteria.setSellerItem(sellerItem);
                    sellerItemCriteria.setSellerItemCriteriaStatus(sellerItemCriteriaModels.getSellerItemCriteriaStatus());
                    sellerItemCriteria = sellerItemCriteriaService.updateSellerItemCriteria(sellerItemCriteria);
                    sllrItemCriteria.add(sellerItemCriteria);
                }
                sellerItem.setSellerItemCriterias(sllrItemCriteria);
            }

            /*            Set<SellerItemImages> sllrItemImages = new HashSet<SellerItemImages>();
                        if (model.getSellerItemImageModels() != null) {
                            for (SellerItemImagesModel sellerItemImagesModels : model.getSellerItemImageModels()) {
                                SellerItemImages sellerItemImages = new SellerItemImages();
                                sellerItemImages.setId(sellerItemImagesModels.getId());
                                sellerItemImages.setImageLocation(sellerItemImagesModels.getImageLocation());
                                sellerItemImages.setImageName(sellerItemImagesModels.getImageName());
                                sellerItemImages.setImageType(sellerItemImagesModels.getImageType());
                                sellerItemImages.setSellerItem(sellerItem);
                                sellerItemImages = sellerItemImagesService.updateSellerItemImages(sellerItemImages);
                                sllrItemImages.add(sellerItemImages);
                            }

                            sellerItem.setSellerItemImageses(sllrItemImages);
                        }*/
        }

        model.setId(sellerItem.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SellerItemModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerItemContext context) {
        SellerItem sellerItem = sellerItemService.getSellerItem(keyBuilder.build().toString());
        SellerItemModel sellerItemModel = conversionService.convert(sellerItem, SellerItemModel.class);
        return sellerItemModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerItemModel> getCollection(final SellerItemContext context) {

        List<SellerItem> sellerItem = new ArrayList<SellerItem>();

        if (context.getAll() != null) {
            sellerItem = sellerItemService.getAll();
        }
        if (context.getSellerItemOnly() != null) {
            sellerItem = sellerItemService.getSellerItemOnly();
        }
        if (context.getSellerBranchItemsOnly() != null && context.getSellerBranchId() != null) {

            sellerItem = sellerItemService.getSellerBranchItemOnly(context.getSellerBranchId());
        }
        if (context.getSellerItemOnly() != null && context.getSellerBranchId() != null) {

            sellerItem = sellerItemService.getSellerItemOnly(context.getSellerBranchId());
        }
        List<SellerItemModel> sellerItemModels = (List<SellerItemModel>) conversionService.convert(sellerItem,
                TypeDescriptor.forObject(sellerItem), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerItemModel.class)));

        return sellerItemModels;
    }
}
