/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubOrderModel;
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
 * @author arthvedi1
 *
 */

@Component("subOrderModelToSubOrderRepresentationConverter")
public class SubOrderModelToSubOrderRepresentationConverter extends PropertyCopyingConverter<SubOrderModel, SubOrderRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderRepresentation convert(final SubOrderModel source) {

        SubOrderRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubOrderStatusCodeModels())) {
            List<SubOrderStatusCodeRepresentation> converted = (List<SubOrderStatusCodeRepresentation>) conversionService.convert(
                    source.getSubOrderStatusCodeModels(), TypeDescriptor.forObject(source.getSubOrderStatusCodeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderStatusCodeRepresentation.class));
            target.getSubOrderStatusCodeRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getOrderItemModels())) {
            List<OrderItemRepresentation> converted = (List<OrderItemRepresentation>) conversionService.convert(
                    source.getOrderItemModels(), TypeDescriptor.forObject(source.getOrderItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemRepresentation.class));
            target.getOrderItemRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderRepresentation> factory) {
        super.setFactory(factory);
    }

}
