package com.zensar.tp;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	  @Bean
	   public Docket getCustomizedDocket() {
	      return new Docket(DocumentationType.SWAGGER_2)
	    		  .select()
	    		  .apis(RequestHandlerSelectors.basePackage("com"))
	    		  .paths(PathSelectors.any())
	    		  .build()
	              .apiInfo(getApiInfo());
	      
	} 
	   private ApiInfo getApiInfo() {
		   return new ApiInfo(
				   "User Rest API Documentation",
				   "This API is designed for Login Auth",
				   "1.0.0",
				   "http://www.Talent-portal",
				   new Contact("admin","http://gpl.com","admin@gmail.com"),
				   "GPL",
				   "http://gpllicense.com",
				   new ArrayList<VendorExtension>());
	   }
}