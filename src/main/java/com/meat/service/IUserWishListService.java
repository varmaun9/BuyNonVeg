/**
 *
 */
package com.meat.service;

import com.meat.domain.UserWishList;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface IUserWishListService {
    UserWishList create(UserWishList userWishList);

    void deleteUserWishList(String userWishListId);

    List<UserWishList> getAll();

    UserWishList getUserWishList(String userWishListId);

    UserWishList updateUserWishList(UserWishList userWishList);

}
