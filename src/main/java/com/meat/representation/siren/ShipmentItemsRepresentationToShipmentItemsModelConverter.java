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
@Component("shipmentItemsRepresentationToShipmentItemsModelConverter")
public class ShipmentItemsRepresentationToShipmentItemsModelConverter extends
        PropertyCopyingConverter<ShipmentItemsRepresentation, ShipmentItemsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ShipmentItemsModel convert(final ShipmentItemsRepresentation source) {

        ShipmentItemsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ShipmentItemsModel> factory) {
        super.setFactory(factory);
    }
}
