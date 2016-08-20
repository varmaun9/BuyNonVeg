/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CouponBuyXGetYModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("couponBuyXGetYRepresentationToCouponBuyXGetYModelConverter")
public class CouponBuyXGetYRepresentationToCouponBuyXGetYModelConverter extends
        PropertyCopyingConverter<CouponBuyXGetYRepresentation, CouponBuyXGetYModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponBuyXGetYModel convert(final CouponBuyXGetYRepresentation source) {

        CouponBuyXGetYModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponBuyXGetYModel> factory) {
        super.setFactory(factory);
    }
}
