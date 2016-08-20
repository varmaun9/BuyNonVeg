/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AddressModel;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.model.SellerBranchAddressModel;
import com.meat.model.UsersModel;
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
 * @author Administrator
 *
 */
@Component("addressRepresentationToAddressModelConverter")
public class AddressRepresentationToAddressModelConverter extends PropertyCopyingConverter<AddressRepresentation, AddressModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AddressModel convert(final AddressRepresentation source) {

        AddressModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getUsersRep())) {
            List<UsersModel> converted = (List<UsersModel>) conversionService.convert(source.getUsersRep(),
                    TypeDescriptor.forObject(source.getUsersRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersModel.class));
            target.getUserModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsRep())) {
            List<OrderDeliveryOptionsModel> converted = (List<OrderDeliveryOptionsModel>) conversionService.convert(
                    source.getOrderDeliveryOptionsRep(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsModel.class));
            target.getOrderDeliveryOptionsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressRep())) {
            List<SellerBranchAddressModel> converted = (List<SellerBranchAddressModel>) conversionService.convert(
                    source.getSellerBranchAddressRep(), TypeDescriptor.forObject(source.getSellerBranchAddressRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchAddressModel.class));
            target.getSellerBranchAddressModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AddressModel> factory) {
        super.setFactory(factory);
    }
}
