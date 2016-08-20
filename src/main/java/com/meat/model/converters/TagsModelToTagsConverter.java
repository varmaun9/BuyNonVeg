package com.meat.model.converters;

import com.meat.domain.CategoryTags;
import com.meat.domain.ItemTags;
import com.meat.domain.SubCategoryTags;
import com.meat.domain.Tags;
import com.meat.model.TagsModel;
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

@Component("tagsModelToTagsConverter")
public class TagsModelToTagsConverter implements Converter<TagsModel, Tags> {
    @Autowired
    private ObjectFactory<Tags> tagsFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Tags convert(final TagsModel source) {
        Tags tags = tagsFactory.getObject();
        BeanUtils.copyProperties(source, tags);

        if (CollectionUtils.isNotEmpty(source.getItemTagModels())) {
            List<ItemTags> converted = (List<ItemTags>) conversionService.convert(source.getItemTagModels(),
                    TypeDescriptor.forObject(source.getItemTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTags.class));
            tags.getItemTagses().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagModels())) {
            List<SubCategoryTags> converted = (List<SubCategoryTags>) conversionService.convert(source.getSubCategoryTagModels(),
                    TypeDescriptor.forObject(source.getSubCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTags.class));
            tags.getSubCategoryTagses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryTagModels())) {
            List<CategoryTags> converted = (List<CategoryTags>) conversionService.convert(source.getCategoryTagModels(),
                    TypeDescriptor.forObject(source.getCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTags.class));
            tags.getCategoryTagses().addAll(converted);
        }

        return tags;
    }

    @Autowired
    public void setTagFactory(final ObjectFactory<Tags> tagFactory) {
        tagsFactory = tagFactory;
    }

}
