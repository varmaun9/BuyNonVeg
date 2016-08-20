/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.UserSearch;
import com.meat.model.UserSearchModel;
import com.meat.service.IUserSearchService;

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
public class UserSearchBusinessDelegate implements IBusinessDelegate<UserSearchModel, UserSearchContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserSearchService userSearchService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserSearchModel create(final UserSearchModel model) {
        UserSearch userSearch = new UserSearch();
        userSearch.setId(model.getId());
        // userSearch.setUserId(model.getUserId());
        // userSearch.setItemId(model.getItemId());
        userSearch.setCreatedDate(new Date());
        userSearch.setUserSearchItemStatus(model.getUserSearchItemStatus());
        userSearch = userSearchService.create(userSearch);
        model.setId(userSearch.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserSearchContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserSearchModel edit(final IKeyBuilder<String> keyBuilder, final UserSearchModel model) {
        UserSearch userSearch = userSearchService.getUserSearch(keyBuilder.build().toString());
        userSearch.setId(model.getId());
        // userSearch.setUserId(model.getUserId());
        //  userSearch.setItemId(model.getItemId());
        userSearch.setUserSearchItemStatus(model.getUserSearchItemStatus());
        userSearch = userSearchService.updateUserSearch(userSearch);
        model.setId(userSearch.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserSearchModel getByKey(final IKeyBuilder<String> keyBuilder, final UserSearchContext context) {
        UserSearch userSearch = userSearchService.getUserSearch(keyBuilder.build().toString());
        UserSearchModel userSearchModel = conversionService.convert(userSearch, UserSearchModel.class);

        return userSearchModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserSearchModel> getCollection(final UserSearchContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
