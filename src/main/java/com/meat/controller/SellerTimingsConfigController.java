/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerTimingsConfigContext;
import com.meat.model.SellerTimingsConfigModel;
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
@RequestMapping(value = "/sellerTimingsConfig", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerTimingsConfigController {
    private IBusinessDelegate<SellerTimingsConfigModel, SellerTimingsConfigContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerTimingsConfigContext> sellerTimingsConfigContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerTimingsConfigModel> create(@RequestBody final SellerTimingsConfigModel sellerTimingsConfigModel) {
        businessDelegate.create(sellerTimingsConfigModel);
        return new ResponseEntity<SellerTimingsConfigModel>(sellerTimingsConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerTimingsConfigModel> edit(@PathVariable(value = "id") final String sellerTimingsConfigId,
            @RequestBody final SellerTimingsConfigModel sellerTimingsConfigModel) {
        SellerTimingsConfigContext sellerTimingsConfigContext = new SellerTimingsConfigContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerTimingsConfigId), sellerTimingsConfigModel);
        return new ResponseEntity<SellerTimingsConfigModel>(sellerTimingsConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerTimingsConfiges() {
        SellerTimingsConfigContext sellerTimingsConfigContext = sellerTimingsConfigContextFactory.getObject();
        sellerTimingsConfigContext.setAll("all");
        Collection<SellerTimingsConfigModel> sellerTimingsConfigModel = businessDelegate.getCollection(sellerTimingsConfigContext);
        IModelWrapper<Collection<SellerTimingsConfigModel>> models = new CollectionModelWrapper<SellerTimingsConfigModel>(
                SellerTimingsConfigModel.class, sellerTimingsConfigModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerTimingsConfigModel> getSellerTimingsConfig(@PathVariable(value = "id") final String sellerTimingsConfigId) {
        SellerTimingsConfigContext sellerTimingsConfigContext = sellerTimingsConfigContextFactory.getObject();
        SellerTimingsConfigModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerTimingsConfigId),
                sellerTimingsConfigContext);
        return new ResponseEntity<SellerTimingsConfigModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerTimingsConfigBusinessDelegate")
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
    public void setSellerTimingsConfigObjectFactory(final ObjectFactory<SellerTimingsConfigContext> sellerTimingsConfigContextFactory) {
        this.sellerTimingsConfigContextFactory = sellerTimingsConfigContextFactory;
    }

}
