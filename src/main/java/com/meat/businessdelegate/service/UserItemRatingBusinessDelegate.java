/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Item;
import com.meat.domain.UserItemRating;
import com.meat.domain.Users;
import com.meat.model.UserItemRatingModel;
import com.meat.service.IUserItemRatingService;

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
public class UserItemRatingBusinessDelegate
        implements IBusinessDelegate<UserItemRatingModel, UserItemRatingContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserItemRatingService userItemRatingService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserItemRatingModel create(final UserItemRatingModel model) {
        UserItemRating userItemRating = new UserItemRating();
        userItemRating.setId(model.getId());
        userItemRating.setComments(model.getComments());
        userItemRating.setCreatedDate(new Date());
        userItemRating.setItemRatingStatus(model.getItemRatingStatus());
        userItemRating.setRating(Integer.parseInt(model.getRating()));
        Item item = new Item();
        item.setId(model.getItemId());
        userItemRating.setItem(item);
        Users users = new Users();
        users.setId(model.getUserId());
        userItemRating.setUsers(users);
        userItemRating = userItemRatingService.create(userItemRating);
        model.setId(userItemRating.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserItemRatingContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserItemRatingModel edit(final IKeyBuilder<String> keyBuilder, final UserItemRatingModel model) {
        UserItemRating userItemRating = userItemRatingService.getUserItemRating(keyBuilder.build().toString());
        userItemRating.setId(model.getId());
        userItemRating.setComments(model.getComments());
        userItemRating.setItemRatingStatus(model.getItemRatingStatus());
        userItemRating.setRating(Integer.parseInt(model.getRating()));
        Item item = new Item();
        item.setId(model.getItemId());
        userItemRating.setItem(item);
        Users users = new Users();
        users.setId(model.getUserId());
        userItemRating.setUsers(users);
        userItemRating = userItemRatingService.updateUserItemRating(userItemRating);
        model.setId(userItemRating.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserItemRatingModel getByKey(final IKeyBuilder<String> keyBuilder, final UserItemRatingContext context) {
        UserItemRating userItemRating = userItemRatingService.getUserItemRating(keyBuilder.build().toString());
        UserItemRatingModel userItemRatingModel = conversionService.convert(userItemRating, UserItemRatingModel.class);

        return userItemRatingModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserItemRatingModel> getCollection(final UserItemRatingContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
