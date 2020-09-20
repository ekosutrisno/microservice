package com.microservice.emailservice.model;

import java.io.Serializable;

/**
 * @Author Eko Sutrisno
 * @Email ekosutrisno801@gmail.com
 * @Github https://github.com/ekosutrisno
 * @Gitlab https://gitlab.com/ekosutrisno1
 * @Create 11/09/2020 16:29
 */
public class EmailRequest implements Serializable {
   private String from;
   private String to;
   private String subject;

   public EmailRequest() {
   }

   public EmailRequest(String from, String to, String subject) {
      this.from = from;
      this.to = to;
      this.subject = subject;
   }

   public String getFrom() {
      return from;
   }

   public void setFrom(String from) {
      this.from = from;
   }

   public String getTo() {
      return to;
   }

   public void setTo(String to) {
      this.to = to;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }
}
