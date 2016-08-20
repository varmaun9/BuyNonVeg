/**
 *
 */
package com.meat.service;

import com.meat.domain.UserSellerItemRating;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IUserSellerItemRatingService {
    UserSellerItemRating create(UserSellerItemRating userSellerItemRating);

    void deleteUserSellerItemRating(String userSellerItemRatingId);

    List<UserSellerItemRating> getAll();

    UserSellerItemRating getUserSellerItemRating(String userSellerItemRatingId);

    UserSellerItemRating updateUserSellerItemRating(UserSellerItemRating userSellerItemRating);

}
