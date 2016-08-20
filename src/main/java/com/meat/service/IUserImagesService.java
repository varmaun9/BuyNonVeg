package com.meat.service;

import com.meat.domain.UserImages;

import java.util.List;

public interface IUserImagesService {

    UserImages create(UserImages userImages);

    void deleteUserImages(String userImagesId);

    List<UserImages> getAll();

    UserImages getUserImages(String userImagesId);

    UserImages updateUserImages(UserImages userImages);

}
