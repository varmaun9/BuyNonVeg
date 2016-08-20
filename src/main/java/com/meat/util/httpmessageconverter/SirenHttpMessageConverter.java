package com.meat.util.httpmessageconverter;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.code.siren4j.component.Entity;
import com.google.code.siren4j.component.Link;
import com.google.code.siren4j.component.builder.LinkBuilder;
import com.google.code.siren4j.converter.ReflectingConverter;
import com.google.code.siren4j.converter.ResourceConverter;
import com.google.code.siren4j.converter.ResourceRegistry;
import com.google.code.siren4j.converter.ResourceRegistryImpl;
import com.google.code.siren4j.error.Siren4JException;
import com.google.code.siren4j.error.Siren4JRuntimeException;
import com.google.code.siren4j.resource.CollectionResource;
import com.google.code.siren4j.resource.Resource;
import com.google.code.siren4j.util.ComponentUtils;
import com.meat.util.CollectionTypeDescriptor;
import com.meat.util.IModelWrapper;
import com.meat.util.IRepresentationLookupService;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Collection;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * HTTPMessage Converter for Siren Representation Format
 *
 * @author rbuddepu
 *
 */
@Component
public class SirenHttpMessageConverter extends AbstractJackson2HttpMessageConverter<Object> {
    private ConversionService conversionService;
    private IRepresentationLookupService representationLookupService;
    private final ResourceRegistry registry;

    /**
     * Constructor for SirenHttpMessageConverter
     */
    public SirenHttpMessageConverter() {
        super(new MediaType("application", "vnd.siren+json", DEFAULT_CHARSET));
        setPrettyPrint(true);

        try {
            registry = ResourceRegistryImpl.newInstance((String[]) null);
        }
        catch (Siren4JException e) {
            throw new Siren4JRuntimeException(e);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.httpmessageconverter.AbstractJackson2HttpMessageConverter#getJavaType(java.lang.reflect.Type,
     *      java.lang.Class)
     */
    @Override
    protected JavaType getJavaType(final Type type, final Class<?> contextClass) {
        return super.getJavaType(Entity.class, contextClass);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.httpmessageconverter.AbstractJackson2HttpMessageConverter#readInternal(java.lang.reflect.Type,
     *      java.lang.Class, org.springframework.http.HttpInputMessage)
     */
    @Override
    protected Object readInternal(final Type type, final Class<?> contextClass, final HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        final Object object = super.readInternal(type, contextClass, inputMessage);

        ResourceConverter resourceConverter;
        try {
            resourceConverter = ReflectingConverter.newInstance(registry);
        }
        catch (Siren4JException e) {
            throw new HttpMessageNotReadableException("Unable to instantiate Siren Converter", e);
        }
        Object converted = resourceConverter.toObject((Entity) object);

        TypeDescriptor typeDescriptor = TypeDescriptor.valueOf((Class) type);
        TypeDescriptor objectDescriptor = TypeDescriptor.forObject(converted);
        if (!objectDescriptor.isAssignableTo(typeDescriptor)) {
            converted = conversionService.convert(converted, objectDescriptor, typeDescriptor);
        }

        return converted;
    }

    /**
     * @param conversionService
     *            the conversionService to set
     */
    @Autowired
    public void setConversionService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.httpmessageconverter.AbstractJackson2HttpMessageConverter#setObjectMapper(com.fasterxml.jackson.databind.ObjectMapper)
     */
    @Override
    @javax.annotation.Resource(name = "sirenObjectMapper")
    public void setObjectMapper(final ObjectMapper objectMapper) {
        super.setObjectMapper(objectMapper);
    }

    /**
     * @param representationLookupService
     *            the representationLookupService to set
     */
    @Autowired
    public void setRepresentationLookupService(final IRepresentationLookupService representationLookupService) {
        this.representationLookupService = representationLookupService;
    }

    private URI toUri(final ServletUriComponentsBuilder builder) {
        return builder.build().encode().toUri().normalize();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.httpmessageconverter.AbstractJackson2HttpMessageConverter#writeInternal(java.lang.Object,
     *      org.springframework.http.HttpOutputMessage)
     */
    @Override
    protected void writeInternal(final Object object, final HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
        TypeDescriptor typeDescriptor = TypeDescriptor.forObject(object);
        Resource converted = null;

        if (!typeDescriptor.isAssignableTo(TypeDescriptor.valueOf(Resource.class))) {
            TypeDescriptor representation = null;

            Object toConvert = object;
            if (typeDescriptor.isAssignableTo(TypeDescriptor.valueOf(IModelWrapper.class))) {
                IModelWrapper modelWrapper = (IModelWrapper) object;
                typeDescriptor = modelWrapper.getModelType();
                toConvert = modelWrapper.getModel();
            }
            else if (typeDescriptor.isCollection()) {
                typeDescriptor = CollectionTypeDescriptor.forCollection((Collection) toConvert);
                logger.info("You are converting a Collection-type object.  You might have better luck by using an IModelWrapper!.");
            }

            if (typeDescriptor.isCollection()) {
                representation = representationLookupService.getRepresentation(typeDescriptor, CollectionResource.class);
            }
            else {
                representation = representationLookupService.getRepresentation(typeDescriptor, Resource.class);
            }

            converted = (Resource) conversionService.convert(toConvert, typeDescriptor, representation);
        }
        else {
            converted = (Resource) object;
        }

        Entity entity = null;
        if (converted != null) {
            ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
            converted.setFullyQualifiedLinks(true);
            String uri = FilenameUtils.getFullPathNoEndSeparator(toUri(builder).toASCIIString());
            converted.setBaseUri(uri);

            ResourceConverter resourceConverter;
            try {
                resourceConverter = ReflectingConverter.newInstance(registry);
            }
            catch (Siren4JException e) {
                throw new HttpMessageNotWritableException("Unable to instantiate Siren Converter", e);
            }

            entity = resourceConverter.toEntity(converted);
        }

        /*
         * Add a Location header
         */
        if (entity != null) {
            Link baseUri = ComponentUtils.getLinkByRel(entity, Link.RELATIONSHIP_BASEURI);
            Link selfLink = ComponentUtils.getLinkByRel(entity, Link.RELATIONSHIP_SELF);
            if (typeDescriptor.isCollection() && selfLink.getHref().equals(baseUri.getHref() + "/")) {
                entity.getLinks().remove(selfLink);

                ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentServletMapping();

                final String resolvedUri = toUri(builder).toASCIIString();
                final StringBuilder uri = new StringBuilder();
                uri.append(resolvedUri);
                uri.append(resolvedUri.endsWith("/") ? "" : "/");
                Link link = LinkBuilder.newInstance().setRelationship(Link.RELATIONSHIP_SELF).setHref(uri.toString()).build();
                entity.getLinks().add(link);
            }

            final HttpHeaders headers = outputMessage.getHeaders();
            headers.setLocation(URI.create(ComponentUtils.getLinkByRel(entity, Link.RELATIONSHIP_SELF).getHref()));
        }

        super.writeInternal(entity, outputMessage);
    }
}