package com.microservice.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@RestController
public class AuthServiceApplication {

   /***
    * Endpoint to handle User Principal
    * @param principal as Principal
    * @return Principal
    */
   @RequestMapping("/user")
   public Principal user(Principal principal) {
      return principal;
   }

   public static void main(String[] args) {
      SpringApplication.run(AuthServiceApplication.class, args);
   }

}
