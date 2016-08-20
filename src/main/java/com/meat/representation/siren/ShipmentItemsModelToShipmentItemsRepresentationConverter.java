/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ShipmentItemsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("shipmentItemsModelToShipmentItemsRepresentationConverter")
public class ShipmentItemsModelToShipmentItemsRepresentationConverter extends
        PropertyCopyingConverter<ShipmentItemsModel, ShipmentItemsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ShipmentItemsRepresentation convert(final ShipmentItemsModel source) {

        ShipmentItemsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ShipmentItemsRepresentation> factory) {
        super.setFactory(factory);
    }
}
