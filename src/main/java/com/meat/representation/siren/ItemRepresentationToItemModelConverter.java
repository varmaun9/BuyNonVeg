/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("ItemRepresentationToItemModelConverter")
public class ItemRepresentationToItemModelConverter extends PropertyCopyingConverter<ItemRepresentation, ItemModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemModel convert(final ItemRepresentation source) {

        ItemModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getUserItemRatingsRep())) {
            List<UserItemRatingModel> converted = (List<UserItemRatingModel>) conversionService.convert(source.getUserItemRatingsRep(),
                    TypeDescriptor.forObject(source.getUserItemRatingsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingModel.class));
            target.getUserItemRatingsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemAttributesesRep())) {
            List<ItemAttributesModel> converted = (List<ItemAttributesModel>) conversionService.convert(source.getItemAttributesesRep(),
                    TypeDescriptor.forObject(source.getItemAttributesesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesModel.class));
            target.getItemAttributesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishListsRep())) {
            List<UserWishListModel> converted = (List<UserWishListModel>) conversionService.convert(source.getUserWishListsRep(),
                    TypeDescriptor.forObject(source.getUserWishListsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListModel.class));
            target.getUserWishListsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemImagesesRep())) {
            List<ItemImagesModel> converted = (List<ItemImagesModel>) conversionService.convert(source.getItemImagesesRep(),
                    TypeDescriptor.forObject(source.getItemImagesesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemImagesModel.class));
            target.getItemImagesesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemTagsesRep())) {
            List<ItemTagsModel> converted = (List<ItemTagsModel>) conversionService.convert(source.getItemTagsesRep(),
                    TypeDescriptor.forObject(source.getItemTagsesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsModel.class));
            target.getItemTagsesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemRep())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItemRep(),
                    TypeDescriptor.forObject(source.getSellerItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            target.getSellerItemModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemModel> factory) {
        super.setFactory(factory);
    }
}
