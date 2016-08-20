/**
 *
 */
package com.meat.service;

import com.meat.domain.Invoice;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IInvoiceService {

    Invoice create(Invoice invoice);

    void deleteInvoice(String invoiceId);

    List<Invoice> getAll();

    Invoice getInvoice(String invoiceId);

    /**
     * @return
     */
    List<Invoice> getInvoiceOnly();

    Invoice updateInvoice(Invoice invoice);

}
