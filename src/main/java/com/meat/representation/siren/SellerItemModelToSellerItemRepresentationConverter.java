/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SellerItemModel;
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
@Component("sellerItemModelToSellerItemRepresentationConverter")
public class SellerItemModelToSellerItemRepresentationConverter
        extends PropertyCopyingConverter<SellerItemModel, SellerItemRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerItemRepresentation convert(final SellerItemModel source) {

        SellerItemRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSellerItemImageModels())) {
            List<SellerItemImagesRepresentation> converted = (List<SellerItemImagesRepresentation>) conversionService.convert(
                    source.getSellerItemImageModels(), TypeDescriptor.forObject(source.getSellerItemImageModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemImagesRepresentation.class));
            target.getSellerItemImageRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriaModels())) {
            List<SellerItemCriteriaRepresentation> converted = (List<SellerItemCriteriaRepresentation>) conversionService.convert(
                    source.getSellerItemCriteriaModels(), TypeDescriptor.forObject(source.getSellerItemCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaRepresentation.class));
            target.getSellerItemCriteriaRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemTaxModels())) {
            List<SellerItemTaxRepresentation> converted = (List<SellerItemTaxRepresentation>) conversionService.convert(
                    source.getSellerItemTaxModels(), TypeDescriptor.forObject(source.getSellerItemTaxModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemTaxRepresentation.class));
            target.getSellerItemTaxRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemModels())) {
            List<OrderItemRepresentation> converted = (List<OrderItemRepresentation>) conversionService.convert(source.getOrderItemModels(),
                    TypeDescriptor.forObject(source.getOrderItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemRepresentation.class));
            target.getOrderItemRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingModels())) {
            List<UserSellerItemRatingRepresentation> converted = (List<UserSellerItemRatingRepresentation>) conversionService.convert(
                    source.getUserSellerItemRatingModels(), TypeDescriptor.forObject(source.getUserSellerItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingRepresentation.class));
            target.getUserSellerItemRatingRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigModels())) {
            List<OfferConfigRepresentation> converted = (List<OfferConfigRepresentation>) conversionService.convert(
                    source.getOfferConfigModels(), TypeDescriptor.forObject(source.getOfferConfigModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigRepresentation.class));
            target.getOfferConfigRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SellerItemRepresentation> factory) {
        super.setFactory(factory);
    }
}