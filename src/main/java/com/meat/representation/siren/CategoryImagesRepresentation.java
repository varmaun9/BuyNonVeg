package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.meat.model.CategoryImagesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("categoryImagesRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryImages", uri = "/categoryImageses/{id}")
@Representation(CategoryImagesModel.class)
public class CategoryImagesRepresentation extends BaseResource {

    private String id;
    private String categoryId;
    private String imageName;
    private String imageLocation;
    private String imageType;

    public String getCategoryId() {
        return categoryId;
    }

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

    public void setCategoryId(final String categoryId) {
        this.categoryId = categoryId;
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

}