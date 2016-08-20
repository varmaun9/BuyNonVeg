/**
 *
 */
package com.meat.service;

import com.meat.domain.MeatInvoice;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IMeatInvoiceService {

    MeatInvoice create(MeatInvoice meatInvoice);

    void deleteMeatInvoice(String meatInvoiceId);

    List<MeatInvoice> getAll();

    // List<MeatInvoice> getCity(String city);

    MeatInvoice getMeatInvoice(String meatInvoiceId);

    /**
     * @return
     */
    List<MeatInvoice> getMeatInvoiceOnly();

    MeatInvoice updateMeatInvoice(MeatInvoice meatInvoice);

}
