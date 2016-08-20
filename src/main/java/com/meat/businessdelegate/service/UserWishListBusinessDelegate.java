/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Item;
import com.meat.domain.UserWishList;
import com.meat.domain.Users;
import com.meat.model.UserWishListModel;
import com.meat.service.IUserWishListService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class UserWishListBusinessDelegate implements IBusinessDelegate<UserWishListModel, UserWishListContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserWishListService userWishListService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserWishListModel create(final UserWishListModel model) {
        UserWishList userWishList = new UserWishList();
        userWishList.setId(model.getId());
        Item item = new Item();
        item.setId(model.getItemId());
        userWishList.setItem(item);
        Users users = new Users();
        users.setId(model.getUserId());
        userWishList.setUsers(users);
        userWishList.setCreatedDate(new Date());
        userWishList.setDescription(model.getDescription());
        userWishList = userWishListService.create(userWishList);
        model.setId(userWishList.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserWishListContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserWishListModel edit(final IKeyBuilder<String> keyBuilder, final UserWishListModel model) {
        UserWishList userWishList = userWishListService.getUserWishList(keyBuilder.build().toString());
        userWishList.setId(model.getId());
        Item item = new Item();
        item.setId(model.getItemId());
        userWishList.setItem(item);
        Users users = new Users();
        users.setId(model.getUserId());
        userWishList.setUsers(users);
        userWishList.setDescription(model.getDescription());
        userWishList = userWishListService.updateUserWishList(userWishList);
        model.setId(userWishList.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserWishListModel getByKey(final IKeyBuilder<String> keyBuilder, final UserWishListContext context) {
        UserWishList userWishList = userWishListService.getUserWishList(keyBuilder.build().toString());
        UserWishListModel userWishListModel = conversionService.convert(userWishList, UserWishListModel.class);

        return userWishListModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserWishListModel> getCollection(final UserWishListContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
