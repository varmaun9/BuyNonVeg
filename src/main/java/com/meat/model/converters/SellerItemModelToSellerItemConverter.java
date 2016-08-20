/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.SellerItemModel;
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

/**
 * @author venkat
 *
 */

@Component("sellerItemModelToSellerItemConverter")
public class SellerItemModelToSellerItemConverter implements Converter<SellerItemModel, SellerItem> {
    @Autowired
    private ObjectFactory<SellerItem> sellerItemFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItem convert(final SellerItemModel source) {
        SellerItem sellerItem = sellerItemFactory.getObject();
        BeanUtils.copyProperties(source, sellerItem);

        if (CollectionUtils.isNotEmpty(source.getSellerItemImageModels())) {
            List<SellerItemImages> converted = (List<SellerItemImages>) conversionService.convert(source.getSellerItemImageModels(),
                    TypeDescriptor.forObject(source.getSellerItemImageModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemImages.class));
            sellerItem.getSellerItemImageses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriaModels())) {
            List<SellerItemCriteria> converted = (List<SellerItemCriteria>) conversionService.convert(source.getSellerItemCriteriaModels(),
                    TypeDescriptor.forObject(source.getSellerItemCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteria.class));
            sellerItem.getSellerItemCriterias().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxModels())) {
            List<SellerItemTax> converted = (List<SellerItemTax>) conversionService.convert(source.getSellerItemTaxModels(),
                    TypeDescriptor.forObject(source.getSellerItemTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTax.class));
            sellerItem.getSellerItemTaxes().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemModels())) {
            List<OrderItem> converted = (List<OrderItem>) conversionService.convert(source.getOrderItemModels(),
                    TypeDescriptor.forObject(source.getOrderItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItem.class));
            sellerItem.getOrderItems().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingModels())) {
            List<UserSellerItemRating> converted = (List<UserSellerItemRating>) conversionService.convert(
                    source.getUserSellerItemRatingModels(), TypeDescriptor.forObject(source.getUserSellerItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRating.class));
            sellerItem.getUserSellerItemRatings().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfig> converted = (List<OfferConfig>) conversionService.convert(source.getOfferConfigModels(),
                    TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfig.class));
            sellerItem.getOfferConfigs().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemPieceTypeModels())) {
            List<SellerItemPieceType> converted = (List<SellerItemPieceType>) conversionService.convert(
                    source.getSellerItemPieceTypeModels(), TypeDescriptor.forObject(source.getSellerItemPieceTypeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemPieceType.class));
            sellerItem.getSellerItemPieceTypes().addAll(converted);
        }
        return sellerItem;
    }

    @Autowired
    public void setSellerItemFactory(final ObjectFactory<SellerItem> sellerItemFactory) {
        this.sellerItemFactory = sellerItemFactory;
    }

}
