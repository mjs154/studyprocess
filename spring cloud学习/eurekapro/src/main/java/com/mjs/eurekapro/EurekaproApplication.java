package com.mjs.eurekapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaproApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaproApplication.class, args);
	}

}

