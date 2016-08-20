/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryModel;
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
 * @author arthvedi1
 *
 */
@Component("categoryModelToCategoryRepresentationConverter")
public class CategoryModelToCategoryRepresentationConverter extends PropertyCopyingConverter<CategoryModel, CategoryRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryRepresentation convert(final CategoryModel source) {

        CategoryRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesModels())) {
            List<CategoryAttributesRepresentation> converted = (List<CategoryAttributesRepresentation>) conversionService.convert(
                    source.getCategoryAttributesModels(), TypeDescriptor.forObject(source.getCategoryAttributesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesRepresentation.class));
            target.getCategoryAttributesRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryTagsModels())) {
            List<CategoryTagsRepresentation> converted = (List<CategoryTagsRepresentation>) conversionService.convert(
                    source.getCategoryTagsModels(), TypeDescriptor.forObject(source.getCategoryTagsModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsRepresentation.class));
            target.getCategoryTagsRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategoryImagesModels())) {
            List<CategoryImagesRepresentation> converted = (List<CategoryImagesRepresentation>) conversionService.convert(
                    source.getCategoryImagesModels(), TypeDescriptor.forObject(source.getCategoryImagesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryImagesRepresentation.class));
            target.getCategoryImagesRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriaModels())) {
            List<CategoryCriteriaRepresentation> converted = (List<CategoryCriteriaRepresentation>) conversionService.convert(
                    source.getCategoryCriteriaModels(), TypeDescriptor.forObject(source.getCategoryCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaRepresentation.class));
            target.getCategoryCriteriaRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoriesModels())) {
            List<SubCategoryRepresentation> converted = (List<SubCategoryRepresentation>) conversionService.convert(
                    source.getSubCategoriesModels(), TypeDescriptor.forObject(source.getSubCategoriesModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryRepresentation.class));
            target.getSubCategoryRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCutTypeModels())) {
            List<CategoryCutTypeRepresentation> converted = (List<CategoryCutTypeRepresentation>) conversionService.convert(
                    source.getCategoryCutTypeModels(), TypeDescriptor.forObject(source.getCategoryCutTypeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCutTypeRepresentation.class));
            target.getCategoryCutTypeRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryRepresentation> factory) {
        super.setFactory(factory);
    }
}
