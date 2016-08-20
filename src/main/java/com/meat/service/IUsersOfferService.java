/**
 *
 */
package com.meat.service;

import com.meat.domain.UsersOffer;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IUsersOfferService {

    UsersOffer create(UsersOffer usersOffer);

    void deleteUsersOffer(String usersOfferId);

    List<UsersOffer> getAll();

    UsersOffer getUsersOffer(String usersOfferId);

    List<UsersOffer> getUsersOfferOnly();

    UsersOffer updateUsersOffer(UsersOffer usersOffer);

}
