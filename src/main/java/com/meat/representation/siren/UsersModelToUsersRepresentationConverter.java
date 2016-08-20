package com.meat.representation.siren;

import com.meat.model.UsersModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("usersModelToUsersRepresentationConverter")
public class UsersModelToUsersRepresentationConverter extends PropertyCopyingConverter<UsersModel, UsersRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersRepresentation convert(final UsersModel source) {

        UsersRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingModels())) {
            List<UserSellerItemRatingRepresentation> converted = (List<UserSellerItemRatingRepresentation>) conversionService.convert(
                    source.getUserSellerItemRatingModels(), TypeDescriptor.forObject(source.getUserSellerItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingRepresentation.class));
            target.getUserSellerItemRatingRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserItemRatingModels())) {
            List<UserItemRatingRepresentation> converted = (List<UserItemRatingRepresentation>) conversionService.convert(
                    source.getUserItemRatingModels(), TypeDescriptor.forObject(source.getUserItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingRepresentation.class));
            target.getUserItemRatingRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserWishListModels())) {
            List<UserWishListRepresentation> converted = (List<UserWishListRepresentation>) conversionService.convert(
                    source.getUserWishListModels(), TypeDescriptor.forObject(source.getUserWishListModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListRepresentation.class));
            target.getUserWishListRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getRoleModels())) {
            List<RolesRepresentation> converted = (List<RolesRepresentation>) conversionService.convert(source.getRoleModels(),
                    TypeDescriptor.forObject(source.getRoleModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RolesRepresentation.class));
            target.getRoleRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAddresModels())) {
            List<AddressRepresentation> converted = (List<AddressRepresentation>) conversionService.convert(source.getAddresModels(),
                    TypeDescriptor.forObject(source.getAddresModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AddressRepresentation.class));
            target.getAddressRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserImagesModels())) {
            List<UserImagesRepresentation> converted = (List<UserImagesRepresentation>) conversionService.convert(
                    source.getUserImagesModels(), TypeDescriptor.forObject(source.getUserImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserImagesRepresentation.class));
            target.getUserImagesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderModels())) {
            List<OrdersRepresentation> converted = (List<OrdersRepresentation>) conversionService.convert(source.getOrderModels(),
                    TypeDescriptor.forObject(source.getOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrdersRepresentation.class));
            target.getOrdersRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UsersRepresentation> factory) {
        super.setFactory(factory);
    }
}
