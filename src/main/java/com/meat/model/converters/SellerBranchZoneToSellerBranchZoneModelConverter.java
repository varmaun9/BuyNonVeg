/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchZone;
import com.meat.model.SellerBranchZoneModel;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerBranchZoneToSellerBranchZoneModelConverter")
public class SellerBranchZoneToSellerBranchZoneModelConverter implements Converter<SellerBranchZone, SellerBranchZoneModel> {
    private static final Logger LOGGER = Logger.getLogger(SellerBranchZoneToSellerBranchZoneModelConverter.class);
    @Autowired
    private ObjectFactory<SellerBranchZoneModel> sellerBranchZoneModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchZoneModel convert(final SellerBranchZone source) {
        SellerBranchZoneModel sellerBranchZoneModel = sellerBranchZoneModelFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchZoneModel);
        sellerBranchZoneModel.setSellerBranchId(source.getSellerBranch().getId());
        sellerBranchZoneModel.setZoneId(source.getZone().getId());
        return sellerBranchZoneModel;
    }

    @Autowired
    public void setZoneFactory(final ObjectFactory<SellerBranchZoneModel> sellerBranchZoneModelFactory) {
        this.sellerBranchZoneModelFactory = sellerBranchZoneModelFactory;
    }

}
