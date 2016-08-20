package com.meat.domain;

// Generated Nov 4, 2015 12:01:05 PM by Hibernate Tools 4.0.0

import javax.persistence.*;

/**
 * SellerBranchImages generated by hbm2java
 */
@Entity
@Table(name = "seller_branch_images", catalog = "meat_app")
public class SellerBranchImages extends AbstractDomain implements java.io.Serializable {

    private SellerBranch sellerBranch;
    private String imageName;
    private String imageType;
    private String imageLocation;

    public SellerBranchImages() {
    }

    public SellerBranchImages(final String id, final SellerBranch sellerBranch, final String imageName, final String imageType,
            final String imageLocation) {
        this.id = id;
        this.sellerBranch = sellerBranch;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageLocation = imageLocation;
    }

    @Column(name = "image_location", nullable = false, length = 100)
    public String getImageLocation() {
        return imageLocation;
    }

    @Column(name = "image_name", nullable = false, length = 45)
    public String getImageName() {
        return imageName;
    }

    @Column(name = "image_type", nullable = false, length = 45)
    public String getImageType() {
        return imageType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_branch_id", nullable = false)
    public SellerBranch getSellerBranch() {
        return sellerBranch;
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

    public void setSellerBranch(final SellerBranch sellerBranch) {
        this.sellerBranch = sellerBranch;
    }

}