/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerItemImages;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISellerItemImagesService {

    SellerItemImages create(SellerItemImages sellerItemImages);

    void deleteSellerItemImages(String sellerItemImagesId);

    List<SellerItemImages> getAll();

    SellerItemImages getSellerItemImages(String sellerItemImagesId);

    SellerItemImages updateSellerItemImages(SellerItemImages sellerItemImages);

}
