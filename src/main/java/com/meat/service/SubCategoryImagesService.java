package com.meat.service;

import com.meat.dao.SubCategoryImagesRepository;
import com.meat.domain.SubCategoryImages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryImagesService implements ISubCategoryImagesService {
    @Autowired
    private SubCategoryImagesRepository subCategoryImagesRepository;

    @Override
    public SubCategoryImages create(final SubCategoryImages subCategoryImages) {
        // TODO Auto-generated method stub
        return subCategoryImagesRepository.save(subCategoryImages);
    }

    @Override
    public void deleteSubCategoryImages(final String subCategoryImagesId) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<SubCategoryImages> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SubCategoryImages getSubCategoryImages(final String subCategoryImagesId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.nonveg.service.ISubCategoryImagesService#updateSubCategoryImages(com.ruhungry.domain.SubCategoryImages)
     */
    @Override
    public SubCategoryImages updateSubCategoryImages(final SubCategoryImages subCategoryImages) {
        // TODO Auto-generated method stub
        return subCategoryImagesRepository.save(subCategoryImages);
    }

}
