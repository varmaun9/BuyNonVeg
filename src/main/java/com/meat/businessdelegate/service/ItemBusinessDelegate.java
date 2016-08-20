/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.constants.DBSequences;
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
 * @author Varma
 *
 */
@Service
public class ItemBusinessDelegate implements IBusinessDelegate<ItemModel, ItemContext, IKeyBuilder<String>, String> {

    @Autowired
    private IItemService itemService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private ISeoService seoService;
    @Autowired
    private ISellerItemService sellerItemService;
    @Autowired
    private IItemTagsService itemTagsService;
    @Autowired
    private ITagsService tagsService;
    @Autowired
    private IAttributesService attributesService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemModel create(final ItemModel model) {
        Item item = new Item();
        item.setId(model.getId());
        SubCategory subCategory = new SubCategory();
        subCategory.setId(model.getSubCategoryId());
        item.setSubCategory(subCategory);
        item.setItemName(model.getItemName());
        item.setSellingTag(model.getSellingTag());

        Seo seo = new Seo();
        /*seo.setId(model.getSeoId());*/
        seo.setSeoTitle(model.getSeoTitle());
        seo.setSeoKeywords(model.getSeoKeywords());
        seo.setSeoMetaDescription(model.getSeoMetaDescription());
        item.setSeo(seo);
        item.setCreatedDate(new Date());
        item.setMeatStatus(model.getMeatStatus());
        item.setDescription(model.getDescription());
        item.setStatus(model.getStatus());

        Integer i = itemService.getMaxCode();
        if (i == null || i == 0) {
            i = 99999;
            Long bi = Long.valueOf(i + 1);
            item.setItemCount(bi);
        }
        else {
            item.setItemCount(i + 1);
        }
        Integer ca = i + 1;
        String m = DBSequences.ITEM.getSequenceName();
        String mc = m.concat(ca.toString());
        item.setItemCode(mc);
        item = itemService.create(item);
        model.setItemNameStatus(item.getItemName() + " SuccessFully Created ");
        if (item.getItemName() != null) {
            if (item.getItemName().equals("Duplicate")) {
                model.setItemNameStatus(model.getItemName() + " Already Exists! ");
            }
        }

        if (item.getId() != null) {
            if (model.getItemTagsesModels() != null) {
                List<ItemTags> itemTagses = new ArrayList<ItemTags>();
                for (ItemTagsModel itemTagsModels : model.getItemTagsesModels()) {
                    ItemTags itemTags = new ItemTags();
                    itemTags.setItemTagsStatus(itemTagsModels.getItemTagsStatus());
                    itemTags.setItem(item);
                    Tags tags = new Tags();
                    tags.setId(itemTagsModels.getTagsId());
                    itemTags.setTags(tags);
                    itemTagses.add(itemTags);
                    itemTagsModels.setId(itemTags.getId());
                }
                item = itemService.addItemTags(item, itemTagses);
            }

            if (model.getItemAttributesesModels() != null) {
                List<ItemAttributes> itemAttribute = new ArrayList<ItemAttributes>();
                for (ItemAttributesModel itemAttributesModels : model.getItemAttributesesModels()) {
                    ItemAttributes itemAttributes = new ItemAttributes();
                    Attributes attributes = attributesService.getAttributes(itemAttributesModels.getAttributesId());
                    attributes.setId(itemAttributesModels.getAttributesId());
                    itemAttributes.setAttributes(attributes);
                    CategoryAttributes categoryAttributes = new CategoryAttributes();
                    categoryAttributes.setId(itemAttributesModels.getCategoryAttributesId());
                    itemAttributes.setCategoryAttributes(categoryAttributes);
                    itemAttributes.setItem(item);
                    itemAttributes.setAttributeName(attributes.getAttributeName());
                    itemAttributes.setAttributeValue(itemAttributesModels.getAttributeValue());
                    itemAttributes.setStatus(itemAttributesModels.getStatus());
                    itemAttribute.add(itemAttributes);
                    itemAttributesModels.setId(itemAttributes.getId());
                }
                item = itemService.addItemAttributes(item, itemAttribute);
            }
            if (model.getItemImagesesModels() != null) {
                List<ItemImages> itemImages = new ArrayList<ItemImages>();
                for (ItemImagesModel itemImagesModel : model.getItemImagesesModels()) {
                    ItemImages itmImags = new ItemImages();
                    itmImags.setId(itemImagesModel.getId());
                    itmImags.setItem(item);
                    itmImags.setImageName(itemImagesModel.getImageName());
                    itmImags.setImageType(itemImagesModel.getImageType());
                    itmImags.setImageLocation(itemImagesModel.getImageLocation());
                    itemImages.add(itmImags);
                }
                item = itemService.addItemImages(item, itemImages);
            }
            Set<SellerItem> sellerItems = new HashSet<SellerItem>();
            if (CollectionUtils.isNotEmpty(model.getSellerItemModels())) {
                for (SellerItemModel sellerItemModels : model.getSellerItemModels()) {
                    SellerItem sellerItem = new SellerItem();
                    sellerItem.setCreatedDate(new Date());
                    sellerItem.setDescription(sellerItemModels.getDescription());
                    sellerItem.setId(sellerItemModels.getId());
                    // sellerItem.setIngredients(sellerItemModels.getIngredients());
                    sellerItem.setItem(item);

                    //Seo seo1 = new Seo();
                    // seo1.setId(sellerItemModels.getSeoId());
                    seo.setSeoKeywords(sellerItemModels.getSeoKeywords());
                    seo.setSeoMetaDescription(sellerItemModels.getSeoMetaDescription());
                    seo.setSeoTitle(sellerItemModels.getSeoTitle());
                    sellerItemModels.setId(seo.getId());
                    sellerItem.setSeo(seo);
                    String value1 = sellerItemModels.getBaseUnit();
                    sellerItem.setBaseUnit(Float.parseFloat(value1));
                    sellerItem.setItemAvailableStatus(sellerItemModels.getItemAvailableStatus());
                    sellerItem.setQuantity(sellerItemModels.getQuantity());
                    String value = sellerItemModels.getSellingPrice();
                    if (value != null) {
                        BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
                        sellerItem.setSellingPrice(b);
                    }
                    String mp = sellerItemModels.getMarketPrice();
                    if (value != null) {
                        BigDecimal mpr = new BigDecimal(value.replaceAll(",", " "));
                        sellerItem.setSellingPrice(mpr);
                    }
                    SellerBranch sb = new SellerBranch();
                    sb.setId(sellerItemModels.getSellerBranchId());
                    sellerItem.setSellerBranch(sb);
                    sellerItem.setSellerItemName(sellerItemModels.getSellerItemName());
                    sellerItem.setSellerStock(sellerItemModels.getSellerStock());
                    sellerItem.setSpecialTag(sellerItemModels.getSpecialTag());
                    sellerItem.setSellingTag(Integer.parseInt(sellerItemModels.getSellingTag()));
                    sellerItems.add(sellerItem);
                    sellerItemModels.setId(sellerItem.getId());
                }
                item = itemService.addSellerItems(item, sellerItems);
            }
        }
        model.setId(item.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ItemContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ItemModel edit(final IKeyBuilder<String> keyBuilder, final ItemModel model) {

        Item item = itemService.getItem(keyBuilder.build().toString());
        item.setId(model.getId());
        if (model.getItemName() != null) {
            item.setItemName(model.getItemName());
        }
        if (model.getDescription() != null) {
            item.setDescription(model.getDescription());
        }
        if (model.getStatus() != null) {
            item.setStatus(model.getStatus());
        }
        if (model.getSellingTag() != null) {
            item.setSellingTag(model.getSellingTag());
        }

        if (model.getSubCategoryId() != null) {
            SubCategory subCategory = new SubCategory();
            subCategory.setId(model.getSubCategoryId());
            item.setSubCategory(subCategory);

        }

        if (model.getSeoId() != null) {
            Seo seo = new Seo();
            seo.setId(model.getSeoId());
            seo.setSeoTitle(model.getSeoTitle());
            seo.setSeoKeywords(model.getSeoKeywords());
            seo.setSeoMetaDescription(model.getSeoMetaDescription());
            item.setSeo(seo);
        }
        if (model.getItemAttributesesModels() != null) {
            List<ItemAttributes> itemAttribute = new ArrayList<ItemAttributes>();
            for (ItemAttributesModel itemAttributesModels : model.getItemAttributesesModels()) {
                ItemAttributes itemAttributes = new ItemAttributes();
                Attributes attributes = attributesService.getAttributes(itemAttributesModels.getAttributesId());
                itemAttributes.setId(itemAttributesModels.getId());
                attributes.setId(itemAttributesModels.getAttributesId());
                CategoryAttributes catAttributes = new CategoryAttributes();
                catAttributes.setId(itemAttributesModels.getCategoryAttributesId());
                itemAttributes.setCategoryAttributes(catAttributes);
                itemAttributes.setAttributes(attributes);
                itemAttributes.setAttributeName(attributes.getAttributeName());
                itemAttributes.setItem(item);
                itemAttributes.setAttributeValue(itemAttributesModels.getAttributeValue());
                itemAttributes.setStatus(itemAttributesModels.getStatus());
                itemAttribute.add(itemAttributes);
            }
            item = itemService.addItemAttributes(item, itemAttribute);
        }

        List<ItemTags> itemTagses = new ArrayList<ItemTags>();
        if (model.getItemTagsesModels() != null) {
            for (ItemTagsModel tagModel : model.getItemTagsesModels()) {
                ItemTags itemTags = new ItemTags();
                // ItemTags itemTags = itemTagsService.getItemTags(tgModel.getId());
                itemTags.setId(tagModel.getId());
                itemTags.setItem(item);
                itemTags.setItemTagsStatus(tagModel.getItemTagsStatus());
                Tags tags = new Tags();
                tags.setId(tagModel.getTagsId());
                itemTags.setTags(tags);
                itemTagses.add(itemTags);
            }
            item = itemService.addItemTags(item, itemTagses);
        }

        List<ItemImages> itemImages = new ArrayList<ItemImages>();
        if (model.getItemImagesesModels() != null) {
            for (ItemImagesModel itemImagesModel : model.getItemImagesesModels()) {
                ItemImages itemImags = new ItemImages();
                itemImags.setId(itemImagesModel.getId());
                itemImags.setItem(item);
                itemImags.setImageName(itemImagesModel.getImageName());
                itemImags.setImageType(itemImagesModel.getImageType());
                itemImags.setImageLocation(itemImagesModel.getImageLocation());
                itemImages.add(itemImags);
            }
            item = itemService.addItemImages(item, itemImages);
        }

        item = itemService.updateItem(item);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public ItemModel getByKey(final IKeyBuilder<String> keyBuilder, final ItemContext context) {
        Item item = itemService.getItem(keyBuilder.build().toString());
        ItemModel itemModel = conversionService.convert(item, ItemModel.class);
        return itemModel;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ItemModel> getCollection(final ItemContext context) {

        List<Item> itm = new ArrayList<Item>();
        if (context.getAll() != null) {
            itm = itemService.getAll();
        }
        if (context.getItemOnly() != null) {
            itm = itemService.getItemOnly();
        }
        if (context.getSubCategoryId() != null) {
            itm = itemService.getItemBySubCategoryId(context.getSubCategoryId());
        }
        if (context.getCategoryId() != null) {
            itm = itemService.getItemByCategoryId(context.getCategoryId());
        }
        if (context.getItemWithOutSellerItem() != null && context.getItemId() != null) {
            itm = itemService.getItemWithOutSellerItem(context.getItemId());
        }
        if (context.getItemWithSellerItem() != null && context.getItemId() != null) {
            itm = itemService.getItemWithSellerItem(context.getItemId());
        }
        if (context.getCategoryId() != null && context.getZoneId() != null) {
            itm = itemService.getItemByZoneAndCategory(context.getZoneId(), context.getCategoryId());
        }
        if (context.getCategoryId() != null && context.getItemOnly() != null) {
            itm = itemService.getItemByCategoryItemOnly(context.getCategoryId());
        }
        List<ItemModel> itmModels = (List<ItemModel>) conversionService.convert(itm, TypeDescriptor.forObject(itm),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ItemModel.class)));

        return itmModels;
    }

}
