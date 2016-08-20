/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ShipmentModel;
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
@Component("shipmentModelToShipmentRepresentationConverter")
public class ShipmentModelToShipmentRepresentationConverter extends PropertyCopyingConverter<ShipmentModel, ShipmentRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ShipmentRepresentation convert(final ShipmentModel source) {

        ShipmentRepresentation target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getShipmentItemModels())) {
            List<ShipmentItemsRepresentation> converted = (List<ShipmentItemsRepresentation>) conversionService.convert(
                    source.getShipmentItemModels(), TypeDescriptor.forObject(source.getShipmentItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItemsRepresentation.class));
            target.getShipmentItemRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ShipmentRepresentation> factory) {
        super.setFactory(factory);
    }
}
