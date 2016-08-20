/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SubOrderStatusCodeModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi1
 *
 */

@Component("subOrderStatusCodeRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "subOrderStatusCodes", uri = "/subOrderStatusCodes")
@Representation(SubOrderStatusCodeModel.class)
public class SubOrderStatusCodeRepresentations extends CollectionResource<SubOrderStatusCodeRepresentation> {

}
