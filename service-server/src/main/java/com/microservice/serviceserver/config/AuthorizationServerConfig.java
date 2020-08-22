package com.microservice.serviceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * @Author Eko Sutrisno
 * @create 22/08/2020 21:50
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

   @Autowired
   private AuthenticationManager authenticationManager;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   private EnvironmentOAuth env;

   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      security.tokenKeyAccess("permitAll()")
              .checkTokenAccess("isAuthenticated()");
   }

   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory()
              .withClient("Puspita Sari")
              .secret(passwordEncoder.encode("akucintakamu"))
              .authorizedGrantTypes("client_credentials", "password", "refresh_token")
              .scopes("profile", "email")
              .accessTokenValiditySeconds(6000)
              .refreshTokenValiditySeconds(6000);
   }

   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager)
              .tokenStore(tokenStore())
              .accessTokenConverter(tokenEnhance());
   }

   @Bean
   public TokenStore tokenStore() {
      if (env.getUsejwttokenconverter())
         return new JwtTokenStore(tokenEnhance());
      return new InMemoryTokenStore();
   }

   @Bean
   public JwtAccessTokenConverter tokenEnhance() {
      JwtAccessTokenConverter accessTokenConverter = new TokenEnhancerJwt();
      accessTokenConverter.setSigningKey(env.getPrivatekey());
      accessTokenConverter.setVerifierKey(env.getPublickey());

      return accessTokenConverter;
   }

}
