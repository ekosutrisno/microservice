package com.microservice.emailservice.controller;

import com.microservice.emailservice.mail.Mail;
import com.microservice.emailservice.mail.MailService;
import com.microservice.emailservice.model.EmailRequest;
import com.microservice.emailservice.util.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author Eko Sutrisno
 * @Email ekosutrisno801@gmail.com
 * @Github https://github.com/ekosutrisno
 * @Gitlab https://gitlab.com/ekosutrisno1
 * @Create 11/09/2020 16:27
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/message", produces = "application/json")
@Api(produces = "application/json", tags = "Email", description = "Handling Info dan Messaging")
public class SendingMessage {

   @Autowired
   private MailService mailService;
   @Autowired
   private PasswordEncoder passwordEncoder;

   @PostMapping("/sendCodeVerification")
   @ApiOperation(value = "Code Verification", tags = {"Email"})
   public ResponseEntity<?> sendingCodeVerification(@RequestBody EmailRequest emailRequest) throws MessagingException {
      Mail email = new Mail();

      email.setFrom(emailRequest.getFrom());
      email.setTo(emailRequest.getTo());
      email.setSubject(emailRequest.getSubject());

      Map<String, Object> payload = new HashMap<>();
      String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();
      String username = "Eko Sutrisno";

      payload.put("token", token);
      payload.put("username", username);
      email.setModel(payload);

      //Sending Info And News
      mailService.sendingCodeVerification(email);

      //Generate Response
      Map<String, Object> response = new HashMap<>();
      response.put("ResponseSuccess", email);

      return new ResponseEntity<>(response, HttpStatus.OK);
   }

   @PostMapping("/sendInfoAndNews")
   @ApiOperation(value = "Info and News", tags = {"Email"})
   public ResponseEntity<?> sendEmailInfoAndNews(@RequestBody EmailRequest emailRequest) throws MessagingException {
      Mail email = new Mail();

      email.setFrom(emailRequest.getFrom());
      email.setTo(emailRequest.getTo());
      email.setSubject(emailRequest.getSubject());

      Map<String, Object> payload = new HashMap<>();
      String token = RandomUtil.generateRandomStringNumber(6).toUpperCase();
      String username = "Eko Sutrisno";

      payload.put("token", token);
      payload.put("username", username);
      email.setModel(payload);

      //Sending Info And News
      mailService.sendEmailInfoAndNews(email);

      //Generate Response
      Map<String, Object> response = new HashMap<>();
      response.put("ResponseSuccess", email);

      return new ResponseEntity<>(response, HttpStatus.OK);
   }

   @PostMapping("/forgotPassword")
   @ApiOperation(value = "Reset Password", tags = {"Email"})
   public ResponseEntity<?> forgotPassword(@RequestBody EmailRequest emailRequest, HttpServletRequest request) throws MessagingException {
      Mail email = new Mail();

      email.setFrom(emailRequest.getFrom());
      email.setTo(emailRequest.getTo());
      email.setSubject(emailRequest.getSubject());

      Map<String, Object> payload = new HashMap<>();
      String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
      UUID token = UUID.randomUUID();

      payload.put("username", "Eko Sutrisno");
      payload.put("ttd", "Team Supports");
      payload.put("resetUrl", url + "/reset-password?token=" + passwordEncoder.encode(token.toString()));

      email.setModel(payload);
      //Sending email
      mailService.sendEmailForgotPassword(email);

      //Generate Response
      Map<String, Object> response = new HashMap<>();
      response.put("ResponseSuccess", email);

      return new ResponseEntity<>(response, HttpStatus.OK);
   }
}
