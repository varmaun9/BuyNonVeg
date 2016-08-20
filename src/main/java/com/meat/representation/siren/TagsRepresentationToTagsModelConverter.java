/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryTagsModel;
import com.meat.model.ItemTagsModel;
import com.meat.model.SubCategoryTagsModel;
import com.meat.model.TagsModel;
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
@Component("tagRepresentationToTagModelConverter")
public class TagsRepresentationToTagsModelConverter extends PropertyCopyingConverter<TagsRepresentation, TagsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public TagsModel convert(final TagsRepresentation source) {

        TagsModel target = super.convert(source);
        if (CollectionUtils.isNotEmpty(source.getCategoryTagRep())) {
            List<CategoryTagsModel> converted = (List<CategoryTagsModel>) conversionService.convert(source.getCategoryTagRep(),
                    TypeDescriptor.forObject(source.getCategoryTagRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryTagsModel.class));
            target.getCategoryTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getItemTagRep())) {
            List<ItemTagsModel> converted = (List<ItemTagsModel>) conversionService.convert(source.getItemTagRep(),
                    TypeDescriptor.forObject(source.getItemTagRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), ItemTagsModel.class));
            target.getItemTagModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSubCategoryTagRep())) {
            List<SubCategoryTagsModel> converted = (List<SubCategoryTagsModel>) conversionService.convert(source.getSubCategoryTagRep(),
                    TypeDescriptor.forObject(source.getSubCategoryTagRep()),
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
    public void setFactory(final ObjectFactory<TagsModel> factory) {
        super.setFactory(factory);
    }

}
