/**
 *
 */
package com.meat.service;

import com.meat.domain.MailConfig;

import java.util.List;

/**
 * @author arthvedi
 *
 */
public interface IMailConfigService {

    MailConfig create(MailConfig mailConfig);

    void deleteMailConfig(String mailConfigId);

    List<MailConfig> getAll();

    MailConfig getMailConfig(String mailConfigId);

    /**
     * @return
     */
    MailConfig getOrderPlacedMailConfig();

    /**
     * @return
     */
    MailConfig getUserAcitvationMailConfig();

    /**
     * @return
     */
    MailConfig getUserForgotPasswordMailConfig();

    /**
     * @return
     */
    MailConfig getUserRegistrationMailConfig();

    /**
     * @return
     */
    MailConfig getUserSubscriptinMailConfig();

    MailConfig updateMailConfig(MailConfig mailConfig);

}
