package com.javafsd.gatwayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatwayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayApiApplication.class, args);
	}

}
