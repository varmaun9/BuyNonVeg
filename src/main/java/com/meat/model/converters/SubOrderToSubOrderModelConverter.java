/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubOrder;
import com.meat.model.OrderItemModel;
import com.meat.model.SubOrderModel;
import com.meat.model.SubOrderStatusCodeModel;
import com.meat.model.SubOrderTaxesModel;
import com.meat.util.CollectionTypeDescriptor;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
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

@Component("subOrderToSubOrderModelConverter")
public class SubOrderToSubOrderModelConverter implements Converter<SubOrder, SubOrderModel> {

    private static final Logger LOGGER = Logger.getLogger(SubOrderToSubOrderModelConverter.class);
    @Autowired
    private ObjectFactory<SubOrderModel> subOrderModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public SubOrderModel convert(final SubOrder source) {
        // TODO Auto-generated method stub
        SubOrderModel subOrderModel = subOrderModelFactory.getObject();

        BeanUtils.copyProperties(source, subOrderModel);
        subOrderModel.setSellerBranchId(source.getSellerBranch().getId());
        if (source.getTimings() != null) {
            subOrderModel.setTimingsId(source.getTimings().getId());
        }
        if (source.getDeliveryUser() != null) {
            subOrderModel.setDeliveryContactId(source.getDeliveryUser().getId());
            subOrderModel.setDeliveryContactName(source.getDeliveryUser().getUserName());
        }
        subOrderModel.setOrdersId(source.getOrders().getId());
        subOrderModel.setUsersId(source.getUsers().getId());
        //subOrderModel.setSellerInvoiceId(source.getSellerInvoice().getId());
        subOrderModel.setSubOrderCount(Long.toString(source.getSubOrderCount()));
        subOrderModel.setSubOrderTotalPrice(source.getSubOrderTotalPrice().toString());
        subOrderModel.setSubOrderTotalCharges(source.getSubOrderTotalCharges().toString());
        //source.setTaxValue(Integer.parseInt(subOrderModel.getSubOrderCount()));
        //source.setTaxValue(Integer.toString());
        //categoryAttributesModel.setAttributeName(source.getAttributes().getAttributeName());
        subOrderModel.setSubOrderDeliveryTime(source.getSubOrderDeliveryTime());
        subOrderModel.setSubOrderStatus(source.getSubOrderStatus());
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
        String formattedDateString = null;
        if (source.getSubOrderDeliveryDate() != null) {
            formattedDateString = formatter.format(source.getSubOrderDeliveryDate());
        }
        subOrderModel.setSubOrderDeliveryDate(formattedDateString);
        subOrderModel.setDeliveryType(source.getDeliveryType());
        subOrderModel.setCreatedDate(ds1);
        if (source.getTaxValue() != null) {
            subOrderModel.setTaxValue(source.getTaxValue().toString());
        }
        if (source.getDiscount() != null) {
            subOrderModel.setDiscount(source.getDiscount().toString());
        }
        if (source.getSubOrderTotalCharges() != null) {
            subOrderModel.setSubOrderTotalCharges(source.getSubOrderTotalCharges().toString());
        }
        if (source.getRefundPayableAmount() != null) {
            subOrderModel.setRefundPayableAmount(source.getRefundPayableAmount().toString());
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderStatusCodes())) {
            List<SubOrderStatusCodeModel> converted = (List<SubOrderStatusCodeModel>) conversionService.convert(
                    source.getSubOrderStatusCodes(), TypeDescriptor.forObject(source.getSubOrderStatusCodes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderStatusCodeModel.class));
            subOrderModel.getSubOrderStatusCodeModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderItems())) {
            List<OrderItemModel> converted = (List<OrderItemModel>) conversionService.convert(source.getOrderItems(),
                    TypeDescriptor.forObject(source.getOrderItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderItemModel.class));
            subOrderModel.getOrderItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubOrderTaxes())) {
            List<SubOrderTaxesModel> converted = (List<SubOrderTaxesModel>) conversionService.convert(source.getSubOrderTaxes(),
                    TypeDescriptor.forObject(source.getSubOrderTaxes()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubOrderTaxesModel.class));
            subOrderModel.getSubOrderTaxModels().addAll(converted);
        }

        return subOrderModel;

    }

    @Autowired
    public void setSubOrderFactory(final ObjectFactory<SubOrderModel> subOrderModelFactory) {
        this.subOrderModelFactory = subOrderModelFactory;
    }

}
