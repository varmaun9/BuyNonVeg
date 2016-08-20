package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SubCategoryImagesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("subCategoryImagesRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategoryImageses", uri = "/subCategoryImageses")
@Representation(SubCategoryImagesModel.class)
public class SubCategoryImagesRepresentations extends CollectionResource<SubCategoryImagesRepresentation> {

}
