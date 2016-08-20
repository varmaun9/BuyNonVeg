package com.meat.representation.siren;

import com.meat.model.SubCategoryModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("subCategoryModelToSubCategoryRepresentationConverter")
public class SubCategoryModelToSubCategoryRepresentationConverter extends
PropertyCopyingConverter<SubCategoryModel, SubCategoryRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryRepresentation convert(final SubCategoryModel source) {

        SubCategoryRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubCategoryImageModels())) {
            List<SubCategoryImagesRepresentation> converted = (List<SubCategoryImagesRepresentation>) conversionService.convert(
                    source.getSubCategoryImageModels(), TypeDescriptor.forObject(source.getSubCategoryImageModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryImagesRepresentation.class));
            target.getSubCategoryImagesRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagModels())) {
            List<SubCategoryTagsRepresentation> converted = (List<SubCategoryTagsRepresentation>) conversionService.convert(
                    source.getSubCategoryTagModels(), TypeDescriptor.forObject(source.getSubCategoryTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTagsRepresentation.class));
            target.getSubCategoryTagsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getItemModels())) {
            List<ItemRepresentation> converted = (List<ItemRepresentation>) conversionService.convert(source.getItemModels(),
                    TypeDescriptor.forObject(source.getItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemRepresentation.class));
            target.getItemRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributeModels())) {
            List<SubCategoryAttributesRepresentation> converted = (List<SubCategoryAttributesRepresentation>) conversionService.convert(
                    source.getSubCategoryAttributeModels(), TypeDescriptor.forObject(source.getSubCategoryAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesRepresentation.class));
            target.getSubCategoryAttributesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryRepresentation> factory) {
        super.setFactory(factory);
    }
}
