/**
 *
 */
package com.meat.dao;

import com.meat.domain.Tags;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arthvedi
 *
 */

public interface TagsRepository extends PagingAndSortingRepository<Tags, Serializable> {

    /**
     * @param categoryId
     * @return
     */
    @Query("select t from Tags t join t.categoryTagses ct where ct.category.id=?1")
    List<Tags> findTagsByThymeleafCategory(String categoryId);

}
