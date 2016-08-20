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
@Component("subOrderTaxesRepresentationToSubOrderTaxesModelConverter")
public class SubOrderTaxesRepresentationToSubOrderTaxesModelConverter
        extends PropertyCopyingConverter<SubOrderTaxesRepresentation, SubOrderTaxesModel> {

    @Override
    public SubOrderTaxesModel convert(final SubOrderTaxesRepresentation source) {

        SubOrderTaxesModel target = super.convert(source);

        return target;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<SubOrderTaxesModel> factory) {
        super.setFactory(factory);
    }
}
