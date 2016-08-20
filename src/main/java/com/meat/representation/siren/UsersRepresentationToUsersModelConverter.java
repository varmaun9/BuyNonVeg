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
 * @author arthvedi1
 *
 */
@Component("usersRepresentationToUsersModelConverter")
public class UsersRepresentationToUsersModelConverter extends PropertyCopyingConverter<UsersRepresentation, UsersModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public UsersModel convert(final UsersRepresentation source) {

        UsersModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getOrdersRep())) {
            List<OrdersModel> converted = (List<OrdersModel>) conversionService.convert(source.getOrdersRep(),
                    TypeDescriptor.forObject(source.getOrdersRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrdersModel.class));
            target.getOrderModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishListRep())) {
            List<UserWishListModel> converted = (List<UserWishListModel>) conversionService.convert(source.getUserWishListRep(),
                    TypeDescriptor.forObject(source.getUserWishListRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListModel.class));
            target.getUserWishListModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserImagesRep())) {
            List<UserImagesModel> converted = (List<UserImagesModel>) conversionService.convert(source.getUserImagesRep(),
                    TypeDescriptor.forObject(source.getUserImagesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserImagesModel.class));
            target.getUserImagesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getRoleRep())) {
            List<RolesModel> converted = (List<RolesModel>) conversionService.convert(source.getRoleRep(),
                    TypeDescriptor.forObject(source.getRoleRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RolesModel.class));
            target.getRoleModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserItemRatingRep())) {
            List<UserItemRatingModel> converted = (List<UserItemRatingModel>) conversionService.convert(source.getUserItemRatingRep(),
                    TypeDescriptor.forObject(source.getUserItemRatingRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingModel.class));
            target.getUserItemRatingModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAddressRep())) {
            List<AddressModel> converted = (List<AddressModel>) conversionService.convert(source.getAddressRep(),
                    TypeDescriptor.forObject(source.getAddressRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AddressModel.class));
            target.getAddresModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingRep())) {
            List<UserSellerItemRatingModel> converted = (List<UserSellerItemRatingModel>) conversionService.convert(
                    source.getUserSellerItemRatingRep(), TypeDescriptor.forObject(source.getUserSellerItemRatingRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingModel.class));
            target.getUserSellerItemRatingModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<UsersModel> factory) {
        super.setFactory(factory);
    }

}
