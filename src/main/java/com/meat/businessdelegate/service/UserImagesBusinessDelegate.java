/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.UserImages;
import com.meat.domain.Users;
import com.meat.model.UserImagesModel;
import com.meat.service.IUserImagesService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class UserImagesBusinessDelegate implements IBusinessDelegate<UserImagesModel, UserImagesContext, IKeyBuilder<String>, String> {

    @Autowired
    private IUserImagesService userImagesService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserImagesModel create(final UserImagesModel model) {
        UserImages userImages = new UserImages();
        userImages.setId(model.getId());
        Users users = new Users();
        users.setId(model.getUserId());
        userImages.setUsers(users);
        userImages.setImageLocation(model.getImageLocation());
        userImages.setImageName(model.getImageName());
        userImages.setImageType(model.getImageType());
        userImages = userImagesService.create(userImages);
        model.setId(userImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final UserImagesContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public UserImagesModel edit(final IKeyBuilder<String> keyBuilder, final UserImagesModel model) {
        UserImages userImages = userImagesService.getUserImages(keyBuilder.build().toString());
        userImages.setId(model.getId());
        Users users = new Users();
        users.setId(model.getUserId());
        userImages.setUsers(users);
        userImages.setImageLocation(model.getImageLocation());
        userImages.setImageName(model.getImageName());
        userImages.setImageType(model.getImageType());
        userImages = userImagesService.updateUserImages(userImages);
        model.setId(userImages.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public UserImagesModel getByKey(final IKeyBuilder<String> keyBuilder, final UserImagesContext context) {
        UserImages userImages = userImagesService.getUserImages(keyBuilder.build().toString());
        UserImagesModel userImagesModel = conversionService.convert(userImages, UserImagesModel.class);

        return userImagesModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<UserImagesModel> getCollection(final UserImagesContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
