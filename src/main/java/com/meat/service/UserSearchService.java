/**
 *
 */
package com.meat.service;

import com.meat.dao.UserSearchRepository;
import com.meat.domain.UserSearch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class UserSearchService implements IUserSearchService {
    @Autowired
    private UserSearchRepository userSearchRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSearchService#create(com.meat.domain.UserSearch)
     */
    @Override
    public UserSearch create(final UserSearch userSearch) {
        // TODO Auto-generated method stub
        return userSearchRepository.save(userSearch);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSearchService#deleteUserSearch(java.lang.String)
     */
    @Override
    public void deleteUserSearch(final String userSearchId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSearchService#getAll()
     */
    @Override
    public List<UserSearch> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSearchService#getUserSearch(java.lang.String)
     */
    @Override
    public UserSearch getUserSearch(final String userSearchId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSearchService#updateUserSearch(com.meat.domain.UserSearch)
     */
    @Override
    public UserSearch updateUserSearch(final UserSearch userSearch) {
        // TODO Auto-generated method stub
        return userSearchRepository.save(userSearch);
    }

}
