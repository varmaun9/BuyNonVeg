/**
 *
 */
package com.meat.dao;

import com.meat.domain.MeatInvoice;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface MeatInvoiceRepository extends PagingAndSortingRepository<MeatInvoice, Serializable> {

}
