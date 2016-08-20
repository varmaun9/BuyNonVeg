/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SellerItemPieceTypeContext;
import com.meat.model.SellerItemPieceTypeModel;
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
 * @author varma
 *
 */

@RestController
@RequestMapping(value = "/sellerItemPieceType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SellerItemPieceTypeController {
    private IBusinessDelegate<SellerItemPieceTypeModel, SellerItemPieceTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SellerItemPieceTypeContext> sellerItemPieceTypeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemPieceTypeModel> create(@RequestBody final SellerItemPieceTypeModel sellerItemPieceTypeModel) {
        businessDelegate.create(sellerItemPieceTypeModel);
        return new ResponseEntity<SellerItemPieceTypeModel>(sellerItemPieceTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SellerItemPieceTypeModel> edit(@PathVariable(value = "id") final String sellerItemPieceTypeId,
            @RequestBody final SellerItemPieceTypeModel sellerItemPieceTypeModel) {
        SellerItemPieceTypeContext sellerItemPieceTypeContext = new SellerItemPieceTypeContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(sellerItemPieceTypeId), sellerItemPieceTypeModel);
        return new ResponseEntity<SellerItemPieceTypeModel>(sellerItemPieceTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSellerItemPieceType() {
        SellerItemPieceTypeContext sellerItemPieceTypeContext = sellerItemPieceTypeContextFactory.getObject();
        sellerItemPieceTypeContext.setAll("all");
        Collection<SellerItemPieceTypeModel> sellerItemPieceTypeModel = businessDelegate.getCollection(sellerItemPieceTypeContext);
        IModelWrapper<Collection<SellerItemPieceTypeModel>> models = new CollectionModelWrapper<SellerItemPieceTypeModel>(
                SellerItemPieceTypeModel.class, sellerItemPieceTypeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SellerItemPieceTypeModel> getSellerItemTax(@PathVariable(value = "id") final String sellerItemPieceTypeId) {
        SellerItemPieceTypeContext sellerItemPieceTypeContext = sellerItemPieceTypeContextFactory.getObject();
        SellerItemPieceTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(sellerItemPieceTypeId),
                sellerItemPieceTypeContext);
        return new ResponseEntity<SellerItemPieceTypeModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "sellerItemPieceTypeBusinessDelegate")
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
    public void setSellerItemPieceTypeObjectFactory(final ObjectFactory<SellerItemPieceTypeContext> sellerItemPieceTypeContextFactory) {
        this.sellerItemPieceTypeContextFactory = sellerItemPieceTypeContextFactory;
    }

}
