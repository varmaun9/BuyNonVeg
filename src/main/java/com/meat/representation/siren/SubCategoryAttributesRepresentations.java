/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SubCategoryAttributesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("subCategoryAttributesRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subCategoryAttributes", uri = "/SubCategoryAttributes")
@Representation(SubCategoryAttributesModel.class)
public class SubCategoryAttributesRepresentations extends CollectionResource<SubCategoryAttributesRepresentation> {

}
