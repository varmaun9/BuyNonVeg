/**
 *
 */
package com.meat.dao;

import com.meat.domain.PieceType;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface PieceTypeRepository extends PagingAndSortingRepository<PieceType, Serializable> {

}
