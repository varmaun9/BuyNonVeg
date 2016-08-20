/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerItemTaxContext;
import com.meat.model.SellerItemTaxModel;
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
@RequestMapping(value = "/sellerItemTax", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerItemTaxController {
    private IBusinessDelegate<SellerItemTaxModel, SellerItemTaxContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerItemTaxContext> sellerItemTaxContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemTaxModel> create(@RequestBody final SellerItemTaxModel sellerItemTaxModel) {
        businessDelegate.create(sellerItemTaxModel);
        return new ResponseEntity<SellerItemTaxModel>(sellerItemTaxModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerItemTaxModel> edit(@PathVariable(value = "id") final String sellerItemTaxId,
            @RequestBody final SellerItemTaxModel sellerItemTaxModel) {
        SellerItemTaxContext sellerItemTaxContext = new SellerItemTaxContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerItemTaxId), sellerItemTaxModel);
        return new ResponseEntity<SellerItemTaxModel>(sellerItemTaxModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItemTax() {
        SellerItemTaxContext sellerItemTaxContext = sellerItemTaxContextFactory.getObject();
        sellerItemTaxContext.setAll("all");
        Collection<SellerItemTaxModel> sellerItemTaxModel = businessDelegate.getCollection(sellerItemTaxContext);
        IModelWrapper<Collection<SellerItemTaxModel>> models = new CollectionModelWrapper<SellerItemTaxModel>(SellerItemTaxModel.class,
                sellerItemTaxModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemTaxModel> getSellerItemTax(@PathVariable(value = "id") final String sellerItemTaxId) {
        SellerItemTaxContext sellerItemTaxContext = sellerItemTaxContextFactory.getObject();
        SellerItemTaxModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerItemTaxId), sellerItemTaxContext);
        return new ResponseEntity<SellerItemTaxModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerItemTaxBusinessDelegate")
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
    public void setSellerItemTaxObjectFactory(final ObjectFactory<SellerItemTaxContext> sellerItemTaxContextFactory) {
        this.sellerItemTaxContextFactory = sellerItemTaxContextFactory;
    }

}
