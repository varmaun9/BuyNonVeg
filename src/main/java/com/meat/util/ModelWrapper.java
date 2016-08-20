package com.meat.util;

import com.meat.businessdelegate.domain.IModel;

import org.springframework.core.convert.TypeDescriptor;

/**
 * Implementation class of IModelWrarpper class to hold Model Object with type descriptor
 *
 * @author rbuddepu
 *
 * @param <T>
 */
public class ModelWrapper<T extends IModel> implements IModelWrapper<T> {

    private TypeDescriptor modelDescriptor;
    private T modelObject;

    /**
     * Constructor for ModelWrapper
     *
     * @param modelClass
     * @param modelObject
     */
    public ModelWrapper(final Class<T> modelClass, final T modelObject) {
        super();
        this.modelDescriptor = TypeDescriptor.valueOf(modelClass);
        this.modelObject = modelObject;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.model.IModelWrapper#getModel()
     */
    @Override
    public T getModel() {
        return modelObject;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.cscinfo.entity.util.model.IModelWrapper#getModelType()
     */
    @Override
    public TypeDescriptor getModelType() {
        return modelDescriptor;
    }
}
