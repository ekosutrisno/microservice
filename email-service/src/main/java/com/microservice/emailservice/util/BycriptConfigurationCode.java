package com.microservice.emailservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The type Bycript configuration code.
 */
@Configuration
public class BycriptConfigurationCode {
    /**
     * Gets password encoder.
     *
     * @return the password encoder
     */
    @Bean
   public PasswordEncoder getPasswordEncoder() {
      return new BCryptPasswordEncoder();
   }
}
