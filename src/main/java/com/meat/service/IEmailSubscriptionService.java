/**
 *
 */
package com.meat.service;

import com.meat.domain.EmailSubscription;

import java.util.List;

/**
 * @author varma
 *
 */
public interface IEmailSubscriptionService {

    EmailSubscription create(EmailSubscription emailSubscription);

    void deleteEmailSubscription(String emailSubscriptionId);

    List<EmailSubscription> getAll();

    EmailSubscription getEmailSubscription(String emailSubscriptionId);

    /**
     * @param userEmail
     * @return
     */
    EmailSubscription getEmailSubscriptionByEmail(String userEmail);

    /**
     * @return
     */
    List<EmailSubscription> getEmailSubscriptionSendsMail();

    EmailSubscription updateEmailSubscription(EmailSubscription emailSubscription);

}
