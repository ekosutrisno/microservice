package com.microservice.authservice.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Create 22/08/2020 23:51
 */
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity implements Serializable  {
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

   public UserEntity() {
   }

   public UserEntity(UserEntity user) {
      this.id= user.getId();
      this.username = user.getUsername();
      this.password = user.getPassword();
      this.email = user.getEmail();
      this.enabled = user.isEnabled();
      this.accountNonExpired = user.isAccountNonExpired();
      this.credentialsNonExpired = user.isCredentialsNonExpired();
      this.accountNonLocked = user.isAccountNonLocked();
      this.roles = user.getRoles();
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
