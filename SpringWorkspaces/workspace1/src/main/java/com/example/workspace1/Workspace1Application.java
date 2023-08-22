package com.example.workspace1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Workspace1Application {

	public static void main(String[] args) {

		SpringApplication.run(Workspace1Application.class, args);
		System.out.println("Hello");
	}

}
