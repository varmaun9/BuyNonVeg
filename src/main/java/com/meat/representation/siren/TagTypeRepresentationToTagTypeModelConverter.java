/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.TagTypeModel;
import com.meat.model.TagsModel;
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
@Component("tagTypeRepresentationToTagTypeModelConverter")
public class TagTypeRepresentationToTagTypeModelConverter extends PropertyCopyingConverter<TagTypeRepresentation, TagTypeModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TagTypeModel convert(final TagTypeRepresentation source) {

        TagTypeModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getTagRep())) {
            List<TagsModel> converted = (List<TagsModel>) conversionService.convert(source.getTagRep(),
                    TypeDescriptor.forObject(source.getTagRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsModel.class));
            target.getTagModel().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TagTypeModel> factory) {
        super.setFactory(factory);
    }
}
