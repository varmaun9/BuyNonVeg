package com.meat.representation.siren;

import com.meat.model.SeoModel;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.PropertyCopyingConverter;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

@Component("seoModelToSeoRepresentationConverter")
public class SeoModelToSeoRepresentationConverter extends PropertyCopyingConverter<SeoModel, SeoRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public SeoRepresentation convert(final SeoModel source) {

        SeoRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getSubCategoryModels())) {
            List<SubCategoryRepresentation> converted = (List<SubCategoryRepresentation>) conversionService.convert(
                    source.getSubCategoryModels(), TypeDescriptor.forObject(source.getSubCategoryModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryRepresentation.class));
            target.getSubCategoryRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getTagModels())) {
            List<TagsRepresentation> converted = (List<TagsRepresentation>) conversionService.convert(source.getTagModels(),
                    TypeDescriptor.forObject(source.getTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsRepresentation.class));
            target.getTagRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItemRepresentation> converted = (List<SellerItemRepresentation>) conversionService.convert(
                    source.getSellerItemModels(), TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemRepresentation.class));
            target.getSellerItemRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerModels())) {
            List<SellerRepresentation> converted = (List<SellerRepresentation>) conversionService.convert(source.getSellerModels(),
                    TypeDescriptor.forObject(source.getSellerModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerRepresentation.class));
            target.getSellerRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategorieModels())) {
            List<CategoryRepresentation> converted = (List<CategoryRepresentation>) conversionService.convert(source.getCategorieModels(),
                    TypeDescriptor.forObject(source.getCategorieModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryRepresentation.class));
            target.getCategorieRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCriteriaModels())) {
            List<CriteriaRepresentation> converted = (List<CriteriaRepresentation>) conversionService.convert(source.getCriteriaModels(),
                    TypeDescriptor.forObject(source.getCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CriteriaRepresentation.class));
            target.getCriteriaRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemModels())) {
            List<ItemRepresentation> converted = (List<ItemRepresentation>) conversionService.convert(source.getItemModels(),
                    TypeDescriptor.forObject(source.getItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemRepresentation.class));
            target.getItemRep().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getAttributeModels())) {
            List<AttributesRepresentation> converted = (List<AttributesRepresentation>) conversionService.convert(
                    source.getAttributeModels(), TypeDescriptor.forObject(source.getAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AttributesRepresentation.class));
            target.getAttributesRep().addAll(converted);
        }

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SeoRepresentation> factory) {
        super.setFactory(factory);
    }

}
