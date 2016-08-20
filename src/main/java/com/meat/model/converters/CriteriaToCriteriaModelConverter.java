package com.meat.model.converters;

import com.meat.domain.Criteria;
import com.meat.model.CategoryCriteriaModel;
import com.meat.model.CriteriaModel;
import com.meat.model.SellerItemCriteriaModel;
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

@Component("criteriaToCriteriaModelConverter")
public class CriteriaToCriteriaModelConverter implements Converter<Criteria, CriteriaModel> {

    private static final Logger LOGGER = Logger.getLogger(CriteriaToCriteriaModelConverter.class);
    @Autowired
    private ObjectFactory<CriteriaModel> criteriaModelFactory;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    @Override
    public CriteriaModel convert(final Criteria source) {
        // TODO Auto-generated method stub
        CriteriaModel criteriaModel = criteriaModelFactory.getObject();
        if (source.getSeo() != null) {
            criteriaModel.setSeoId(source.getSeo().getId());
            criteriaModel.setSeoTitle(source.getSeo().getSeoTitle());
            criteriaModel.setSeoKeywords(source.getSeo().getSeoKeywords());
            criteriaModel.setSeoMetaDescription(source.getSeo().getSeoMetaDescription());
        }
        BeanUtils.copyProperties(source, criteriaModel);
        criteriaModel.setOrderOfPlace(source.getOrderOfPlace().toString());
        if (CollectionUtils.isNotEmpty(source.getCategoryCriterias())) {
            List<CategoryCriteriaModel> converted = (List<CategoryCriteriaModel>) conversionService.convert(source.getCategoryCriterias(),
                    TypeDescriptor.forObject(source.getCategoryCriterias()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaModel.class));
            criteriaModel.getCategoryCriteriasModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemCriterias())) {
            List<SellerItemCriteriaModel> converted = (List<SellerItemCriteriaModel>) conversionService.convert(
                    source.getSellerItemCriterias(), TypeDescriptor.forObject(source.getSellerItemCriterias()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaModel.class));
            criteriaModel.getSellerItemCriteriasModels().addAll(converted);
        }

        return criteriaModel;

    }

    @Autowired
    public void setCriteriaFactory(final ObjectFactory<CriteriaModel> criteriaModelFactory) {
        this.criteriaModelFactory = criteriaModelFactory;
    }

}
