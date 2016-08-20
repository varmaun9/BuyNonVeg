/**
 *
 */
package com.meat.dao;

import com.meat.domain.EmailSubscription;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author varma
 *
 */
public interface EmailSubscriptionRepository extends PagingAndSortingRepository<EmailSubscription, Serializable> {

    /**
     * @return
     */

    /**
     * @return
     */
    @Query("SELECT DISTINCT es from EmailSubscription es WHERE es.subscriptionStatus='SUBSCRIBED'")
    List<EmailSubscription> findAllSubscribedUserEmails();

    /**
     * @param emailId
     * @return
     */
    @Query("SELECT DISTINCT es from EmailSubscription es WHERE es.userEmail=?1")
    EmailSubscription findByEmailId(final String emailId);

}
