package com.meat.representation.siren;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.TaxModel;
import com.meat.util.Representation;

	
	@Component("TaxRepresentations")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Siren4JEntity(name = "taxes", uri = "/taxes")
	@Representation(TaxModel.class)
	public class TaxRepresentations extends CollectionResource<TaxRepresentation> {


}
