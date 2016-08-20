/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerInvoiceContext;
import com.meat.model.SellerInvoiceModel;
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
@RequestMapping(value = "/sellerInvoice", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerInvoiceController {
    private IBusinessDelegate<SellerInvoiceModel, SellerInvoiceContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerInvoiceContext> sellerInvoiceContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerInvoiceModel> create(@RequestBody final SellerInvoiceModel sellerInvoiceModel) {
        businessDelegate.create(sellerInvoiceModel);
        return new ResponseEntity<SellerInvoiceModel>(sellerInvoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerInvoiceModel> edit(@PathVariable(value = "id") final String sellerInvoiceId,
            @RequestBody final SellerInvoiceModel sellerInvoiceModel) {
        SellerInvoiceContext sellerInvoiceContext = new SellerInvoiceContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerInvoiceId), sellerInvoiceModel);
        return new ResponseEntity<SellerInvoiceModel>(sellerInvoiceModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/generateInvoice", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> generateInvoice() {
        SellerInvoiceContext sellerInvoiceContext = sellerInvoiceContextFactory.getObject();
        //sellerInvoiceContext.setAll("all");
        sellerInvoiceContext.setGenerate("Start");
        // sellerInvoiceContext.setSellerInvoiceByAll("all");
        Collection<SellerInvoiceModel> sellerInvoiceModels = businessDelegate.getCollection(sellerInvoiceContext);
        IModelWrapper<Collection<SellerInvoiceModel>> models = new CollectionModelWrapper<SellerInvoiceModel>(SellerInvoiceModel.class,
                sellerInvoiceModels);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerInvoicees() {
        SellerInvoiceContext sellerInvoiceContext = sellerInvoiceContextFactory.getObject();
        sellerInvoiceContext.setAll("all");
        Collection<SellerInvoiceModel> sellerInvoiceModel = businessDelegate.getCollection(sellerInvoiceContext);
        IModelWrapper<Collection<SellerInvoiceModel>> models = new CollectionModelWrapper<SellerInvoiceModel>(SellerInvoiceModel.class,
                sellerInvoiceModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerInvoiceModel> getSellerInvoice(@PathVariable(value = "id") final String sellerInvoiceId) {
        SellerInvoiceContext sellerInvoiceContext = sellerInvoiceContextFactory.getObject();
        SellerInvoiceModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerInvoiceId), sellerInvoiceContext);
        return new ResponseEntity<SellerInvoiceModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerInvoiceBusinessDelegate")
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
    public void setSellerInvoiceObjectFactory(final ObjectFactory<SellerInvoiceContext> sellerInvoiceContextFactory) {
        this.sellerInvoiceContextFactory = sellerInvoiceContextFactory;
    }

}
