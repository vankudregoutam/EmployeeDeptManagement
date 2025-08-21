package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class EmpDeptApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDeptApplication.class, args);
	}
	
	@Bean
	public OpenAPI getOpenAPI() {
		return new OpenAPI();
	}

}
