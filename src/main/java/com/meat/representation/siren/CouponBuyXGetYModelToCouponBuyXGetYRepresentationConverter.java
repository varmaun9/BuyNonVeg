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
@Component("couponBuyXGetYModelToCouponBuyXGetYRepresentationConverter")
public class CouponBuyXGetYModelToCouponBuyXGetYRepresentationConverter extends
        PropertyCopyingConverter<CouponBuyXGetYModel, CouponBuyXGetYRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponBuyXGetYRepresentation convert(final CouponBuyXGetYModel source) {

        CouponBuyXGetYRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponBuyXGetYRepresentation> factory) {
        super.setFactory(factory);
    }
}
