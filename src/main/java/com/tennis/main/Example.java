package com.tennis.main;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Example {
	// localhost:8080
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	@RequestMapping("/r")
	String home3() {
		return "Hello World!";
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Example.class, args);
	}

}