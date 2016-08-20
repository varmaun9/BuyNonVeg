/**
 *
 */
package com.meat.service;

import com.meat.domain.PieceType;

import java.util.List;

/**
 * @author varma
 *
 */
public interface IPieceTypeService {

    PieceType create(PieceType pieceType);

    void deletePieceType(String pieceTypeId);

    List<PieceType> getAll();

    PieceType getPieceType(String pieceTypeId);

    PieceType updatePieceType(PieceType pieceType);
}
