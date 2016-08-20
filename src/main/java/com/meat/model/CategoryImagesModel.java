package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryImagesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CategoryImagesModel extends AbstractModel {

    private String categoryId;
    private String imageName;
    private String imageLocation;
    private String imageType;

    /**
     * @return the categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * @return the imageLocation
     */
    public String getImageLocation() {
        return imageLocation;
    }

    /**
     * @return the imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @return the imageType
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * @param categoryId
     *            the categoryId to set
     */
    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @param imageLocation
     *            the imageLocation to set
     */
    public void setImageLocation(final String imageLocation) {
        this.imageLocation = imageLocation;
    }

    /**
     * @param imageName
     *            the imageName to set
     */
    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    /**
     * @param imageType
     *            the imageType to set
     */
    public void setImageType(final String imageType) {
        this.imageType = imageType;
    }

}
