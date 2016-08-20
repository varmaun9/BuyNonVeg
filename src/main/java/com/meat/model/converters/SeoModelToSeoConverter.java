package com.meat.model.converters;

import com.meat.domain.*;
import com.meat.model.SeoModel;
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

@Component("seoModelToSeoConverter")
public class SeoModelToSeoConverter implements Converter<SeoModel, Seo> {
    @Autowired
    private ObjectFactory<Seo> SeoFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Seo convert(final SeoModel source) {
        Seo seo = SeoFactory.getObject();
        BeanUtils.copyProperties(source, seo);

        if (CollectionUtils.isNotEmpty(source.getSubCategoryModels())) {
            List<SubCategory> converted = (List<SubCategory>) conversionService.convert(source.getSubCategoryModels(),
                    TypeDescriptor.forObject(source.getSubCategoryModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategory.class));
            seo.getSubCategories().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getTagModels())) {
            List<Tags> converted = (List<Tags>) conversionService.convert(source.getTagModels(),
                    TypeDescriptor.forObject(source.getTagModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Tags.class));
            seo.getTagses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCategorieModels())) {
            List<Category> converted = (List<Category>) conversionService.convert(source.getCategorieModels(),
                    TypeDescriptor.forObject(source.getCategorieModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Category.class));
            seo.getCategories().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getCriteriaModels())) {
            List<Criteria> converted = (List<Criteria>) conversionService.convert(source.getCriteriaModels(),
                    TypeDescriptor.forObject(source.getCriteriaModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Criteria.class));
            seo.getCriterias().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getAttributeModels())) {
            List<Attributes> converted = (List<Attributes>) conversionService.convert(source.getAttributeModels(),
                    TypeDescriptor.forObject(source.getAttributeModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Attributes.class));
            seo.getAttributeses().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getItemModels())) {
            List<Item> converted = (List<Item>) conversionService.convert(source.getItemModels(),
                    TypeDescriptor.forObject(source.getItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Item.class));
            seo.getItems().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerModels())) {
            List<Seller> converted = (List<Seller>) conversionService.convert(source.getSellerModels(),
                    TypeDescriptor.forObject(source.getSellerModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), Seller.class));
            seo.getSellers().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemModels())) {
            List<SellerItem> converted = (List<SellerItem>) conversionService.convert(source.getSellerItemModels(),
                    TypeDescriptor.forObject(source.getSellerItemModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItem.class));
            seo.getSellerItems().addAll(converted);
        }

        return seo;
    }

    @Autowired
    public void setSeoFactory(final ObjectFactory<Seo> seoFactory) {
        SeoFactory = seoFactory;
    }

}
