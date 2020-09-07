package com.microservice.serviceserver.services;

import com.microservice.serviceserver.repository.UserDetailRepository;
import com.microservice.serviceserver.models.UserPrincipal;
import com.microservice.serviceserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * @Author Eko Sutrisno
 * @Email ekosutrisno801@gmail.com
 * @Github https://github.com/ekosutrisno
 * @Gitlab https://gitlab.com/ekosutrisno1
 * @Create 06/09/2020 17:51
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
   @Autowired
   private UserDetailRepository userDetailRepository;

   @Override
   @Transactional
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Optional<User> optionalUser = userDetailRepository.findByUsername(username);

      optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));

      return UserPrincipal.create(optionalUser.get());
   }
}
