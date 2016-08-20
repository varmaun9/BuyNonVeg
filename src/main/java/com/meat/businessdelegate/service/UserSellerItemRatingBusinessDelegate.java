/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerItem;
import com.meat.domain.UserSellerItemRating;
import com.meat.domain.Users;
import com.meat.model.UserSellerItemRatingModel;
import com.meat.service.IUserSellerItemRatingService;

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
public class UserSellerItemRatingBusinessDelegate
        implements IBusinessDelegate<UserSellerItemRatingModel, UserSellerItemRatingContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserSellerItemRatingService userSellerItemRatingService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserSellerItemRatingModel create(final UserSellerItemRatingModel model) {
        UserSellerItemRating userSellerItemRating = new UserSellerItemRating();
        userSellerItemRating.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        userSellerItemRating.setSellerItem(sellerItem);
        Users users = new Users();
        users.setId(model.getUserId());
        userSellerItemRating.setUsers(users);

        userSellerItemRating.setCreatedDate(new Date());
        userSellerItemRating.setTitle(model.getTitle());
        userSellerItemRating.setDescription(model.getDescription());
        userSellerItemRating.setRating(Integer.parseInt(model.getRating()));
        userSellerItemRating = userSellerItemRatingService.create(userSellerItemRating);
        model.setId(userSellerItemRating.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserSellerItemRatingContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserSellerItemRatingModel edit(final IKeyBuilder<String> keyBuilder, final UserSellerItemRatingModel model) {
        UserSellerItemRating userSellerItemRating = userSellerItemRatingService.getUserSellerItemRating(keyBuilder.build().toString());
        userSellerItemRating.setId(model.getId());
        SellerItem sellerItem = new SellerItem();
        sellerItem.setId(model.getSellerItemId());
        userSellerItemRating.setSellerItem(sellerItem);
        Users users = new Users();
        users.setId(model.getUserId());
        userSellerItemRating.setUsers(users);
        userSellerItemRating.setDescription(model.getDescription());
        userSellerItemRating.setRating(Integer.parseInt(model.getRating()));

        userSellerItemRating = userSellerItemRatingService.updateUserSellerItemRating(userSellerItemRating);
        model.setId(userSellerItemRating.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserSellerItemRatingModel getByKey(final IKeyBuilder<String> keyBuilder, final UserSellerItemRatingContext context) {
        UserSellerItemRating userSellerItemRating = userSellerItemRatingService.getUserSellerItemRating(keyBuilder.build().toString());
        UserSellerItemRatingModel userSellerItemRatingModel = conversionService.convert(userSellerItemRating,
                UserSellerItemRatingModel.class);

        return userSellerItemRatingModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserSellerItemRatingModel> getCollection(final UserSellerItemRatingContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
