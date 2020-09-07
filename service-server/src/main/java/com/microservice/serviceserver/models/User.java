package com.microservice.serviceserver.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 22/08/2020 23:51
 */
@Entity
@Table(name = User.TABLE_NAME)
public class User implements Serializable {
   static final String TABLE_NAME = "tbl_user";

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "username")
   private String username;
   @Column(name = "password")
   private String password;
   @Column(name = "email")
   private String email;
   @Column(name = "enabled")
   private boolean enabled;
   @Column(name = "account_non_expired")
   private boolean accountNonExpired;
   @Column(name = "credentials_non_expired")
   private boolean credentialsNonExpired;
   @Column(name = "account_non_locked")
   private boolean accountNonLocked;

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
           inverseJoinColumns = {
                   @JoinColumn(name = "role_id", referencedColumnName = "id")})
   private List<Role> roles;

   public User() {
   }

   public User(Long id, String username, String password, String email, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, List<Role> roles) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.email = email;
      this.enabled = enabled;
      this.accountNonExpired = accountNonExpired;
      this.credentialsNonExpired = credentialsNonExpired;
      this.accountNonLocked = accountNonLocked;
      this.roles = roles;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public boolean isEnabled() {
      return enabled;
   }

   public void setEnabled(boolean enabled) {
      this.enabled = enabled;
   }

   public boolean isAccountNonExpired() {
      return accountNonExpired;
   }

   public void setAccountNonExpired(boolean accountNonExpired) {
      this.accountNonExpired = accountNonExpired;
   }

   public boolean isCredentialsNonExpired() {
      return credentialsNonExpired;
   }

   public void setCredentialsNonExpired(boolean credentialsNonExpired) {
      this.credentialsNonExpired = credentialsNonExpired;
   }

   public boolean isAccountNonLocked() {
      return accountNonLocked;
   }

   public void setAccountNonLocked(boolean accountNonLocked) {
      this.accountNonLocked = accountNonLocked;
   }

   public List<Role> getRoles() {
      return roles;
   }

   public void setRoles(List<Role> roles) {
      this.roles = roles;
   }
}
