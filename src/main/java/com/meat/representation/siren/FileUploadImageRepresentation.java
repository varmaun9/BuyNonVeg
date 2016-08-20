/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.meat.fileupload.FileUploadImage;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("fileUploadImageRepresentation")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "fileUpload", uri = "/fileUpload/{imageName}")
@Representation(FileUploadImage.class)
public class FileUploadImageRepresentation {
    private String imageName;
    private String imageWidth;
    private String imageHeight;
    private String imageLocation;
    private String uploadStatus;

    public String getImageHeight() {
        return imageHeight;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setImageHeight(final String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public void setImageLocation(final String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public void setImageName(final String imageName) {
        this.imageName = imageName;
    }

    public void setImageWidth(final String imageWidth) {
        this.imageWidth = imageWidth;
    }

    public void setUploadStatus(final String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}
