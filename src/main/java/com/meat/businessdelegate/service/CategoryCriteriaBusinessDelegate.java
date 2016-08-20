/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.Category;
import com.meat.domain.CategoryCriteria;
import com.meat.domain.Criteria;
import com.meat.model.CategoryCriteriaModel;
import com.meat.service.ICategoryCriteriaService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author Dilli
 *
 */
@Service
public class CategoryCriteriaBusinessDelegate implements
IBusinessDelegate<CategoryCriteriaModel, CategoryCriteriaContext, IKeyBuilder<String>, String> {

    @Autowired
    private ICategoryCriteriaService categoryCriteriaService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryCriteriaModel create(final CategoryCriteriaModel model) {
        CategoryCriteria categoryCriteria = new CategoryCriteria();
        categoryCriteria.setId(model.getId());
        Criteria criteria = new Criteria();
        criteria.setId(model.getCriteriaId());
        categoryCriteria.setCriteria(criteria);
        categoryCriteria.setStatus(model.getStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryCriteria.setCategory(category);
        categoryCriteria = categoryCriteriaService.create(categoryCriteria);
        model.setId(categoryCriteria.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final CategoryCriteriaContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public CategoryCriteriaModel edit(final IKeyBuilder<String> keyBuilder, final CategoryCriteriaModel model) {
        CategoryCriteria categoryCriteria = categoryCriteriaService.getCategoryCriteria(keyBuilder.build().toString());
        categoryCriteria.setId(model.getId());
        Criteria criteria = new Criteria();
        criteria.setId(model.getCriteriaId());
        categoryCriteria.setCriteria(criteria);
        categoryCriteria.setStatus(model.getStatus());
        Category category = new Category();
        category.setId(model.getCategoryId());
        categoryCriteria.setCategory(category);
        categoryCriteria = categoryCriteriaService.updateCategoryCriteria(categoryCriteria);
        model.setId(categoryCriteria.getId());
        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public CategoryCriteriaModel getByKey(final IKeyBuilder<String> keyBuilder, final CategoryCriteriaContext context) {
        CategoryCriteria categoryCriteria = categoryCriteriaService.getCategoryCriteria(keyBuilder.build().toString());
        CategoryCriteriaModel categoryCriteriaModel = conversionService.convert(categoryCriteria, CategoryCriteriaModel.class);

        return categoryCriteriaModel;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<CategoryCriteriaModel> getCollection(final CategoryCriteriaContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
