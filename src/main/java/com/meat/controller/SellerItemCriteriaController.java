/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerItemCriteriaContext;
import com.meat.model.SellerItemCriteriaModel;
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
 * @author venkat
 *
 */

@RestController
@RequestMapping(value = "/SellerItemCriteria", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerItemCriteriaController {
    private IBusinessDelegate<SellerItemCriteriaModel, SellerItemCriteriaContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerItemCriteriaContext> sellerItemCriteriaContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemCriteriaModel> create(@RequestBody final SellerItemCriteriaModel sellerItemCriteriaModel) {
        businessDelegate.create(sellerItemCriteriaModel);
        return new ResponseEntity<SellerItemCriteriaModel>(sellerItemCriteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerItemCriteriaModel> edit(@PathVariable(value = "id") final String sellerItemCriteriaId,
            @RequestBody final SellerItemCriteriaModel sellerItemCriteriaModel) {
        SellerItemCriteriaContext sellerItemCriteriaContext = new SellerItemCriteriaContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerItemCriteriaId), sellerItemCriteriaModel);
        return new ResponseEntity<SellerItemCriteriaModel>(sellerItemCriteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItemCriteria() {
        SellerItemCriteriaContext sellerItemCriteriaContext = sellerItemCriteriaContextFactory.getObject();
        sellerItemCriteriaContext.setAll("all");
        Collection<SellerItemCriteriaModel> sellerItemCriteriaModel = businessDelegate.getCollection(sellerItemCriteriaContext);
        IModelWrapper<Collection<SellerItemCriteriaModel>> models = new CollectionModelWrapper<SellerItemCriteriaModel>(
                SellerItemCriteriaModel.class, sellerItemCriteriaModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemCriteriaModel> getSellerItemCriteria(@PathVariable(value = "id") final String sellerItemCriteriaId) {
        SellerItemCriteriaContext sellerItemCriteriaContext = sellerItemCriteriaContextFactory.getObject();
        SellerItemCriteriaModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerItemCriteriaId),
                sellerItemCriteriaContext);
        return new ResponseEntity<SellerItemCriteriaModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerItemCriteriaBusinessDelegate")
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
    public void setSellerItemCriteriaObjectFactory(final ObjectFactory<SellerItemCriteriaContext> sellerItemCriteriaContextFactory) {
        this.sellerItemCriteriaContextFactory = sellerItemCriteriaContextFactory;
    }
}
