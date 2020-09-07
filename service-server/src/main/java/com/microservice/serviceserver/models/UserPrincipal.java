package com.microservice.serviceserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author Eko Sutrisno
 * @Email ekosutrisno801@gmail.com
 * @Github https://github.com/ekosutrisno
 * @Gitlab https://gitlab.com/ekosutrisno1
 * @Create 06/09/2020 17:35
 */
public class UserPrincipal extends User implements UserDetails {
   private final String username;
   @JsonIgnore
   private final String password;
   private final boolean enabled;
   private final boolean accountNonExpired;
   private final boolean credentialsNonExpired;
   private final boolean accountNonLocked;
   private final Collection<? extends GrantedAuthority> authorities;

   public UserPrincipal(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
      this.username = username;
      this.password = password;
      this.enabled = enabled;
      this.accountNonExpired = accountNonExpired;
      this.credentialsNonExpired = credentialsNonExpired;
      this.accountNonLocked = accountNonLocked;
      this.authorities = authorities;
   }

   public static UserDetails create(User userData) {

      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

      userData.getRoles().forEach(role -> {
         grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
         role.getPermissions().forEach(permission -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
         });
      });

      return new UserPrincipal(
              userData.getUsername(),
              userData.getPassword(),
              userData.isEnabled(),
              userData.isAccountNonExpired(),
              userData.isCredentialsNonExpired(),
              userData.isAccountNonLocked(),
              grantedAuthorities);
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      return authorities;
   }

   @Override
   public String getPassword() {
      return password;
   }

   @Override
   public String getUsername() {
      return username;
   }

   @Override
   public boolean isAccountNonExpired() {
      return accountNonExpired;
   }

   @Override
   public boolean isAccountNonLocked() {
      return accountNonLocked;
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return credentialsNonExpired;
   }

   @Override
   public boolean isEnabled() {
      return enabled;
   }
}
