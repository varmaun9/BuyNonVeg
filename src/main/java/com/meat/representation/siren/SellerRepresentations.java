/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SellerModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("sellerRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellers", uri = "/sellers")
@Representation(SellerModel.class)
public class SellerRepresentations extends CollectionResource<SellerRepresentation> {

}
