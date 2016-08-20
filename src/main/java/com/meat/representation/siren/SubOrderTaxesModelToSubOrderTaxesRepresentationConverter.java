/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.SubOrderTaxesModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author varma
 *
 */
@Component("subOrderTaxesModelToSubOrderTaxesRepresentationConverter")
public class SubOrderTaxesModelToSubOrderTaxesRepresentationConverter
        extends PropertyCopyingConverter<SubOrderTaxesModel, SubOrderTaxesRepresentation> {

    @Override
    public SubOrderTaxesRepresentation convert(final SubOrderTaxesModel source) {

        SubOrderTaxesRepresentation target = super.convert(source);

        return target;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderTaxesRepresentation> factory) {
        super.setFactory(factory);
    }
}
