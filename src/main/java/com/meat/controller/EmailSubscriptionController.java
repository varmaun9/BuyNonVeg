/**
 *
 */
package com.meat.controller;

import com.google.code.siren4j.Siren4J;
import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.businessdelegate.domain.SimpleIdKeyBuilder;
import com.meat.businessdelegate.service.EmailSubscriptionContext;
import com.meat.businessdelegate.service.IBusinessDelegate;
import com.meat.model.EmailSubscriptionModel;
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
 * @author varma
 *
 */
@RestController
@RequestMapping(value = "/emailSubscription", produces = { MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE }, consumes = {
        MediaType.APPLICATION_JSON_VALUE, Siren4J.JSON_MEDIATYPE })
public class EmailSubscriptionController {

    private static final Logger LOGGER = Logger.getLogger(EmailSubscriptionController.class);
    private IBusinessDelegate<EmailSubscriptionModel, EmailSubscriptionContext, IKeyBuilder<String>, String> businessDelegate;
    private ObjectFactory<SimpleIdKeyBuilder> keyBuilderFactory;
    private ObjectFactory<EmailSubscriptionContext> emailSubscriptionObjectFactory;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<EmailSubscriptionModel> createEmailSubscription(@RequestBody final EmailSubscriptionModel emailSubscriptionModel) {
        businessDelegate.create(emailSubscriptionModel);
        return new ResponseEntity<EmailSubscriptionModel>(emailSubscriptionModel, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    @ResponseBody
    public HttpEntity<EmailSubscriptionModel> editEmailSubscription(@PathVariable(value = "id") final String emailSubscriptionId,
            @RequestBody final EmailSubscriptionModel emailSubscription) {
        EmailSubscriptionContext emailSubscriptionContext = emailSubscriptionObjectFactory.getObject();
        businessDelegate.edit(keyBuilderFactory.getObject().withId(emailSubscriptionId), emailSubscription);
        return new ResponseEntity<EmailSubscriptionModel>(emailSubscription, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}", consumes = { MediaType.ALL_VALUE })
    @ResponseBody
    public HttpEntity<EmailSubscriptionModel> getEmailSubscription(@PathVariable(value = "id") final String emailSubscriptionId) {
        EmailSubscriptionContext emailSubscriptionContext = emailSubscriptionObjectFactory.getObject();
        EmailSubscriptionModel model = businessDelegate.getByKey(keyBuilderFactory.getObject().withId(emailSubscriptionId),
                emailSubscriptionContext);
        return new ResponseEntity<EmailSubscriptionModel>(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getEmailSubscriptions() {
        EmailSubscriptionContext emailSubscriptionContext = emailSubscriptionObjectFactory.getObject();
        emailSubscriptionContext.setAll("all");
        Collection<EmailSubscriptionModel> emailSubscriptionModelCollection = businessDelegate.getCollection(emailSubscriptionContext);
        IModelWrapper<Collection<EmailSubscriptionModel>> models = new CollectionModelWrapper<EmailSubscriptionModel>(
                EmailSubscriptionModel.class, emailSubscriptionModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @RequestMapping(value = "/mailsToAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public HttpEntity<IModelWrapper> getEmailSubscriptionsSendsMailsToUsers() {
        EmailSubscriptionContext emailSubscriptionContext = emailSubscriptionObjectFactory.getObject();
        emailSubscriptionContext.setAllEmails("ALLEmails");
        Collection<EmailSubscriptionModel> emailSubscriptionModelCollection = businessDelegate.getCollection(emailSubscriptionContext);
        IModelWrapper<Collection<EmailSubscriptionModel>> models = new CollectionModelWrapper<EmailSubscriptionModel>(
                EmailSubscriptionModel.class, emailSubscriptionModelCollection);
        return new ResponseEntity<IModelWrapper>(models, HttpStatus.OK);
    }

    @Resource(name = "emailSubscriptionBusinessDelegate")
    public void setEmailSubscriptionBusinessDelegate(final IBusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Autowired
    public void setEmailSubscriptionObjectFactory(final ObjectFactory<EmailSubscriptionContext> emailSubscriptionObjectFactory) {
        this.emailSubscriptionObjectFactory = emailSubscriptionObjectFactory;
    }

    /**
     * @param factory
     */
    @Resource
    public void setKeyBuilderFactory(final ObjectFactory<SimpleIdKeyBuilder> factory) {
        keyBuilderFactory = factory;
    }

}
