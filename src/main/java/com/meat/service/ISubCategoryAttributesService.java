package com.meat.service;

import com.meat.domain.SubCategoryAttributes;

import java.util.List;

public interface ISubCategoryAttributesService {

    SubCategoryAttributes create(SubCategoryAttributes subCategoryAttributes);

    void deleteSubCategoryAttributes(String subCategoryAttributesId);

    List<SubCategoryAttributes> getAll();

    SubCategoryAttributes getSubCategoryAttributes(String subCategoryAttributesId);

    SubCategoryAttributes updateSubCategoryAttributes(SubCategoryAttributes subCategoryAttributes);

}
