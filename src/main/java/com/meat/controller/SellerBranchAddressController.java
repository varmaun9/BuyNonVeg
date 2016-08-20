/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchAddressContext;
import com.meat.model.SellerBranchAddressModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi
 *
 */

@RestController
@RequestMapping(value = "/sellerBranchAddress", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchAddressController {
    private IBusinessDelegate<SellerBranchAddressModel, SellerBranchAddressContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchAddressContext> sellerBranchAddressContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchAddressModel> create(@RequestBody final SellerBranchAddressModel sellerBranchAddressModel) {
        businessDelegate.create(sellerBranchAddressModel);
        return new ResponseEntity<SellerBranchAddressModel>(sellerBranchAddressModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchAddressModel> edit(@PathVariable(value = "id") final String sellerBranchAddressId,
            @RequestBody final SellerBranchAddressModel sellerBranchAddressModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchAddressId), sellerBranchAddressModel);
        return new ResponseEntity<SellerBranchAddressModel>(sellerBranchAddressModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchAddress() {
        SellerBranchAddressContext sellerBranchAddressContext = sellerBranchAddressContextFactory.getObject();
        sellerBranchAddressContext.setAll("all");
        Collection<SellerBranchAddressModel> sellerBranchAddressModel = businessDelegate.getCollection(sellerBranchAddressContext);
        IModelWrapper<Collection<SellerBranchAddressModel>> models = new CollectionModelWrapper<SellerBranchAddressModel>(
                SellerBranchAddressModel.class, sellerBranchAddressModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchAddressBySellerBranch(
            @PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerBranchAddressContext sellerBranchAddressContext = sellerBranchAddressContextFactory.getObject();
        sellerBranchAddressContext.setSellerBranchId(sellerBranchId);
        Collection<SellerBranchAddressModel> sellerBranchAddressModel = businessDelegate.getCollection(sellerBranchAddressContext);
        IModelWrapper<Collection<SellerBranchAddressModel>> models = new CollectionModelWrapper<SellerBranchAddressModel>(
                SellerBranchAddressModel.class, sellerBranchAddressModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchAddressModel> getSellerBranchAddress(@PathVariable(value = "id") final String sellerBranchAddressId) {
        SellerBranchAddressContext sellerBranchAddressContext = sellerBranchAddressContextFactory.getObject();
        SellerBranchAddressModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchAddressId),
                sellerBranchAddressContext);
        return new ResponseEntity<SellerBranchAddressModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchAddressBusinessDelegate")
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

    @Autowired
    public void setSellerBranchAddressObjectFactory(final ObjectFactory<SellerBranchAddressContext> sellerBranchAddressContextFactory) {
        this.sellerBranchAddressContextFactory = sellerBranchAddressContextFactory;
    }

}
