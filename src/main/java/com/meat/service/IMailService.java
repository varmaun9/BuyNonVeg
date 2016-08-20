/**
 *
 */
package com.meat.service;

import com.meat.domain.*;
import com.meat.mail.Mail;

import java.util.List;

/**
 * @author varma
 *
 */
public interface IMailService {

    /**
     * @param mail
     * @param users
     * @param orders
     * @param shippingAddress
     */
    void sendOrderPlacedMail(Mail mail, Users users, Orders orders, OrderDeliveryOptions shippingAddress);

    /**
     * @param mail
     * @param sellerUser
     */
    void sendSellerUserPasswordResetMail(Mail mail, SellerUser sellerUser);

    /**
     * @param mail
     * @param users
     */
    void sendUserActivationMail(Mail mail, Users users);

    /**
     * @param mail
     * @param user
     */
    void sendUserPasswordResetMail(Mail mail, Users user);

    /**
     * @param mail
     * @param users
     */
    void sendUserRegistraionMail(Mail mail, Users users);

    List<EmailSubscription> sendUserSubscribedMail(Mail mail, List<EmailSubscription> emailSubscriptions);

    /**
     * @param mail
     * @param emailSubscriptions
     * @param templateName
     * @return
     */
    List<EmailSubscription> sendUserSubscribedMail(Mail mail, List<EmailSubscription> emailSubscriptions, String templateName);

}
