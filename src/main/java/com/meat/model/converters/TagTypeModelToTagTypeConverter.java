/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.TagType;
import com.meat.domain.Tags;
import com.meat.model.TagTypeModel;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("tagTypeModelToTagTypeConverter")
public class TagTypeModelToTagTypeConverter implements Converter<TagTypeModel, TagType> {
    @Autowired
    private ObjectFactory<TagType> tagTypeFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public TagType convert(final TagTypeModel source) {
        TagType tagType = tagTypeFactory.getObject();
        BeanUtils.copyProperties(source, tagType);

        if (CollectionUtils.isNotEmpty(source.getTagModel())) {
            List<Tags> converted = (List<Tags>) conversionService.convert(source.getTagModel(),
                    TypeDescriptor.forObject(source.getTagModel()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Tags.class));
            tagType.getTagses().addAll(converted);
        }

        return tagType;
    }

    @Autowired
    public void setTagTypeFactory(final ObjectFactory<TagType> tagTypeFactory) {
        this.tagTypeFactory = tagTypeFactory;
    }

}
