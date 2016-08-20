/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SellerBankAccount;
import com.meat.domain.SellerBranch;
import com.meat.model.SellerBankAccountModel;
import com.meat.service.ISellerBankAccountService;

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
public class SellerBankAccountBusinessDelegate
        implements IBusinessDelegate<SellerBankAccountModel, SellerBankAccountContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISellerBankAccountService sellerBankAccountService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBankAccountModel create(final SellerBankAccountModel model) {
        SellerBankAccount sellerBankAccount = new SellerBankAccount();
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getId());
        sellerBankAccount.setAccountType(model.getAccountType());
        sellerBankAccount.setPanNumber(model.getPanNumber());

        sellerBankAccount.setSellerBranch(sellerBranch);
        sellerBankAccount.setAccountNo(model.getAccountNo());
        sellerBankAccount.setIfscCode(model.getIfscCode());
        sellerBankAccount.setBranchDetails(model.getBranchDetails());
        sellerBankAccount.setName(model.getName());

        sellerBankAccount = sellerBankAccountService.create(sellerBankAccount);
        model.setId(sellerBankAccount.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SellerBankAccountContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SellerBankAccountModel edit(final IKeyBuilder<String> keyBuilder, final SellerBankAccountModel model) {
        SellerBankAccount sellerBankAccount = sellerBankAccountService.getSellerBankAccount(keyBuilder.build().toString());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getId());
        sellerBankAccount.setSellerBranch(sellerBranch);
        sellerBankAccount.setAccountNo(model.getAccountNo());
        sellerBankAccount.setIfscCode(model.getIfscCode());
        sellerBankAccount.setBranchDetails(model.getBranchDetails());
        sellerBankAccount.setName(model.getName());

        sellerBankAccount = sellerBankAccountService.updateSellerBankAccount(sellerBankAccount);
        model.setId(sellerBankAccount.getId());
        return model;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public SellerBankAccountModel getByKey(final IKeyBuilder<String> keyBuilder, final SellerBankAccountContext context) {
        SellerBankAccount sellerBankAccount = sellerBankAccountService.getSellerBankAccount(keyBuilder.build().toString());
        SellerBankAccountModel sellerBankAccountModel = conversionService.convert(sellerBankAccount, SellerBankAccountModel.class);
        return sellerBankAccountModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SellerBankAccountModel> getCollection(final SellerBankAccountContext context) {
        List<SellerBankAccount> sellerBankAccount = new ArrayList<SellerBankAccount>();

        if (context.getAll() != null) {
            sellerBankAccount = sellerBankAccountService.getAll();
        }
        if (context.getSellerBankAccountOnly() != null) {
            sellerBankAccount = sellerBankAccountService.getSellerBankAccountOnly();
        }
        List<SellerBankAccountModel> sellerBankAccountModels = (List<SellerBankAccountModel>) conversionService.convert(sellerBankAccount,
                TypeDescriptor.forObject(sellerBankAccount),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SellerBankAccountModel.class)));

        return sellerBankAccountModels;
    }

}
