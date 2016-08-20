package com.meat.service;

import com.meat.domain.SubCategoryTags;

import java.util.List;

public interface ISubCategoryTagsService {

    SubCategoryTags create(SubCategoryTags subCategoryTags);

    void deleteSubCategoryTags(String subCategoryTagsId);

    List<SubCategoryTags> getAll();

    SubCategoryTags getSubCategoryTags(String subCategoryTagsId);

    SubCategoryTags updateSubCategoryTags(SubCategoryTags subCategoryTags);

}
