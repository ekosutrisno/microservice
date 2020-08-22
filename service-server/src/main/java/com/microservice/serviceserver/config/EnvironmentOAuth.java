package com.microservice.serviceserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Eko Sutrisno
 * @create 22/08/2020 23:00
 */
@Configuration
@ConfigurationProperties("config.oauth2")
public class EnvironmentOAuth {
   private String privatekey;
   private String publickey;
   private Boolean usejdbcstoretoken;
   private Boolean usejwttokenconverter;

   public String getPrivatekey() {
      return privatekey;
   }

   public void setPrivatekey(String privatekey) {
      this.privatekey = privatekey;
   }

   public String getPublickey() {
      return publickey;
   }

   public void setPublickey(String publickey) {
      this.publickey = publickey;
   }

   public Boolean getUsejdbcstoretoken() {
      return usejdbcstoretoken;
   }

   public void setUsejdbcstoretoken(Boolean usejdbcstoretoken) {
      this.usejdbcstoretoken = usejdbcstoretoken;
   }

   public Boolean getUsejwttokenconverter() {
      return usejwttokenconverter;
   }

   public void setUsejwttokenconverter(Boolean usejwttokenconverter) {
      this.usejwttokenconverter = usejwttokenconverter;
   }
}
