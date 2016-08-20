/**
 *
 */
package com.meat.fileupload;

/**
 * @author varma
 *
 */
public class FileUploadImage {

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
