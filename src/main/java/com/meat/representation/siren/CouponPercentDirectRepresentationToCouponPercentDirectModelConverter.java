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
@Component("couponPercentDirectRepresentationToCouponPercentDirectModelConverter")
public class CouponPercentDirectRepresentationToCouponPercentDirectModelConverter extends
PropertyCopyingConverter<CouponPercentDirectRepresentation, CouponPercentDirectModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponPercentDirectModel convert(final CouponPercentDirectRepresentation source) {

        CouponPercentDirectModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponPercentDirectModel> factory) {
        super.setFactory(factory);
    }
}
