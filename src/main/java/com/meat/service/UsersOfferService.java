/**
 *
 */
package com.meat.service;

import com.meat.dao.UsersOfferRepository;
import com.meat.domain.UsersOffer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class UsersOfferService implements IUsersOfferService {

    @Autowired
    private UsersOfferRepository usersOfferRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#create(com.meat.domain.UsersOffer)
     */
    @Override
    public UsersOffer create(final UsersOffer usersOffer) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#deleteUsersOffer(java.lang.String)
     */
    @Override
    public void deleteUsersOffer(final String usersOfferId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#getAll()
     */
    @Override
    public List<UsersOffer> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#getUsersOffer(java.lang.String)
     */
    @Override
    public UsersOffer getUsersOffer(final String usersOfferId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#getUsersOfferOnly()
     */
    @Override
    public List<UsersOffer> getUsersOfferOnly() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUsersOfferService#updateUsersOffer(com.meat.domain.UsersOffer)
     */
    @Override
    public UsersOffer updateUsersOffer(final UsersOffer usersOffer) {
        // TODO Auto-generated method stub
        return null;
    }

}
