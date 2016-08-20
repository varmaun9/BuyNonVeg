/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ShipmentItemsModel;
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
@Component("shipmentRepresentationToShipmentModelConverter")
public class ShipmentRepresentationToShipmentModelConverter extends PropertyCopyingConverter<ShipmentRepresentation, ShipmentModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ShipmentModel convert(final ShipmentRepresentation source) {

        ShipmentModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getShipmentItemRep())) {
            List<ShipmentItemsModel> converted = (List<ShipmentItemsModel>) conversionService.convert(source.getShipmentItemRep(),
                    TypeDescriptor.forObject(source.getShipmentItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ShipmentItemsModel.class));
            target.getShipmentItemModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ShipmentModel> factory) {
        super.setFactory(factory);
    }
}
