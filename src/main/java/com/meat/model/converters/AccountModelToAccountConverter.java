/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Account;
import com.meat.model.AccountModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("accountModelToAccountConverter")
public class AccountModelToAccountConverter implements Converter<AccountModel, Account> {
    @Autowired
    private ObjectFactory<Account> accountFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Account convert(final AccountModel source) {
        Account account = accountFactory.getObject();
        BeanUtils.copyProperties(source, account);

        return account;
    }

    @Autowired
    public void setAccountFactory(final ObjectFactory<Account> accountFactory) {
        this.accountFactory = accountFactory;
    }

}
