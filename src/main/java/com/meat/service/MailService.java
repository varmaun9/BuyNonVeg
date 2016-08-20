/**
 *
 */
package com.meat.service;

import com.meat.domain.*;
import com.meat.mail.Mail;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author varma
 *
 */
@Component
@ImportResource("classpath:spring-thymeleaf.xml")
@PropertySource("classpath:mail.properties")
@PropertySource("classpath:application.properties")
public class MailService implements IMailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    @Value("${mail.from}")
    private String mailFrom;
    @Value("${mail.username}")
    private String mailUserName;
    @Value("${url}")
    private String url;

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMailService#sendOrderPlacedMail(com.meat.mail.Mail, com.meat.domain.Users, com.meat.domain.Orders)
     */
    @Override
    public void sendOrderPlacedMail(final Mail mail, final Users users, final Orders orders, final OrderDeliveryOptions shippingAddress) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                Context context = new Context();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                // final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, ;
                context.setVariable("users", users);
                context.setVariable("orders", orders);
                context.setVariable("shippingAddress", shippingAddress);
                /*context.setVariable("orderCode", orders.getOrderCode());
                context.setVariable("orderPlacedDate", orders.getOrderCreatedDate());*/
                message.setTo(mail.getMailTo());
                message.setSubject(mail.getMailSubject());
                message.setFrom(mail.getMailFrom());
                String html = templateEngine.process("email-templates/orderplaced", context);
                //String text = ("Hi Example Test email hiuigfxflkjfdsax");

                message.setText(html, true);

            }

        };
        //Send email using the autowired mailSender
        mailSender.send(preparator);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMailService#sendSellerUserPasswordResetMail(com.meat.mail.Mail, com.meat.domain.SellerUser)
     */
    @Override
    public void sendSellerUserPasswordResetMail(final Mail mail, final SellerUser sellerUser) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                Context context = new Context();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                context.setVariable("userName", sellerUser.getUserName());
                String activationurl = url + "/resetsupassword?id=" + sellerUser.getUsers().getId();
                context.setVariable("activationurl", activationurl);
                message.setTo(mail.getMailTo());
                message.setSubject(mail.getMailSubject());
                message.setFrom(mail.getMailFrom());
                String html = templateEngine.process("email-templates/recoverpassword", context);
                message.setText(html, true);

            }

        };
        //Send email using the autowired mailSender
        mailSender.send(preparator);

    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMailService#sendUserActivationMail(com.meat.mail.Mail, com.meat.domain.Users)
     */
    @Override
    public void sendUserActivationMail(final Mail mail, final Users users) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                Context context = new Context();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                context.setVariable("userName", users.getUserName());
                /*  String activationurl = url + "/useractivation/" + users.getId();
                context.setVariable("activationurl", activationurl);*/
                message.setTo(mail.getMailTo());
                message.setSubject(mail.getMailSubject());
                message.setFrom(mail.getMailFrom());
                String html = templateEngine.process("email-templates/accountactivationsuccess", context);
                message.setText(html, true);

            }

        };
        //Send email using the autowired mailSender
        mailSender.send(preparator);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMailService#sendUserPasswordResetMail(com.meat.mail.Mail, com.meat.domain.Users)
     */
    @Override
    public void sendUserPasswordResetMail(final Mail mail, final Users users) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                Context context = new Context();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                context.setVariable("userName", users.getUserName());
                String resetPasswordUrl = url + "/resetpassword?id=" + users.getId();
                context.setVariable("resetPasswordUrl", resetPasswordUrl);
                message.setTo(mail.getMailTo());
                message.setSubject(mail.getMailSubject());
                message.setFrom(mail.getMailFrom());
                String html = templateEngine.process("email-templates/recoverpassword", context);
                message.setText(html, true);

            }

        };
        //Send email using the autowired mailSender
        mailSender.send(preparator);
    }

    /**
     * {@inheritDoc}
     *
     * @see com.meat.service.IMailService#sendUserActivationMail(com.meat.mail.Mail, com.meat.domain.Users)
     */
    @Override
    public void sendUserRegistraionMail(final Mail mail, final Users users) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(final MimeMessage mimeMessage) throws Exception {
                Context context = new Context();
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                context.setVariable("userName", users.getUserName());
                String activationurl = url + "/useractivation/" + users.getId();
                context.setVariable("activationurl", activationurl);
                message.setTo(mail.getMailTo());
                message.setSubject(mail.getMailSubject());
                message.setFrom(mail.getMailFrom());
                String html = templateEngine.process("email-templates/accountactivation", context);
                message.setText(html, true);

            }

        };
        //Send email using the autowired mailSender
        mailSender.send(preparator);
    }

    /**
     * {@inheritDoc}
     *
     * @return
     *
     * @see com.meat.service.IMailService#sendUserSubscribedMail(com.meat.mail.Mail, com.meat.domain.Users)
     */
    @Override
    public List<EmailSubscription> sendUserSubscribedMail(final Mail mail, final List<EmailSubscription> emailSubscriptions) {

        for (final EmailSubscription emailSubscription : emailSubscriptions) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mail.getMailFrom());
            message.setTo(mail.getMailTo());
            message.setSubject(mail.getMailSubject());
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(final MimeMessage mimeMessage) throws Exception {
                    Context context = new Context();
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                    //  context.setVariable("userName", users.getUserName());
                    message.setTo(emailSubscription.getUserEmail());
                    message.setSubject(mail.getMailSubject());
                    message.setFrom(mail.getMailFrom());
                    String html = templateEngine.process("email-templates/accountactivation", context);
                    message.setText(html, true);
                }
            };
            //Send email using the autowired mailSender
            mailSender.send(preparator);
        }
        return emailSubscriptions;
    }

    @Override
    public List<EmailSubscription> sendUserSubscribedMail(final Mail mail, final List<EmailSubscription> emailSubscriptions,
            final String templateName) {

        for (final EmailSubscription emailSubscription : emailSubscriptions) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mail.getMailFrom());
            message.setTo(mail.getMailTo());
            message.setSubject(mail.getMailSubject());
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @Override
                public void prepare(final MimeMessage mimeMessage) throws Exception {
                    Context context = new Context();
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
                    message.setTo(emailSubscription.getUserEmail());
                    message.setSubject(mail.getMailSubject());
                    message.setFrom(mail.getMailFrom());
                    String html = templateEngine.process("email-templates/newsLetter", context);
                    message.setText(html, true);
                }
            };
            //Send email using the autowired mailSender
            mailSender.send(preparator);
        }
        return emailSubscriptions;
    }
}
