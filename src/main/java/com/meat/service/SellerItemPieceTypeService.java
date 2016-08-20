/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerItemPieceTypeRepository;
import com.meat.domain.SellerItemPieceType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class SellerItemPieceTypeService implements ISellerItemPieceTypeService {

    @Autowired
    private SellerItemPieceTypeRepository sellerItemPieceTypeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemPieceTypeService#create(com.meat.domain.SellerItemPieceType)
     */
    @Override
    public SellerItemPieceType create(final SellerItemPieceType sellerItemPieceType) {
        // TODO Auto-generated method stub
        return sellerItemPieceTypeRepository.save(sellerItemPieceType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemPieceTypeService#deleteSellerItemPieceType(java.lang.String)
     */
    @Override
    public void deleteSellerItemPieceType(final String sellerItemPieceTypeId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemPieceTypeService#getAll()
     */
    @Override
    public List<SellerItemPieceType> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemPieceTypeService#getSellerItemPieceType(java.lang.String)
     */
    @Override
    public SellerItemPieceType getSellerItemPieceType(final String sellerItemPieceTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerItemPieceTypeService#updateSellerItemPieceType(com.meat.domain.SellerItemPieceType)
     */
    @Override
    public SellerItemPieceType updateSellerItemPieceType(final SellerItemPieceType sellerItemPieceType) {
        // TODO Auto-generated method stub
        return null;
    }

}
