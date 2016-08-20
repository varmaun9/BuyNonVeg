/**
 *
 */
package com.meat.service;

import com.meat.dao.InvoiceRepository;
import com.meat.domain.Invoice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class InvoiceService implements IInvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#create(com.meat.domain.Invoice)
     */

    @Override
    public Invoice create(final Invoice invoice) {
        // TODO Auto-generated method stub
        return invoiceRepository.save(invoice);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#deleteInvoice(java.lang.String)
     */
    @Override
    public void deleteInvoice(final String invoiceId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#getAll()
     */

    @Override
    @Transactional
    public List<Invoice> getAll() {
        List<Invoice> invoice = new ArrayList<Invoice>();
        invoice = (List<Invoice>) invoiceRepository.findAll();
        return invoice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#getCity(java.lang.String)
     */

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#getInvoice(java.lang.String)
     */

    @Override
    public Invoice getInvoice(final String invoiceId) {
        Invoice invoice = new Invoice();
        invoice = invoiceRepository.findOne(invoiceId);
        return invoice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#getInvoiceOnly()
     */
    @Override
    public List<Invoice> getInvoiceOnly() {
        List<Invoice> invoice = new ArrayList<Invoice>();
        invoice = (List<Invoice>) invoiceRepository.findAll();
        List<Invoice> invoiceses = new ArrayList<Invoice>();
        for (Invoice i : invoice) {
            Invoice in = new Invoice();
            in.setId(i.getId());
            in.setOrders(i.getOrders());
            in.setInvoiceOrder(i.getInvoiceOrder());
            in.setInvoiceDate(new Date());
            in.setInvoiceDetails(i.getInvoiceDetails());
            invoiceses.add(in);
        }
        return invoiceses;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IInvoiceService#updateInvoice(com.meat.domain.Invoice)
     */
    @Override
    public Invoice updateInvoice(final Invoice invoice) {

        return invoiceRepository.save(invoice);
    }

}
