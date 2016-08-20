package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("itemImagesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ItemImagesModel extends AbstractModel {

    private String itemId;
    private String imageName;
    private String imageLocation;
    private String imageType;

    public String getImageLocation() {
        return imageLocation;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageType() {
        return imageType;
    }

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
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

    /**
     * @param itemId
     *            the itemId to set
     */
    public void setItemId(final String itemId) {
        this.itemId = itemId;
    }

}
