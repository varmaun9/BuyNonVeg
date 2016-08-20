/**
 *
 */
package com.meat.service;

import com.meat.dao.PieceTypeRepository;
import com.meat.domain.PieceType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component
public class PieceTypeService implements IPieceTypeService {

    @Autowired
    private PieceTypeRepository pieceTypeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPieceTypeService#create(com.meat.domain.PieceType)
     */
    @Override
    public PieceType create(final PieceType pieceType) {
        // TODO Auto-generated method stub
        return pieceTypeRepository.save(pieceType);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPieceTypeService#deletePieceType(java.lang.String)
     */
    @Override
    public void deletePieceType(final String pieceTypeId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPieceTypeService#getAll()
     */
    @Override
    public List<PieceType> getAll() {
        // TODO Auto-generated method stub
        return (List<PieceType>) pieceTypeRepository.findAll();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPieceTypeService#getPieceType(java.lang.String)
     */
    @Override
    public PieceType getPieceType(final String pieceTypeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPieceTypeService#updatePieceType(com.meat.domain.PieceType)
     */
    @Override
    public PieceType updatePieceType(final PieceType pieceType) {
        // TODO Auto-generated method stub
        return null;
    }

}
