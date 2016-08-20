/**
 *
 */
package com.meat.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerImagesModel")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SellerImagesModel extends AbstractModel {
    private String sellerId;
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

    public String getSellerId() {
        return sellerId;
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

    public void setSellerId(final String sellerId) {
        this.sellerId = sellerId;
    }

}
