/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.ItemImagesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("itemImagesModelToItemImagesRepresentationConverter")
public class ItemImagesModelToItemImagesRepresentationConverter extends PropertyCopyingConverter<ItemImagesModel, ItemImagesRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemImagesRepresentation convert(final ItemImagesModel source) {

        ItemImagesRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemImagesRepresentation> factory) {
        super.setFactory(factory);
    }
}
