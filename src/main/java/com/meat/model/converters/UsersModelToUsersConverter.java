/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.UsersModel;
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
 * @author Dilli
 *
 */
@Component("usersModelToUsersConverter")
public class UsersModelToUsersConverter implements Converter<UsersModel, Users> {
    @Autowired
    private ObjectFactory<Users> usersFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Users convert(final UsersModel source) {
        Users users = usersFactory.getObject();
        BeanUtils.copyProperties(source, users);
        if (CollectionUtils.isNotEmpty(source.getOrderModels())) {
            List<Orders> converted = (List<Orders>) conversionService.convert(source.getOrderModels(),
                    TypeDescriptor.forObject(source.getOrderModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Orders.class));
            users.getOrders().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatingModels())) {
            List<UserSellerItemRating> converted = (List<UserSellerItemRating>) conversionService.convert(
                    source.getUserSellerItemRatingModels(), TypeDescriptor.forObject(source.getUserSellerItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRating.class));
            users.getUserSellerItemRatings().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserItemRatingModels())) {
            List<UserItemRating> converted = (List<UserItemRating>) conversionService.convert(source.getUserItemRatingModels(),
                    TypeDescriptor.forObject(source.getUserItemRatingModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRating.class));
            users.getUserItemRatings().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getRoleModels())) {
            List<Roles> converted = (List<Roles>) conversionService.convert(source.getRoleModels(),
                    TypeDescriptor.forObject(source.getRoleModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Roles.class));
            users.getRoles().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAddresModels())) {
            List<Address> converted = (List<Address>) conversionService.convert(source.getAddresModels(),
                    TypeDescriptor.forObject(source.getAddresModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Address.class));
            users.getAddresses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishListModels())) {
            List<UserWishList> converted = (List<UserWishList>) conversionService.convert(source.getUserWishListModels(),
                    TypeDescriptor.forObject(source.getUserWishListModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishList.class));
            users.getUserWishLists().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserImagesModels())) {
            List<UserImages> converted = (List<UserImages>) conversionService.convert(source.getUserImagesModels(),
                    TypeDescriptor.forObject(source.getUserImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserImages.class));
            users.getUserImageses().addAll(converted);
        }

        return users;
    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<Users> usersFactory) {
        this.usersFactory = usersFactory;
    }

}
