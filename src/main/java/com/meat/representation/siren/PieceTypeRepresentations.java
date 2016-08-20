package com.meat.representation.siren;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.BaseResource;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.PieceTypeModel;
import com.meat.util.Representation;



@Component ("pieceTypeRepresentations ")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "pieceTypes", uri = "/pieceTypes/{id}")
@Representation(PieceTypeModel.class)

public class PieceTypeRepresentations extends CollectionResource<PieceTypeRepresentation> {

}
