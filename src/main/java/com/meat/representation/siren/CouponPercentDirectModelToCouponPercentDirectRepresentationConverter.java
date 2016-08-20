/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CouponPercentDirectModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("couponPercentDirectModelToCouponPercentDirectRepresentationConverter")
public class CouponPercentDirectModelToCouponPercentDirectRepresentationConverter extends
PropertyCopyingConverter<CouponPercentDirectModel, CouponPercentDirectRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponPercentDirectRepresentation convert(final CouponPercentDirectModel source) {

        CouponPercentDirectRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponPercentDirectRepresentation> factory) {
        super.setFactory(factory);
    }
}