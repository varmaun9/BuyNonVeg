/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Users;
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

/**
 * @author Dilli
 *
 */
@Component("usersToUsersModelConverter")
public class UsersToUsersModelConverter implements Converter<Users, UsersModel> {

    @Autowired
    private ObjectFactory<UsersModel> usersModelFactory;
    private static final Logger LOGGER = Logger.getLogger(UsersToUsersModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public UsersModel convert(final Users source) {
        // TODO Auto-generated method stub
        UsersModel usersModel = usersModelFactory.getObject();
        BeanUtils.copyProperties(source, usersModel);

        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                usersModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        usersModel.setUserCount(Long.toString(source.getUserCount()));

        String ds2 = null;
        if (source.getDob() != null) {
            ds2 = source.getDob().toString();
        }
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds2 != null) {
            try {

                String ds5 = sdf4.format(sdf3.parse(ds2));
                usersModel.setDob(ds5);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getUserSellerItemRatings())) {
            List<UserSellerItemRatingModel> converted = (List<UserSellerItemRatingModel>) conversionService.convert(
                    source.getUserSellerItemRatings(), TypeDescriptor.forObject(source.getUserSellerItemRatings()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserSellerItemRatingModel.class));
            usersModel.getUserSellerItemRatingModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserItemRatings())) {
            List<UserItemRatingModel> converted = (List<UserItemRatingModel>) conversionService.convert(source.getUserItemRatings(),
                    TypeDescriptor.forObject(source.getUserItemRatings()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserItemRatingModel.class));
            usersModel.getUserItemRatingModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getUserWishLists())) {
            List<UserWishListModel> converted = (List<UserWishListModel>) conversionService.convert(source.getUserWishLists(),
                    TypeDescriptor.forObject(source.getUserWishLists()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserWishListModel.class));
            usersModel.getUserWishListModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getRoles())) {
            List<RolesModel> converted = (List<RolesModel>) conversionService.convert(source.getRoles(),
                    TypeDescriptor.forObject(source.getRoles()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), RolesModel.class));
            usersModel.getRoleModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrders())) {
            List<OrdersModel> converted = (List<OrdersModel>) conversionService.convert(source.getOrders(),
                    TypeDescriptor.forObject(source.getOrders()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrdersModel.class));
            usersModel.getOrderModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAddresses())) {
            List<AddressModel> converted = (List<AddressModel>) conversionService.convert(source.getAddresses(),
                    TypeDescriptor.forObject(source.getAddresses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AddressModel.class));
            usersModel.getAddresModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserImageses())) {
            List<UserImagesModel> converted = (List<UserImagesModel>) conversionService.convert(source.getUserImageses(),
                    TypeDescriptor.forObject(source.getUserImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UserImagesModel.class));
            usersModel.getUserImagesModels().addAll(converted);
        }

        return usersModel;

    }

    @Autowired
    public void setUsersFactory(final ObjectFactory<UsersModel> usersModelFactory) {
        this.usersModelFactory = usersModelFactory;
    }

}
