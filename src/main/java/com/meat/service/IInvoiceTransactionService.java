/**
 *
 */
package com.meat.service;

import com.meat.domain.InvoiceTransaction;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IInvoiceTransactionService {

    InvoiceTransaction create(InvoiceTransaction invoiceTransaction);

    void deleteInvoiceTransaction(String invoiceTransactionId);

    List<InvoiceTransaction> getAll();

    List<InvoiceTransaction> getCity(String city);

    InvoiceTransaction getInvoiceTransaction(String invoiceTransactionId);

    InvoiceTransaction updateInvoiceTransaction(InvoiceTransaction invoiceTransaction);

}
