package com.microservice.emailservice.controller;

import com.microservice.emailservice.mail.Mail;
import com.microservice.emailservice.mail.MailService;
import com.microservice.emailservice.model.EmailRequest;
import com.microservice.emailservice.model.EmailRequestForgotPassword;
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
 * The type Sending message.
 */
@RestController
@CrossOrigin("*")
@RequestMapping(value = "/message", produces = "application/json")
@Api(produces = "application/json", tags = "Email", description = "Handling Info dan Messaging")
public class SendingMessage {

    private static final String EMAIL_FROM = "mtodo.support@exoapp.com";

    @Autowired
    private MailService mailService;

    /**
     * Sending code verification response entity.
     *
     * @param emailRequest the email request
     * @return the response entity
     * @throws MessagingException the messaging exception
     */
    @PostMapping("/verification")
    @ApiOperation(value = "Code Verification", tags = {"Email"})
    public ResponseEntity<?> sendingCodeVerification(@RequestBody EmailRequest emailRequest) throws MessagingException {
        Mail email = new Mail();

        email.setFrom(EMAIL_FROM);
        email.setTo(emailRequest.getTo());
        email.setSubject(emailRequest.getSubject());

        Map<String, Object> payload = new HashMap<>();
        String token = emailRequest.getToken();
        String username = emailRequest.getUsername();

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

    /**
     * Send email info and news response entity.
     *
     * @param emailRequest the email request
     * @return the response entity
     * @throws MessagingException the messaging exception
     */
    @PostMapping("/info")
    @ApiOperation(value = "Info and News", tags = {"Email"})
    public ResponseEntity<?> sendEmailInfoAndNews(@RequestBody EmailRequest emailRequest) throws MessagingException {
        Mail email = new Mail();

        email.setFrom(EMAIL_FROM);
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

    /**
     * Forgot password response entity.
     *
     * @param emailRequest the email request
     * @param request      the request
     * @return the response entity
     * @throws MessagingException the messaging exception
     */
    @PostMapping("/forgot-password")
    @ApiOperation(value = "Reset Password", tags = {"Email"})
    public ResponseEntity<?> forgotPassword(@RequestBody EmailRequestForgotPassword emailRequest, HttpServletRequest request) throws MessagingException {
        Mail email = new Mail();

        email.setFrom(emailRequest.getFrom());
        email.setTo(emailRequest.getTo());
        email.setSubject(emailRequest.getSubject());

        Map<String, Object> payload = new HashMap<>();

        payload.put("username", emailRequest.getUsername());
        payload.put("ttd", "MTodo Team");
        payload.put("resetUrl", emailRequest.getUrl());

        email.setModel(payload);
        //Sending email
        mailService.sendEmailForgotPassword(email);

        //Generate Response
        Map<String, Object> response = new HashMap<>();
        response.put("ResponseSuccess", email);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
