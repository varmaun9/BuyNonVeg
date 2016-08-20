/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.BankOffer;
import com.meat.model.BankOfferModel;
import com.meat.model.OfferConfigModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("bankOfferToBankOfferModelConverter")
public class BankOfferToBankOfferModelConverter implements Converter<BankOffer, BankOfferModel> {

    private static final Logger LOGGER = Logger.getLogger(BankOfferToBankOfferModelConverter.class);
    @Autowired
    private ObjectFactory<BankOfferModel> bankOfferModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public BankOfferModel convert(final BankOffer source) {
        // TODO Auto-generated method stub
        BankOfferModel bankOfferModel = bankOfferModelFactory.getObject();

        BeanUtils.copyProperties(source, bankOfferModel);

        if (CollectionUtils.isNotEmpty(source.getOfferConfigs())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigs(),
                    TypeDescriptor.forObject(source.getOfferConfigs()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            bankOfferModel.getOfferConfigModels().addAll(converted);
        }
        /*  if (CollectionUtils.isNotEmpty(source.getUsers())) {
            List<UsersModel> converted = (List<UsersModel>) conversionService.convert(source.getUsers(),
                    TypeDescriptor.forObject(source.getUsers()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersModel.class));
            BankOfferModel.getUserModels().addAll(converted);
        }*/
        /* if (CollectionUtils.isNotEmpty(source.getSellerBranches())) {
            List<SellerBranchModel> converted = (List<SellerBranchModel>) conversionService.convert(source.getSellerBranches(),
                    TypeDescriptor.forObject(source.getSellerBranches()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchModel.class));
            BankOfferModel.getSellerBranchModels().addAll(converted);
        }*/
        return bankOfferModel;

    }

    @Autowired
    public void setBankOfferFactory(final ObjectFactory<BankOfferModel> bankOfferModelFactory) {
        this.bankOfferModelFactory = bankOfferModelFactory;
    }

}
