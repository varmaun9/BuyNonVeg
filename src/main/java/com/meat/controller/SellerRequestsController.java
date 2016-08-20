/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerRequestsContext;
import com.meat.model.SellerRequestsModel;
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
@RequestMapping(value = "/sellerRequests", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerRequestsController {
    private IBusinessDelegate<SellerRequestsModel, SellerRequestsContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerRequestsContext> sellerRequestsContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerRequestsModel> create(@RequestBody final SellerRequestsModel sellerRequestsModel) {
        businessDelegate.create(sellerRequestsModel);
        return new ResponseEntity<SellerRequestsModel>(sellerRequestsModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerRequestsModel> edit(@PathVariable(value = "id") final String sellerRequestsId,
            @RequestBody final SellerRequestsModel sellerRequestsModel) {
        SellerRequestsContext sellerRequestsContext = new SellerRequestsContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerRequestsId), sellerRequestsModel);
        return new ResponseEntity<SellerRequestsModel>(sellerRequestsModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllAddresses() {
        SellerRequestsContext sellerRequestsContext = sellerRequestsContextFactory.getObject();
        sellerRequestsContext.setAll("all");
        Collection<SellerRequestsModel> sellerRequestsModel = businessDelegate.getCollection(sellerRequestsContext);
        IModelWrapper<Collection<SellerRequestsModel>> models = new CollectionModelWrapper<SellerRequestsModel>(SellerRequestsModel.class,
                sellerRequestsModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerRequestsModel> getSellerRequests(@PathVariable(value = "id") final String sellerRequestsId) {
        SellerRequestsContext sellerRequestsContext = sellerRequestsContextFactory.getObject();
        SellerRequestsModel model = businessDelegate
                .getByKey(keyBuilderFactory.getObject().withId(sellerRequestsId), sellerRequestsContext);
        return new ResponseEntity<SellerRequestsModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerRequestsBusinessDelegate")
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
    public void setSellerRequestsObjectFactory(final ObjectFactory<SellerRequestsContext> sellerRequestsContextFactory) {
        this.sellerRequestsContextFactory = sellerRequestsContextFactory;
    }

}
