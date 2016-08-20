/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.Seo;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("seoToSeoModelConverter")
public class SeoToSeoModelConverter implements Converter<Seo, SeoModel> {

    @Autowired
    private ObjectFactory<SeoModel> seoModelFactory;
    private static final Logger LOGGER = Logger.getLogger(SeoToSeoModelConverter.class);
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public SeoModel convert(final Seo source) {
        // TODO Auto-generated method stub
        SeoModel seoModel = seoModelFactory.getObject();

        BeanUtils.copyProperties(source, seoModel);

        if (CollectionUtils.isNotEmpty(source.getSubCategories())) {
            List<SubCategoryModel> converted = (List<SubCategoryModel>) conversionService.convert(source.getSubCategories(),
                    TypeDescriptor.forObject(source.getSubCategories()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryModel.class));
            seoModel.getSubCategoryModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getTagses())) {
            List<TagsModel> converted = (List<TagsModel>) conversionService.convert(source.getTagses(),
                    TypeDescriptor.forObject(source.getTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsModel.class));
            seoModel.getTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategories())) {
            List<CategoryModel> converted = (List<CategoryModel>) conversionService.convert(source.getCategories(),
                    TypeDescriptor.forObject(source.getCategories()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryModel.class));
            seoModel.getCategorieModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getAttributeses())) {
            List<AttributesModel> converted = (List<AttributesModel>) conversionService.convert(source.getAttributeses(),
                    TypeDescriptor.forObject(source.getAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), AttributesModel.class));
            seoModel.getAttributeModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItems())) {
            List<ItemModel> converted = (List<ItemModel>) conversionService.convert(source.getItems(),
                    TypeDescriptor.forObject(source.getItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemModel.class));
            seoModel.getItemModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellers())) {
            List<SellerModel> converted = (List<SellerModel>) conversionService.convert(source.getSellers(),
                    TypeDescriptor.forObject(source.getSellers()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerModel.class));
            seoModel.getSellerModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItems())) {
            List<SellerItemModel> converted = (List<SellerItemModel>) conversionService.convert(source.getSellerItems(),
                    TypeDescriptor.forObject(source.getSellerItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemModel.class));
            seoModel.getSellerItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCriterias())) {
            List<CriteriaModel> converted = (List<CriteriaModel>) conversionService.convert(source.getCriterias(),
                    TypeDescriptor.forObject(source.getCriterias()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CriteriaModel.class));
            seoModel.getCriteriaModels().addAll(converted);
        }

        return seoModel;

    }

    @Autowired
    public void setSeoFactory(final ObjectFactory<SeoModel> seoModelFactory) {
        this.seoModelFactory = seoModelFactory;
    }
}
