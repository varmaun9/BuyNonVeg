/**
 *
 */
package com.meat.dao;

import com.meat.domain.PreOrderCartItems;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */
public interface PreOrderCartItemsRepository extends PagingAndSortingRepository<PreOrderCartItems, Serializable> {

    /**
     * @param sellerItemId
     * @param usersId
     * @param status
     */
    @Query("DELETE FROM PreOrderCartItems poci WHERE poci.sellerItem.id = ?1 AND poci.users.id = ?2 AND poci.statusFlag = ?3")
    void deletePreOrderCartItemsBySelleItemUserStatus(String sellerItemId, String usersId, String status);

    /**
     * @param usersId
     * @param statusFlag
     * @return
     */
    @Query("select poci from PreOrderCartItems poci where poci.users.id=?1 and poci.statusFlag=?2 ")
    PreOrderCartItems findBySellerItemAndStatus(String usersId, String statusFlag);

    /**
     * @param sellerItemId
     * @param cartStatusFlag
     * @param userId
     * @return
     */
    @Query("SELECT poci FROM PreOrderCartItems poci WHERE poci.sellerItem.id=?1 AND poci.statusFlag=?2 AND poci.users.id=?3")
    PreOrderCartItems findBySellerItemAndStatusAndUser(String sellerItemId, String cartStatusFlag, String userId);

    /* *//**
          * @param usersId
          * @param sellerItemId
          * @param statusFlag
          * @return
          *//*
           @Query("select poci from PreOrderCartItems poci where poci.users.id=?1 and poci.sellerItem.id=?2 and poci.statusFlag=?3 ")
           PreOrderCartItems findBySellerItemIdAndStatus(String usersId, String sellerItemId, String statusFlag);*/

    /**
     * @param sellerItemId
     * @param userId
     * @return
     */
    @Query("SELECT poci FROM PreOrderCartItems poci WHERE poci.users.id=?2 AND poci.sellerItem.id=?1")
    PreOrderCartItems findBySellerItemAndUser(String sellerItemId, String userId);

    /**
     * @param userId
     * @param status
     * @return
     */
    @Query("select distinct pocit from PreOrderCartItems pocit where pocit.users.id=?1 and pocit.status=?2")
    List<PreOrderCartItems> findCartItemsOnly(String userId, String status);

    /**
     * @param userId
     * @param status
     * @return preOrderCart Items
     */
    @Query("SELECT poci FROM PreOrderCartItems poci JOIN poci.users u WHERE u.id=?1 AND poci.status = ?2")
    List<PreOrderCartItems> findPreOrderCartItemsByUserIdAndStatus(String userId, String status);

    /**
     * @param userId
     * @param statusFlag
     * @return
     */
    @Query("SELECT poci FROM PreOrderCartItems poci JOIN poci.users u WHERE u.id=?1 AND poci.statusFlag = ?2")
    List<PreOrderCartItems> findPreOrderCartItemsByUserIdAndStatusFlag(String userId, String statusFlag);

    /**
     * @param userId
     * @param sellerItemId
     * @return
     */
    @Query("SELECT poci FROM PreOrderCartItems poci WHERE poci.users.id = ?1 AND poci.sellerItem.id=?2")
    List<PreOrderCartItems> findPreOrderCartItemsByUserSellerItem(String userId, String sellerItemId);

    /**
     * @param id
     * @param userId
     * @return
     */
    @Query("SELECT poc FROM PreOrderCartItems poc JOIN poc.users u JOIN poc.sellerItem si WHERE u.id = ?2 AND si.id = ?1 ORDER BY poc.statusFlag")
    List<PreOrderCartItems> findPreOrderUserSellerItemsByseller(String id, String userId);

    /**
     * @param id
     * @param userId
     * @return
     */
    @Query("SELECT COUNT(poc) FROM PreOrderCartItems poc JOIN poc.users u JOIN poc.sellerItem si WHERE u.id = ?2 AND si.id = ?1")
    Integer findPreOrderUserSellerItemsCountByseller(String id, String userId);

    /**
     * @return
     */
    /*  *//**
           * @return
           */
    /*
    @Query("select MAX(categoryCount) from Category c")
    Integer getMaxCode();
    
    }*/
    @Query("select MAX(preOrderCartItemsCount) from PreOrderCartItems poci")
    Integer getMaxCode();

    /**
     * @param userId
     * @param id
     * @return
     */
    @Query("select poci from PreOrderCartItems poci where poci.users.id=?1 and poci.sellerItem.id=?2 and poci.preOrderCartItemsCode like '%QCART%'")
    List<PreOrderCartItems> getPreOrderCartRItmsByQCart(String userId, String id);

    /**
     * @param userId
     * @param status
     * @return
     */
    @Query("select distinct pocit from PreOrderCartItems pocit where pocit.users=?1 and pocit.statusFlag=?2")
    PreOrderCartItems getQuickPreOrderCartItems(String userId, String statusFlag);

}
