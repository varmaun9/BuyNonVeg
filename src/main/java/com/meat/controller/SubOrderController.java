/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubOrderContext;
import com.meat.model.SubOrderModel;
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
@RequestMapping(value = "/subOrder", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubOrderController {
    private IBusinessDelegate<SubOrderModel, SubOrderContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubOrderContext> subOrderContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubOrderModel> create(@RequestBody final SubOrderModel subOrderModel) {
        businessDelegate.create(subOrderModel);
        return new ResponseEntity<SubOrderModel>(subOrderModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubOrderModel> edit(@PathVariable(value = "id") final String subOrderId,
            @RequestBody final SubOrderModel subOrderModel) {
        SubOrderContext subOrderContext = new SubOrderContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subOrderId), subOrderModel);
        return new ResponseEntity<SubOrderModel>(subOrderModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubOrder() {
        SubOrderContext subOrderContext = subOrderContextFactory.getObject();
        subOrderContext.setAll("all");
        Collection<SubOrderModel> subOrderModel = businessDelegate.getCollection(subOrderContext);
        IModelWrapper<Collection<SubOrderModel>> models = new CollectionModelWrapper<SubOrderModel>(SubOrderModel.class, subOrderModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubOrderModel> getSubOrder(@PathVariable(value = "id") final String subOrderId) {
        SubOrderContext subOrderContext = subOrderContextFactory.getObject();
        SubOrderModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subOrderId), subOrderContext);
        return new ResponseEntity<SubOrderModel>(model, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}")
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSubOrderBySellerBranch(@PathVariable(value = "sellerBranchId") final String sellerBranchId) {

        SubOrderContext subOrderContext = subOrderContextFactory.getObject();
        subOrderContext.setSellerBranchId(sellerBranchId);
        Collection<SubOrderModel> subOrderModel = businessDelegate.getCollection(subOrderContext);
        IModelWrapper<Collection<SubOrderModel>> models = new CollectionModelWrapper<SubOrderModel>(SubOrderModel.class, subOrderModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerBranch/{sellerBranchId}/date/{date}/status/{status}")
    @ResponseBody
    public ResponseEntity<IModelWrapper> getSubOrderBySellerBranchWithDate(
            @PathVariable(value = "sellerBranchId") final String sellerBranchId, @PathVariable(value = "date") final String date,
            @PathVariable(value = "status") final String status) {

        SubOrderContext subOrderContext = subOrderContextFactory.getObject();
        subOrderContext.setSellerBranchId(sellerBranchId);
        subOrderContext.setDate(date);
        subOrderContext.setStatus(status);
        subOrderContext.setSubOrderBranchDateStatus("SUBORDERBRANCHDATE");
        Collection<SubOrderModel> subOrderModel = businessDelegate.getCollection(subOrderContext);
        IModelWrapper<Collection<SubOrderModel>> models = new CollectionModelWrapper<SubOrderModel>(SubOrderModel.class, subOrderModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subOrderBusinessDelegate")
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
    public void setSubOrderObjectFactory(final ObjectFactory<SubOrderContext> subOrderContextFactory) {
        this.subOrderContextFactory = subOrderContextFactory;
    }

}
