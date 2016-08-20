/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.OrderItemModel;
import com.meat.model.SubOrderModel;
import com.meat.model.SubOrderStatusCodeModel;
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

@Component("subOrderRepresentationToSubOrderModelConverter")
public class SubOrderRepresentationToSubOrderModelConverter extends PropertyCopyingConverter<SubOrderRepresentation, SubOrderModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrderModel convert(final SubOrderRepresentation source) {

        SubOrderModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubOrderStatusCodeRep())) {
            List<SubOrderStatusCodeModel> converted = (List<SubOrderStatusCodeModel>) conversionService.convert(
                    source.getSubOrderStatusCodeRep(), TypeDescriptor.forObject(source.getSubOrderStatusCodeRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderStatusCodeModel.class));
            target.getSubOrderStatusCodeModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemRep())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItemRep(),
                    TypeDescriptor.forObject(source.getOrderItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            target.getOrderItemModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderModel> factory) {
        super.setFactory(factory);
    }

}
