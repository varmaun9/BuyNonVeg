package com.meat.util;

import org.springframework.core.convert.TypeDescriptor;

/**
 * Registry to maintain the representation details of the models
 *
 * @author rbuddepu
 */
public interface IRepresentationLookupRegistry {

    /**
     * @param modelType
     * @param matchType
     * @return
     */
    TypeDescriptor find(TypeDescriptor modelType, TypeDescriptor matchType);

    /**
     *
     * @param representation
     * @param model
     */
    void register(TypeDescriptor representation, TypeDescriptor model);
}