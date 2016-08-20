/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ItemModel;
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
@Component("itemModelToItemRepresentationConverter")
public class ItemModelToItemRepresentationConverter extends PropertyCopyingConverter<ItemModel, ItemRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemRepresentation convert(final ItemModel source) {

        ItemRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getItemAttributesesModels())) {
            List<ItemAttributesRepresentation> converted = (List<ItemAttributesRepresentation>) conversionService.convert(
                    source.getItemAttributesesModels(), TypeDescriptor.forObject(source.getItemAttributesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemAttributesRepresentation.class));
            target.getItemAttributesesRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserItemRatingsModels())) {
            List<UserItemRatingRepresentation> converted = (List<UserItemRatingRepresentation>) conversionService.convert(
                    source.getUserItemRatingsModels(), TypeDescriptor.forObject(source.getUserItemRatingsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingRepresentation.class));
            target.getUserItemRatingsRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishListsModels())) {
            List<UserWishListRepresentation> converted = (List<UserWishListRepresentation>) conversionService.convert(
                    source.getUserWishListsModels(), TypeDescriptor.forObject(source.getUserWishListsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListRepresentation.class));
            target.getUserWishListsRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItemRepresentation> converted = (List<SellerItemRepresentation>) conversionService.convert(
                    source.getSellerItemModels(), TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemRepresentation.class));
            target.getSellerItemRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemImagesesModels())) {
            List<ItemImagesRepresentation> converted = (List<ItemImagesRepresentation>) conversionService.convert(
                    source.getItemImagesesModels(), TypeDescriptor.forObject(source.getItemImagesesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemImagesRepresentation.class));
            target.getItemImagesesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemTagsesModels())) {
            List<ItemTagsRepresentation> converted = (List<ItemTagsRepresentation>) conversionService.convert(source.getItemTagsesModels(),
                    TypeDescriptor.forObject(source.getItemTagsesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsRepresentation.class));
            target.getItemTagsesRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemRepresentation> factory) {
        super.setFactory(factory);
    }
}
