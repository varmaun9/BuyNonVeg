/**
 *
 */
package com.meat.dao;

import com.meat.domain.UserImages;

import java.io.Serializable;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface UserImagesRepository extends PagingAndSortingRepository<UserImages, Serializable> {

}
