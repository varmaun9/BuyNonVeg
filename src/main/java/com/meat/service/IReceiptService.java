/**
 *
 */
package com.meat.service;

import com.meat.domain.Receipt;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IReceiptService {

    Receipt create(Receipt receipt);

    void deleteReceipt(String receiptId);

    List<Receipt> getAll();

    Receipt getReceipt(String receiptId);

    /**
     * @return
     */
    List<Receipt> getReceiptOnly();

    Receipt updateReceipt(Receipt receipt);

}
