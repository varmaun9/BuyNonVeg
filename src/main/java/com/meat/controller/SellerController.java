/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerContext;
import com.meat.model.SellerModel;
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
@RequestMapping(value = "/seller", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerController {
    private IBusinessDelegate<SellerModel, SellerContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerContext> sellerContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerModel> create(@RequestBody final SellerModel sellerModel) {
        businessDelegate.create(sellerModel);
        return new ResponseEntity<SellerModel>(sellerModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerModel> edit(@PathVariable(value = "id") final String sellerId, @RequestBody final SellerModel sellerModel) {
        SellerContext sellerContext = new SellerContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerId), sellerModel);
        return new ResponseEntity<SellerModel>(sellerModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSeller() {
        SellerContext sellerContext = sellerContextFactory.getObject();
        sellerContext.setAll("all");
        Collection<SellerModel> sellerModel = businessDelegate.getCollection(sellerContext);
        IModelWrapper<Collection<SellerModel>> models = new CollectionModelWrapper<SellerModel>(SellerModel.class, sellerModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sellerOnly", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerOnly() {
        SellerContext sellerContext = sellerContextFactory.getObject();
        sellerContext.setSellerOnly("sellerOnly");
        Collection<SellerModel> sellerModel = businessDelegate.getCollection(sellerContext);
        IModelWrapper<Collection<SellerModel>> models = new CollectionModelWrapper<SellerModel>(SellerModel.class, sellerModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerModel> getSeller(@PathVariable(value = "id") final String sellerId) {
        SellerContext sellerContext = sellerContextFactory.getObject();
        SellerModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerId), sellerContext);
        return new ResponseEntity<SellerModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerBusinessDelegate")
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
    public void setSellerObjectFactory(final ObjectFactory<SellerContext> sellerContextFactory) {
        this.sellerContextFactory = sellerContextFactory;
    }

}
