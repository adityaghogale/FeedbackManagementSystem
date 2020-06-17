package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.cg")
@EnableDiscoveryClient
public class ViewEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewEmployeeServiceApplication.class, args);
	}

}
