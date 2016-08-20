/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerInvoice;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface ISellerInvoiceService {

    SellerInvoice create(SellerInvoice sellerInvoice);

    void deleteSellerInvoice(String sellerInvoiceId);

    /**
     * @param id
     * @return
     */

    List<SellerInvoice> getAll();

    List<SellerInvoice> getCity(String city);

    /**
     * @return
     */
    List<SellerInvoice> getInvoicesByGeneratingNow();

    /**
     * @param branchId
     * @return
     */
    String getLastSellerInvoiceAmountByBranch(String branchId);

    SellerInvoice getSellerInvoice(String sellerInvoiceId);

    /**
     * @return
     */
    List<SellerInvoice> getSellerInvoiceOnly();

    SellerInvoice updateSellerInvoice(SellerInvoice sellerInvoice);

}
