/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.CategoryCutTypeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("categoryCutTypeRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "categoryCutTypes", uri = "/categoryCutTypes")
@Representation(CategoryCutTypeModel.class)
public class CategoryCutTypeRepresentations extends CollectionResource<CategoryCutTypeRepresentation> {
}
