/**
 *
 */
package com.meat.service;

import com.meat.dao.UserSellerItemRatingRepository;
import com.meat.domain.UserSellerItemRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component
public class UserSellerItemRatingService implements IUserSellerItemRatingService {
    @Autowired
    private UserSellerItemRatingRepository userSellerItemRatingRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSellerItemRatingService#create(com.meat.domain.UserSellerItemRating)
     */
    @Override
    public UserSellerItemRating create(final UserSellerItemRating userSellerItemRating) {
        // TODO Auto-generated method stub
        return userSellerItemRatingRepository.save(userSellerItemRating);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSellerItemRatingService#deleteUserSellerItemRating(java.lang.String)
     */
    @Override
    public void deleteUserSellerItemRating(final String userSellerItemRatingId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSellerItemRatingService#getAll()
     */
    @Override
    public List<UserSellerItemRating> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSellerItemRatingService#getUserSellerItemRating(java.lang.String)
     */
    @Override
    public UserSellerItemRating getUserSellerItemRating(final String userSellerItemRatingId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserSellerItemRatingService#updateUserSellerItemRating(com.meat.domain.UserSellerItemRating)
     */
    @Override
    public UserSellerItemRating updateUserSellerItemRating(final UserSellerItemRating userSellerItemRating) {
        // TODO Auto-generated method stub
        return userSellerItemRatingRepository.save(userSellerItemRating);
    }

}
