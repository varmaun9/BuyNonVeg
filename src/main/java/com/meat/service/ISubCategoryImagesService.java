package com.meat.service;

import com.meat.domain.SubCategoryImages;

import java.util.List;

public interface ISubCategoryImagesService {

    SubCategoryImages create(SubCategoryImages subCategoryImages);

    void deleteSubCategoryImages(String subCategoryImagesId);

    List<SubCategoryImages> getAll();

    SubCategoryImages getSubCategoryImages(String subCategoryImagesId);

    SubCategoryImages updateSubCategoryImages(SubCategoryImages subCategoryImages);

}
