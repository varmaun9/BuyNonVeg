package com.meat.service;

import com.meat.dao.UserImagesRepository;
import com.meat.domain.UserImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserImagesService implements IUserImagesService {
    @Autowired
    private UserImagesRepository userImagesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserImagesService#create(com.meat.domain.UserImages)
     */
    @Override
    public UserImages create(final UserImages userImages) {
        // TODO Auto-generated method stub
        return userImagesRepository.save(userImages);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserImagesService#deleteUserImages(java.lang.String)
     */
    @Override
    public void deleteUserImages(final String userImagesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserImagesService#getAll()
     */
    @Override
    public List<UserImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserImagesService#getUserImages(java.lang.String)
     */
    @Override
    public UserImages getUserImages(final String userImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IUserImagesService#updateUserImages(com.meat.domain.UserImages)
     */
    @Override
    public UserImages updateUserImages(final UserImages userImages) {
        // TODO Auto-generated method stub
        return userImagesRepository.save(userImages);
    }

}
