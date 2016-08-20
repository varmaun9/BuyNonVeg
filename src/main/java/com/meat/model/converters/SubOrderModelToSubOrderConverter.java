/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.OrderItem;
import com.meat.domain.SubOrder;
import com.meat.domain.SubOrderStatusCode;
import com.meat.model.SubOrderModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderModelToSubOrderConverter")
public class SubOrderModelToSubOrderConverter implements Converter<SubOrderModel, SubOrder> {
    @Autowired
    private ObjectFactory<SubOrder> subOrderFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public SubOrder convert(final SubOrderModel source) {
        SubOrder subOrder = subOrderFactory.getObject();
        BeanUtils.copyProperties(source, subOrder);

        if (CollectionUtils.isNotEmpty(source.getSubOrderStatusCodeModels())) {
            List<SubOrderStatusCode> converted = (List<SubOrderStatusCode>) conversionService.convert(source.getSubOrderStatusCodeModels(),
                    TypeDescriptor.forObject(source.getSubOrderStatusCodeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderStatusCode.class));
            subOrder.getSubOrderStatusCodes().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItemModels())) {
            List<OrderItem> converted = (List<OrderItem>) conversionService.convert(source.getOrderItemModels(),
                    TypeDescriptor.forObject(source.getOrderItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItem.class));
            subOrder.getOrderItems().addAll(converted);
        }

        return subOrder;
    }

    @Autowired
    public void setSubOrderFactory(final ObjectFactory<SubOrder> subOrderFactory) {
        this.subOrderFactory = subOrderFactory;
    }

}
