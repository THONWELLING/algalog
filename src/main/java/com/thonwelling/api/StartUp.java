package com.thonwelling.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartUp {

	public static void main(String[] args) {

		SpringApplication.run(StartUp.class, args);
		System.out.println("API Is Running Sucessfully !!!");
	}

}
