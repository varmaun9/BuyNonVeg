/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchCharges;
import com.meat.model.SellerBranchChargesModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("sellerBranchChargesModelToSellerBranchChargesConverter")
public class SellerBranchChargesModelToSellerBranchChargesConverter implements Converter<SellerBranchChargesModel, SellerBranchCharges> {
    @Autowired
    private ObjectFactory<SellerBranchCharges> sellerBranchChargesFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SellerBranchCharges convert(final SellerBranchChargesModel source) {
        SellerBranchCharges sellerBranchCharges = sellerBranchChargesFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchCharges);

        return sellerBranchCharges;
    }

    @Autowired
    public void setSellerBranchChargesFactory(final ObjectFactory<SellerBranchCharges> sellerBranchChargesFactory) {
        this.sellerBranchChargesFactory = sellerBranchChargesFactory;
    }

}
