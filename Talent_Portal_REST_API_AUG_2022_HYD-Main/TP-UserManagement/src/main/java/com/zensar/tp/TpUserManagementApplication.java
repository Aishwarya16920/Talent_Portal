package com.zensar.tp;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TpUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpUserManagementApplication.class, args);
		
		}
	@Bean
    public ModelMapper getModelMapper()
    {
        return new ModelMapper();
    }

}
