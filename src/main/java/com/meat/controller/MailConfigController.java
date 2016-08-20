/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.businessdelegate.service.MailConfigContext;
import com.meat.domain.MailConfig;
import com.meat.model.MailConfigModel;
import com.meat.util.CollectionModelWrapper;
import com.meat.util.IModelWrapper;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author arthvedi
 *
 */

@RestController
@RequestMapping(value = "/mailConfig", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class MailConfigController {

    private static final Logger LOGGER = Logger.getLogger(MailConfigController.class);
    private IBusinessDelegate<MailConfigModel, MailConfigContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<MailConfigContext> mailConfigObjectFactory;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<MailConfigModel> createMailConfig(@RequestBody final MailConfigModel mailConfigModel) {
        MailConfig mailConfig = new MailConfig();
        businessDelegate.create(mailConfigModel);
        return new ResponseEntity<MailConfigModel>(mailConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<MailConfigModel> editMailConfig(@PathVariable(value = "id") final String mailConfigId,
            @RequestBody final MailConfigModel mailConfigModel) {
        MailConfigContext mailConfigContext = mailConfigObjectFactory.getObject();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(mailConfigId), mailConfigModel);
        return new ResponseEntity<MailConfigModel>(mailConfigModel, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<MailConfigModel> getMailConfig(@PathVariable(value = "id") final String mailConfigId) {
        MailConfigContext mailConfigContext = mailConfigObjectFactory.getObject();
        MailConfigModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(mailConfigId), mailConfigContext);
        return new ResponseEntity<MailConfigModel>(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getStates() {
        MailConfigContext mailConfigContext = mailConfigObjectFactory.getObject();
        mailConfigContext.setAll("all");
        Collection<MailConfigModel> mailConfigModelCollection = businessDelegate.getCollection(mailConfigContext);
        IModelWrapper<Collection<MailConfigModel>> models = new CollectionModelWrapper<MailConfigModel>(MailConfigModel.class,
                mailConfigModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

    @Resource(name = "mailConfigBusinessDelegate")
    public void setMailConfigBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setMailConfigObjectFactory(final ObjectFactory<MailConfigContext> mailConfigObjectFactory) {
        this.mailConfigObjectFactory = mailConfigObjectFactory;
    }

}
