package com.microservice.serviceserver.models;

import java.util.UUID;

/**
 * @Author Eko Sutrisno
 * @Create 22/08/2020 23:51
 */
public class User {
   static final String TABLE_NAME = "tbl_user";

   private String userId = UUID.randomUUID().toString();
   private String username;
   private String password;
   private String email;
   private Short enabled;
   private Short accountNonExpired;
   private Short credentialsNonExpired;
   private Short accountNonLocked;

   public User(String username, String password, String email, Short enabled, Short accountNonExpired, Short credentialsNonExpired, Short accountNonLocked) {
      this.username = username;
      this.password = password;
      this.email = email;
      this.enabled = enabled;
      this.accountNonExpired = accountNonExpired;
      this.credentialsNonExpired = credentialsNonExpired;
      this.accountNonLocked = accountNonLocked;
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Short getEnabled() {
      return enabled;
   }

   public void setEnabled(Short enabled) {
      this.enabled = enabled;
   }

   public Short getAccountNonExpired() {
      return accountNonExpired;
   }

   public void setAccountNonExpired(Short accountNonExpired) {
      this.accountNonExpired = accountNonExpired;
   }

   public Short getCredentialsNonExpired() {
      return credentialsNonExpired;
   }

   public void setCredentialsNonExpired(Short credentialsNonExpired) {
      this.credentialsNonExpired = credentialsNonExpired;
   }

   public Short getAccountNonLocked() {
      return accountNonLocked;
   }

   public void setAccountNonLocked(Short accountNonLocked) {
      this.accountNonLocked = accountNonLocked;
   }
}
