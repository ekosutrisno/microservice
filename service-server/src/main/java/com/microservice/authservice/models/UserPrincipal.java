package com.microservice.authservice.models;

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
public class UserPrincipal extends UserEntity implements UserDetails {

   public UserPrincipal(UserEntity userEntity) {
      super(userEntity);
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {

      List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

      getRoles().forEach(role -> {
         grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
         role.getPermissions().forEach(permission -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
         });

      });
      return grantedAuthorities;
   }

   @Override
   public String getPassword() {
      return super.getPassword();
   }

   @Override
   public String getUsername() {
      return super.getUsername();
   }

   @Override
   public boolean isAccountNonExpired() {
      return super.isAccountNonExpired();
   }

   @Override
   public boolean isAccountNonLocked() {
      return super.isAccountNonLocked();
   }

   @Override
   public boolean isCredentialsNonExpired() {
      return super.isCredentialsNonExpired();
   }

   @Override
   public boolean isEnabled() {
      return super.isEnabled();
   }
}
