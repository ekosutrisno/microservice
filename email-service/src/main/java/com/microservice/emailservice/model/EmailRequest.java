package com.microservice.emailservice.model;

import java.io.Serializable;

/**
 * The type Email request.
 *
 * @Author Eko Sutrisno
 * @Email ekosutrisno801 @gmail.com
 * @Github https ://github.com/ekosutrisno
 * @Gitlab https ://gitlab.com/ekosutrisno1
 * @Create 11 /09/2020 16:29
 */
public class EmailRequest implements Serializable {
   private String from;
   private String to;
   private String subject;

   /**
    * Instantiates a new Email request.
    */
   public EmailRequest() {
   }

   /**
    * Instantiates a new Email request.
    *
    * @param from    the from
    * @param to      the to
    * @param subject the subject
    */
   public EmailRequest(String from, String to, String subject) {
      this.from = from;
      this.to = to;
      this.subject = subject;
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
}
