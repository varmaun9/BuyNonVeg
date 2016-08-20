/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.*;
import com.meat.model.SellerInvoiceModel;
import com.meat.service.IAccountService;
import com.meat.service.IInvoiceTransactionService;
import com.meat.service.IReceiptService;
import com.meat.service.ISellerInvoiceService;

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
public class SellerInvoiceBusinessDelegate
        implements IBusinessDelegate<SellerInvoiceModel, SellerInvoiceContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerInvoiceService sellerInvoiceService;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private IReceiptService receiptService;
    @Autowired
    private IAccountService accountService;
    @Autowired
    private IInvoiceTransactionService invoiceTransactionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerInvoiceModel create(final SellerInvoiceModel model) {
        SellerInvoice sellerInvoice = new SellerInvoice();
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        sellerInvoice.setSellerBranch(sellerBranch);
        String value = model.getTotalAmount();
        if (value != null) {
            BigDecimal b = new BigDecimal(value.replaceAll(",", " "));
            sellerInvoice.setTotalAmount(b);
        }
        String value1 = model.getTax();
        if (value1 != null) {
            BigDecimal b = new BigDecimal(value1.replaceAll(",", " "));
            sellerInvoice.setTax(b);
        }
        String value2 = model.getDiscount();
        if (value2 != null) {
            BigDecimal b = new BigDecimal(value2.replaceAll(",", " "));
            sellerInvoice.setDiscount(b);
        }
        String value3 = model.getGrandTotalAmount();
        if (value3 != null) {
            BigDecimal b = new BigDecimal(value3.replaceAll(",", " "));
            sellerInvoice.setGrandTotalAmount(b);
        }
        String value4 = model.getMeatInvoiceAmount();
        if (value4 != null) {
            BigDecimal b = new BigDecimal(value4.replaceAll(",", " "));
            sellerInvoice.setMeatInvoiceAmount(b);
        }
        String value5 = model.getMeatInvoiceDiscount();
        if (value5 != null) {
            BigDecimal b = new BigDecimal(value5.replaceAll(",", " "));
            sellerInvoice.setMeatInvoiceDiscount(b);
        }
        String value6 = model.getAmountToBePaid();
        if (value6 != null) {
            BigDecimal b = new BigDecimal(value6.replaceAll(",", " "));
            sellerInvoice.setAmountToBePaid(b);
        }
        String value7 = model.getPreviousInvoiceAmount();
        if (value7 != null) {
            BigDecimal b = new BigDecimal(value7.replaceAll(",", " "));
            sellerInvoice.setPreviousInvoiceAmount(b);
        }
        String value8 = model.getDueAmount();
        if (value8 != null) {
            BigDecimal b = new BigDecimal(value8.replaceAll(",", " "));
            sellerInvoice.setDueAmount(b);
        }
        sellerInvoice.setPaidStatus(model.getPaidStatus());
        sellerInvoice.setCreatedDate(new Date());
        sellerInvoice.setReferenceDocumentNo(model.getReferenceDocumentNo());
        sellerInvoice.setTransferMode(model.getTransferMode());
        sellerInvoice.setReceiptNo(model.getReceiptNo());
        sellerInvoice.setMeatInvoiceTax(model.getMeatInvoiceTax());
        sellerInvoice.setPeriod(model.getPeriod());
        sellerInvoice.setId(model.getId());
        sellerInvoice = sellerInvoiceService.create(sellerInvoice);
        model.setId(sellerInvoice.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerInvoiceContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerInvoiceModel edit(final IKeyBuilder<String> keyBuilder, final SellerInvoiceModel model) {
        SellerInvoice sellerInvoice = sellerInvoiceService.getSellerInvoice(keyBuilder.build().toString());
        BigDecimal amountPaid = new BigDecimal(model.getAmountToBePaid());
        BigDecimal amountToBePaid = sellerInvoice.getAmountToBePaid();
        Receipt receipt = new Receipt();
        receipt.setAmount(amountPaid);
        receipt.setCreatedDate(new Date());
        receipt.setReferenceNo(model.getReceiptNo());
        receipt.setSellerInvoice(sellerInvoice);
        sellerInvoice.setDueAmount(amountToBePaid.subtract(amountPaid));
        if ((amountToBePaid.subtract(amountPaid)).compareTo(BigDecimal.ZERO) < 0) {

            sellerInvoice.setPaidStatus("UNPAID");

        }
        if ((amountToBePaid.subtract(amountPaid)).compareTo(BigDecimal.ZERO) == 0) {

            sellerInvoice.setPaidStatus("PAID");
        }
        sellerInvoiceService.updateSellerInvoice(sellerInvoice);
        receiptService.create(receipt);
        Account sellerAccount = accountService.getAccountByBranch(sellerInvoice.getSellerBranch().getId());
        BigDecimal totalAmount = sellerAccount.getAmount().subtract(sellerAccount.getAmount());
        sellerAccount.setAmount(totalAmount);
        accountService.updateAccount(sellerAccount);
        InvoiceTransaction sellerInvoiceTransaction = new InvoiceTransaction();

        sellerInvoiceTransaction.setAmount(amountPaid);

        sellerInvoiceTransaction.setTransactionType("DEBIT");

        sellerInvoiceTransaction.setDate(new Date());
        sellerInvoiceTransaction.setSellerInvoice(sellerInvoice);

        invoiceTransactionService.create(sellerInvoiceTransaction);

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public SellerInvoiceModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerInvoiceContext context) {
        SellerInvoice sellerInvoice = sellerInvoiceService.getSellerInvoice(keyBuilder.build().toString());
        SellerInvoiceModel sellerInvoiceModel = conversionService.convert(sellerInvoice, SellerInvoiceModel.class);
        return sellerInvoiceModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerInvoiceModel> getCollection(final SellerInvoiceContext context) {
        List<SellerInvoice> sellerInvoice = new ArrayList<SellerInvoice>();

        if (context.getAll() != null) {
            sellerInvoice = sellerInvoiceService.getAll();
        }
        if (context.getSellerInvoiceOnly() != null) {
            sellerInvoice = sellerInvoiceService.getSellerInvoiceOnly();
        }
        if (context.getGenerate() != null) {
            sellerInvoice = sellerInvoiceService.getInvoicesByGeneratingNow();
        }
        List<SellerInvoiceModel> sellerInvoiceModels = (List<SellerInvoiceModel>) conversionService.convert(sellerInvoice,
                TypeDescriptor.forObject(sellerInvoice),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerInvoiceModel.class)));

        return sellerInvoiceModels;
    }

}
