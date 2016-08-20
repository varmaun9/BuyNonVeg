/**
 *
 */
package com.meat.model.converters;

import com.meat.domain.TagType;
import com.meat.model.TagTypeModel;
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

/**
 * @author arthvedi
 *
 */

@Component("tagTypeToTagTypeModelCoverter")
public class TagTypeToTagTypeModelCoverter implements Converter<TagType, TagTypeModel> {

    private static final Logger LOGGER = Logger.getLogger(TagTypeToTagTypeModelCoverter.class);
    @Autowired
    private ObjectFactory<TagTypeModel> tagTypeModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public TagTypeModel convert(final TagType source) {
        // TODO Auto-generated method stub
        TagTypeModel tagTypeModel = tagTypeModelFactory.getObject();
        BeanUtils.copyProperties(source, tagTypeModel);

        String ds1 = null;
        if (source.getCreatedDate() != null) {
            ds1 = source.getCreatedDate().toString();
        }
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
        if (ds1 != null) {
            try {
                String ds2 = sdf2.format(sdf1.parse(ds1));
                tagTypeModel.setCreatedDate(ds2);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (CollectionUtils.isNotEmpty(source.getTagses())) {
            List<TagsModel> converted = (List<TagsModel>) conversionService.convert(source.getTagses(),
                    TypeDescriptor.forObject(source.getTagses()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), TagsModel.class));
            tagTypeModel.getTagModel().addAll(converted);
        }

        return tagTypeModel;

    }

    @Autowired
    public void setTagTypeFactory(final ObjectFactory<TagTypeModel> tagTypeModelFactory) {
        this.tagTypeModelFactory = tagTypeModelFactory;
    }
}
