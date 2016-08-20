/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchCharges;
import com.meat.model.SellerBranchChargesModel;

import org.apache.log4j.Logger;
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
@Component("sellerBranchChargesToSellerBranchChargesModelConverter")
public class SellerBranchChargesToSellerBranchChargesModelConverter implements Converter<SellerBranchCharges, SellerBranchChargesModel> {

    private static final Logger LOGGER = Logger.getLogger(SellerBranchChargesToSellerBranchChargesModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchChargesModel> sellerBranchChargesModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchChargesModel convert(final SellerBranchCharges source) {
        // TODO Auto-generated method stub
        SellerBranchChargesModel sellerBranchChargesModel = sellerBranchChargesModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchChargesModel);
        if (source.getAmountType() != null) {
            sellerBranchChargesModel.setAmountTypeId(source.getAmountType().getId());
            sellerBranchChargesModel.setAmountDescription(source.getAmountType().getAmountDescription());
        }
        return sellerBranchChargesModel;

    }

    @Autowired
    public void setSellerBranchChargesFactory(final ObjectFactory<SellerBranchChargesModel> sellerBranchChargesModelFactory) {
        this.sellerBranchChargesModelFactory = sellerBranchChargesModelFactory;
    }
}
