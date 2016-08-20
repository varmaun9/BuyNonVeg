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
@Component("itemAttributesRepresentationToItemAttributesModelConverter")
public class ItemAttributesRepresentationToItemAttributesModelConverter extends
        PropertyCopyingConverter<ItemAttributesRepresentation, ItemAttributesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemAttributesModel convert(final ItemAttributesRepresentation source) {

        ItemAttributesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemAttributesModel> factory) {
        super.setFactory(factory);
    }
}