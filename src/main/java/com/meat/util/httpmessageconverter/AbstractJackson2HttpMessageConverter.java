package com.meat.util.httpmessageconverter;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

/**
 * Abstract class for Http Message Converters which intercepts the Http requests and responses
 *
 * @author rbuddepu
 */
public class AbstractJackson2HttpMessageConverter<T> extends AbstractHttpMessageConverter<T> implements GenericHttpMessageConverter<T> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    // Check for Jackson 2.3's overloaded canDeserialize/canSerialize variants with cause reference
    private static final boolean jackson23Available = ClassUtils.hasMethod(ObjectMapper.class, "canDeserialize", JavaType.class,
            AtomicReference.class);

    private ObjectMapper objectMapper = new ObjectMapper();
    private String jsonPrefix;
    private Boolean prettyPrint;

    /**
     * Constructor for AbstractJackson2HttpMessageConverter
     */
    public AbstractJackson2HttpMessageConverter() {
        super();
    }

    /**
     * Constructor for AbstractJackson2HttpMessageConverter
     *
     * @param supportedMediaTypes
     */
    public AbstractJackson2HttpMessageConverter(final MediaType... supportedMediaTypes) {
        super(supportedMediaTypes);
    }

    /**
     * Constructor for AbstractJackson2HttpMessageConverter
     *
     * @param supportedMediaType
     */
    public AbstractJackson2HttpMessageConverter(final MediaType supportedMediaType) {
        super(supportedMediaType);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#canRead(java.lang.Class, org.springframework.http.MediaType)
     */
    @Override
    public boolean canRead(final Class<?> clazz, final MediaType mediaType) {
        return canRead(clazz, null, mediaType);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.GenericHttpMessageConverter#canRead(java.lang.reflect.Type, java.lang.Class,
     *      org.springframework.http.MediaType)
     */
    @Override
    public boolean canRead(final Type type, final Class<?> contextClass, final MediaType mediaType) {
        JavaType javaType = getJavaType(type, contextClass);
        if (!jackson23Available || !logger.isWarnEnabled()) {
            return (this.objectMapper.canDeserialize(javaType) && canRead(mediaType));
        }
        AtomicReference<Throwable> causeRef = new AtomicReference<Throwable>();
        if (this.objectMapper.canDeserialize(javaType, causeRef) && canRead(mediaType)) {
            return true;
        }
        Throwable cause = causeRef.get();
        if (cause != null) {
            String msg = "Failed to evaluate deserialization for type " + javaType;
            if (logger.isDebugEnabled()) {
                logger.warn(msg, cause);
            }
            else {
                logger.warn(msg + ": " + cause);
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#canWrite(java.lang.Class, org.springframework.http.MediaType)
     */
    @Override
    public boolean canWrite(final Class<?> clazz, final MediaType mediaType) {
        if (!jackson23Available || !logger.isWarnEnabled()) {
            return (this.objectMapper.canSerialize(clazz) && canWrite(mediaType));
        }
        AtomicReference<Throwable> causeRef = new AtomicReference<Throwable>();
        if (this.objectMapper.canSerialize(clazz, causeRef) && canWrite(mediaType)) {
            return true;
        }
        Throwable cause = causeRef.get();
        if (cause != null) {
            String msg = "Failed to evaluate serialization for type [" + clazz + "]";
            if (logger.isDebugEnabled()) {
                logger.warn(msg, cause);
            }
            else {
                logger.warn(msg + ": " + cause);
            }
        }
        return false;
    }

    private void configurePrettyPrint() {
        if (this.prettyPrint != null) {
            this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, this.prettyPrint);
        }
    }

    /**
     * Return the Jackson {@link JavaType} for the specified type and context class. <p>The default implementation returns
     * {@code typeFactory.constructType(type, contextClass)}, but this can be overridden in subclasses, to allow for custom generic
     * collection handling. For instance: <pre class="code"> protected JavaType getJavaType(Type type) { if (type instanceof Class &&
     * List.class.isAssignableFrom((Class)type)) { return TypeFactory.collectionType(ArrayList.class, MyBean.class); } else { return
     * super.getJavaType(type); } } </pre>
     *
     * @param type
     *            the type to return the java type for
     * @param contextClass
     *            a context class for the target type, for example a class in which the target type appears in a method signature, can be
     *            {@code null} signature, can be {@code null}
     * @return the java type
     */
    protected JavaType getJavaType(final Type type, final Class<?> contextClass) {
        return this.objectMapper.getTypeFactory().constructType(type, contextClass);
    }

    /**
     * Determine the JSON encoding to use for the given content type.
     *
     * @param contentType
     *            the media type as requested by the caller
     * @return the JSON encoding to use (never {@code null})
     */
    protected JsonEncoding getJsonEncoding(final MediaType contentType) {
        if (contentType != null && contentType.getCharSet() != null) {
            Charset charset = contentType.getCharSet();
            for (JsonEncoding encoding : JsonEncoding.values()) {
                if (charset.name().equals(encoding.getJavaName())) {
                    return encoding;
                }
            }
        }
        return JsonEncoding.UTF8;
    }

    /**
     * Return the underlying {@code ObjectMapper} for this view.
     */
    public ObjectMapper getObjectMapper() {
        return this.objectMapper;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.GenericHttpMessageConverter#read(java.lang.reflect.Type, java.lang.Class,
     *      org.springframework.http.HttpInputMessage)
     */
    @Override
    public T read(final Type type, final Class<?> contextClass, final HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        return readInternal(type, contextClass, inputMessage);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#readInternal(java.lang.Class,
     *      org.springframework.http.HttpInputMessage)
     */
    @Override
    protected T readInternal(final Class<? extends T> clazz, final HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        return readInternal(clazz, null, inputMessage);
    }

    /**
     * @param type
     * @param contextClass
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    protected T readInternal(final Type type, final Class<?> contextClass, final HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {

        JavaType javaType = getJavaType(type, contextClass);
        return readJavaType(javaType, inputMessage);
    }

    /**
     * @param javaType
     * @param inputMessage
     * @return
     */
    private T readJavaType(final JavaType javaType, final HttpInputMessage inputMessage) {
        try {
            return this.objectMapper.readValue(inputMessage.getBody(), javaType);
        }
        catch (IOException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }

    /**
     * Specify a custom prefix to use for this view's JSON output. Default is none.
     *
     * @see #setPrefixJson
     */
    public void setJsonPrefix(final String jsonPrefix) {
        this.jsonPrefix = jsonPrefix;
    }

    /**
     * Set the {@code ObjectMapper} for this view. If not set, a default {@link ObjectMapper#ObjectMapper() ObjectMapper} is used.
     * <p>Setting a custom-configured {@code ObjectMapper} is one way to take further control of the JSON serialization process. For
     * example, an extended {@link com.fasterxml.jackson.databind.ser.SerializerFactory} can be configured that provides custom serializers
     * for specific types. The other option for refining the serialization process is to use Jackson's provided annotations on the types to
     * be serialized, in which case a custom-configured ObjectMapper is unnecessary.
     */
    public void setObjectMapper(final ObjectMapper objectMapper) {
        Assert.notNull(objectMapper, "ObjectMapper must not be null");
        this.objectMapper = objectMapper;
        configurePrettyPrint();
    }

    /**
     * Indicate whether the JSON output by this view should be prefixed with "{} &&". Default is false. <p>Prefixing the JSON string in this
     * manner is used to help prevent JSON Hijacking. The prefix renders the string syntactically invalid as a script so that it cannot be
     * hijacked. This prefix does not affect the evaluation of JSON, but if JSON validation is performed on the string, the prefix would
     * need to be ignored.
     *
     * @see #setJsonPrefix
     */
    public void setPrefixJson(final boolean prefixJson) {
        this.jsonPrefix = (prefixJson ? "{} && " : null);
    }

    /**
     * Whether to use the {@link DefaultPrettyPrinter} when writing JSON. This is a shortcut for setting up an {@code ObjectMapper} as
     * follows: <pre class="code"> ObjectMapper mapper = new ObjectMapper(); mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
     * converter.setObjectMapper(mapper); </pre>
     */
    public void setPrettyPrint(final boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
        configurePrettyPrint();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#supports(java.lang.Class)
     */
    @Override
    protected boolean supports(final Class<?> clazz) {
        // should not be called, since we override canRead/Write instead
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.http.converter.AbstractHttpMessageConverter#writeInternal(java.lang.Object,
     *      org.springframework.http.HttpOutputMessage)
     */
    @Override
    protected void writeInternal(final Object object, final HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {

        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());
        // The following has been deprecated as late as Jackson 2.2 (April 2013);
        // preserved for the time being, for Jackson 2.0/2.1 compatibility.
        @SuppressWarnings("deprecation")
        JsonGenerator jsonGenerator = this.objectMapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);

        // A workaround for JsonGenerators not applying serialization features
        // https://github.com/FasterXML/jackson-databind/issues/12
        if (this.objectMapper.isEnabled(SerializationFeature.INDENT_OUTPUT)) {
            jsonGenerator.useDefaultPrettyPrinter();
        }

        try {
            if (this.jsonPrefix != null) {
                jsonGenerator.writeRaw(this.jsonPrefix);
            }
            this.objectMapper.writeValue(jsonGenerator, object);
        }
        catch (JsonProcessingException ex) {
            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }

	


}
