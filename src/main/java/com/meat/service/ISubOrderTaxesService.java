/**
 *
 */
package com.meat.service;

import com.meat.domain.SubOrderTaxes;

import java.util.List;

/**
 * @author varma
 *
 */
public interface ISubOrderTaxesService {

    SubOrderTaxes create(SubOrderTaxes subOrderTaxes);

    void deleteSubOrderTaxes(String subOrderTaxesId);

    List<SubOrderTaxes> getAll();

    SubOrderTaxes getSubOrderTaxes(String subOrderTaxesId);

    SubOrderTaxes updateSubOrderTaxes(SubOrderTaxes subOrderTaxes);

}
