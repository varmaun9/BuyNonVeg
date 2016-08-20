/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ItemTagsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemTagsModelToItemTagsRepresentationConverter")
public class ItemTagsModelToItemTagsRepresentationConverter extends PropertyCopyingConverter<ItemTagsModel, ItemTagsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemTagsRepresentation convert(final ItemTagsModel source) {

        ItemTagsRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemTagsRepresentation> factory) {
        super.setFactory(factory);
    }
}
