/**
 *
 */
package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.SellerBranchTimingsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("sellerBranchTimingsRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "sellerBranchTimingses", uri = "/sellerBranchTimingses")
@Representation(SellerBranchTimingsModel.class)
public class SellerBranchTimingsRepresentations extends CollectionResource<SellerBranchTimingsRepresentation> {

}
