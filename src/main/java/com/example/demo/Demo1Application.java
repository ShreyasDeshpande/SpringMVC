package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.example.demo.controller", "com.example.demo.service", "com.example.demo.dao" })
public class Demo1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Demo1Application.class, args);
		// ctx.getBean(AlienController.class);
		// ctx.getBean(AlienService.class);

	}

}
