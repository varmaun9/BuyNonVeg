/**
 *
 */
package com.meat.service;

import com.meat.dao.InvoiceStatusCodesRepository;
import com.meat.domain.InvoiceStatusCodes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class InvoiceStatusCodesService implements IInvoiceStatusCodesService {

    @Autowired
    private InvoiceStatusCodesRepository invoiceStatusCodesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#create(com.meat.domain.InvoiceStatusCodes)
     */
    @Override
    public InvoiceStatusCodes create(final InvoiceStatusCodes invoiceStatusCodes) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#deleteAddress(java.lang.String)
     */
    @Override
    public void deleteAddress(final String invoiceStatusCodesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#getAll()
     */
    @Override
    public List<InvoiceStatusCodes> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#getCity(java.lang.String)
     */
    @Override
    public List<InvoiceStatusCodes> getCity(final String city) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#getInvoiceStatusCodes(java.lang.String)
     */
    @Override
    public InvoiceStatusCodes getInvoiceStatusCodes(final String invoiceStatusCodesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceStatusCodesService#updateInvoiceStatusCodes(com.meat.domain.InvoiceStatusCodes)
     */
    @Override
    public InvoiceStatusCodes updateInvoiceStatusCodes(final InvoiceStatusCodes invoiceStatusCodes) {
        // TODO Auto-generated method stub
        return null;
    }

}
