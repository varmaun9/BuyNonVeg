/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.AmountType;
import com.meat.domain.Coupon;
import com.meat.domain.SellerBranchTax;
import com.meat.model.AmountTypeModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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

@Component("amountTypeModelToAmountTypeConverter")
public class AmountTypeModelToAmountTypeConverter implements Converter<AmountTypeModel, AmountType> {
    @Autowired
    private ObjectFactory<AmountType> amountTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public AmountType convert(final AmountTypeModel source) {
        AmountType amountType = amountTypeFactory.getObject();
        BeanUtils.copyProperties(source, amountType);

        if (CollectionUtils.isNotEmpty(source.getCouponsModels())) {
            List<Coupon> converted = (List<Coupon>) conversionService.convert(source.getCouponsModels(),
                    TypeDescriptor.forObject(source.getCouponsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Coupon.class));
            amountType.getCoupons().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchTaxesModels())) {
            List<SellerBranchTax> converted = (List<SellerBranchTax>) conversionService.convert(source.getSellerBranchTaxesModels(),
                    TypeDescriptor.forObject(source.getSellerBranchTaxesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchTax.class));
            amountType.getSellerBranchTaxes().addAll(converted);
        }
        return amountType;
    }

    @Autowired
    public void setAmountTypeFactory(final ObjectFactory<AmountType> amountTypeFactory) {
        this.amountTypeFactory = amountTypeFactory;
    }

}
