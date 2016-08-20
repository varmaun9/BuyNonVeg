/**
 *
 */
package com.meat.service;

import com.meat.dao.InvoiceTransactionRepository;
import com.meat.domain.InvoiceTransaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class InvoiceTransactionService implements IInvoiceTransactionService {

    @Autowired
    private InvoiceTransactionRepository invoiceTransactionRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#create(com.meat.domain.InvoiceTransaction)
     */
    @Override
    public InvoiceTransaction create(final InvoiceTransaction invoiceTransaction) {
        // TODO Auto-generated method stub
        return invoiceTransactionRepository.save(invoiceTransaction);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#deleteInvoiceTransaction(java.lang.String)
     */
    @Override
    public void deleteInvoiceTransaction(final String invoiceTransactionId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#getAll()
     */
    @Override
    public List<InvoiceTransaction> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#getCity(java.lang.String)
     */
    @Override
    public List<InvoiceTransaction> getCity(final String city) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#getInvoiceTransaction(java.lang.String)
     */
    @Override
    public InvoiceTransaction getInvoiceTransaction(final String invoiceTransactionId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceTransactionService#updateInvoiceTransaction(com.meat.domain.InvoiceTransaction)
     */
    @Override
    public InvoiceTransaction updateInvoiceTransaction(final InvoiceTransaction invoiceTransaction) {
        // TODO Auto-generated method stub
        return null;
    }

}
