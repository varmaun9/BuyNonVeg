package com.meat.model.converters;

import com.meat.domain.CategoryCriteria;
import com.meat.domain.Criteria;
import com.meat.domain.SellerItemCriteria;
import com.meat.model.CriteriaModel;
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

@Component("criteriaModelToCriteriaConverter")
public class CriteriaModelToCriteriaConverter implements Converter<CriteriaModel, Criteria> {
    @Autowired
    private ObjectFactory<Criteria> criteriaFactory;
    @Autowired
    private ConversionService conversionService;

    @Override
    public Criteria convert(final CriteriaModel source) {
        Criteria criteria = criteriaFactory.getObject();
        BeanUtils.copyProperties(source, criteria);
        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriasModels())) {
            List<CategoryCriteria> converted = (List<CategoryCriteria>) conversionService.convert(source.getCategoryCriteriasModels(),
                    TypeDescriptor.forObject(source.getCategoryCriteriasModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteria.class));
            criteria.getCategoryCriterias().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriasModels())) {
            List<SellerItemCriteria> converted = (List<SellerItemCriteria>) conversionService.convert(
                    source.getSellerItemCriteriasModels(), TypeDescriptor.forObject(source.getSellerItemCriteriasModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteria.class));
            criteria.getSellerItemCriterias().addAll(converted);
        }

        return criteria;
    }

    @Autowired
    public void setCriteriaFactory(final ObjectFactory<Criteria> criteriaFactory) {
        this.criteriaFactory = criteriaFactory;
    }

}
