/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.BankOffer;
import com.meat.domain.Offer;
import com.meat.model.BankOfferModel;
import com.meat.service.IBankOfferService;

import java.util.ArrayList;
import java.util.Collection;
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
public class BankOfferBusinessDelegate implements IBusinessDelegate<BankOfferModel, BankOfferContext, IKeyBuilder<String>, String> {

    @Autowired
    private IBankOfferService bankOfferService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public BankOfferModel create(final BankOfferModel model) {

        BankOffer bankOffer = new BankOffer();
        bankOffer.setId(model.getId());
        bankOffer.setBankName(model.getBankName());
        Offer offer = new Offer();
        offer.setId(model.getOfferId());
        bankOffer.setOffer(offer);
        bankOffer.setStatus(model.getStatus());
        bankOffer = bankOfferService.create(bankOffer);

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final BankOfferContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public BankOfferModel edit(final IKeyBuilder<String> keyBuilder, final BankOfferModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public BankOfferModel getByKey(final IKeyBuilder<String> keyBuilder, final BankOfferContext context) {
        BankOffer bankOffer = bankOfferService.getBankOffer(keyBuilder.build().toString());
        BankOfferModel bankOfferModel = conversionService.convert(bankOffer, BankOfferModel.class);
        return bankOfferModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<BankOfferModel> getCollection(final BankOfferContext context) {
        List<BankOffer> bankOffer = new ArrayList<BankOffer>();

        if (context.getAll() != null) {
            bankOffer = bankOfferService.getAll();
        }
        if (context.getBankOfferOnly() != null) {
            bankOffer = bankOfferService.getBankOfferOnly();
        }
        List<BankOfferModel> bankOfferModels = (List<BankOfferModel>) conversionService.convert(bankOffer,
                TypeDescriptor.forObject(bankOffer), TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(BankOfferModel.class)));

        return bankOfferModels;
    }

}
