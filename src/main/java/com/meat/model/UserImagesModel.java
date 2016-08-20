package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("userImagesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserImagesModel extends AbstractModel {
    private String userId;
    private String imageName;
    private String imageType;
    private String imageLocation;

    public String getImageLocation() {
        return imageLocation;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public String getUserId() {
        return userId;
    }

    public void setImageLocation(final String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    public void setImageType(final String imageType) {
        this.imageType = imageType;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

}
