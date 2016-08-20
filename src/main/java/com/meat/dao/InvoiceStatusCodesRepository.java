/**
 *
 */
package com.meat.dao;

import com.meat.domain.InvoiceStatusCodes;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface InvoiceStatusCodesRepository extends PagingAndSortingRepository<InvoiceStatusCodes, Serializable> {

}
