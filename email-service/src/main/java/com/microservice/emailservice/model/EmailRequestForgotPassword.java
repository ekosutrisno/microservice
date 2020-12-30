package com.microservice.emailservice.model;

import java.io.Serializable;

/**
 * The type Email request forgot password.
 */
public class EmailRequestForgotPassword implements Serializable {
   private String from;
   private String to;
   private String subject;
   private String username;
   private String token;
   private String url;

    /**
     * Instantiates a new Email request forgot password.
     *
     * @param from     the from
     * @param to       the to
     * @param subject  the subject
     * @param username the username
     * @param token    the token
     * @param url      the url
     */
    public EmailRequestForgotPassword(String from, String to, String subject, String username, String token, String url) {
      this.from = from;
      this.to = to;
      this.subject = subject;
      this.username = username;
      this.token = token;
      this.url = url;
   }

    /**
     * Instantiates a new Email request forgot password.
     */
    public EmailRequestForgotPassword() {
   }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
      return url;
   }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
      this.url = url;
   }

    /**
     * Gets from.
     *
     * @return the from
     */
    public String getFrom() {
      return from;
   }

    /**
     * Sets from.
     *
     * @param from the from
     */
    public void setFrom(String from) {
      this.from = from;
   }

    /**
     * Gets to.
     *
     * @return the to
     */
    public String getTo() {
      return to;
   }

    /**
     * Sets to.
     *
     * @param to the to
     */
    public void setTo(String to) {
      this.to = to;
   }

    /**
     * Gets subject.
     *
     * @return the subject
     */
    public String getSubject() {
      return subject;
   }

    /**
     * Sets subject.
     *
     * @param subject the subject
     */
    public void setSubject(String subject) {
      this.subject = subject;
   }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
      return username;
   }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
      this.username = username;
   }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
      return token;
   }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
      this.token = token;
   }
}
