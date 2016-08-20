/**
 *
 */
package com.meat.service;

import com.meat.dao.SellerBranchTaxRepository;
import com.meat.dao.SellerInvoiceRepository;
import com.meat.dao.SubOrderRepository;
import com.meat.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class SellerInvoiceService implements ISellerInvoiceService {

    @Autowired
    private SellerInvoiceRepository sellerInvoiceRepository;
    @Autowired
    private SubOrderRepository subOrderRepository;
    @Autowired
    private SellerBranchTaxRepository sellerBranchTaxRepository;
    @Autowired
    private IInvoiceTransactionService invoiceTransactionService;
    @Autowired
    private IMeatInvoiceService meatInvoiceService;

    @Autowired
    private IAccountService accountService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#create(com.meat.domain.SellerInvoice)
     */
    @Override
    public SellerInvoice create(final SellerInvoice sellerInvoice) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#deleteSellerInvoice(java.lang.String)
     */
    @Override
    public void deleteSellerInvoice(final String sellerInvoiceId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getAll()
     */
    @Override
    public List<SellerInvoice> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getCity(java.lang.String)
     */
    @Override
    public List<SellerInvoice> getCity(final String city) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getInvoicesByGeneratingNow()
     */
    @Override
    public List<SellerInvoice> getInvoicesByGeneratingNow() {

        List<SellerInvoice> sellerInvoices = new ArrayList<SellerInvoice>(0);
        for (Object[] o : subOrderRepository.findUnbilledSubOrdersTotalAmount()) {
            //o[0] --> sellerBranchId,
            //o[1] --> subOrderSubTotalPrice,
            //o[2] -->subOrderTotalPrice
            //o[3] -->discount
            //o[4] -->taxValue
            //o[5] --> subOrder sseller charges
            //o[6]  --> createdDate min
            // o[7] --> createdDate max
            SellerInvoice sellerInvoice = new SellerInvoice();
            SellerBranch sb = new SellerBranch();
            sb.setId(o[0].toString());
            sellerInvoice.setCreatedDate(new Date());
            sellerInvoice.setDiscount(new BigDecimal(o[3].toString()));
            sellerInvoice.setSellerBranch(sb);
            sellerInvoice.setPeriod(o[6].toString() + " To " + o[7].toString());
            sellerInvoice.setTax(new BigDecimal(o[4].toString()));
            sellerInvoice.setTotalAmount(new BigDecimal(o[1].toString()));
            sellerInvoice.setCancelledSubOrdersAmount(subOrderRepository.findCancelledSubOrdersAmountByBranch(sb.getId()));
            BigDecimal totalBilledDeleiveredSubOrdersAmount = subOrderRepository.findDeliverySubOrdersAmountByBranch(sb.getId());
            sellerInvoice.setGrandTotalAmount(totalBilledDeleiveredSubOrdersAmount);
            sellerInvoice.setPaidStatus("UNPAID");

            List<SellerBranchTax> sbt = sellerBranchTaxRepository.findTaxByBranchAndTaxType(sb.getId(), "MARGIN");
            MeatInvoice meatInvoice = new MeatInvoice();
            BigDecimal meatInvoiceMarginPerc = sbt.get(0).getTaxValue();
            BigDecimal meatInvoiceMarginValue = totalBilledDeleiveredSubOrdersAmount
                    .multiply(meatInvoiceMarginPerc.divide(new BigDecimal(100), 2, RoundingMode.CEILING));
            BigDecimal meatInvoiceServiceTax = new BigDecimal(2.00);
            BigDecimal meatInvoicePayableAmount = meatInvoiceMarginValue
                    .add(meatInvoiceMarginValue.multiply(meatInvoiceServiceTax.divide(new BigDecimal(100), 2, RoundingMode.CEILING)));
            meatInvoice.setGrandTotalAmount(meatInvoicePayableAmount);
            meatInvoice.setTotalAmount(meatInvoiceMarginValue);
            meatInvoice.setTax(meatInvoiceServiceTax.toString());
            sellerInvoice.setMeatInvoiceAmount(meatInvoicePayableAmount);
            sellerInvoice.setMeatInvoiceTax(meatInvoiceServiceTax.toString());
            sellerInvoice.setMeatInvoiceDiscount(new BigDecimal(0.0));

            sellerInvoice.setCodBilledAmount(subOrderRepository.findBilledSubOrdersAmountByPaymentType(sb.getId(), "COD"));
            sellerInvoice
                    .setPaymentGatewayBilledAmount(subOrderRepository.findBilledSubOrdersAmountByPaymentType(sb.getId(), "PAYMENTGATEWAY"));

            BigDecimal previousDueAmount = sellerInvoiceRepository.findBilledAmountBySellerBranchPaidStatus(sb.getId(), "UNPAID");
            BigDecimal totalPayableAmountAfterCOD = totalBilledDeleiveredSubOrdersAmount.subtract(sellerInvoice.getCodBilledAmount());
            if (previousDueAmount == null) {
                previousDueAmount = new BigDecimal(0.0);
            }
            BigDecimal totalAmountPayableWithPreviousDue = totalPayableAmountAfterCOD.add(previousDueAmount);

            BigDecimal totalAmountPayableToSellerAfterMeatMarginAndCODWithPreviousDue = totalAmountPayableWithPreviousDue
                    .subtract(meatInvoicePayableAmount);
            sellerInvoice.setAmountToBePaid(totalAmountPayableToSellerAfterMeatMarginAndCODWithPreviousDue);
            sellerInvoice.setDueAmount(totalAmountPayableToSellerAfterMeatMarginAndCODWithPreviousDue);
            sellerInvoice = sellerInvoiceRepository.save(sellerInvoice);
            if (previousDueAmount != null) {

                List<SellerInvoice> unPaidSellerInvoices = sellerInvoiceRepository.findSellerInvoiceBySellerBranchPaidStatus(sb.getId(),
                        "UNPAID");
                for (SellerInvoice unPaidSellerInvoice : unPaidSellerInvoices) {
                    unPaidSellerInvoice.setPaidStatus("PAID");
                    unPaidSellerInvoice.setDescription("Due Amount: " + previousDueAmount + " added to " + sellerInvoice.getId());
                    sellerInvoiceRepository.save(unPaidSellerInvoice);
                }
            }
            meatInvoice.setSellerInvoice(sellerInvoice);

            meatInvoice = meatInvoiceService.create(meatInvoice);
            if (sellerInvoice.getId() != null) {
                List<SubOrder> subs = new ArrayList<SubOrder>(0);
                List<SubOrder> subOrdersUnbilled = subOrderRepository.findUnbilledSubOrders();
                for (SubOrder so : subOrdersUnbilled) {
                    if (so.getSellerBranch().getId().equals(sellerInvoice.getSellerBranch().getId())) {
                        so.setBilledStatus("BILLED");
                        so.setSellerInvoice(sellerInvoice);

                    }
                    subs.add(so);

                }
                subOrderRepository.save(subs);
            }
            Account sellerAccount = accountService.getAccountByBranch(sb.getId());
            BigDecimal totalAmount = totalAmountPayableToSellerAfterMeatMarginAndCODWithPreviousDue.add(sellerAccount.getAmount());
            sellerAccount.setAmount(totalAmount);
            accountService.updateAccount(sellerAccount);
            Account meatAccount = accountService.getAccountByEntityType("MEAT");
            BigDecimal totalMeatAmount = sellerInvoice.getGrandTotalAmount().add(meatAccount.getAmount());
            meatAccount.setAmount(totalMeatAmount);
            accountService.updateAccount(meatAccount);
            if (sellerInvoice.getId() != null) {

                meatInvoice.setSellerInvoice(sellerInvoice);
                meatInvoiceService.updateMeatInvoice(meatInvoice);
                InvoiceTransaction sellerInvoiceTransaction = new InvoiceTransaction();
                sellerInvoiceTransaction.setAmount(sellerInvoice.getAmountToBePaid());

                sellerInvoiceTransaction.setTransactionType("CREDIT");

                sellerInvoiceTransaction.setDate(new Date());
                sellerInvoiceTransaction.setSellerInvoice(sellerInvoice);
                // transactions.add(sellerInvoiceTransaction);
                invoiceTransactionService.create(sellerInvoiceTransaction);
                InvoiceTransaction meatInvoiceTransaction = new InvoiceTransaction();
                if (meatInvoice.getId() != null) {

                    meatInvoiceTransaction.setAmount(meatInvoice.getGrandTotalAmount());

                    meatInvoiceTransaction.setTransactionType("DEBIT");

                    meatInvoiceTransaction.setDate(new Date());
                    meatInvoiceTransaction.setMeatInvoice(meatInvoice);

                    invoiceTransactionService.create(meatInvoiceTransaction);

                }

            }
            sellerInvoices.add(sellerInvoice);

        }
        return sellerInvoices;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getLastSellerInvoiceAmountByBranch(java.lang.String)
     */
    @Override
    public String getLastSellerInvoiceAmountByBranch(final String branchId) {
        // TODO Auto-generated method stub
        return sellerInvoiceRepository.findLastGeneratedSellerInvoiceAmountByBranch(branchId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getSellerInvoice(java.lang.String)
     */
    @Override
    public SellerInvoice getSellerInvoice(final String sellerInvoiceId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#getSellerInvoiceOnly()
     */
    @Override
    public List<SellerInvoice> getSellerInvoiceOnly() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISellerInvoiceService#updateSellerInvoice(com.meat.domain.SellerInvoice)
     */
    @Override
    public SellerInvoice updateSellerInvoice(final SellerInvoice sellerInvoice) {
        // TODO Auto-generated method stub

        return sellerInvoiceRepository.save(sellerInvoice);
    }
}
