package com.meat.service;

import com.meat.dao.UserItemRatingRepository;
import com.meat.domain.UserItemRating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserItemRatingService implements IUserItemRatingService {
    @Autowired
    private UserItemRatingRepository userItemRatingRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserItemRatingService#create(com.meat.domain.UserItemRating)
     */
    @Override
    public UserItemRating create(final UserItemRating userItemRating) {
        // TODO Auto-generated method stub
        return userItemRatingRepository.save(userItemRating);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserItemRatingService#deleteUserItemRating(java.lang.String)
     */
    @Override
    public void deleteUserItemRating(final String userItemRatingId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserItemRatingService#getAll()
     */
    @Override
    public List<UserItemRating> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserItemRatingService#getUserItemRating(java.lang.String)
     */
    @Override
    public UserItemRating getUserItemRating(final String userItemRatingId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserItemRatingService#updateUserItemRating(com.meat.domain.UserItemRating)
     */
    @Override
    public UserItemRating updateUserItemRating(final UserItemRating userItemRating) {
        // TODO Auto-generated method stub
        return userItemRatingRepository.save(userItemRating);
    }

}
