package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"package1"})
@SpringBootApplication
public class RestLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestLoginApplication.class, args);
	}

}
