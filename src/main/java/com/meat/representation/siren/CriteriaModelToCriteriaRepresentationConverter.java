/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CriteriaModel;
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
 * @author Dilli
 *
 */
@Component("criteriaModelToCriteriaRepresentationConverter")
public class CriteriaModelToCriteriaRepresentationConverter extends PropertyCopyingConverter<CriteriaModel, CriteriaRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CriteriaRepresentation convert(final CriteriaModel source) {

        CriteriaRepresentation target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriasModels())) {
            List<CategoryCriteriaRepresentation> converted = (List<CategoryCriteriaRepresentation>) conversionService.convert(
                    source.getCategoryCriteriasModels(), TypeDescriptor.forObject(source.getCategoryCriteriasModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaRepresentation.class));
            target.getCategoryCriteriasRep().addAll(converted);
        }

        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriasModels())) {
            List<SellerItemCriteriaRepresentation> converted = (List<SellerItemCriteriaRepresentation>) conversionService.convert(
                    source.getSellerItemCriteriasModels(), TypeDescriptor.forObject(source.getSellerItemCriteriasModels()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaRepresentation.class));
            target.getSellerItemCriteriasRep().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CriteriaRepresentation> factory) {
        super.setFactory(factory);
    }
}
