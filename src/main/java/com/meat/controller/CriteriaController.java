/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.CriteriaContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.CriteriaModel;
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
@RequestMapping(value = "/criteria", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class CriteriaController {
    private IBusinessDelegate<CriteriaModel, CriteriaContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<CriteriaContext> criteriaContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CriteriaModel> create(@RequestBody final CriteriaModel criteriaModel) {
        businessDelegate.create(criteriaModel);
        return new ResponseEntity<CriteriaModel>(criteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<CriteriaModel> edit(@PathVariable(value = "id") final String criteriaId,
            @RequestBody final CriteriaModel criteriaModel) {
        CriteriaContext criteriaContext = new CriteriaContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(criteriaId), criteriaModel);
        return new ResponseEntity<CriteriaModel>(criteriaModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllCriterias() {
        CriteriaContext criteriaContext = criteriaContextFactory.getObject();
        criteriaContext.setAll("all");
        Collection<CriteriaModel> criteriaModel = businessDelegate.getCollection(criteriaContext);
        IModelWrapper<Collection<CriteriaModel>> models = new CollectionModelWrapper<CriteriaModel>(CriteriaModel.class, criteriaModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<CriteriaModel> getCriteria(@PathVariable(value = "id") final String criteriaId) {
        CriteriaContext criteriaContext = criteriaContextFactory.getObject();
        CriteriaModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(criteriaId), criteriaContext);
        return new ResponseEntity<CriteriaModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "criteriaBusinessDelegate")
    public void setBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setCriteriaObjectFactory(final ObjectFactory<CriteriaContext> criteriaContextFactory) {
        this.criteriaContextFactory = criteriaContextFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }
}
