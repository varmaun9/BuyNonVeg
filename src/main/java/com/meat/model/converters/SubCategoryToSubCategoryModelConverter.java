/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.SubCategory;
import com.meat.model.*;
import com.meat.util.CollectionTypeDescriptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@Component("subCategoryToSubCategoryModelConverter")
public class SubCategoryToSubCategoryModelConverter implements Converter<SubCategory, SubCategoryModel> {

    private static final Logger LOGGER = Logger.getLogger(SubCategoryToSubCategoryModelConverter.class);
    @Autowired
    private ObjectFactory<SubCategoryModel> subCategoryModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */

    @Override
    public SubCategoryModel convert(final SubCategory source) {
        // TODO Auto-generated method stub
        SubCategoryModel subCategoryModel = subCategoryModelFactory.getObject();

        BeanUtils.copyProperties(source, subCategoryModel);
        // subCategoryModel.setSellingTag(source.getSellingTag().toString());
        if (source.getSeo() != null) {
            subCategoryModel.setSeoId(source.getSeo().getId());
            subCategoryModel.setSeoTitle(source.getSeo().getSeoTitle());
            subCategoryModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            subCategoryModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        /*if (source.getCategory() != null) {
            subCategoryModel.setCategoryId(source.getCategory().toString());
        }*/
        subCategoryModel.setSubCategoryCount(Long.toString(source.getSubCategoryCount()));
        if (source.getCategory() != null) {
            subCategoryModel.setCategoryId(source.getCategory().getId());
            subCategoryModel.setCategoryName(source.getCategory().getCategoryName());
        }
        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                subCategoryModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getSubCategoryImageses())) {
            List<SubCategoryImagesModel> converted = (List<SubCategoryImagesModel>) conversionService.convert(
                    source.getSubCategoryImageses(), TypeDescriptor.forObject(source.getSubCategoryImageses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryImagesModel.class));
            subCategoryModel.getSubCategoryImageModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItems())) {
            List<ItemModel> converted = (List<ItemModel>) conversionService.convert(source.getItems(),
                    TypeDescriptor.forObject(source.getItems()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemModel.class));
            subCategoryModel.getItemModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagses())) {
            List<SubCategoryTagsModel> converted = (List<SubCategoryTagsModel>) conversionService.convert(source.getSubCategoryTagses(),
                    TypeDescriptor.forObject(source.getSubCategoryTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTagsModel.class));
            subCategoryModel.getSubCategoryTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryAttributeses())) {
            List<SubCategoryAttributesModel> converted = (List<SubCategoryAttributesModel>) conversionService.convert(
                    source.getSubCategoryAttributeses(), TypeDescriptor.forObject(source.getSubCategoryAttributeses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryAttributesModel.class));
            subCategoryModel.getSubCategoryAttributeModels().addAll(converted);
        }
        return subCategoryModel;

    }

    @Autowired
    public void setSubCategoryFactory(final ObjectFactory<SubCategoryModel> subCategoryModelFactory) {
        this.subCategoryModelFactory = subCategoryModelFactory;
    }
}
