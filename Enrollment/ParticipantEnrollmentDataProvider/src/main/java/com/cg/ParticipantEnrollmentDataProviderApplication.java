package com.cg;

import javax.persistence.NamedEntityGraph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class ParticipantEnrollmentDataProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParticipantEnrollmentDataProviderApplication.class, args);
	}

}
