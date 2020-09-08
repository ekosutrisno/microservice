package com.microservice.authservice.config;

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
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;


/**
 * @Author Eko Sutrisno
 * @Create 22/08/2020 21:50
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

   @Autowired
   private AuthenticationManager authenticationManager;
   @Autowired
   private PasswordEncoder passwordEncoder;
   @Autowired
   private DataSource dataSource;
   @Autowired
   private EnvironmentOAuth env;

   /***
    * This for handling Security Acces
    * @param security is object AuthorizationServerSecurityConfigurer
    * @throws Exception for handling Exception
    */
   @Override
   public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
      security.tokenKeyAccess("permitAll()")
              .checkTokenAccess("isAuthenticated()");
   }

   /***
    * Handiling Client in OAuth2
    * @param clients as ClientDetail
    * @throws Exception To handle Exception
    */
   @Override
   public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.jdbc(dataSource)
              .passwordEncoder(passwordEncoder)
              .dataSource(dataSource);
   }

   /***
    * To Handle endponit Server include AuthenticationManagaer adn tokenStore
    * @param endpoints as AuthorizationServerEndpointsConfigurer
    * @throws Exception Handle Exception
    */
   @Override
   public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager)
              .tokenStore(tokenStore());

      if (env.getUsejwttokenconverter())
         endpoints.accessTokenConverter(tokenEnhance());
   }

   /***
    * Token Store Bean to handlind Option token Store to Use
    * @return TokenStore
    */
   @Bean
   public TokenStore tokenStore() {
      if (env.getUsejdbcstoretoken())
         return new JdbcTokenStore(dataSource);

      if (env.getUsejwttokenconverter())
         return new JwtTokenStore(tokenEnhance());

      return new InMemoryTokenStore();
   }

   /***
    * To Handle token Enhance and handling JWT as Token
    * @return accessTokenConverter
    */
   @Bean
   public JwtAccessTokenConverter tokenEnhance() {
      JwtAccessTokenConverter accessTokenConverter = new TokenEnhancerJwt();
      accessTokenConverter.setSigningKey(env.getPrivatekey());
      accessTokenConverter.setVerifierKey(env.getPublickey());

      return accessTokenConverter;
   }

}
