/*
 *
 */
package com.meat.model.converters;

import com.meat.domain.AmountType;
import com.meat.model.AmountTypeModel;
import com.meat.model.CouponModel;
import com.meat.model.SellerBranchTaxModel;
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
 * @author varma
 *
 */
@Component("amountTypeToAmountTypeModelConverter")
public class AmountTypeToAmountTypeModelConverter implements Converter<AmountType, AmountTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(AmountTypeToAmountTypeModelConverter.class);
    @Autowired
    private ObjectFactory<AmountTypeModel> amountTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public AmountTypeModel convert(final AmountType source) {
        // TODO Auto-generated method stub
        AmountTypeModel amountTypeModel = amountTypeModelFactory.getObject();

        BeanUtils.copyProperties(source, amountTypeModel);

        if (CollectionUtils.isNotEmpty(source.getCoupons())) {
            List<CouponModel> converted = (List<CouponModel>) conversionService.convert(source.getCoupons(),
                    TypeDescriptor.forObject(source.getCoupons()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponModel.class));
            amountTypeModel.getCouponsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxes())) {
            List<SellerBranchTaxModel> converted = (List<SellerBranchTaxModel>) conversionService.convert(source.getSellerBranchTaxes(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTaxModel.class));
            amountTypeModel.getSellerBranchTaxesModels().addAll(converted);
        }

        return amountTypeModel;

    }

    @Autowired
    public void setAmountTypeFactory(final ObjectFactory<AmountTypeModel> amountTypeModelFactory) {
        this.amountTypeModelFactory = amountTypeModelFactory;
    }
}
