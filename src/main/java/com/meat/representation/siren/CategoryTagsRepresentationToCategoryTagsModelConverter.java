/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryTagsModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */
@Component("CategoryTagsRepresentationToCategoryTagsModelConverter")
public class CategoryTagsRepresentationToCategoryTagsModelConverter extends
PropertyCopyingConverter<CategoryTagsRepresentation, CategoryTagsModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CategoryTagsModel convert(final CategoryTagsRepresentation source) {

        CategoryTagsModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CategoryTagsModel> factory) {
        super.setFactory(factory);
    }

}
