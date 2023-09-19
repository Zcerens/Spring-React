package com.example.dockerizing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DockerizingApplication {

	@GetMapping("/hello")
	public String sayHello(){
		return "Hello docker demo!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerizingApplication.class, args);
	}

}
