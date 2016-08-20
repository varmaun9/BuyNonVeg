package com.meat.util;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 * Implementation of registry to perform operations on the registry
 *
 * @author rbuddepu
 */
@Component
public class RepresentationLookupRegistry implements IRepresentationLookupRegistry {
    private final Map<TypeDescriptor, Set<TypeDescriptor>> registry = new ConcurrentHashMap<TypeDescriptor, Set<TypeDescriptor>>(64);

    private void addToClassHierarchy(final int index, Class<?> type, final boolean asArray, final List<Class<?>> hierarchy,
            final Set<Class<?>> visited) {
        if (asArray) {
            type = Array.newInstance(type, 0).getClass();
        }
        if (visited.add(type)) {
            hierarchy.add(index, type);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.IRepresentationLookupRegistry#find(org.springframework.core.convert.TypeDescriptor,
     *      org.springframework.core.convert.TypeDescriptor)
     */
    @Override
    public TypeDescriptor find(final TypeDescriptor modelType, final TypeDescriptor matchType) {
        Validate.notNull(modelType, "modelType must not be null.");
        Validate.notNull(matchType, "matchType must not be null.");

        if (!registry.isEmpty()) {
            if (modelType.isCollection()) {
                return findCollection(modelType, matchType);
            }
            else {
                return findSingle(modelType, matchType);
            }
        }

        return null;
    }

    /**
     * @param modelType
     * @param matchType
     * @return
     */
    private TypeDescriptor findCollection(final TypeDescriptor modelType, final TypeDescriptor matchType) {
        List<Class<?>> modelCandidates = getClassHierarchy(modelType.getType());

        for (Class<?> modelCandidate : modelCandidates) {
            TypeDescriptor modelDescriptor = TypeDescriptor.valueOf(modelCandidate);
            if (!modelDescriptor.isCollection()) {
                continue;
            }

            List<Class<?>> genericCandidates = getClassHierarchy(modelType.getResolvableType().resolveGeneric(0));
            for (Class<?> genericCandidate : genericCandidates) {
                TypeDescriptor collectionDescriptor = CollectionTypeDescriptor.forType(modelDescriptor, genericCandidate);

                /*
                 * If we have representations to look for...
                 */
                final Set<TypeDescriptor> representations = registry.get(collectionDescriptor);
                if (!CollectionUtils.isEmpty(representations)) {
                    /*
                     * for each representation, make sure it is assignable to matchType
                     */
                    for (TypeDescriptor representation : representations) {
                        if (representation.isAssignableTo(matchType)) {
                            return representation;
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * @param modelType
     * @param matchType
     */
    private TypeDescriptor findSingle(final TypeDescriptor modelType, final TypeDescriptor matchType) {
        List<Class<?>> modelCandidates = getClassHierarchy(modelType.getType());

        for (Class<?> modelCandidate : modelCandidates) {
            TypeDescriptor modelDescriptor = TypeDescriptor.valueOf(modelCandidate);

            /*
             * If we have representations to look for...
             */
            final Set<TypeDescriptor> representations = registry.get(modelDescriptor);
            if (!CollectionUtils.isEmpty(representations)) {
                /*
                 * for each representation, make sure it is assignable to matchType
                 */
                for (TypeDescriptor representation : representations) {
                    if (representation.isAssignableTo(matchType)) {
                        return representation;
                    }
                }
            }
        }

        return null;
    }

    /**
     * Returns an ordered class hierarchy for the given type.
     *
     * @param type
     *            the type
     * @return an ordered list of all classes that the given type extends or implements
     */
    private List<Class<?>> getClassHierarchy(final Class<?> type) {
        List<Class<?>> hierarchy = new ArrayList<Class<?>>(20);
        Set<Class<?>> visited = new HashSet<Class<?>>(20);
        addToClassHierarchy(0, ClassUtils.resolvePrimitiveIfNecessary(type), false, hierarchy, visited);
        boolean array = type.isArray();
        int i = 0;
        while (i < hierarchy.size()) {
            Class<?> candidate = hierarchy.get(i);
            candidate = (array ? candidate.getComponentType() : ClassUtils.resolvePrimitiveIfNecessary(candidate));
            Class<?> superclass = candidate.getSuperclass();
            if (candidate.getSuperclass() != null && superclass != Object.class) {
                addToClassHierarchy(i + 1, candidate.getSuperclass(), array, hierarchy, visited);
            }
            for (Class<?> implementedInterface : candidate.getInterfaces()) {
                addToClassHierarchy(hierarchy.size(), implementedInterface, array, hierarchy, visited);
            }
            i++;
        }
        return hierarchy;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.IRepresentationLookupRegistry#register(org.springframework.core.convert.TypeDescriptor,
     *      org.springframework.core.convert.TypeDescriptor)
     */
    @Override
    public void register(final TypeDescriptor representation, final TypeDescriptor model) {
        Validate.notNull(representation, "representation must not be null.");
        Validate.notNull(model, "model must not be null.");

        Set<TypeDescriptor> representations = registry.get(model);
        if (representations == null) {
            representations = new HashSet<TypeDescriptor>();
            registry.put(model, representations);
        }
        representations.add(representation);
    }
}