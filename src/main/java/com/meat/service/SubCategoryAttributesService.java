package com.meat.service;

import com.meat.dao.SubCategoryAttributesRepository;
import com.meat.domain.SubCategoryAttributes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryAttributesService implements ISubCategoryAttributesService {
    @Autowired
    private SubCategoryAttributesRepository subCategoryAttributesRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryAttributesService#create(com.meat.domain.SubCategoryAttributes)
     */
    @Override
    public SubCategoryAttributes create(final SubCategoryAttributes subCategoryAttributes) {
        // TODO Auto-generated method stub
        return subCategoryAttributesRepository.save(subCategoryAttributes);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryAttributesService#deleteSubCategoryAttributes(java.lang.String)
     */
    @Override
    public void deleteSubCategoryAttributes(final String subCategoryAttributesId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryAttributesService#getAll()
     */
    @Override
    public List<SubCategoryAttributes> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryAttributesService#getSubCategoryAttributes(java.lang.String)
     */
    @Override
    public SubCategoryAttributes getSubCategoryAttributes(final String subCategoryAttributesId) {
        // TODO Auto-generated method stub
        return subCategoryAttributesRepository.findOne(subCategoryAttributesId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubCategoryAttributesService#updateSubCategoryAttributes(com.meat.domain.SubCategoryAttributes)
     */
    @Override
    public SubCategoryAttributes updateSubCategoryAttributes(final SubCategoryAttributes subCategoryAttributes) {
        // TODO Auto-generated method stub
        return subCategoryAttributesRepository.save(subCategoryAttributes);
    }

}
