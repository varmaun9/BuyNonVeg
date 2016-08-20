/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Category;
import com.meat.domain.CategoryCutType;
import com.meat.domain.CutType;
import com.meat.model.CategoryCutTypeModel;
import com.meat.service.ICategoryCutTypeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author varma
 *
 */
@Service
@Transactional
public class CategoryCutTypeBusinessDelegate
        implements IBusinessDelegate<CategoryCutTypeModel, CategoryCutTypeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICategoryCutTypeService categoryCutTypeService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryCutTypeModel create(final CategoryCutTypeModel model) {
        // TODO Auto-generated method stub
        CategoryCutType categoryCutType = new CategoryCutType();
        categoryCutType.setDescription(model.getDescription());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryCutType.setCategory(category);
        CutType cutType = new CutType();
        cutType.setId(model.getCutTypeId());
        categoryCutType.setCutType(cutType);
        categoryCutType.setStatus(model.getStatus());

        categoryCutTypeService.create(categoryCutType);

        model.setId(categoryCutType.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryCutTypeContext context) {
        // TODO Auto-generated method stub
        categoryCutTypeService.deleteCategoryCutType(keyBuilder.build().toString());
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryCutTypeModel edit(final IKeyBuilder<String> keyBuilder, final CategoryCutTypeModel model) {
        CategoryCutType categoryCutType = categoryCutTypeService.getCategoryCutType(keyBuilder.build().toString());
        if (model.getCutTypeId() != null) {
            CutType cutType = new CutType();
            cutType.setId(model.getCutTypeId());
            categoryCutType.setCutType(cutType);
        }
        if (model.getCategoryId() != null) {
            Category category = new Category();
            category.setId(model.getCategoryId());
            categoryCutType.setCategory(category);
        }
        categoryCutType.setStatus(model.getStatus());
        categoryCutType = categoryCutTypeService.updateCategoryCutType(categoryCutType);
        model.setId(categoryCutType.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryCutTypeModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryCutTypeContext context) {
        CategoryCutType categoryCutType = categoryCutTypeService.getCategoryCutType(keyBuilder.build().toString());
        CategoryCutTypeModel categoryCutTypeModel = conversionService.convert(categoryCutType, CategoryCutTypeModel.class);
        return categoryCutTypeModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryCutTypeModel> getCollection(final CategoryCutTypeContext context) {
        List<CategoryCutType> categoryCutTypes = new ArrayList<CategoryCutType>();

        if (context.getAll() != null) {
            categoryCutTypes = categoryCutTypeService.getAll();
        }
        List<CategoryCutTypeModel> categoryCutTypeModels = (List<CategoryCutTypeModel>) conversionService.convert(categoryCutTypes,
                TypeDescriptor.forObject(categoryCutTypes),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(CategoryCutTypeModel.class)));
        return categoryCutTypeModels;

    }

}
