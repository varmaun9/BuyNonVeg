package com.meat.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * Implementation for the registry service to get the representations
 *
 * @author rbuddepu
 */
@Service
public class RepresentationLookupService implements IRepresentationLookupService {

    private static final TypeDescriptor NO_MATCH = TypeDescriptor.valueOf(Object.class);
    private final Map<RepresentationCacheKey, TypeDescriptor> representationCache = new ConcurrentHashMap<RepresentationCacheKey, TypeDescriptor>(
            64);
    private IRepresentationLookupRegistry registry;

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.IRepresentationLookupService#getRepresentation(org.springframework.core.convert.TypeDescriptor,
     *      java.lang.Class)
     */
    @Override
    public TypeDescriptor getRepresentation(final TypeDescriptor representationType, final Class<?> matchClass) {
        Validate.notNull(representationType, "representationType must not be null.");

        final TypeDescriptor matchType = TypeDescriptor.valueOf(matchClass);
        RepresentationCacheKey key = new RepresentationCacheKey(representationType, matchType);
        TypeDescriptor representation = representationCache.get(key);
        if (representation != null) {
            return (representation != NO_MATCH ? representation : null);
        }

        representation = registry.find(representationType, matchType);
        if (representation != null) {
            representationCache.put(key, representation);
            return representation;
        }

        representationCache.put(key, NO_MATCH);
        return null;
    }

    /**
     * @param registry
     *            the registry to set
     */
    @Autowired
    public void setRegistry(final IRepresentationLookupRegistry registry) {
        this.registry = registry;
    }

    /**
     * Key for use with the converter cache.
     */
    private static final class RepresentationCacheKey {
        private final TypeDescriptor representation;
        private final TypeDescriptor match;

        public RepresentationCacheKey(final TypeDescriptor representation, final TypeDescriptor match) {
            this.representation = representation;
            this.match = match;
        }

        @Override
        public boolean equals(final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RepresentationCacheKey)) {
                return false;
            }
            RepresentationCacheKey otherKey = (RepresentationCacheKey) other;
            return ObjectUtils.nullSafeEquals(representation, otherKey.representation) && ObjectUtils.nullSafeEquals(match, otherKey.match);
        }

        @Override
        public int hashCode() {
            return ObjectUtils.nullSafeHashCode(representation) * 29 + ObjectUtils.nullSafeHashCode(match);
        }

        @Override
        public String toString() {
            return "ConverterCacheKey [sourceType = " + representation + ", targetType = " + match + "]";
        }
    }
}
