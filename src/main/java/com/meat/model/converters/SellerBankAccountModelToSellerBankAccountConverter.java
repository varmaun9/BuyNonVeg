/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBankAccount;
import com.meat.model.SellerBankAccountModel;

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
@Component("sellerBankAccountModelToSellerBankAccountConverter")
public class SellerBankAccountModelToSellerBankAccountConverter implements Converter<SellerBankAccountModel, SellerBankAccount> {
    @Autowired
    private ObjectFactory<SellerBankAccount> sellerBankAccountFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBankAccount convert(final SellerBankAccountModel source) {
        SellerBankAccount sellerBankAccount = sellerBankAccountFactory.getObject();
        BeanUtils.copyProperties(source, sellerBankAccount);

        return sellerBankAccount;
    }

    @Autowired
    public void setSellerBankAccountFactory(final ObjectFactory<SellerBankAccount> sellerBankAccountFactory) {
        this.sellerBankAccountFactory = sellerBankAccountFactory;
    }

}
