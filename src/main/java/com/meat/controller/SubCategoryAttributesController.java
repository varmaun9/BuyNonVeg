/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.SubCategoryAttributesContext;
import com.meat.model.SubCategoryAttributesModel;
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
@RequestMapping(value = "/subCategoryAttributes", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class SubCategoryAttributesController {
    private IBusinessDelegate<SubCategoryAttributesModel, SubCategoryAttributesContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<SubCategoryAttributesContext> subCategoryAttributesContextFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryAttributesModel> create(@RequestBody final SubCategoryAttributesModel subCategoryAttributesModel) {
        businessDelegate.create(subCategoryAttributesModel);
        return new ResponseEntity<SubCategoryAttributesModel>(subCategoryAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<SubCategoryAttributesModel> edit(@PathVariable(value = "id") final String subCategoryAttributesId,
            @RequestBody final SubCategoryAttributesModel subCategoryAttributesModel) {
        SubCategoryAttributesContext subCategoryAttributesContext = new SubCategoryAttributesContext();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(subCategoryAttributesId), subCategoryAttributesModel);
        return new ResponseEntity<SubCategoryAttributesModel>(subCategoryAttributesModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<IModelWrapper> getAllSubCategoryAttributes() {
        SubCategoryAttributesContext subCategoryAttributesContext = subCategoryAttributesContextFactory.getObject();
        subCategoryAttributesContext.setAll("all");
        Collection<SubCategoryAttributesModel> subCategoryAttributesModel = businessDelegate.getCollection(subCategoryAttributesContext);
        IModelWrapper<Collection<SubCategoryAttributesModel>> models = new CollectionModelWrapper<SubCategoryAttributesModel>(
                SubCategoryAttributesModel.class, subCategoryAttributesModel);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public ResponseEntity<SubCategoryAttributesModel> getSubCategoryAttributes(
            @PathVariable(value = "id") final String subCategoryAttributesId) {
        SubCategoryAttributesContext subCategoryAttributesContext = subCategoryAttributesContextFactory.getObject();
        SubCategoryAttributesModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(subCategoryAttributesId),
                subCategoryAttributesContext);
        return new ResponseEntity<SubCategoryAttributesModel>(model, HttpStatus.OK);
    }

    /**
     * @param businessDelegate
     */
    @Resource(name = "subCategoryAttributesBusinessDelegate")
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
    public void setSubCategoryAttributesObjectFactory(final ObjectFactory<SubCategoryAttributesContext> subCategoryAttributesContextFactory) {
        this.subCategoryAttributesContextFactory = subCategoryAttributesContextFactory;
    }

}
