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
@Component("seoRepresentationToSeoModelConverter")
public class SeoRepresentationToSeoModelConverter extends PropertyCopyingConverter<SeoRepresentation, SeoModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SeoModel convert(final SeoRepresentation source) {

        SeoModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getSubCategoryRep())) {
            List<SubCategoryModel> converted = (List<SubCategoryModel>) conversionService.convert(source.getSubCategoryRep(),
                    TypeDescriptor.forObject(source.getSubCategoryRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryModel.class));
            target.getSubCategoryModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCriteriaRep())) {
            List<CriteriaModel> converted = (List<CriteriaModel>) conversionService.convert(source.getCriteriaRep(),
                    TypeDescriptor.forObject(source.getCriteriaRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CriteriaModel.class));
            target.getCriteriaModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getTagRep())) {
            List<TagsModel> converted = (List<TagsModel>) conversionService.convert(source.getTagRep(),
                    TypeDescriptor.forObject(source.getTagRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsModel.class));
            target.getTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAttributesRep())) {
            List<AttributesModel> converted = (List<AttributesModel>) conversionService.convert(source.getAttributesRep(),
                    TypeDescriptor.forObject(source.getAttributesRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AttributesModel.class));
            target.getAttributeModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategorieRep())) {
            List<CategoryModel> converted = (List<CategoryModel>) conversionService.convert(source.getCategorieRep(),
                    TypeDescriptor.forObject(source.getCategorieRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryModel.class));
            target.getCategorieModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemRep())) {
            List<ItemModel> converted = (List<ItemModel>) conversionService.convert(source.getItemRep(),
                    TypeDescriptor.forObject(source.getItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemModel.class));
            target.getItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerRep())) {
            List<SellerModel> converted = (List<SellerModel>) conversionService.convert(source.getSellerRep(),
                    TypeDescriptor.forObject(source.getSellerRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerModel.class));
            target.getSellerModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemRep())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItemRep(),
                    TypeDescriptor.forObject(source.getSellerItemRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            target.getSellerItemModels().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SeoModel> factory) {
        super.setFactory(factory);
    }

}
