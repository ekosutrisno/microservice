package com.microservice.emailservice.mail;

import java.io.Serializable;
import java.util.Map;

/**
 * Mail
 */
public class Mail implements Serializable {

  private String from;
  private String to;
  private String subject;
  private Map<String, Object> model;

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
   * Gets model.
   *
   * @return the model
   */
  public Map<String, Object> getModel() {
    return model;
  }

  /**
   * Sets model.
   *
   * @param model the model
   */
  public void setModel(Map<String, Object> model) {
    this.model = model;
  }

}