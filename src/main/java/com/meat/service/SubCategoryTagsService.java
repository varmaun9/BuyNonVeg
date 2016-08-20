package com.meat.service;

import com.meat.dao.SubCategoryTagsRepository;
import com.meat.domain.SubCategoryTags;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryTagsService implements ISubCategoryTagsService {
    @Autowired
    private SubCategoryTagsRepository subCategoryTagsRepository;

    @Override
    public SubCategoryTags create(final SubCategoryTags subCategoryTags) {
        // TODO Auto-generated method stub
        return subCategoryTagsRepository.save(subCategoryTags);
    }

    @Override
    public void deleteSubCategoryTags(final String subCategoryTagsId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SubCategoryTags> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubCategoryTags getSubCategoryTags(final String subCategoryTagsId) {
        // TODO Auto-generated method stub
        return subCategoryTagsRepository.findOne(subCategoryTagsId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ISubCategoryTagsService#updateSubCategoryTags(com.ruhungry.domain.SubCategoryTags)
     */
    @Override
    public SubCategoryTags updateSubCategoryTags(final SubCategoryTags subCategoryTags) {
        // TODO Auto-generated method stub
        return subCategoryTagsRepository.save(subCategoryTags);
    }

}
