package com.microservice.emailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * The type Swagger config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Swagger configuration docket.
     *
     * @return the docket
     */
    @Bean
   public Docket swaggerConfiguration() {
      return new Docket(DocumentationType.SWAGGER_2).select()
              .paths(PathSelectors.any())
              .apis(RequestHandlerSelectors.basePackage("com.microservice.emailservice"))
              .build().groupName("Email Service")
              .apiInfo(apiInfo());
   }

   private ApiInfo apiInfo() {
      return new ApiInfo(
              "App Email Services",
              "Email Services REST API",
              "0.0.1",
              "",
              new Contact("Eko Sutrisno",
                      "",
                      "ekosutrisno801@gmail.com"),
              "Apache 2.0",
              "http://www.apache.org/licenses/LICENSE-2.0.html",
              Collections.emptyList());
   }
}
