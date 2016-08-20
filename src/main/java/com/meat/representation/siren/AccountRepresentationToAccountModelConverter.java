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
@Component("accountRepresentationToAccountModelConverter")
public class AccountRepresentationToAccountModelConverter extends PropertyCopyingConverter<AccountRepresentation, AccountModel> {

    @Autowired
    private ConversionService conversionService;

    @Override
    public AccountModel convert(final AccountRepresentation source) {

        AccountModel target = super.convert(source);

        return target;
    }

    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @Override
    @Autowired
    public void setFactory(final ObjectFactory<AccountModel> factory) {
        super.setFactory(factory);
    }

}
