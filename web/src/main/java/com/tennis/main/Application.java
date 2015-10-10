package com.tennis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
// TODO
public class Application {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}
}