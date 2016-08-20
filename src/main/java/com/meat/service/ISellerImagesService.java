/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerImages;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerImagesService {

    SellerImages create(SellerImages sellerImages);

    void deleteSellerImages(String sellerImagesId);

    List<SellerImages> getAll();

    SellerImages getSellerImages(String sellerImagesId);

    SellerImages updateSellerImages(SellerImages sellerImages);
}
