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
@Component("sellerItemRepresentationToSellerItemModelConverter")
public class SellerItemRepresentationToSellerItemModelConverter
        extends PropertyCopyingConverter<SellerItemRepresentation, SellerItemModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemModel convert(final SellerItemRepresentation source) {

        SellerItemModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getSellerItemImageRep())) {
            List<SellerItemImagesModel> converted = (List<SellerItemImagesModel>) conversionService.convert(source.getSellerItemImageRep(),
                    TypeDescriptor.forObject(source.getSellerItemImageRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemImagesModel.class));
            target.getSellerItemImageModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriaRep())) {
            List<SellerItemCriteriaModel> converted = (List<SellerItemCriteriaModel>) conversionService.convert(
                    source.getSellerItemCriteriaRep(), TypeDescriptor.forObject(source.getSellerItemCriteriaRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaModel.class));
            target.getSellerItemCriteriaModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxRep())) {
            List<SellerItemTaxModel> converted = (List<SellerItemTaxModel>) conversionService.convert(source.getSellerItemTaxRep(),
                    TypeDescriptor.forObject(source.getSellerItemTaxRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxModel.class));
            target.getSellerItemTaxModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemRep())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItemRep(),
                    TypeDescriptor.forObject(source.getOrderItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            target.getOrderItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingRep())) {
            List<UserSellerItemRatingModel> converted = (List<UserSellerItemRatingModel>) conversionService.convert(
                    source.getUserSellerItemRatingRep(), TypeDescriptor.forObject(source.getUserSellerItemRatingRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingModel.class));
            target.getUserSellerItemRatingModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigRep())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigRep(),
                    TypeDescriptor.forObject(source.getOfferConfigRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            target.getOfferConfigModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemModel> factory) {
        super.setFactory(factory);
    }
}
