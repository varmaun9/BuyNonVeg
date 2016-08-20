/**
 *
 */
package com.meat.dao;

import com.meat.domain.Invoice;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Serializable> {

}
