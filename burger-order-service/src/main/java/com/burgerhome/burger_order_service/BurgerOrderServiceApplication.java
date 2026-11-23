package com.burgerhome.burger_order_service;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.burgerhome.burger_order_service.client")
public class BurgerOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerOrderServiceApplication.class, args);
	}

}
