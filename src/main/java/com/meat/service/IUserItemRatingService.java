package com.meat.service;

import com.meat.domain.UserItemRating;

import java.util.List;

public interface IUserItemRatingService {

    UserItemRating create(UserItemRating userItemRating);

    void deleteUserItemRating(String userItemRatingId);

    List<UserItemRating> getAll();

    UserItemRating getUserItemRating(String userItemRatingId);

    UserItemRating updateUserItemRating(UserItemRating userItemRating);

}
