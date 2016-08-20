/**
 *
 */
package com.meat.dao;

import com.meat.domain.InvoiceTransaction;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface InvoiceTransactionRepository extends PagingAndSortingRepository<InvoiceTransaction, Serializable> {

}
