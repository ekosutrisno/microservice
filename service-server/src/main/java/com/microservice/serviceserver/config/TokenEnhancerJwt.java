package com.microservice.serviceserver.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Eko Sutrisno
 * @Create 22/08/2020 22:50
 */

public class TokenEnhancerJwt extends JwtAccessTokenConverter {
   @Override
   public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
      User user = (User) authentication.getPrincipal();
      Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
      if (user.getUsername() != null)
         info.put("username", user.getUsername());

      DefaultOAuth2AccessToken oAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
      oAuth2AccessToken.setAdditionalInformation(info);

      return super.enhance(oAuth2AccessToken, authentication);
   }
}
