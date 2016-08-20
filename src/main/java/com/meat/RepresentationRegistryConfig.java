package com.meat;

import com.meat.util.IRepresentationLookupRegistry;
import com.meat.util.Representation;

import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.TypeDescriptor;

/**
 * This Class register all the representations with registry to perform operations on the registry
 *
 * @author rbuddepu
 *
 */
@Configuration
public class RepresentationRegistryConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(RepresentationRegistryConfig.class);

    @Autowired
    private ListableBeanFactory beanFactory;
    private IRepresentationLookupRegistry registry;

    @PostConstruct
    public void init() {
        Map<String, Object> map = beanFactory.getBeansWithAnnotation(Representation.class);

        LOGGER.debug("Registering {} representations", map.size());
        for (Object bean : map.values()) {
            TypeDescriptor typeDescriptor = TypeDescriptor.forObject(bean);
            Representation annotation = bean.getClass().getAnnotation(Representation.class);
            if (!typeDescriptor.isCollection()) {
                final TypeDescriptor modelDescriptor = TypeDescriptor.valueOf(annotation.value());
                registry.register(typeDescriptor, modelDescriptor);
                LOGGER.debug("Registered Class [representation={}, model={}]", typeDescriptor, modelDescriptor);
            }
            else {
                final TypeDescriptor modelDescriptor = TypeDescriptor.collection(Collection.class,
                        TypeDescriptor.valueOf(annotation.value()));
                registry.register(typeDescriptor, modelDescriptor);
                LOGGER.debug("Registered Collection [type={}, model={}]", typeDescriptor, modelDescriptor);
            }
        }
    }

    /**
     * @param registry
     *            the registry to set
     */
    @Autowired
    public void setRegistry(final IRepresentationLookupRegistry registry) {
        this.registry = registry;
    }
}
