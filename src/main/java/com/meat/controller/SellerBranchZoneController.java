/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchZoneContext;
import com.meat.model.SellerBranchZoneModel;
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
 * @author Dilli
 *
 */
@RestController
@RequestMapping(value = "/sellerBranchZone", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchZoneController {
    private IBusinessDelegate<SellerBranchZoneModel, SellerBranchZoneContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchZoneContext> sellerBranchZoneContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchZoneModel> create(@RequestBody final SellerBranchZoneModel sellerBranchZoneModel) {
        businessDelegate.create(sellerBranchZoneModel);
        return new ResponseEntity<SellerBranchZoneModel>(sellerBranchZoneModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchZoneModel> edit(@PathVariable(value = "id") final String sellerBranchZoneId,
            @RequestBody final SellerBranchZoneModel sellerBranchZoneModel) {
        SellerBranchZoneContext sellerBranchZoneContext = new SellerBranchZoneContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchZoneId), sellerBranchZoneModel);
        return new ResponseEntity<SellerBranchZoneModel>(sellerBranchZoneModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllZones() {
        SellerBranchZoneContext sellerBranchZoneContext = sellerBranchZoneContextFactory.getObject();
        sellerBranchZoneContext.setAll("all");
        Collection<SellerBranchZoneModel> sellerBranchZoneModel = businessDelegate.getCollection(sellerBranchZoneContext);
        IModelWrapper<Collection<SellerBranchZoneModel>> models = new CollectionModelWrapper<SellerBranchZoneModel>(
                SellerBranchZoneModel.class, sellerBranchZoneModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchZoneModel> getSellerBranchZone(@PathVariable(value = "id") final String sellerBranchZoneId) {
        SellerBranchZoneContext sellerBranchZoneContext = sellerBranchZoneContextFactory.getObject();
        SellerBranchZoneModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchZoneId),
                sellerBranchZoneContext);
        return new ResponseEntity<SellerBranchZoneModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchZoneBusinessDelegate")
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
    public void setSellerBranchZoneObjectFactory(final ObjectFactory<SellerBranchZoneContext> sellerBranchZoneContextFactory) {
        this.sellerBranchZoneContextFactory = sellerBranchZoneContextFactory;
    }

}
