/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AddressModel;
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
@Component("addressModelToAddressRepresentationConverter")
public class AddressModelToAddressRepresentationConverter extends PropertyCopyingConverter<AddressModel, AddressRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AddressRepresentation convert(final AddressModel source) {

        AddressRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getOrderDeliveryOptionsModels())) {
            List<OrderDeliveryOptionsRepresentation> converted = (List<OrderDeliveryOptionsRepresentation>) conversionService.convert(
                    source.getOrderDeliveryOptionsModels(), TypeDescriptor.forObject(source.getOrderDeliveryOptionsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OrderDeliveryOptionsRepresentation.class));
            target.getOrderDeliveryOptionsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getUserModels())) {
            List<UsersRepresentation> converted = (List<UsersRepresentation>) conversionService.convert(source.getUserModels(),
                    TypeDescriptor.forObject(source.getUserModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), UsersRepresentation.class));
            target.getUsersRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerBranchAddressModels())) {
            List<SellerBranchAddressRepresentation> converted = (List<SellerBranchAddressRepresentation>) conversionService.convert(
                    source.getSellerBranchAddressModels(), TypeDescriptor.forObject(source.getSellerBranchAddressModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerBranchRepresentation.class));
            target.getSellerBranchAddressRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AddressRepresentation> factory) {
        super.setFactory(factory);
    }
}
