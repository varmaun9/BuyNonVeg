/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.UserSellerItemRatingModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Dilli
 *
 */
@Component("userSellerItemRatingRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "userSellerItemRatings", uri = "/userSellerItemRatings")
@Representation(UserSellerItemRatingModel.class)
public class UserSellerItemRatingRepresentations extends CollectionResource<UserSellerItemRatingRepresentation> {

}
