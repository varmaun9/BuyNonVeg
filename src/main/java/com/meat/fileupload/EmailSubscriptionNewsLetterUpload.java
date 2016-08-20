/**
 *
 */
package com.meat.fileupload;

import com.meat.domain.EmailSubscription;
import com.meat.service.IEmailSubscriptionService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author varma
 *
 */
@Controller
public class EmailSubscriptionNewsLetterUpload {

    @Autowired
    private IEmailSubscriptionService emailSubscriptionService;

    @RequestMapping(value = "/newsLetter/sendMailsUsingTemplate", method = RequestMethod.POST)
    @ResponseBody
    public List<EmailSubscription> sendMailsUsingTemplate(@RequestParam("htmlTemplate") final MultipartFile htmlTemplate,
            final HttpServletRequest req) {
        List<EmailSubscription> emailSubscriptions = new ArrayList<EmailSubscription>();
        UUID uniqueName = UUID.randomUUID();
        String contentType = htmlTemplate.getContentType();
        if (contentType.equals("text/html")) {
            String webAppPath = (req.getServletContext().getRealPath("/"));
            String fileExtension = htmlTemplate.getOriginalFilename().substring(htmlTemplate.getOriginalFilename().lastIndexOf('.'));
            BufferedOutputStream stream;
            try {

                stream = new BufferedOutputStream(new FileOutputStream(
                        new File(webAppPath + "/../../../src/main/resources/mail/email-templates/newsLetter" + fileExtension)));
                FileCopyUtils.copy(htmlTemplate.getInputStream(), stream);
                stream.close();
                emailSubscriptions = emailSubscriptionService.getEmailSubscriptionSendsMail();

            }
            catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return emailSubscriptions;
    }

}
