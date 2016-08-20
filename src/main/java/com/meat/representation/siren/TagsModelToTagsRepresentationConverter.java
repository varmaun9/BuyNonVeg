package com.meat.representation.siren;

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

@Component("tagModelToTagRepresentationConverter")
public class TagsModelToTagsRepresentationConverter extends PropertyCopyingConverter<TagsModel, TagsRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TagsRepresentation convert(final TagsModel source) {

        TagsRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryTagModels())) {
            List<CategoryTagsRepresentation> converted = (List<CategoryTagsRepresentation>) conversionService.convert(
                    source.getCategoryTagModels(), TypeDescriptor.forObject(source.getCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsRepresentation.class));
            target.getCategoryTagRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getItemTagModels())) {
            List<ItemTagsRepresentation> converted = (List<ItemTagsRepresentation>) conversionService.convert(source.getItemTagModels(),
                    TypeDescriptor.forObject(source.getItemTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsRepresentation.class));
            target.getItemTagRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagModels())) {
            List<SubCategoryTagsRepresentation> converted = (List<SubCategoryTagsRepresentation>) conversionService.convert(
                    source.getSubCategoryTagModels(), TypeDescriptor.forObject(source.getSubCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTagsRepresentation.class));
            target.getSubCategoryTagRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<TagsRepresentation> factory) {
        super.setFactory(factory);
    }

}
