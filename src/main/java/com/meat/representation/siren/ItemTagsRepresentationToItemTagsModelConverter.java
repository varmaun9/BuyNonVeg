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
 * @author varma
 *
 */
@Component("itemTagsRepresentationToItemTagsModelConverter")
public class ItemTagsRepresentationToItemTagsModelConverter extends PropertyCopyingConverter<ItemTagsRepresentation, ItemTagsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public ItemTagsModel convert(final ItemTagsRepresentation source) {

        ItemTagsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<ItemTagsModel> factory) {
        super.setFactory(factory);
    }
}
