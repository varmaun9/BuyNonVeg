/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerBranchTimingsContext;
import com.meat.model.SellerBranchTimingsModel;
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
@RequestMapping(value = "/sellerBranchTimings", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerBranchTimingsController {
    private IBusinessDelegate<SellerBranchTimingsModel, SellerBranchTimingsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerBranchTimingsContext> sellerBranchTimingsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchTimingsModel> create(@RequestBody final SellerBranchTimingsModel sellerBranchTimingsModel) {
        businessDelegate.create(sellerBranchTimingsModel);
        return new ResponseEntity<SellerBranchTimingsModel>(sellerBranchTimingsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerBranchTimingsModel> edit(@PathVariable(value = "id") final String sellerBranchTimingsId,
            @RequestBody final SellerBranchTimingsModel sellerBranchTimingsModel) {
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerBranchTimingsId), sellerBranchTimingsModel);
        return new ResponseEntity<SellerBranchTimingsModel>(sellerBranchTimingsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchTimingsBySellerBranch(
            @PathVariable(value = "sellerBranchId") final String sellerBranchId) {
        SellerBranchTimingsContext sellerBranchTimingsContext = sellerBranchTimingsContextFactory.getObject();
        sellerBranchTimingsContext.setAll("all");
        sellerBranchTimingsContext.setSellerBranchId(sellerBranchId);
        Collection<SellerBranchTimingsModel> sellerBranchTimingsModel = businessDelegate.getCollection(sellerBranchTimingsContext);
        IModelWrapper<Collection<SellerBranchTimingsModel>> models = new CollectionModelWrapper<SellerBranchTimingsModel>(
                SellerBranchTimingsModel.class, sellerBranchTimingsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerBranchTimingses() {
        SellerBranchTimingsContext sellerBranchTimingsContext = sellerBranchTimingsContextFactory.getObject();
        sellerBranchTimingsContext.setAll("all");
        Collection<SellerBranchTimingsModel> sellerBranchTimingsModel = businessDelegate.getCollection(sellerBranchTimingsContext);
        IModelWrapper<Collection<SellerBranchTimingsModel>> models = new CollectionModelWrapper<SellerBranchTimingsModel>(
                SellerBranchTimingsModel.class, sellerBranchTimingsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerBranchTimingsModel> getSellerBranchTimings(@PathVariable(value = "id") final String sellerBranchTimingsId) {
        SellerBranchTimingsContext sellerBranchTimingsContext = sellerBranchTimingsContextFactory.getObject();
        SellerBranchTimingsModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerBranchTimingsId),
                sellerBranchTimingsContext);
        return new ResponseEntity<SellerBranchTimingsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBranchTimingsBusinessDelegate")
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
    public void setSellerBranchTimingsObjectFactory(final ObjectFactory<SellerBranchTimingsContext> sellerBranchTimingsContextFactory) {
        this.sellerBranchTimingsContextFactory = sellerBranchTimingsContextFactory;
    }

}
