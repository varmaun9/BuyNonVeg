/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CouponModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("couponModelToCouponRepresentationConverter")
public class CouponModelToCouponRepresentationConverter extends PropertyCopyingConverter<CouponModel, CouponRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponRepresentation convert(final CouponModel source) {

        CouponRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCouponPercentDirectsModels())) {
            List<CouponPercentDirectRepresentation> converted = (List<CouponPercentDirectRepresentation>) conversionService.convert(
                    source.getCouponPercentDirectsModels(), TypeDescriptor.forObject(source.getCouponPercentDirectsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponPercentDirectRepresentation.class));
            target.getCouponPercentDirectsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCouponBuyXGetYsModels())) {
            List<CouponBuyXGetYRepresentation> converted = (List<CouponBuyXGetYRepresentation>) conversionService.convert(
                    source.getCouponBuyXGetYsModels(), TypeDescriptor.forObject(source.getCouponBuyXGetYsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponBuyXGetYRepresentation.class));
            target.getCouponBuyXGetYsRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponRepresentation> factory) {
        super.setFactory(factory);
    }
}
