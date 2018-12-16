package com.mjs.confsvr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @EnableConfigServer 使服务成为spring cloud config服务
 */
@SpringBootApplication
@EnableConfigServer
public class ConfsvrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfsvrApplication.class, args);
	}
}
