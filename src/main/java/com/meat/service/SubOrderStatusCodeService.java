/**
 *
 */
package com.meat.service;

import com.meat.dao.SubOrderStatusCodeRepository;
import com.meat.domain.SubOrderStatusCode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author arthvedi1
 *
 */

@Component
public class SubOrderStatusCodeService implements ISubOrderStatusCodeService {

    @Autowired
    private SubOrderStatusCodeRepository subOrderStatuodeRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderStatusCodeService#create(com.meat.domain.SubOrderStatusCode)
     */
    @Override
    @Transactional
    public SubOrderStatusCode create(final SubOrderStatusCode subOrderStatusCode) {
        // TODO Auto-generated method stub
        return subOrderStatuodeRepository.save(subOrderStatusCode);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderStatusCodeService#deleteSubOrderStatusCode(java.lang.String)
     */
    @Override
    public void deleteSubOrderStatusCode(final String subOrderStatusCodeId) {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderStatusCodeService#getAll()
     */
    @Override
    public List<SubOrderStatusCode> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderStatusCodeService#getSubOrderStatusCode(java.lang.String)
     */
    @Override
    public SubOrderStatusCode getSubOrderStatusCode(final String subOrderStatusCodeId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.ISubOrderStatusCodeService#updateSubOrderStatusCode(com.meat.domain.SubOrderStatusCode)
     */
    @Override
    public SubOrderStatusCode updateSubOrderStatusCode(final SubOrderStatusCode subOrderStatusCode) {
        // TODO Auto-generated method stub
        return null;
    }

}
