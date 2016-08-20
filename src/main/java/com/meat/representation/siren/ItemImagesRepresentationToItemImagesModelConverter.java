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
@Component("itemImagesRepresentationToItemImagesModelConverter")
public class ItemImagesRepresentationToItemImagesModelConverter extends PropertyCopyingConverter<ItemImagesRepresentation, ItemImagesModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemImagesModel convert(final ItemImagesRepresentation source) {

        ItemImagesModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemImagesModel> factory) {
        super.setFactory(factory);
    }
}
