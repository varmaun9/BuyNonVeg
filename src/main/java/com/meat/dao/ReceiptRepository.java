/**
 *
 */
package com.meat.dao;

import com.meat.domain.Receipt;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface ReceiptRepository extends PagingAndSortingRepository<Receipt, Serializable> {

}
