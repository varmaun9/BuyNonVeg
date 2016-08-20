/**
 *
 */
package com.meat.businessdelegate.service;

import com.meat.businessdelegate.domain.IKeyBuilder;
import com.meat.domain.SubOrder;
import com.meat.domain.SubOrderStatusCode;
import com.meat.model.SubOrderStatusCodeModel;
import com.meat.service.ISubOrderStatusCodeService;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author arthvedi1
 *
 */

@Service
public class SubOrderStatusCodeBusinessDelegate
        implements IBusinessDelegate<SubOrderStatusCodeModel, SubOrderStatusCodeContext, IKeyBuilder<String>, String> {

    @Autowired
    private ISubOrderStatusCodeService subOrderStatusCodeService;
    @Autowired
    private ConversionService conversionService;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#create(com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubOrderStatusCodeModel create(final SubOrderStatusCodeModel model) {

        SubOrderStatusCode subOrderStatusCode = new SubOrderStatusCode();
        SubOrder subOrder = new SubOrder();
        subOrder.setId(model.getSubOrderId());
        subOrderStatusCode.setSubOrder(subOrder);
        subOrderStatusCode.setSubOrderStatusName(model.getSubOrderStatusName());
        subOrderStatusCode.setSubOrderStatusDate(new Date());
        subOrderStatusCode.setSubOrderStatusDescription(model.getSubOrderStatusDescription());
        subOrderStatusCode.setId(model.getId());
        subOrderStatusCode = subOrderStatusCodeService.create(subOrderStatusCode);
        model.setId(subOrderStatusCode.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#delete(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public void delete(final IKeyBuilder<String> keyBuilder, final SubOrderStatusCodeContext context) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#edit(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.domain.IModel)
     */
    @Override
    public SubOrderStatusCodeModel edit(final IKeyBuilder<String> keyBuilder, final SubOrderStatusCodeModel model) {
        SubOrderStatusCode subOrderStatusCode = subOrderStatusCodeService.getSubOrderStatusCode(keyBuilder.build().toString());

        SubOrder subOrder = new SubOrder();
        subOrder.setId(model.getSubOrderId());
        subOrderStatusCode.setSubOrder(subOrder);
        subOrderStatusCode.setSubOrderStatusName(model.getSubOrderStatusName());
        subOrderStatusCode.setSubOrderStatusDate(new Date());
        subOrderStatusCode.setSubOrderStatusDescription(model.getSubOrderStatusDescription());
        subOrderStatusCode.setId(model.getId());
        subOrderStatusCode = subOrderStatusCodeService.updateSubOrderStatusCode(subOrderStatusCode);
        model.setId(subOrderStatusCode.getId());

        return model;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getByKey(com.meat.businessdelegate.domain.IKeyBuilder,
     *      com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public SubOrderStatusCodeModel getByKey(final IKeyBuilder<String> keyBuilder, final SubOrderStatusCodeContext context) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.businessdelegate.service.IBusinessDelegate#getCollection(com.meat.businessdelegate.service.IBusinessDelegateContext)
     */
    @Override
    public Collection<SubOrderStatusCodeModel> getCollection(final SubOrderStatusCodeContext context) {
        // TODO Auto-generated method stub
        return null;
    }

}
