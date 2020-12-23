package com.microservice.emailservice.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MailService
 */
@Component
public class MailService {

   /**
    * The Logger.
    */
   Logger logger = LoggerFactory.getLogger(MailService.class);

   @Autowired
   private JavaMailSender emailSender;

   @Autowired
   private org.thymeleaf.spring5.SpringTemplateEngine templateEngine;

   /**
    * Sending code verification.
    *
    * @param mail the mail
    * @throws MessagingException the messaging exception
    */
   @Async("threadPoolTaskExecutor")
   public void sendingCodeVerification(Mail mail) throws MessagingException {

      MimeMessage message = emailSender.createMimeMessage();

      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
              StandardCharsets.UTF_8.name());

      Context context = new Context();
      context.setVariables(mail.getModel());
      String html = templateEngine.process("email/verify-code", context);

      helper.setTo(mail.getTo());
      helper.setText(html, true);
      helper.setSubject(mail.getSubject());
      helper.setFrom(mail.getFrom());

      emailSender.send(message);
      logger.info("Email berhasil dikirim");
   }

   /**
    * Send email forgot password.
    *
    * @param mail the mail
    * @throws MessagingException  the messaging exception
    * @throws SendFailedException the send failed exception
    */
   @Async("threadPoolTaskExecutor")
   public void sendEmailForgotPassword(Mail mail) throws MessagingException, SendFailedException {
      MimeMessage message = emailSender.createMimeMessage();

      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
              StandardCharsets.UTF_8.name());

      Context context = new Context();
      context.setVariables(mail.getModel());
      String html = templateEngine.process("email/verify-password", context);

      helper.setTo(mail.getTo());
      helper.setText(html, true);
      helper.setSubject(mail.getSubject());
      helper.setFrom(mail.getFrom());

      emailSender.send(message);
      logger.info("Email berhasil dikirim");
   }

   /**
    * Send email info and news.
    *
    * @param mail the mail
    * @throws MessagingException the messaging exception
    */
   @Async("threadPoolTaskExecutor")
   public void sendEmailInfoAndNews(Mail mail) throws MessagingException {

      MimeMessage message = emailSender.createMimeMessage();

      MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
              StandardCharsets.UTF_8.name());

      Context context = new Context();
      context.setVariables(mail.getModel());
      String html = templateEngine.process("email/verify-code", context);

      List<String> alamatTo = new ArrayList<>();
      Collections.addAll(alamatTo, mail.getTo().split(","));
      alamatTo.forEach(sendAllEmail -> {
         try {
            helper.setTo(sendAllEmail.replace("\\s", ""));
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(mail.getFrom());
            emailSender.send(message);
            logger.info("Email sent to " + sendAllEmail + " success");
         } catch (MessagingException m) {
            logger.info(m.getMessage());
         }
      });
   }
}