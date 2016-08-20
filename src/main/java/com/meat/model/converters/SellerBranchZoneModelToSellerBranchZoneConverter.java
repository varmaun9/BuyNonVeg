/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SellerBranchZone;
import com.meat.model.SellerBranchZoneModel;

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

@Component("sellerBranchZoneModelToSellerBranchZoneConverter")
public class SellerBranchZoneModelToSellerBranchZoneConverter implements Converter<SellerBranchZoneModel, SellerBranchZone> {
    @Autowired
    private ObjectFactory<SellerBranchZone> sellerBranchZoneFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SellerBranchZone convert(final SellerBranchZoneModel source) {

        SellerBranchZone sellerBranchZone = sellerBranchZoneFactory.getObject();
        BeanUtils.copyProperties(source, sellerBranchZone);
        return sellerBranchZone;
    }

    @Autowired
    public void setSellerBranchZoneFactory(final ObjectFactory<SellerBranchZone> sellerBranchZoneFactory) {
        this.sellerBranchZoneFactory = sellerBranchZoneFactory;
    }

}
