package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.SubCategoryImagesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryImagesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategoryImages", uri = "/subCategoryImageses/{id}")
@Representation(SubCategoryImagesModel.class)
public class SubCategoryImagesRepresentation extends BaseResource {

    private String id;
    private String subCategoryId;
    private String imageName;
    private String imageType;
    private String imageLocation;

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

    public String getSubCategoryId() {
        return subCategoryId;
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

    public void setSubCategoryId(final String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

}