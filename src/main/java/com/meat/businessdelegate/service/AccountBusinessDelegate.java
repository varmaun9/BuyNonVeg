/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Account;
import com.meat.domain.SellerBranch;
import com.meat.model.AccountModel;
import com.meat.service.IAccountService;

import java.math.BigDecimal;
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
public class AccountBusinessDelegate implements IBusinessDelegate<AccountModel, AccountContext, IKeyBuilder<String>, String> {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public AccountModel create(final AccountModel model) {
        Account account = new Account();
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        account.setSellerBranch(sellerBranch);
        account.setEntityType(model.getEntityName());
        account.setEntityType(model.getEntityType());

        String value = model.getAmount();
        if (value != null) {
            BigDecimal bd = new BigDecimal(value.replaceAll(",", " "));
            account.setAmount(bd);
        }
        account.setId(model.getId());
        account = accountService.create(account);
        model.setId(account.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final AccountContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public AccountModel edit(final IKeyBuilder<String> keyBuilder, final AccountModel model) {
        Account account = accountService.getAccount(keyBuilder.build().toString());
        SellerBranch sellerBranch = new SellerBranch();
        sellerBranch.setId(model.getSellerBranchId());
        account.setSellerBranch(sellerBranch);
        account.setEntityType(model.getEntityName());
        account.setEntityType(model.getEntityType());

        String value = model.getAmount();
        if (value != null) {
            BigDecimal bd = new BigDecimal(value.replaceAll(",", " "));
            account.setAmount(bd);
        }
        account.setId(model.getId());
        account = accountService.updateAccount(account);
        model.setId(account.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */

    @Override
    public AccountModel getByKey(final IKeyBuilder<String> keyBuilder, final AccountContext context) {

        Account account = new Account();
        if (context.getAll() != null) {
            account = accountService.getAccount(keyBuilder.build().toString());
        }
        if (context.getBranch() != null) {
            account = accountService.getAccountByBranch(context.getBranch());
        }
        AccountModel accountModel = conversionService.convert(account, AccountModel.class);
        return accountModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<AccountModel> getCollection(final AccountContext context) {
        List<Account> account = new ArrayList<Account>();
        if (context.getAll() != null) {
            account = accountService.getAll();
        }
        if (context.getAccountOnly() != null) {
            account = accountService.getAccountOnly();
        }
        List<AccountModel> accountModels = (List<AccountModel>) conversionService.convert(account, TypeDescriptor.forObject(account),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(AccountModel.class)));
        return accountModels;
    }

}
