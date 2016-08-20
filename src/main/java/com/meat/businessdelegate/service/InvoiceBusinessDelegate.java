/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Invoice;
import com.meat.domain.Orders;
import com.meat.model.InvoiceModel;
import com.meat.service.IInvoiceService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi
 *
 */
@Service
public class InvoiceBusinessDelegate implements IBusinessDelegate<InvoiceModel, InvoiceContext, IKeyBuilder<String>, String> {

    @Autowired
    private IInvoiceService invoiceService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public InvoiceModel create(final InvoiceModel model) {
        Invoice invoice = new Invoice();
        Orders order = new Orders();
        order.setId(model.getOrdersId());
        invoice.setOrders(order);
        invoice.setInvoiceOrder(model.getInvoiceOrder());
        invoice.setInvoiceDate(new Date());
        invoice.setInvoiceDetails(model.getInvoiceDetails());
        invoice.setId(model.getId());
        invoice = invoiceService.create(invoice);
        model.setId(invoice.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final InvoiceContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public InvoiceModel edit(final IKeyBuilder<String> keyBuilder, final InvoiceModel model) {
        Invoice invoice = invoiceService.getInvoice(keyBuilder.build().toString());

        Orders order = new Orders();
        order.setId(model.getOrdersId());
        invoice.setOrders(order);
        invoice.setInvoiceOrder(model.getInvoiceOrder());
        invoice.setInvoiceDate(new Date());
        invoice.setInvoiceDetails(model.getInvoiceDetails());
        invoice.setId(model.getId());
        invoice = invoiceService.updateInvoice(invoice);
        model.setId(invoice.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public InvoiceModel getByKey(final IKeyBuilder<String> keyBuilder, final InvoiceContext context) {
        Invoice invoice = invoiceService.getInvoice(keyBuilder.build().toString());
        InvoiceModel invoiceModel = conversionService.convert(invoice, InvoiceModel.class);

        return invoiceModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<InvoiceModel> getCollection(final InvoiceContext context) {
        List<Invoice> invoice = new ArrayList<Invoice>();

        if (context.getAll() != null) {
            invoice = invoiceService.getAll();
        }
        if (context.getInvoiceOnly() != null) {
            invoice = invoiceService.getInvoiceOnly();
        }
        List<InvoiceModel> invoiceModels = (List<InvoiceModel>) conversionService.convert(invoice, TypeDescriptor.forObject(invoice),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(InvoiceModel.class)));

        return invoiceModels;
    }

}
