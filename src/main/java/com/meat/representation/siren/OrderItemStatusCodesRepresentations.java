package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.OrderItemStatusCodesModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderItemStatusCodesRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orderItemStatusCodeses", uri = "/orderItemStatusCodeses")
@Representation(OrderItemStatusCodesModel.class)
public class OrderItemStatusCodesRepresentations extends CollectionResource<OrderItemStatusCodesRepresentation> {

}
