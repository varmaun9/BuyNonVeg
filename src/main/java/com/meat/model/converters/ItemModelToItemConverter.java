package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.ItemModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component("itemModelToItemConverter")
public class ItemModelToItemConverter implements Converter<ItemModel, Item> {
    @Autowired
    private ObjectFactory<Item> itemFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Item convert(final ItemModel source) {
        Item item = itemFactory.getObject();
        BeanUtils.copyProperties(source, item);
        item.setId(source.getId());
        if (CollectionUtils.isNotEmpty(source.getItemAttributesesModels())) {
            List<ItemAttributes> converted = (List<ItemAttributes>) conversionService.convert(source.getItemAttributesesModels(),
                    TypeDescriptor.forObject(source.getItemAttributesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributes.class));
            item.getItemAttributeses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getItemImagesesModels())) {
            List<ItemImages> converted = (List<ItemImages>) conversionService.convert(source.getItemImagesesModels(),
                    TypeDescriptor.forObject(source.getItemImagesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemImages.class));
            item.getItemImageses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemTagsesModels())) {
            List<ItemTags> converted = (List<ItemTags>) conversionService.convert(source.getItemTagsesModels(),
                    TypeDescriptor.forObject(source.getItemTagsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTags.class));
            item.getItemTagses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItem> converted = (List<SellerItem>) conversionService.convert(source.getSellerItemModels(),
                    TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItem.class));
            item.getSellerItems().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserItemRatingsModels())) {
            List<UserItemRating> converted = (List<UserItemRating>) conversionService.convert(source.getUserItemRatingsModels(),
                    TypeDescriptor.forObject(source.getUserItemRatingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRating.class));
            item.getUserItemRatings().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishListsModels())) {
            List<UserWishList> converted = (List<UserWishList>) conversionService.convert(source.getUserWishListsModels(),
                    TypeDescriptor.forObject(source.getUserWishListsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishList.class));
            item.getUserWishLists().addAll(converted);
        }
        return item;
    }

    @Autowired
    public void setItemFactory(final ObjectFactory<Item> itemFactory) {
        this.itemFactory = itemFactory;
    }

}
