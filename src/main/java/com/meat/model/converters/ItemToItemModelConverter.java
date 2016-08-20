package com.meat.model.converters;

import com.meat.domain.Item;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemToItemModelConverter")
public class ItemToItemModelConverter implements Converter<Item, ItemModel> {

    private static final Logger LOGGER = Logger.getLogger(ItemToItemModelConverter.class);
    @Autowired
    private ObjectFactory<ItemModel> itemModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public ItemModel convert(final Item source) {
        // TODO Auto-generated method stub
        ItemModel itemModel = itemModelFactory.getObject();

        BeanUtils.copyProperties(source, itemModel);
        itemModel.setId(source.getId());
        itemModel.setItemCount(Long.toString(source.getItemCount()));
        if (source.getSellingTag() != null) {
            itemModel.setSellingTag(source.getSellingTag().toString());
        }
        if (source.getSubCategory() != null) {
            itemModel.setSubCategoryId(source.getSubCategory().getId());
            itemModel.setSubCategoryName(source.getSubCategory().getSubCategoryName());
            itemModel.setCategoryId(source.getSubCategory().getCategory().getId());
            itemModel.setCategoryName(source.getSubCategory().getCategory().getCategoryName());
        }

        if (source.getSeo() != null) {
            itemModel.setSeoId(source.getSeo().getId());
            itemModel.setSeoTitle(source.getSeo().getSeoTitle());
            itemModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            itemModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                itemModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getItemAttributeses())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributeses(),
                    TypeDescriptor.forObject(source.getItemAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            itemModel.getItemAttributesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemImageses())) {
            List<ItemImagesModel> converted = (List<ItemImagesModel>) conversionService.convert(source.getItemImageses(),
                    TypeDescriptor.forObject(source.getItemImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemImagesModel.class));
            itemModel.getItemImagesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemTagses())) {
            List<ItemTagsModel> converted = (List<ItemTagsModel>) conversionService.convert(source.getItemTagses(),
                    TypeDescriptor.forObject(source.getItemTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsModel.class));
            itemModel.getItemTagsesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItems())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItems(),
                    TypeDescriptor.forObject(source.getSellerItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            itemModel.getSellerItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserItemRatings())) {
            List<UserItemRatingModel> converted = (List<UserItemRatingModel>) conversionService.convert(source.getUserItemRatings(),
                    TypeDescriptor.forObject(source.getUserItemRatings()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingModel.class));
            itemModel.getUserItemRatingsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishLists())) {
            List<UserWishListModel> converted = (List<UserWishListModel>) conversionService.convert(source.getUserWishLists(),
                    TypeDescriptor.forObject(source.getUserWishLists()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListModel.class));
            itemModel.getUserWishListsModels().addAll(converted);
        }
        return itemModel;

    }

    @Autowired
    public void setItemFactory(final ObjectFactory<ItemModel> itemModelFactory) {
        this.itemModelFactory = itemModelFactory;
    }

}
