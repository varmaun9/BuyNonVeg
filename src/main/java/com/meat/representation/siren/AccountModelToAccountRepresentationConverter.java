/**
 *
 */
package com.meat.representation.siren;

import com.meat.model.AccountModel;
import com.meat.util.PropertyCopyingConverter;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component("accountModelToAccountRepresentationConverter")
public class AccountModelToAccountRepresentationConverter extends PropertyCopyingConverter<AccountModel, AccountRepresentation> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AccountRepresentation convert(final AccountModel source) {

        AccountRepresentation target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AccountRepresentation> factory) {
        super.setFactory(factory);
    }

}
