/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SellerTimingsConfigModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerTimingsConfigRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerTimingsConfigs", uri = "/sellerTimingsConfigs")
@Representation(SellerTimingsConfigModel.class)
public class SellerTimingsConfigRepresentations extends CollectionResource<SellerTimingsConfigRepresentation> {

}
