/**
 *
 */
package com.meat.service;

import com.meat.domain.InvoiceStatusCodes;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IInvoiceStatusCodesService {

    InvoiceStatusCodes create(InvoiceStatusCodes invoiceStatusCodes);

    void deleteAddress(String invoiceStatusCodesId);

    List<InvoiceStatusCodes> getAll();

    List<InvoiceStatusCodes> getCity(String city);

    InvoiceStatusCodes getInvoiceStatusCodes(String invoiceStatusCodesId);

    InvoiceStatusCodes updateInvoiceStatusCodes(InvoiceStatusCodes invoiceStatusCodes);

}
