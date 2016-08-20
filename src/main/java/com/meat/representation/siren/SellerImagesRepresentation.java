/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SellerImagesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerImagesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerImages", uri = "/sellerImageses/{id}")
@Representation(SellerImagesModel.class)
public class SellerImagesRepresentation extends BaseResource {
    private String id;

    private String imageName;
    private String imageType;
    private String imageLocation;
    private String sellerId;

    public String getId() {
        return id;
    }

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

    public void setId(final String id) {
        this.id = id;
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
