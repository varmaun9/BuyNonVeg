/**
 *
 */
package com.meat.service;

import com.meat.domain.SubOrderStatusCode;

import java.util.List;

/**
 * @author arthvedi1
 *
 */
public interface ISubOrderStatusCodeService {

    SubOrderStatusCode create(SubOrderStatusCode subOrderStatusCode);

    void deleteSubOrderStatusCode(String subOrderStatusCodeId);

    List<SubOrderStatusCode> getAll();

    SubOrderStatusCode getSubOrderStatusCode(String subOrderStatusCodeId);

    SubOrderStatusCode updateSubOrderStatusCode(SubOrderStatusCode subOrderStatusCode);

}
