/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerImagesContext;
import com.meat.model.SellerImagesModel;
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
@RequestMapping(value = "/sellerImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerImagesController {
    private IBusinessDelegate<SellerImagesModel, SellerImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerImagesContext> sellerImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerImagesModel> create(@RequestBody final SellerImagesModel sellerImagesModel) {
        businessDelegate.create(sellerImagesModel);
        return new ResponseEntity<SellerImagesModel>(sellerImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerImagesModel> edit(@PathVariable(value = "id") final String sellerImagesId,
            @RequestBody final SellerImagesModel sellerImagesModel) {
        SellerImagesContext sellerImagesContext = new SellerImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerImagesId), sellerImagesModel);
        return new ResponseEntity<SellerImagesModel>(sellerImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerImages() {
        SellerImagesContext sellerImagesContext = sellerImagesContextFactory.getObject();
        sellerImagesContext.setAll("all");
        Collection<SellerImagesModel> sellerImagesModel = businessDelegate.getCollection(sellerImagesContext);
        IModelWrapper<Collection<SellerImagesModel>> models = new CollectionModelWrapper<SellerImagesModel>(SellerImagesModel.class,
                sellerImagesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerImagesModel> getSellerImages(@PathVariable(value = "id") final String sellerImagesId) {
        SellerImagesContext sellerImagesContext = sellerImagesContextFactory.getObject();
        SellerImagesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerImagesId), sellerImagesContext);
        return new ResponseEntity<SellerImagesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerImagesBusinessDelegate")
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
    public void setSellerImagesObjectFactory(final ObjectFactory<SellerImagesContext> SellerImagesContextFactory) {
        sellerImagesContextFactory = sellerImagesContextFactory;
    }

}
