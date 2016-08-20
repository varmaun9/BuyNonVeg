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
@Component("subCategoryRepresentationToSubCategoryModelConverter")
public class SubCategoryRepresentationToSubCategoryModelConverter extends
PropertyCopyingConverter<SubCategoryRepresentation, SubCategoryModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SubCategoryModel convert(final SubCategoryRepresentation source) {

        SubCategoryModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getItemRep())) {
            List<ItemModel> converted = (List<ItemModel>) conversionService.convert(source.getItemRep(),
                    TypeDescriptor.forObject(source.getItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemModel.class));
            target.getItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributesRep())) {
            List<SubCategoryAttributesModel> converted = (List<SubCategoryAttributesModel>) conversionService.convert(
                    source.getSubCategoryAttributesRep(), TypeDescriptor.forObject(source.getSubCategoryAttributesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesModel.class));
            target.getSubCategoryAttributeModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryImagesRep())) {
            List<SubCategoryImagesModel> converted = (List<SubCategoryImagesModel>) conversionService.convert(
                    source.getSubCategoryImagesRep(), TypeDescriptor.forObject(source.getSubCategoryImagesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryImagesModel.class));
            target.getSubCategoryImageModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagsRep())) {
            List<SubCategoryTagsModel> converted = (List<SubCategoryTagsModel>) conversionService.convert(source.getSubCategoryTagsRep(),
                    TypeDescriptor.forObject(source.getSubCategoryTagsRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTagsModel.class));
            target.getSubCategoryTagModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubCategoryModel> factory) {
        super.setFactory(factory);
    }

}
