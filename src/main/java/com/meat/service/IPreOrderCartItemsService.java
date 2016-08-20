/**
 *
 */
package com.meat.service;

import com.meat.domain.PreOrderCartItems;

import java.util.List;

/**
 * @author varma
 *
 */
public interface IPreOrderCartItemsService {
    PreOrderCartItems create(PreOrderCartItems preOrderCartItems);

    /**
     * @param preOrderCartItems
     */
    void deleteBulkPreOrderCartItems(List<PreOrderCartItems> preOrderCartItems);

    void deletePreOrderCartItems(String preOrderCartItemsId);

    /**
     * @param preOrderCartItems
     */
    void deleteSinglePreOrderCartItems(PreOrderCartItems preOrderCartItems);

    List<PreOrderCartItems> getAll();

    /**
     * @param userId
     * @param status
     * @return
     */
    List<PreOrderCartItems> getCartItemsOnly(String userId, String status);

    /**
     * @return
     */
    Integer getMaxCode();

    PreOrderCartItems getPreOrderCartItems(String preOrderCartItemsId);

    /**
     * @param id
     * @param string
     * @param id2
     * @return
     */
    List<PreOrderCartItems> getPreOrderCartItemsBySellerItemUser(String userId, String sellerItemId);

    /**
     * @param sellerItemId
     * @param cartStatusFlag
     * @return
     */
    PreOrderCartItems getPreOrderCartItemsByStatusSellerItemUser(String sellerItemId, String cartStatusFlag, String userId);

    /**
     * @param userId
     * @param status
     * @return preordercartItems
     */
    List<PreOrderCartItems> getPreOrderCartItemsByUserAndStatus(String userId, String status);

    /**
     * @param id
     * @param statusFlag
     * @return
     */
    List<PreOrderCartItems> getPreOrderCartItemsByUserAndStatusFlag(String userId, String statusFlag);

    /**
     * @param id
     * @return
     */
    Integer getPreOrderCartItemsCountWithCommonSellerItem(String id, String userId);

    /**
     * @return
     */
    List<PreOrderCartItems> getPreOrderCartItemsOnly();

    /**
     * @param id
     * @param userId
     * @return
     */
    List<PreOrderCartItems> getPreOrderCartItemsWithCommonSellerItem(String id, String userId);

    /**
     * @param id
     * @param id2
     * @param string
     */

    void removeDuplicateByUserSellerItemStatus(String id, String id2, String string);

    /**
     * @param userId
     * @param status
     * @return preordercartItems
     */
    PreOrderCartItems updatePreOrderCartItems(PreOrderCartItems preOrderCartItems);

}
