package com.zensar.tp.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TpApigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpApigatewayApplication.class, args);
	}

}
