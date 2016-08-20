/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerItemPieceType;

import java.util.List;

/**
 * @author varma
 *
 */
public interface ISellerItemPieceTypeService {

    SellerItemPieceType create(SellerItemPieceType sellerItemPieceType);

    void deleteSellerItemPieceType(String sellerItemPieceTypeId);

    List<SellerItemPieceType> getAll();

    SellerItemPieceType getSellerItemPieceType(String sellerItemPieceTypeId);

    SellerItemPieceType updateSellerItemPieceType(SellerItemPieceType sellerItemPieceType);

}
