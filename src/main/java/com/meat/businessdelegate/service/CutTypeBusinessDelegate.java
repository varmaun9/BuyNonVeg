/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.CutType;
import com.meat.model.CutTypeModel;
import com.meat.service.ICutTypeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

/**
 * @author varma
 *
 */
@Service
public class CutTypeBusinessDelegate implements IBusinessDelegate<CutTypeModel, CutTypeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICutTypeService cutTypeService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CutTypeModel create(final CutTypeModel model) {
        CutType cutType = new CutType();
        cutType.setCutTypeName(model.getCutTypeName());
        cutType.setCreatedDate(new Date());
        cutType.setDescription(model.getDescription());
        cutType.setStatus(model.getStatus());
        cutType = cutTypeService.create(cutType);

        return model;
    }

    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CutTypeContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public CutTypeModel edit(final IKeyBuilder<String> keyBuilder, final CutTypeModel model) {
        CutType cutType = cutTypeService.getCutType(keyBuilder.build().toString());
        cutType.setId(model.getId());
        if (model.getCutTypeName() != null) {
            cutType.setCutTypeName(model.getCutTypeName());
        }
        cutType.setDescription(model.getDescription());
        cutType.setStatus(model.getStatus());
        cutType = cutTypeService.updateCutType(cutType);
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CutTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final CutTypeContext context) {
        CutType cutType = cutTypeService.getCutType(keyBuilder.build().toString());
        CutTypeModel cutTypeModel = conversionService.convert(cutType, CutTypeModel.class);
        return cutTypeModel;
    }

    @Override
    public Collection<CutTypeModel> getCollection(final CutTypeContext context) {
        List<CutType> cutType = new ArrayList<CutType>();

        if (context.getAll() != null) {
            cutType = cutTypeService.getAll();
        }
        if (context.getCutTypeOnly() != null) {
            cutType = cutTypeService.getCutTypeOnly();
        }
        if (context.getCategoryId() != null) {
            cutType = cutTypeService.getCutTypeByCategory(context.getCategoryId());
        }
        if (context.getItemId() != null) {
            cutType = cutTypeService.getCutTypeByItem(context.getItemId());
        }
        if (context.getSellerItemId() != null) {
            cutType = cutTypeService.getCutTypeBySellerItem(context.getSellerItemId());
        }
        List<CutTypeModel> cutTypeModels = (List<CutTypeModel>) conversionService.convert(cutType, TypeDescriptor.forObject(cutType),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CutTypeModel.class)));
        return cutTypeModels;

    }

}
