/**
 *
 */
package com.meat.service;

import com.meat.dao.UserWishListRepository;
import com.meat.domain.UserWishList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class UserWishListService implements IUserWishListService {
    @Autowired
    private UserWishListRepository userWishListRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserWishListService#create(com.meat.domain.UserWishList)
     */
    @Override
    public UserWishList create(final UserWishList userWishList) {
        // TODO Auto-generated method stub
        return userWishListRepository.save(userWishList);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserWishListService#deleteUserWishList(java.lang.String)
     */
    @Override
    public void deleteUserWishList(final String userWishListId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserWishListService#getAll()
     */
    @Override
    public List<UserWishList> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserWishListService#getUserWishList(java.lang.String)
     */
    @Override
    public UserWishList getUserWishList(final String userWishListId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserWishListService#updateUserWishList(com.meat.domain.UserWishList)
     */
    @Override
    public UserWishList updateUserWishList(final UserWishList userWishList) {
        // TODO Auto-generated method stub
        return userWishListRepository.save(userWishList);
    }

}
