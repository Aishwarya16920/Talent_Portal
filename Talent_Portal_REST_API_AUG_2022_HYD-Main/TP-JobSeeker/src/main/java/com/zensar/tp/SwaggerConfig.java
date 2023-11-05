package com.zensar.tp;



import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
//@EnableSwagger2
public class SwaggerConfig {
     @Bean
      public GroupedOpenApi publicApi() {
          return GroupedOpenApi.builder()
                  .group("springshop-public")
                  .pathsToMatch("/public/**")
                  .build();
      }
      @Bean
      public GroupedOpenApi adminApi() {
          return GroupedOpenApi.builder()
                  .group("springshop-admin")
                  .pathsToMatch("/admin/**")
                  .build();
      }
   
}