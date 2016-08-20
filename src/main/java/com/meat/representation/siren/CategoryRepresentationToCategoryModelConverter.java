/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.*;
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
@Component("categoryRepresentationToCategoryModelConverter")
public class CategoryRepresentationToCategoryModelConverter extends PropertyCopyingConverter<CategoryRepresentation, CategoryModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryModel convert(final CategoryRepresentation source) {

        CategoryModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getCategoryAttributesRep())) {
            List<CategoryAttributesModel> converted = (List<CategoryAttributesModel>) conversionService.convert(
                    source.getCategoryAttributesRep(), TypeDescriptor.forObject(source.getCategoryAttributesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryAttributesModel.class));
            target.getCategoryAttributesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryTagsRep())) {
            List<CategoryTagsModel> converted = (List<CategoryTagsModel>) conversionService.convert(source.getCategoryTagsRep(),
                    TypeDescriptor.forObject(source.getCategoryTagsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsModel.class));
            target.getCategoryTagsModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriaRep())) {
            List<CategoryCriteriaModel> converted = (List<CategoryCriteriaModel>) conversionService.convert(source.getCategoryCriteriaRep(),
                    TypeDescriptor.forObject(source.getCategoryCriteriaRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaModel.class));
            target.getCategoryCriteriaModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryRep())) {
            List<SubCategoryModel> converted = (List<SubCategoryModel>) conversionService.convert(source.getSubCategoryRep(),
                    TypeDescriptor.forObject(source.getSubCategoryRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryModel.class));
            target.getSubCategoriesModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferConfigsRep())) {
            List<OfferConfigModel> converted = (List<OfferConfigModel>) conversionService.convert(source.getOfferConfigsRep(),
                    TypeDescriptor.forObject(source.getOfferConfigsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferConfigModel.class));
            target.getOfferConfigModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getOfferExcludeConfigsRep())) {
            List<OfferExcludeConfigModel> converted = (List<OfferExcludeConfigModel>) conversionService.convert(
                    source.getOfferExcludeConfigsRep(), TypeDescriptor.forObject(source.getOfferExcludeConfigsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), OfferExcludeConfigModel.class));
            target.getOfferExcludeConfigModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryCutTypeRep())) {
            List<CategoryCutTypeModel> converted = (List<CategoryCutTypeModel>) conversionService.convert(source.getCategoryCutTypeRep(),
                    TypeDescriptor.forObject(source.getCategoryCutTypeRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCutTypeModel.class));
            target.getCategoryCutTypeModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryModel> factory) {
        super.setFactory(factory);
    }

}
