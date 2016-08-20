/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.AddressContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.AddressModel;
import com.meat.security.CustomUserDetails;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi1
 *
 */
@RestController
@RequestMapping(value = "/address", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class AddressController {
    private IBusinessDelegate<AddressModel, AddressContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<AddressContext> addressContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<AddressModel> create(@RequestBody final AddressModel addressModel) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return new ResponseEntity<AddressModel>(addressModel, HttpStatus.UNAUTHORIZED);
        }
        else {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            businessDelegate.create(addressModel);
            return new ResponseEntity<AddressModel>(addressModel, HttpStatus.CREATED);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public void deleteAddress(@PathVariable(value = "id") final String addressId) {

        AddressContext addressContext = addressContextFactory.getObject();
        addressContext.setAddressId(addressId);
        businessDelegate.delete(keyBuilderFactory.getObject().withId(addressId), addressContext);

    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<AddressModel> edit(@PathVariable(value = "id") final String addressId,
            @RequestBody final AddressModel addressModel) {
        AddressContext addressContext = new AddressContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(addressId), addressModel);
        return new ResponseEntity<AddressModel>(addressModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<AddressModel> getAddress(@PathVariable(value = "id") final String addressId) {
        AddressContext addressContext = addressContextFactory.getObject();
        AddressModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(addressId), addressContext);
        return new ResponseEntity<AddressModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllAddresses() {
        AddressContext addressContext = addressContextFactory.getObject();
        addressContext.setAll("all");
        Collection<AddressModel> addressModel = businessDelegate.getCollection(addressContext);
        IModelWrapper<Collection<AddressModel>> models = new CollectionModelWrapper<AddressModel>(AddressModel.class, addressModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @Autowired
    public void setAddressObjectFactory(final ObjectFactory<AddressContext> addressContextFactory) {
        this.addressContextFactory = addressContextFactory;
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "addressBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
