package com.meat.representation.siren;

import com.google.code.siren4j.annotations.Siren4JEntity;
import com.google.code.siren4j.resource.CollectionResource;
import com.meat.model.OrderDeliveryOptionsModel;
import com.meat.util.Representation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("orderDeliveryOptionsRepresentations")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Siren4JEntity(name = "orderDeliveryOptionses", uri = "/orderDeliveryOptionses")
@Representation(OrderDeliveryOptionsModel.class)
public class OrderDeliveryOptionsRepresentations extends CollectionResource<OrderDeliveryOptionsRepresentation> {

}
