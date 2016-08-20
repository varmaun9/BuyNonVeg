/**
 *
 */
package com.meat.service;


import com.meat.domain.SellerBranchImages;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerBranchImagesService {

    SellerBranchImages create(SellerBranchImages sellerBranchImages);

    void deleteSellerBranchImages(String sellerBranchImagesId);

    List<SellerBranchImages> getAll();

    SellerBranchImages getSellerBranchImages(String sellerBranchImagesId);

    SellerBranchImages updateSellerBranchImages(SellerBranchImages sellerBranchImages);

}
