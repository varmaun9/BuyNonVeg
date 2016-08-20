/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CouponBuyXGetYModel;
import com.meat.model.CouponModel;
import com.meat.model.CouponPercentDirectModel;
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
@Component("couponRepresentationToCopuonModelConverter")
public class CouponRepresentationToCopuonModelConverter extends PropertyCopyingConverter<CouponRepresentation, CouponModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CouponModel convert(final CouponRepresentation source) {

        CouponModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCouponPercentDirectsRep())) {
            List<CouponPercentDirectModel> converted = (List<CouponPercentDirectModel>) conversionService.convert(
                    source.getCouponPercentDirectsRep(), TypeDescriptor.forObject(source.getCouponPercentDirectsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponPercentDirectModel.class));
            target.getCouponPercentDirectsModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCouponBuyXGetYsRep())) {
            List<CouponBuyXGetYModel> converted = (List<CouponBuyXGetYModel>) conversionService.convert(source.getCouponBuyXGetYsRep(),
                    TypeDescriptor.forObject(source.getCouponBuyXGetYsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CouponBuyXGetYModel.class));
            target.getCouponBuyXGetYsModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CouponModel> factory) {
        super.setFactory(factory);
    }

}
