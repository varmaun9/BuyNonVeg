/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Account;
import com.meat.model.AccountModel;

import org.apache.log4j.Logger;
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
@Component("accountToAccountModelConverter")
public class AccountToAccountModelConverter implements Converter<Account, AccountModel> {

    private static final Logger LOGGER = Logger.getLogger(AccountToAccountModelConverter.class);
    @Autowired
    private ObjectFactory<AccountModel> accountModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public AccountModel convert(final Account source) {
        // TODO Auto-generated method stub
        AccountModel accountModel = accountModelFactory.getObject();

        BeanUtils.copyProperties(source, accountModel);

        return accountModel;

    }

    @Autowired
    public void setAccountFactory(final ObjectFactory<AccountModel> accountModelFactory) {
        this.accountModelFactory = accountModelFactory;
    }

}
