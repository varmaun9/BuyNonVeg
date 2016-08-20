/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBankAccount;
import com.meat.model.SellerBankAccountModel;

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
@Component("sellerBankAccountToSellerBankAccountModelConverter")
public class SellerBankAccountToSellerBankAccountModelConverter implements Converter<SellerBankAccount, SellerBankAccountModel> {

    @Autowired
    private ObjectFactory<SellerBankAccountModel> sellerBankAccountModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SellerBankAccountToSellerBankAccountModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBankAccountModel convert(final SellerBankAccount source) {
        // TODO Auto-generated method stub
        SellerBankAccountModel sellerBankAccountModel = sellerBankAccountModelFactory.getObject();

        BeanUtils.copyProperties(source, sellerBankAccountModel);

        return sellerBankAccountModel;

    }

    @Autowired
    public void setSellerBankAccountFactory(final ObjectFactory<SellerBankAccountModel> sellerBankAccountModelFactory) {
        this.sellerBankAccountModelFactory = sellerBankAccountModelFactory;
    }

}
