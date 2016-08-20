/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.TagTypeModel;
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
@Component("tagTypeModelToTagTypeRepresentationConverter")
public class TagTypeModelToTagTypeRepresentationConverter extends PropertyCopyingConverter<TagTypeModel, TagTypeRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TagTypeRepresentation convert(final TagTypeModel source) {

        TagTypeRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getTagModel())) {
            List<TagsRepresentation> converted = (List<TagsRepresentation>) conversionService.convert(source.getTagModel(),
                    TypeDescriptor.forObject(source.getTagModel()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsRepresentation.class));
            target.getTagRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TagTypeRepresentation> factory) {
        super.setFactory(factory);
    }
}