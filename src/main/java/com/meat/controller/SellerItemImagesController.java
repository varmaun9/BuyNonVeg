/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerItemImagesContext;
import com.meat.model.SellerItemImagesModel;
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
@RequestMapping(value = "/sellerItemImages", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerItemImagesController {
    private IBusinessDelegate<SellerItemImagesModel, SellerItemImagesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerItemImagesContext> sellerItemImagesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemImagesModel> create(@RequestBody final SellerItemImagesModel sellerItemImagesModel) {
        businessDelegate.create(sellerItemImagesModel);
        return new ResponseEntity<SellerItemImagesModel>(sellerItemImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerItemImagesModel> edit(@PathVariable(value = "id") final String sellerItemImagesId,
            @RequestBody final SellerItemImagesModel sellerItemImagesModel) {
        SellerItemImagesContext sellerItemImagesContext = new SellerItemImagesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerItemImagesId), sellerItemImagesModel);
        return new ResponseEntity<SellerItemImagesModel>(sellerItemImagesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItemImages() {
        SellerItemImagesContext sellerItemImagesContext = sellerItemImagesContextFactory.getObject();
        sellerItemImagesContext.setAll("all");
        Collection<SellerItemImagesModel> sellerItemImagesModel = businessDelegate.getCollection(sellerItemImagesContext);
        IModelWrapper<Collection<SellerItemImagesModel>> models = new CollectionModelWrapper<SellerItemImagesModel>(
                SellerItemImagesModel.class, sellerItemImagesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemImagesModel> getSellerItemImages(@PathVariable(value = "id") final String sellerItemImagesId) {
        SellerItemImagesContext sellerItemImagesContext = sellerItemImagesContextFactory.getObject();
        SellerItemImagesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerItemImagesId),
                sellerItemImagesContext);
        return new ResponseEntity<SellerItemImagesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerItemImagesBusinessDelegate")
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
    public void setSellerItemImagesObjectFactory(final ObjectFactory<SellerItemImagesContext> sellerItemImagesContextFactory) {
        this.sellerItemImagesContextFactory = sellerItemImagesContextFactory;
    }

}
