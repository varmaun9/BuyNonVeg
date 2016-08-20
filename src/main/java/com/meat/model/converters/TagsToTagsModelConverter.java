package com.meat.model.converters;

import com.meat.domain.Tags;
import com.meat.model.CategoryTagsModel;
import com.meat.model.ItemTagsModel;
import com.meat.model.SubCategoryTagsModel;
import com.meat.model.TagsModel;
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

@Component("tagsToTagsModelConverter")
public class TagsToTagsModelConverter implements Converter<Tags, TagsModel> {

    private static final Logger LOGGER = Logger.getLogger(TagsToTagsModelConverter.class);
    @Autowired
    private ObjectFactory<TagsModel> tagsModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public TagsModel convert(final Tags source) {
        // TODO Auto-generated method stub
        TagsModel tagsModel = tagsModelFactory.getObject();
        BeanUtils.copyProperties(source, tagsModel);
        if (source.getSeo() != null) {
            tagsModel.setSeoId(source.getSeo().getId());
            tagsModel.setSeoTitle(source.getSeo().getSeoTitle());
            tagsModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            tagsModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
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
                tagsModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        tagsModel.setTagTypeId(source.getTagType().getId());
        tagsModel.setTagTypeName(source.getTagType().getTagTypeName());
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagses())) {
            List<SubCategoryTagsModel> converted = (List<SubCategoryTagsModel>) conversionService.convert(source.getSubCategoryTagses(),
                    TypeDescriptor.forObject(source.getSubCategoryTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SubCategoryTagsModel.class));
            tagsModel.getSubCategoryTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getCategoryTagses())) {
            List<CategoryTagsModel> converted = (List<CategoryTagsModel>) conversionService.convert(source.getCategoryTagses(),
                    TypeDescriptor.forObject(source.getCategoryTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsModel.class));
            tagsModel.getCategoryTagModels().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getItemTagses())) {
            List<ItemTagsModel> converted = (List<ItemTagsModel>) conversionService.convert(source.getItemTagses(),
                    TypeDescriptor.forObject(source.getItemTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsModel.class));
            tagsModel.getItemTagModels().addAll(converted);
        }

        return tagsModel;

    }

    @Autowired
    public void setTagFactory(final ObjectFactory<TagsModel> tagModelFactory) {
        tagsModelFactory = tagsModelFactory;
    }
}
