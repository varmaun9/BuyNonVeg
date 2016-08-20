/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.CategoryCriteriaModel;
import com.meat.model.CriteriaModel;
import com.meat.model.SellerItemCriteriaModel;
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
@Component("criteriaRepresentationToCriteriaModelConverter")
public class CriteriaRepresentationToCriteriaModelConverter extends PropertyCopyingConverter<CriteriaRepresentation, CriteriaModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public CriteriaModel convert(final CriteriaRepresentation source) {

        CriteriaModel target = super.convert(source);

        if (CollectionUtils.isNotEmpty(source.getCategoryCriteriasRep())) {
            List<CategoryCriteriaModel> converted = (List<CategoryCriteriaModel>) conversionService.convert(
                    source.getCategoryCriteriasRep(), TypeDescriptor.forObject(source.getCategoryCriteriasRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), CategoryCriteriaModel.class));
            target.getCategoryCriteriasModels().addAll(converted);
        }
        if (CollectionUtils.isNotEmpty(source.getSellerItemCriteriasRep())) {
            List<SellerItemCriteriaModel> converted = (List<SellerItemCriteriaModel>) conversionService.convert(
                    source.getSellerItemCriteriasRep(), TypeDescriptor.forObject(source.getSellerItemCriteriasRep()),
                    CollectionTypeDescriptor.forType(TypeDescriptor.valueOf(List.class), SellerItemCriteriaModel.class));
            target.getSellerItemCriteriasModels().addAll(converted);
        }
        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<CriteriaModel> factory) {
        super.setFactory(factory);
    }
}
