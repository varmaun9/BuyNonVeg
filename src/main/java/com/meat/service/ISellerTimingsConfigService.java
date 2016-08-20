/**
 *
 */
package com.meat.service;

import com.meat.domain.SellerTimingsConfig;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface ISellerTimingsConfigService {

    SellerTimingsConfig create(SellerTimingsConfig sellerTimingsConfig);

    void deleteSellerTimingsConfig(String sellerTimingsConfigId);

    List<SellerTimingsConfig> getAll();

    SellerTimingsConfig getSellerTimingsConfig(String sellerTimingsConfigId);

    SellerTimingsConfig updateSellerTimingsConfig(SellerTimingsConfig sellerTimingsConfig);

}
