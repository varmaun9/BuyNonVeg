/**
 *
 */
package com.meat.service;

import com.meat.dao.PreOrderCartItemsRepository;
import com.meat.domain.PreOrderCartItems;
import com.meat.domain.SellerItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author arthvedi
 *
 */
@Component
public class PreOrderCartItemsService implements IPreOrderCartItemsService {

    @Autowired
    private PreOrderCartItemsRepository preOrderCartItemsRepository;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#create(com.meat.domain.PreOrderCartItems)
     */
    @Override
    @Transactional
    public PreOrderCartItems create(final PreOrderCartItems preOrderCartItems) {

        return preOrderCartItemsRepository.save(preOrderCartItems);
    }

    @Override
    public void deleteBulkPreOrderCartItems(final List<PreOrderCartItems> preOrderCartItems) {
        preOrderCartItemsRepository.delete(preOrderCartItems);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#deletePreOrderCartItems(java.lang.String)
     */
    @Override
    public void deletePreOrderCartItems(final String preOrderCartItemsId) {
        PreOrderCartItems poci = new PreOrderCartItems();
        poci.setId(preOrderCartItemsId);
        preOrderCartItemsRepository.delete(poci);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#delete(com.meat.domain.PreOrderCartItems)
     */
    @Override
    public void deleteSinglePreOrderCartItems(final PreOrderCartItems preOrderCartItems) {
        // TODO Auto-generated method stub
        preOrderCartItemsRepository.delete(preOrderCartItems);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getAll()
     */

    @Override
    @Transactional
    public List<PreOrderCartItems> getAll() {
        List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();
        preOrderCartItems = (List<PreOrderCartItems>) preOrderCartItemsRepository.findAll();
        return preOrderCartItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getCartItemsOnly(java.lang.String, java.lang.String)
     */
    @Override
    public List<PreOrderCartItems> getCartItemsOnly(final String userId, final String status) {
        List<PreOrderCartItems> pocis = preOrderCartItemsRepository.findCartItemsOnly(userId, status);
        List<PreOrderCartItems> proics = new ArrayList<PreOrderCartItems>();
        if (pocis != null) {
            String statusFlag = "QC";
            PreOrderCartItems porderCartItm = preOrderCartItemsRepository.getQuickPreOrderCartItems(userId, statusFlag);
            if (porderCartItm != null) {
                PreOrderCartItems po = new PreOrderCartItems();
                porderCartItm.setStatusFlag("C");
                po = preOrderCartItemsRepository.save(porderCartItm);//setting all Quick Cart to Cart
                List<PreOrderCartItems> porCartItems = null;
                if (po.getSellerItem() != null) {
                    porCartItems = preOrderCartItemsRepository.getPreOrderCartRItmsByQCart(userId, po.getSellerItem().getId());
                }
                if (porCartItems != null) {
                    preOrderCartItemsRepository.delete(porCartItems);// deleting duplicate items
                }
            }

            for (PreOrderCartItems pois : pocis) {// repo order items
                PreOrderCartItems poci = new PreOrderCartItems();
                poci.setId(pois.getId());
                poci.setDeliveryTime(pois.getDeliveryTime());
                poci.setPrice(pois.getPrice());
                poci.setQuantity(pois.getQuantity());
                poci.setCartPrice(pois.getCartPrice());
                poci.setUnits(pois.getUnits());
                poci.setStatus(pois.getStatus());
                poci.setPreOrderCartItemsCode(pois.getPreOrderCartItemsCode());
                if (pois.getDeliveryDate() != null) {
                    poci.setDeliveryDate(pois.getDeliveryDate());
                }
                Date fd = null;
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                String ds1 = null;
                if (poci.getDeliveryDate() != null) {
                    ds1 = poci.getDeliveryDate().toString();
                }
                if (ds1 != null) {
                    try {
                        String space = ds1;
                        String[] words = space.split("\\s");
                        for (String word : words) {
                        }
                        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
                        String f1 = sdf2.format(sdf3.parse(words[0]));
                        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
                        Date f = sdf4.parse(f1);
                        poci.setDeliveryDate(f);
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

                SellerItem si = new SellerItem();
                si.setId(pois.getSellerItem().getId());
                si.setSellerItemName(pois.getSellerItem().getSellerItemName());
                si.setItem(pois.getSellerItem().getItem());
                si.setItemAvailableStatus(pois.getSellerItem().getItemAvailableStatus());
                si.setSellerBranch(pois.getSellerItem().getSellerBranch());
                poci.setSellerItem(si);
                proics.add(poci);
            }
        }

        return proics;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getMaxCode()
     */
    @Override
    public Integer getMaxCode() {
        // TODO Auto-generated method stub
        return preOrderCartItemsRepository.getMaxCode();
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItems(java.lang.String)
     */

    @Override
    public PreOrderCartItems getPreOrderCartItems(final String preOrderCartItemsId) {
        PreOrderCartItems preOrderCartItems = new PreOrderCartItems();
        preOrderCartItems = preOrderCartItemsRepository.findOne(preOrderCartItemsId);
        return preOrderCartItems;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItemsBySellerItemUser(java.lang.String, java.lang.String)
     */
    @Override
    public List<PreOrderCartItems> getPreOrderCartItemsBySellerItemUser(final String userId, final String sellerItemId) {
        // TODO Auto-generated method stub
        return preOrderCartItemsRepository.findPreOrderCartItemsByUserSellerItem(userId, sellerItemId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItemsByStatusSellerItem(java.lang.String, java.lang.String)
     */

    @Override
    public PreOrderCartItems getPreOrderCartItemsByStatusSellerItemUser(final String sellerItemId, final String cartStatusFlag,
            final String userId) {

        if (!cartStatusFlag.equals("ALL")) {
            return preOrderCartItemsRepository.findBySellerItemAndStatusAndUser(sellerItemId, cartStatusFlag, userId);
        }
        else {
            return preOrderCartItemsRepository.findBySellerItemAndUser(sellerItemId, userId);
        }
    }

    @Override
    public List<PreOrderCartItems> getPreOrderCartItemsByUserAndStatus(final String userId, final String status) {

        List<PreOrderCartItems> poci = preOrderCartItemsRepository.findPreOrderCartItemsByUserIdAndStatus(userId, status);

        return poci;

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItemsByUserAndStatusFlag(java.lang.String, java.lang.String)
     */
    @Override
    public List<PreOrderCartItems> getPreOrderCartItemsByUserAndStatusFlag(final String userId, final String statusFlag) {
        List<PreOrderCartItems> poci = preOrderCartItemsRepository.findPreOrderCartItemsByUserIdAndStatusFlag(userId, statusFlag);

        return poci;
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItemsCountWithCommonSellerItem(java.lang.String)
     */
    @Override
    public Integer getPreOrderCartItemsCountWithCommonSellerItem(final String id, final String userId) {
        // TODO Auto-generated method stub
        return preOrderCartItemsRepository.findPreOrderUserSellerItemsCountByseller(id, userId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#getPreOrderCartItemsOnly()
     */

    @Override
    public List<PreOrderCartItems> getPreOrderCartItemsOnly() {
        List<PreOrderCartItems> preOrderCartItems = new ArrayList<PreOrderCartItems>();
        preOrderCartItems = (List<PreOrderCartItems>) preOrderCartItemsRepository.findAll();
        List<PreOrderCartItems> preOrderCartItemses = new ArrayList<PreOrderCartItems>();
        for (PreOrderCartItems p : preOrderCartItems) {
            PreOrderCartItems poci = new PreOrderCartItems();
            poci.setUsers(p.getUsers());
            poci.setSellerItem(p.getSellerItem());
            poci.setTimings(p.getTimings());
            poci.setQuantity(p.getQuantity());
            poci.setPrice(p.getPrice());
            poci.setUnits(p.getUnits());
            poci.setDeliveryDate(p.getDeliveryDate());
            poci.setDeliveryTime(p.getDeliveryTime());
            poci.setStatus(p.getStatus());
            poci.setPreOrderCartItemsCode(p.getPreOrderCartItemsCode());
            poci.setPreOrderCartItemsCount(p.getPreOrderCartItemsCount());
            poci.setCreatedDate(new Date());
            poci.setStatusFlag(p.getStatusFlag());
            poci.setTimingName(p.getTimingName());
            poci.setModifiedDate(new Date());
            poci.setCartPrice(p.getCartPrice());
            preOrderCartItemses.add(poci);
        }
        return preOrderCartItemses;
    }

    @Override
    public List<PreOrderCartItems> getPreOrderCartItemsWithCommonSellerItem(final String id, final String userId) {
        // TODO Auto-generated method stub
        return preOrderCartItemsRepository.findPreOrderUserSellerItemsByseller(id, userId);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#removeDuplicateByUserSellerItemStatus(java.lang.String, java.lang.String,
     *      java.lang.String)
     */
    @Override
    public void removeDuplicateByUserSellerItemStatus(final String sellerItemId, final String usersId, final String status) {
        // TODO Auto-generated method stub
        preOrderCartItemsRepository.deletePreOrderCartItemsBySelleItemUserStatus(sellerItemId, usersId, status);

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IPreOrderCartItemsService#updatePreOrderCartItems(com.meat.domain.PreOrderCartItems)
     */
    @Override
    public PreOrderCartItems updatePreOrderCartItems(final PreOrderCartItems preOrderCartItems) {
        // TODO Auto-generated method stub
        return preOrderCartItemsRepository.save(preOrderCartItems);
    }

}
