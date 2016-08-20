/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Receipt;
import com.meat.domain.SellerInvoice;
import com.meat.model.ReceiptModel;
import com.meat.service.IReceiptService;

import java.math.BigDecimal;
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
public class ReceiptBusinessDelegate implements IBusinessDelegate<ReceiptModel, ReceiptContext, IKeyBuilder<String>, String> {

    @Autowired
    private IReceiptService receiptService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ReceiptModel create(final ReceiptModel model) {
        Receipt receipt = new Receipt();
        receipt.setReceiptCode(model.getReceiptCode());
        receipt.setReferenceNo(model.getReferenceNo());
        receipt.setReferenceDocumentLink(model.getReferenceDocumentLink());
        String value = model.getAmount();
        if (value != null) {
            BigDecimal bd = new BigDecimal(value.replaceAll(",", " "));
            receipt.setAmount(bd);
        }
        SellerInvoice sellerInvoice = new SellerInvoice();
        sellerInvoice.setId(model.getSellerInvoiceId());
        receipt.setSellerInvoice(sellerInvoice);
        receipt.setCreatedDate(new Date());
        receipt.setId(model.getId());
        receipt = receiptService.create(receipt);
        model.setId(receipt.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final ReceiptContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public ReceiptModel edit(final IKeyBuilder<String> keyBuilder, final ReceiptModel model) {
        Receipt receipt = receiptService.getReceipt(keyBuilder.build().toString());
        receipt.setReceiptCode(model.getReceiptCode());
        receipt.setReferenceNo(model.getReferenceNo());
        receipt.setReferenceDocumentLink(model.getReferenceDocumentLink());
        String value = model.getAmount();
        if (value != null) {
            BigDecimal bd = new BigDecimal(value.replaceAll(",", " "));
            receipt.setAmount(bd);
        }
        SellerInvoice sellerInvoice = new SellerInvoice();
        sellerInvoice.setId(model.getSellerInvoiceId());
        receipt.setSellerInvoice(sellerInvoice);
        receipt.setCreatedDate(new Date());
        receipt.setId(model.getId());
        receipt = receiptService.updateReceipt(receipt);
        model.setId(receipt.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public ReceiptModel getByKey(final IKeyBuilder<String> keyBuilder, final ReceiptContext context) {
        Receipt receipt = receiptService.getReceipt(keyBuilder.build().toString());
        ReceiptModel receiptModel = conversionService.convert(receipt, ReceiptModel.class);
        return receiptModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<ReceiptModel> getCollection(final ReceiptContext context) {
        List<Receipt> receipt = new ArrayList<Receipt>();

        if (context.getAll() != null) {
            receipt = receiptService.getAll();
        }
        if (context.getReceiptOnly() != null) {
            receipt = receiptService.getReceiptOnly();
        }
        List<ReceiptModel> receiptModels = (List<ReceiptModel>) conversionService.convert(receipt, TypeDescriptor.forObject(receipt),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(ReceiptModel.class)));

        return receiptModels;
    }

}
