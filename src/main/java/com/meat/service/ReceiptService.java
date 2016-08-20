/**
 *
 */
package com.meat.service;

import com.meat.dao.ReceiptRepository;
import com.meat.domain.Receipt;

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
public class ReceiptService implements IReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#create(com.meat.domain.Receipt)
     */
    @Override
    public Receipt create(final Receipt receipt) {

        return receiptRepository.save(receipt);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#deleteReceipt(java.lang.String)
     */
    @Override
    public void deleteReceipt(final String receiptId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#getAll()
     */

    @Override
    @Transactional
    public List<Receipt> getAll() {
        List<Receipt> receipt = new ArrayList<Receipt>();
        receipt = (List<Receipt>) receiptRepository.findAll();
        return receipt;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#getReceipt(java.lang.String)
     */
    @Override
    public Receipt getReceipt(final String receiptId) {
        Receipt receipt = new Receipt();
        receipt = receiptRepository.findOne(receiptId);
        return receipt;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#getReceiptOnly()
     */

    @Override
    public List<Receipt> getReceiptOnly() {
        List<Receipt> receipt = new ArrayList<Receipt>();
        receipt = (List<Receipt>) receiptRepository.findAll();
        List<Receipt> receipts = new ArrayList<Receipt>();
        for (Receipt r : receipt) {
            Receipt rt = new Receipt();
            rt.setId(r.getId());
            rt.setReceiptCode(r.getReceiptCode());
            rt.setReferenceNo(r.getReferenceNo());
            rt.setReferenceDocumentLink(r.getReferenceDocumentLink());
            rt.setAmount(r.getAmount());
            rt.setSellerInvoice(r.getSellerInvoice());
            rt.setCreatedDate(new Date());
            receipts.add(rt);
        }
        return receipts;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IReceiptService#updateReceipt(com.meat.domain.Receipt)
     */
    @Override
    public Receipt updateReceipt(final Receipt receipt) {
        // TODO Auto-generated method stub
        return receiptRepository.save(receipt);
    }

}
