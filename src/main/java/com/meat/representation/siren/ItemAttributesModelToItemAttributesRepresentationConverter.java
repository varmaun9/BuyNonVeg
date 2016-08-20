/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ItemAttributesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemAttributesModelToItemAttributesRepresentationConverter")
public class ItemAttributesModelToItemAttributesRepresentationConverter extends
        PropertyCopyingConverter<ItemAttributesModel, ItemAttributesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemAttributesRepresentation convert(final ItemAttributesModel source) {

        ItemAttributesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemAttributesRepresentation> factory) {
        super.setFactory(factory);
    }
}
