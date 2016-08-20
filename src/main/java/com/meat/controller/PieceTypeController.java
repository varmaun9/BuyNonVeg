package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.PieceTypeContext;
import com.meat.model.PieceTypeModel;
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

@RestController
@RequestMapping(value = "/pieceType", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class PieceTypeController {

    private IBusinessDelegate<PieceTypeModel, PieceTypeContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<PieceTypeContext> pieceTypeContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PieceTypeModel> create(@RequestBody final PieceTypeModel pieceTypeModel) {
        businessDelegate.create(pieceTypeModel);
        return new ResponseEntity<PieceTypeModel>(pieceTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PieceTypeModel> edit(@PathVariable(value = "id") final String pieceTypeId,
            @RequestBody final PieceTypeModel pieceTypeModel) {

        businessDelegate.edit(keyBuilderFactory.getObject().withId(pieceTypeId), pieceTypeModel);
        return new ResponseEntity<PieceTypeModel>(pieceTypeModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllPieceType() {
        PieceTypeContext pieceTypeContext = pieceTypeContextFactory.getObject();
        pieceTypeContext.setAll("all");
        Collection<PieceTypeModel> pieceTypeModel = businessDelegate.getCollection(pieceTypeContext);
        IModelWrapper<Collection<PieceTypeModel>> models = new CollectionModelWrapper<PieceTypeModel>(PieceTypeModel.class, pieceTypeModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<PieceTypeModel> getPieceType(@PathVariable(value = "id") final String pieceTypeId) {
        PieceTypeContext pieceTypeContext = pieceTypeContextFactory.getObject();
        PieceTypeModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(pieceTypeId), pieceTypeContext);
        return new ResponseEntity<PieceTypeModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "pieceTypeBusinessDelegate")
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
    public void setPieceTypeObjectFactory(final ObjectFactory<PieceTypeContext> pieceTypeContextFactory) {
        this.pieceTypeContextFactory = pieceTypeContextFactory;
    }

}
