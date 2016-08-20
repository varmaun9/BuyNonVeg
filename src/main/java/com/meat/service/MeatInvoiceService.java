/**
 *
 */
package com.meat.service;

import com.meat.dao.MeatInvoiceRepository;
import com.meat.domain.MeatInvoice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class MeatInvoiceService implements IMeatInvoiceService {

    @Autowired
    private MeatInvoiceRepository meatInvoiceRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#create(com.meat.domain.MeatInvoice)
     */
    @Override
    public MeatInvoice create(final MeatInvoice meatInvoice) {
        // TODO Auto-generated method stub
        return meatInvoiceRepository.save(meatInvoice);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#deleteMeatInvoice(java.lang.String)
     */
    @Override
    public void deleteMeatInvoice(final String meatInvoiceId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#getAll()
     */

    @Override
    public List<MeatInvoice> getAll() {
        List<MeatInvoice> meatInvoice = new ArrayList<MeatInvoice>();
        meatInvoice = (List<MeatInvoice>) meatInvoiceRepository.findAll();
        return meatInvoice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#getCity(java.lang.String)
     */

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#getMeatInvoice(java.lang.String)
     */

    @Override
    public MeatInvoice getMeatInvoice(final String meatInvoiceId) {
        MeatInvoice meatInvoice = new MeatInvoice();
        meatInvoice = meatInvoiceRepository.findOne(meatInvoiceId);
        return meatInvoice;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#getMeatInvoiceOnly()
     */

    @Override
    public List<MeatInvoice> getMeatInvoiceOnly() {
        List<MeatInvoice> meatInvoice = new ArrayList<MeatInvoice>();
        meatInvoice = (List<MeatInvoice>) meatInvoiceRepository.findAll();
        List<MeatInvoice> meatInvoices = new ArrayList<MeatInvoice>();
        for (MeatInvoice m : meatInvoice) {
            MeatInvoice mi = new MeatInvoice();
            mi.setId(m.getId());
            mi.setTotalAmount(m.getTotalAmount());
            mi.setTax(m.getTax());
            mi.setDiscount(m.getDiscount());
            mi.setGrandTotalAmount(m.getGrandTotalAmount());
            mi.setSellerInvoice(m.getSellerInvoice());
            mi.setPaidStatus(m.getPaidStatus());
            meatInvoices.add(mi);
        }
        return meatInvoices;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMeatInvoiceService#updateMeatInvoice(com.meat.domain.MeatInvoice)
     */
    @Override
    public MeatInvoice updateMeatInvoice(final MeatInvoice meatInvoice) {
        // TODO Auto-generated method stub
        return meatInvoiceRepository.save(meatInvoice);
    }

}
